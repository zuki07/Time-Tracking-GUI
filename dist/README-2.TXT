Run the following query to setup the structure of the database in mysql:

CREATE TABLE gui_test.types (
	project_types VARCHAR(40) PRIMARY KEY
) ENGINE = InnoDB;

CREATE TABLE gui_test.project_names (
	project_types VARCHAR(40),
	project_names VARCHAR(40),
	PRIMARY KEY (project_names), 
	FOREIGN KEY (project_types) REFERENCES types (project_types)
) ENGINE = InnoDB;