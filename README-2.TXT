Run the following query to setup the structure of the database in mysql:

CREATE TABLE types (
	project_types VARCHAR(40) PRIMARY KEY
);

CREATE TABLE projectNames (
	project_types VARCHAR(40),
	project_names VARCHAR(40),
	PRIMARY KEY (project_names), 
	FOREIGN KEY (project_types) REFERENCES types (project_types)
);

CREATE TABLE projectsData ( 
	project_name VARCHAR(40) NULL DEFAULT NULL ,
	row_number INT(4) NULL DEFAULT NULL ,
	date DATE NULL DEFAULT NULL , 
	start_time VARCHAR(10) NULL DEFAULT NULL , 
	end_time VARCHAR(10) NULL DEFAULT NULL , 
	duration VARCHAR(10) NULL DEFAULT NULL , 
	total_time VARCHAR(10) NULL DEFAULT NULL,
	FOREIGN KEY (project_name) REFERENCES projectNames (project_names) 
);