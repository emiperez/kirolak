drop table if exists sports;
create table sports
(
	id smallint unsigned PRIMARY KEY AUTO_INCREMENT,
	name char(25) UNIQUE,
	seo_name char(15) UNIQUE,
	score_mode tinyint unsigned COMMENT 'accumulative, winned parts...',
	part_name char(25),
	max_parts tinyint unsigned,
	play_off_name char(25),
	points_win tinyint,
	points_draw tinyint,
	points_loose tinyint
);

drop table if exists competitions;
create table competitions
(
	id int unsigned PRIMARY KEY AUTO_INCREMENT,
	sport_id smallint unsigned,
	name char(25) NOT NULL,
	seo_name char(15) NOT NULL,
	INDEX comp_name (name),
	INDEX comp_sport (sport_id),
	FOREIGN KEY (sport_id) REFERENCES sports(id) ON DELETE CASCADE
);

drop table if exists stages;
create table stages
(
	id int unsigned PRIMARY KEY AUTO_INCREMENT,
	competition_id int unsigned, 
	name char(25) NOT NULL,
	seo_name char(15) NOT NULL,
	type tinyint unsigned COMMENT 'knockout, points...',
	matches tinyint unsigned,
	max_parts tinyint unsigned,
	play_off_name char(25),
	points_win tinyint,
	points_draw tinyint,
	points_loose tinyint,	
	INDEX stage_name (name),
	INDEX stage_comp (competition_id),
	FOREIGN KEY (competition_id) REFERENCES competitions(id) ON DELETE CASCADE
);

drop table if exists groups;
create table groups
(
	id int unsigned PRIMARY KEY AUTO_INCREMENT,
	stage_id int unsigned,
	name char(25) NOT NULL,
	INDEX group_name (name),
	INDEX group_stage (stage_id),
	FOREIGN KEY (stage_id) REFERENCES stages(id) ON DELETE CASCADE
);

drop table if exists teams;
create table teams
(
	id int unsigned PRIMARY KEY AUTO_INCREMENT,
	sport_id smallint unsigned,
	name char(25) NOT NULL,
	INDEX team_name (name),
	INDEX team_sport (sport_id),
	FOREIGN KEY (sport_id) REFERENCES sports(id) ON DELETE CASCADE
	
);

drop table if exists competition_teams;
create table competition_teams
(
	competition_id int unsigned,
	team_id int unsigned,
	PRIMARY KEY(competition_id, team_id),
	FOREIGN KEY (competition_id) REFERENCES competitions(id) ON DELETE CASCADE,
	FOREIGN KEY (team_id) REFERENCES teams(id) ON DELETE CASCADE
);

drop table if exists group_teams;
create table group_teams
(
	group_id int unsigned,
	team_id int unsigned,
	PRIMARY KEY(group_id, team_id),
	FOREIGN KEY (group_id) REFERENCES groups(id) ON DELETE CASCADE,
	FOREIGN KEY (team_id) REFERENCES teams(id) ON DELETE CASCADE
);

drop table if exists rounds;
create table rounds
(
	id smallint unsigned AUTO_INCREMENT,
	group_id int unsigned,
	day date,
	PRIMARY KEY(id, group_id),
	FOREIGN KEY (group_id) REFERENCES groups(id) ON DELETE CASCADE
);

drop table if exists games;
create table games
(
	id int unsigned PRIMARY KEY AUTO_INCREMENT,
	round_id smallint unsigned,
	group_id int unsigned,
	home_team_id int unsigned,
	visiting_team_id int unsigned,
	home_team_score smallint unsigned,
	visiting_team_score smallint unsigned,
	game_status tinyint COMMENT 'playing, finished, cancelled...',
	scheduled datetime,
	INDEX game_round(round_id, group_id),
	FOREIGN KEY (round_id) REFERENCES rounds(id) ON DELETE CASCADE,
	FOREIGN KEY (group_id) REFERENCES groups(id) ON DELETE CASCADE,
	FOREIGN KEY (home_team_id) REFERENCES teams(id) ON DELETE CASCADE,
	FOREIGN KEY (visiting_team_id) REFERENCES teams(id) ON DELETE CASCADE 
);

drop table if exists standings;
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
);

--drop trigger if exists update_game;
create trigger update_game AFTER UPDATE ON games
FOR EACH ROW
	insert into standings (team_id, round_id, group_id) values (NEW.home_team_id, NEW.round_id, NEW.group_id);