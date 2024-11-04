CREATE DATABASE graduateProjectManagement;

USE graduateProjectManagement;

CREATE TABLE assessor
(
    assessorId INT AUTO_INCREMENT PRIMARY KEY,
    assessorName VARCHAR(255),
    uname VARCHAR(255) NOT NULL,
    pword VARCHAR(255) NOT NULL,
    eduBackground VARCHAR(255),
    institution VARCHAR(255),
    age INT,
    major VARCHAR(255),
    phoneNumber VARCHAR(255)
);

CREATE TABLE teacher
(
    teacherId INT AUTO_INCREMENT PRIMARY KEY,
    teacherName VARCHAR(255),
    uname VARCHAR(255) NOT NULL,
    pword VARCHAR(255) NOT NULL,
    eduBackground VARCHAR(255),
    institution VARCHAR(255),
    age INT,
    major VARCHAR(255),
    phoneNumber VARCHAR(255),
    assessorId INT,
    FOREIGN KEY(assessorId) REFERENCES assessor(assessorId)
);

CREATE TABLE officer
(
    officerId INT AUTO_INCREMENT PRIMARY KEY,
    officerName VARCHAR(255),
    uname VARCHAR(255) NOT NULL,
    pword VARCHAR(255) NOT NULL,
    eduBackground VARCHAR(255),
    phoneNumber VARCHAR(255)
);

CREATE TABLE council
(
    councilId INT AUTO_INCREMENT PRIMARY KEY,
    councilName VARCHAR(255),
    uname VARCHAR(255) NOT NULL,
    pword VARCHAR(255) NOT NULL,
);

CREATE TABLE subject
(
    subjectId INT AUTO_INCREMENT PRIMARY KEY,
    subjectName VARCHAR(255) NOT NULL,
    description VARCHAR(1023) NOT NULL,
    teacherId INT,
    FOREIGN KEY(teacherId) REFERENCES teacher(teacherId)
);

CREATE TABLE student
(
    studentId INT AUTO_INCREMENT PRIMARY KEY,
    uname VARCHAR(255) NOT NULL,
    pword VARCHAR(255) NOT NULL,
    studentName VARCHAR(255),
    phoneNumber VARCHAR(255),
    resume VARCHAR(1023)
);

CREATE TABLE student_subject
(
    studentId INT,
    subjectId INT,
    councilId INT,
    pass BOOLEAN,
    state VARCHAR(255),
    replyPosition VARCHAR(255),
    replyTime DATETIME,
    Foreign Key (studentId) REFERENCES student(studentId),
    Foreign Key (subjectId) REFERENCES subject(subjectId),
    Foreign Key (councilId) REFERENCES council(councilId)
);