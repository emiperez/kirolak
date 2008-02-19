drop table if exists score_modes;
create table score_modes
(
	id tinyint unsigned,
	locale char(2),
	name char(15),
	PRIMARY KEY (id, locale)
);
insert into score_modes values(10,'en','Accumulative');
insert into score_modes values(20,'en','Sets');
insert into score_modes values(10,'es','Acumulado');
insert into score_modes values(20,'es','Sets (Tenis)');


drop table if exists stage_types;
create table stage_types
(
	id tinyint unsigned,
	locale char(2),
	name char(15),
	PRIMARY KEY (id, locale)
);
insert into stage_types values(10,'en','Heats');
insert into stage_types values(20,'en','League');
insert into stage_types values(30,'en','Race');
insert into stage_types values(10,'es','Eliminatoria');
insert into stage_types values(20,'es','Liga');
insert into stage_types values(30,'es','Carrera');

drop table if exists match_status;
create table match_status
(
	id tinyint unsigned,
	locale char(2),
	name char(15),
	PRIMARY KEY (id, locale)
);
insert into match_status values(10,'en','To Begin');
insert into match_status values(20,'en','Playing');
insert into match_status values(30,'en','Finished');
insert into match_status values(10,'es','No Iniciado');
insert into match_status values(20,'es','En Juego');
insert into match_status values(30,'es','Finalizado');

drop table if exists standings;
drop table if exists matches;
drop table if exists rounds;
drop table if exists group_teams;
drop table if exists competition_teams;
drop table if exists teams;
drop table if exists groups;
drop table if exists stages;
drop table if exists competitions;
drop table if exists sports;

create table sports
(
	id smallint unsigned PRIMARY KEY AUTO_INCREMENT,
	name char(25) UNIQUE,
	seo_name char(25) UNIQUE,
	score_mode tinyint unsigned COMMENT 'accumulative, winned parts...' NOT NULL,
	part_name char(25),
	max_parts tinyint unsigned,
	play_off_name char(25),
	points_win tinyint,
	points_draw tinyint,
	points_loose tinyint,
	INDEX sport_seo_name (seo_name)
) ENGINE=InnoDB;

create table competitions
(
	id int unsigned PRIMARY KEY AUTO_INCREMENT,
	sport_id smallint unsigned,
	name char(25) NOT NULL,
	seo_name char(25) NOT NULL,
	start_date date,
	finish_date date,
	INDEX comp_name (name),
	INDEX comp_sport (sport_id),
	INDEX comp_start (start_date),
	INDEX comp_finish (finish_date),
	FOREIGN KEY (sport_id) REFERENCES sports(id) ON DELETE CASCADE
)ENGINE=InnoDB;


create table stages
(
	id int unsigned PRIMARY KEY AUTO_INCREMENT,
	competition_id int unsigned, 
	name char(25) NOT NULL,
	seo_name char(25) NOT NULL,
	start_date date,
	finish_date date,
	type tinyint unsigned COMMENT 'knockout, points...',
	matches tinyint unsigned,
	max_parts tinyint unsigned,
	play_off_name char(25),
	points_win tinyint,
	points_draw tinyint,
	points_loose tinyint,	
	INDEX stage_name (name),
	INDEX stage_comp (competition_id),
	INDEX stage_start (start_date),
	INDEX stage_finish (finish_date),
	FOREIGN KEY (competition_id) REFERENCES competitions(id) ON DELETE CASCADE
)ENGINE=InnoDB;

create table groups
(
	id int unsigned PRIMARY KEY AUTO_INCREMENT,
	stage_id int unsigned,
	name char(25) NOT NULL,
	INDEX group_name (name),
	INDEX group_stage (stage_id),
	FOREIGN KEY (stage_id) REFERENCES stages(id) ON DELETE CASCADE
)ENGINE=InnoDB;

create table teams
(
	id int unsigned PRIMARY KEY AUTO_INCREMENT,
	sport_id smallint unsigned,
	name char(25) NOT NULL,
	seo_name char(25) NOT NULL,
	acronym char(3) NOT NULL,
	INDEX team_name (name),
	INDEX team_seo_name (seo_name),
	INDEX team_sport (sport_id),
	FOREIGN KEY (sport_id) REFERENCES sports(id) ON DELETE CASCADE
	
)ENGINE=InnoDB;

create table competition_teams
(
	competition_id int unsigned,
	team_id int unsigned,
	PRIMARY KEY(competition_id, team_id),
	FOREIGN KEY (competition_id) REFERENCES competitions(id) ON DELETE CASCADE,
	FOREIGN KEY (team_id) REFERENCES teams(id) ON DELETE CASCADE
)ENGINE=InnoDB;

create table group_teams
(
	group_id int unsigned,
	team_id int unsigned,
	PRIMARY KEY(group_id, team_id),
	FOREIGN KEY (group_id) REFERENCES groups(id) ON DELETE CASCADE,
	FOREIGN KEY (team_id) REFERENCES teams(id) ON DELETE CASCADE
)ENGINE=InnoDB;

create table rounds
(
	id smallint unsigned,
	group_id int unsigned,
	day date,
	PRIMARY KEY(id, group_id),
	FOREIGN KEY (group_id) REFERENCES groups(id) ON DELETE CASCADE
)ENGINE=InnoDB;

create table matches
(
	id int unsigned PRIMARY KEY AUTO_INCREMENT,
	round_id smallint unsigned,
	group_id int unsigned,
	home_team_id int unsigned,
	visiting_team_id int unsigned,
	home_team_score smallint unsigned,
	visiting_team_score smallint unsigned,
	match_status tinyint COMMENT 'playing, finished, cancelled...',
	day_time datetime,
	updated timestamp default current_timestamp ON UPDATE CURRENT_TIMESTAMP,
	INDEX match_round(round_id, group_id),
	INDEX match_home_team(home_team_id),
	INDEX match_visiting_team(visiting_team_id),
	INDEX match_day_time(day_time),
	INDEX match_updated(updated),
	FOREIGN KEY (round_id,group_id) REFERENCES rounds(id, group_id) ON DELETE CASCADE
)ENGINE=InnoDB;

create table standings
(
	team_id int unsigned,
	round_id smallint unsigned,
	group_id int unsigned,

	games smallint unsigned default 0,
	games_home smallint unsigned default 0,
	games_visiting smallint unsigned default 0,

	won_games smallint unsigned default 0,
	won_home smallint unsigned default 0,
	won_visiting smallint unsigned default 0,

	drawn_games smallint unsigned default 0,
	drawn_home smallint unsigned default 0,
	drawn_visiting smallint unsigned default 0,
	
	lost_games smallint unsigned default 0,
	lost_home smallint unsigned default 0,
	lost_visiting smallint unsigned default 0,

	score_total int unsigned default 0,
	score_home int unsigned default 0,
	score_visiting int unsigned default 0,

	score_against_total int unsigned default 0,
	score_against_home int unsigned default 0,
	score_against_visiting int unsigned default 0,

	team_points int unsigned default 0,
	home_points int unsigned default 0,
	visiting_points int unsigned default 0,

	tie_break_position smallint unsigned default 0,

	PRIMARY KEY (team_id,round_id, group_id),
	FOREIGN KEY (round_id,group_id) REFERENCES rounds(id, group_id) ON DELETE CASCADE,
	FOREIGN KEY (team_id) REFERENCES teams(id) ON DELETE CASCADE
)ENGINE=InnoDB;


drop procedure if exists calculate_round_standings;
delimiter $$



create procedure calculate_round_standings(p_group_id int, p_round_id smallint)
BEGIN
	declare finish int default 0;
	declare ht, hts, vt, vts  int;
	declare prev_round_id smallint default 0;
	declare s_points_win, s_points_draw, s_points_loose tinyint;
	declare cur_1 cursor for select home_team_id, home_team_score, visiting_team_id, visiting_team_score from matches where match_status = 30 and group_id = p_group_id and round_id = p_round_id;	
	DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET finish = 1;

	select MAX(round_id) into prev_round_id from matches where group_id = p_group_id and round_id < p_round_id and match_status = 30;
	select points_win, points_draw, points_loose into s_points_win, s_points_draw, s_points_loose from stages, groups where stages.id = groups.stage_id and groups.id = p_group_id;
	delete from standings where group_id=p_group_id and round_id = p_round_id;
	if(prev_round_id > 0) then
		insert into standings 
			select
				team_id,
				p_round_id,
				p_group_id,
				games,
				games_home,
				games_visiting,

				won_games,
				won_home,
				won_visiting,

				drawn_games,
				drawn_home,
				drawn_visiting,
	
				lost_games,
				lost_home,
				lost_visiting,

				score_total,
				score_home,
				score_visiting,

				score_against_total,
				score_against_home,
				score_against_visiting,

				team_points,
				home_points,
				visiting_points,

				tie_break_position
		  	from standings where group_id = p_group_id and round_id = prev_round_id;
	else
		insert into standings 
			select team_id, p_round_id, p_group_id, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 , 0 
				from group_teams where group_id = p_group_id;
	end if;
	OPEN cur_1;
	REPEAT
		FETCH cur_1  into ht, hts, vt, vts;
		if not finish then
			if(hts > vts) then			
				update standings 
					set games = games +1, games_home = games_home + 1, won_games = won_games + 1, 
						won_home = won_home + 1, score_total = score_total + hts, score_home = score_home + hts, 
						score_against_total = score_against_total + vts, score_against_home = score_against_home + vts,
						team_points = team_points + s_points_win, home_points = home_points + s_points_win
					where team_id = ht and group_id = p_group_id and round_id = p_round_id;
		 		update standings 
					set games = games +1, games_visiting = games_visiting + 1, lost_games = lost_games + 1, 
						lost_visiting = lost_visiting + 1, score_total = score_total + vts, score_visiting= score_visiting + vts, 
						score_against_total = score_against_total + hts, score_against_visiting = score_against_visiting + hts,
						team_points = team_points + s_points_loose, visiting_points = visiting_points + s_points_loose
					where team_id = vt and group_id = p_group_id and round_id = p_round_id;
			else if (hts < vts) then			
				update standings 
					set games = games +1, games_home = games_home + 1, lost_games = lost_games + 1, 
						lost_home = lost_home +1, score_total = score_total + hts, score_home = score_home + hts, 
						score_against_total = score_against_total + vts, score_against_home = score_against_home + vts,
						team_points = team_points + s_points_loose, home_points = home_points + s_points_loose
					where team_id = ht and group_id = p_group_id and round_id = p_round_id;
		 		update standings 
					set games = games +1, games_visiting = games_visiting + 1, won_games = won_games + 1, 
						won_visiting = won_visiting +1, score_total = score_total + vts, score_visiting= score_visiting + vts, 
						score_against_total = score_against_total + hts, score_against_visiting = score_against_visiting + hts,
						team_points = team_points + s_points_win, visiting_points = visiting_points + s_points_win
					where team_id = vt and group_id = p_group_id and round_id = p_round_id;
				else
				update standings 
					set games = games +1, games_home = games_home + 1, drawn_games = drawn_games + 1, 
						drawn_home = drawn_home +1, score_total = score_total + hts, score_home = score_home + hts, 
						score_against_total = score_against_total + vts, score_against_home = score_against_home + vts,
						team_points = team_points + s_points_draw, home_points = home_points + s_points_draw
					where team_id = ht and group_id = p_group_id and round_id = p_round_id;
		 		update standings 
					set games = games +1, games_visiting = games_visiting + 1, drawn_games = drawn_games + 1, 
						drawn_visiting = drawn_visiting +1, score_total = score_total + vts, score_visiting= score_visiting + vts, 
						score_against_total = score_against_total + hts, score_against_visiting = score_against_visiting + hts,
						team_points = team_points + s_points_draw, visiting_points = visiting_points + s_points_draw
					where team_id = vt and group_id = p_group_id and round_id = p_round_id;
				end if;
			end if;
		end if;
		UNTIL finish
	END REPEAT;
	CLOSE cur_1;

END$$

drop procedure if exists calculate_standings$$
create procedure calculate_standings(p_group_id int, p_round_id smallint)
BEGIN
	declare max_round_id smallint default 0;
	declare current_round_id smallint;
	set current_round_id = p_round_id;
	select MAX(round_id) into max_round_id from matches where group_id = p_group_id and match_status = 30;
	if(max_round_id is null) then	
		set max_round_id = p_round_id;
	end if;
	WHILE (current_round_id <= max_round_id) DO
		call calculate_round_standings(p_group_id, current_round_id);
		select MIN(round_id) into current_round_id from matches where group_id = p_group_id and round_id > current_round_id and match_status = 30;
	END WHILE; 
END$$

drop procedure if exists get_standings$$
create procedure get_standings(p_group_id int, p_round_id smallint)
BEGIN
	declare max_round_id smallint default 0;
	declare min_round_id smallint default 1;
	select MAX(round_id) into max_round_id from matches where group_id = p_group_id and match_status = 30 and round_id <= p_round_id;
	if(max_round_id is not null) then	
		select * from standings where group_id = p_group_id and round_id = max_round_id order by team_points desc, (score_total - score_against_total) desc;
	else		
		select MIN(round_id) into min_round_id from matches where group_id = p_group_id;
		select * from standings inner join teams on team_id = teams.id where group_id = p_group_id and round_id = min_round_id order by teams.name;
	end if;
END$$

drop procedure if exists get_current_round$$
create procedure get_current_round(p_group_id int)
BEGIN
	declare max_round_id smallint default 0;
	declare min_round_id smallint default 1;
	select MAX(round_id) into max_round_id from matches where group_id = p_group_id and match_status = 30;
	if(max_round_id is not null) then	
		select * from rounds where group_id = p_group_id and round_id = max_round_id;
	else		
		select MIN(round_id) into min_round_id from matches where group_id = p_group_id;
		select * from rounds where group_id = p_group_id and round_id = min_round_id;
	end if;
END$$


delimiter ;
