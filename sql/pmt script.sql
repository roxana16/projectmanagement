-- DROP TABLE IF EXISTS User;

-- TRUNCATE DATABASE PMT;
-- TRUNCATE TABLE User;
CREATE TABLE IF NOT EXISTS User(
     userId INT NOT NULL AUTO_INCREMENT,
     userName VARCHAR(255) NOT NULL,
     firstName VARCHAR(255) NOT NULL,
     lastName VARCHAR(255) NOT NULL,
     email VARCHAR(255) NOT NULL,
     userPass VARCHAR(255),
     isAdmin TINYINT(1),
     PRIMARY KEY (userId),
     UNIQUE (userName)
);

-- TRUNCATE TABLE Project;
-- DROP TABLE IF EXISTS Project;
CREATE TABLE IF NOT EXISTS Project (
     projectId INT NOT NULL AUTO_INCREMENT,
     projectContent VARCHAR(255),
     projectTitle VARCHAR(255) NOT NULL,
     releaseDate DATETIME,
     PRIMARY KEY (projectId)
);

-- TRUNCATE TABLE Task;
-- DROP TABLE IF EXISTS Task;
CREATE TABLE IF NOT EXISTS Task(
     taskId INT NOT NULL AUTO_INCREMENT,
     taskContent VARCHAR(255),
     taskName VARCHAR(255) NOT NULL,
     startTime DATETIME,
     comment VARCHAR(255) NOT NULL,
     remainingHours INT,
     PRIMARY KEY (taskId)
);	

-- TRUNCATE TABLE Files;
-- DROP TABLE IF EXISTS Files;
CREATE TABLE IF NOT EXISTS Files (
     filesId INT NOT NULL AUTO_INCREMENT,
     filesContent VARCHAR(255) NOT NULL,
     PRIMARY KEY (filesId)
);

-- TRUNCATE TABLE Report;
-- DROP TABLE IF EXISTS Report;
CREATE TABLE IF NOT EXISTS Report (
     reportId INT NOT NULL AUTO_INCREMENT,
     reportContent VARCHAR(255) NOT NULL,
     PRIMARY KEY (reportId)
);

-- TRUNCATE TABLE Status;
-- DROP TABLE IF EXISTS Status;
CREATE TABLE IF NOT EXISTS Status (
     statusId INT NOT NULL AUTO_INCREMENT,
     statusName VARCHAR(255) NOT NULL,
     PRIMARY KEY (statusId)
);

-- TRUNCATE TABLE Comment;
-- DROP TABLE IF EXISTS Comment;
CREATE TABLE IF NOT EXISTS Comment (
     commentId INT NOT NULL AUTO_INCREMENT,
     commentContent VARCHAR(2100) NOT NULL,
     timeMade DATETIME,
     taskId INT NOT NULL,
     userId INT NOT NULL,
     PRIMARY KEY (commentId),
     FOREIGN KEY (taskId) REFERENCES Task(taskId),
     FOREIGN KEY (userId) REFERENCES User(userId)
);

-- TRUNCATE TABLE createProj;
-- DROP TABLE IF EXISTS createProj;
CREATE TABLE IF NOT EXISTS createProj (
     projectId INT NOT NULL,
     adminId INT NOT NULL,
     FOREIGN KEY (projectId) REFERENCES Project(projectId),
     FOREIGN KEY (adminId) REFERENCES User(userId),
     PRIMARY KEY (projectId, adminId)
);

-- TRUNCATE TABLE createTask;
-- DROP TABLE IF EXISTS createTask;
CREATE TABLE IF NOT EXISTS createTask (
     userId INT NOT NULL,
     taskId INT NOT NULL,
     FOREIGN KEY (userId) REFERENCES User(userId),
     FOREIGN KEY (taskId) REFERENCES Task(taskId),
     PRIMARY KEY (userId, taskId)
);

-- TRUNCATE TABLE projectTask;
-- DROP TABLE IF EXISTS projectTask;
CREATE TABLE IF NOT EXISTS projectTask (
     projectId INT NOT NULL,
     taskId INT NOT NULL,
     FOREIGN KEY (projectId) REFERENCES Project(projectId),
     FOREIGN KEY (taskId) REFERENCES Task(taskId),
     PRIMARY KEY (projectId, TaskId)
);

-- TRUNCATE TABLE attachFile;
-- DROP TABLE IF EXISTS attachFile;
CREATE TABLE IF NOT EXISTS attachFile (
     filesId INT NOT NULL,
     taskId INT NOT NULL,
     FOREIGN KEY (filesId) REFERENCES Files(filesId),
     FOREIGN KEY (taskId) REFERENCES Task(taskId),
     PRIMARY KEY (filesId, TaskId)
);

-- TRUNCATE TABLE generateStatus;
-- DROP TABLE IF EXISTS generateStatus;
CREATE TABLE IF NOT EXISTS generateStatus (
     statusId INT NOT NULL,
     taskId INT NOT NULL,
     FOREIGN KEY (statusId) REFERENCES Status(statusId),
     FOREIGN KEY (taskId) REFERENCES Task(taskId),
     PRIMARY KEY (statusId, TaskId)
);

-- TRUNCATE TABLE generateReport;
-- DROP TABLE IF EXISTS generateReport;
-- DROP TABLE IF EXISTS generateReportA;
-- DROP TABLE IF EXISTS generateReportU;


CREATE TABLE IF NOT EXISTS generateReport (
     reportId INT NOT NULL,
     userId INT NOT NULL,
     generatorId INT NOT NULL,
     FOREIGN KEY (reportId) REFERENCES Report(reportId),
     FOREIGN KEY (userId) REFERENCES User(userId),
	 FOREIGN KEY (generatorId) REFERENCES User(userId),
     PRIMARY KEY (reportId)
);

-- TRUNCATE TABLE reportTask;
-- DROP TABLE IF EXISTS reportTask;
CREATE TABLE IF NOT EXISTS reportTask (
     taskId INT NOT NULL,
     statusId INT NOT NULL,
     reportId INT NOT NULL,
     FOREIGN KEY (reportId) REFERENCES Report(reportId),
     FOREIGN KEY (statusId) REFERENCES Status(statusId),
     FOREIGN KEY (taskId) REFERENCES Task(taskId),
     PRIMARY KEY (reportId, taskId)
);
