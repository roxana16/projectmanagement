DROP DATABASE `projectmanagement`;
CREATE DATABASE `projectmanagement` DEFAULT CHARACTER SET utf8mb4 ;
USE `projectmanagement`;

CREATE TABLE IF NOT EXISTS User(
     userId INT NOT NULL AUTO_INCREMENT,
     userName VARCHAR(50) NOT NULL,
     firstName VARCHAR(50) NOT NULL,
     lastName VARCHAR(50) NOT NULL,
     email VARCHAR(100) NOT NULL,
     userPass VARCHAR(255) NOT NULL,
     isAdmin BIT DEFAULT 0,
     PRIMARY KEY (userId),
     UNIQUE (userName)
);

CREATE TABLE IF NOT EXISTS Project (
     projectId INT NOT NULL AUTO_INCREMENT,
     projectContent VARCHAR(2100),
     projectTitle VARCHAR(100) NOT NULL,
     releaseDate DATE,
     PRIMARY KEY (projectId)
);

CREATE TABLE IF NOT EXISTS Status (
     statusId INT NOT NULL AUTO_INCREMENT,
     statusName VARCHAR(255) NOT NULL,
     PRIMARY KEY (statusId)
);

CREATE TABLE IF NOT EXISTS Task(
     taskId INT NOT NULL AUTO_INCREMENT,
     taskContent VARCHAR(2100),
     taskName VARCHAR(100) NOT NULL,
     startTime DATETIME,
     remainingHours INT,
     userId INT,
     projectId INT NOT NULL,
     statusId INT NOT NULL,
     PRIMARY KEY (taskId),
     FOREIGN KEY (userId) REFERENCES User(userId) ON DELETE SET NULL,
     FOREIGN KEY (projectId) REFERENCES Project(projectId) ON DELETE CASCADE,
     FOREIGN KEY (statusId) REFERENCES Status(statusId) ON DELETE RESTRICT
);	

CREATE TABLE IF NOT EXISTS File (
     fileId INT NOT NULL AUTO_INCREMENT,
     fileName VARCHAR(255) NOT NULL,
     PRIMARY KEY (fileId)
);

CREATE TABLE IF NOT EXISTS Report (
     reportId INT NOT NULL AUTO_INCREMENT,
     reportContent VARCHAR(2100) NOT NULL,
     userId INT,
     generatorId INT,
     FOREIGN KEY (userId) REFERENCES User(userId) ON DELETE SET NULL,
	 FOREIGN KEY (generatorId) REFERENCES User(userId) ON DELETE SET NULL,
     PRIMARY KEY (reportId)
);

CREATE TABLE IF NOT EXISTS Comment (
     commentId INT NOT NULL AUTO_INCREMENT,
     commentContent VARCHAR(2100) NOT NULL,
     timeMade DATETIME NOT NULL,
     taskId INT NOT NULL,
     userId INT NOT NULL,
     PRIMARY KEY (commentId),
     FOREIGN KEY (taskId) REFERENCES Task(taskId) ON DELETE CASCADE,
     FOREIGN KEY (userId) REFERENCES User(userId) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Task_File (
     fileId INT NOT NULL,
     taskId INT NOT NULL,
     FOREIGN KEY (fileId) REFERENCES File(fileId) ON DELETE CASCADE,
     FOREIGN KEY (taskId) REFERENCES Task(taskId) ON DELETE CASCADE,
     PRIMARY KEY (fileId, TaskId)
);

CREATE TABLE IF NOT EXISTS Report_Task (
     taskId INT NOT NULL,
     statusId INT NOT NULL,
     reportId INT NOT NULL,
     FOREIGN KEY (reportId) REFERENCES Report(reportId) ON DELETE CASCADE,
     FOREIGN KEY (statusId) REFERENCES Status(statusId) ON DELETE RESTRICT,
     FOREIGN KEY (taskId) REFERENCES Task(taskId) ON DELETE CASCADE,
     PRIMARY KEY (reportId, taskId)
);
