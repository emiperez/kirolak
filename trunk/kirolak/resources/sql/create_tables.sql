drop table if exists score_modes;
create table score_modes
(
	id tinyint unsigned PRIMARY KEY,
	name char(15) UNIQUE
);
insert into score_modes values(10,'Accumulative');
insert into score_modes values(20,'Winned Parts');


drop table if exists stage_types;
create table stage_types
(
	id tinyint unsigned PRIMARY KEY,
	name char(15)
);
insert into stage_types values(10,'Heats');
insert into stage_types values(20,'Points');
insert into stage_types values(30,'Race');

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
	points_loose tinyint
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
	id smallint unsigned AUTO_INCREMENT,
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
	scheduled datetime,
	updated datetime,
	INDEX match_round(round_id, group_id),
	INDEX match_home_team(home_team_id),
	INDEX match_visiting_team(visiting_team_id),
	INDEX match_scheduled(scheduled),
	INDEX match_updated(updated),
	FOREIGN KEY (round_id) REFERENCES rounds(id) ON DELETE CASCADE,
	FOREIGN KEY (group_id) REFERENCES groups(id) ON DELETE CASCADE,
	FOREIGN KEY (home_team_id) REFERENCES teams(id) ON DELETE CASCADE,
	FOREIGN KEY (visiting_team_id) REFERENCES teams(id) ON DELETE CASCADE 
)ENGINE=InnoDB;

create table standings
(
	team_id int unsigned,
	round_id smallint unsigned,
	group_id int unsigned,

	games smallint unsigned,
	games_home smallint unsigned,
	games_visiting smallint unsigned,

	won_games smallint unsigned,
	won_home smallint unsigned,
	won_visiting smallint unsigned,

	drawn_games smallint unsigned,
	drawn_home smallint unsigned,
	drawn_visiting smallint unsigned,
	
	lost_games smallint unsigned,
	lost_home smallint unsigned,
	lost_visiting smallint unsigned,

	score_total int unsigned,
	score_home int unsigned,
	score_visiting int unsigned,

	score_against_total int unsigned,
	score_against_home int unsigned,
	score_against_visiting int unsigned,

	team_points int unsigned,
	home_points int unsigned,
	visiting_points int unsigned,

	tie_break_position smallint unsigned,

	PRIMARY KEY (team_id,round_id, group_id),
	FOREIGN KEY (round_id) REFERENCES rounds(id) ON DELETE CASCADE,
	FOREIGN KEY (group_id) REFERENCES groups(id) ON DELETE CASCADE,
	FOREIGN KEY (team_id) REFERENCES teams(id) ON DELETE CASCADE
)ENGINE=InnoDB;

--drop trigger if exists update_game;
create trigger update_match AFTER UPDATE ON matches
FOR EACH ROW
	insert into standings (team_id, round_id, group_id) values (NEW.home_team_id, NEW.round_id, NEW.group_id);