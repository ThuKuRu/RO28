DROP DATABASE IF EXISTS Testing_System_Assigment;
CREATE DATABASE Testing_System_Assigment;
USE Testing_System_Assigment;

CREATE TABLE `Department` (
	DepartmentID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    DepartmentName			NVARCHAR(30) NOT NULL UNIQUE KEY
);
    
CREATE TABLE `Position` (
	PositionID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    PositionName			ENUM('Dev', 'Test', 'Scrum Master', 'PM') NOT NULL UNIQUE KEY 
);
    
CREATE TABLE `Account` (
	AccountID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email					VARCHAR(50) NOT NULL UNIQUE KEY,
    Username				VARCHAR(50) NOT NULL UNIQUE KEY,
    FullName				VARCHAR(100) NOT NULL UNIQUE KEY,
    DepartmentID			TINYINT UNSIGNED NOT NULL,
    PositionID				TINYINT UNSIGNED NOT NULL,
    CreateDate				DATE NOT NULL,
	FOREIGN KEY (DepartmentID) REFERENCES  `Department`(DepartmentID) ON DELETE CASCADE,
	FOREIGN KEY (PositionID) REFERENCES  `Position`(PositionID) ON DELETE CASCADE
);

CREATE TABLE `Group` (
	GroupID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    GroupName				VARCHAR(50) NOT NULL UNIQUE KEY,
    CreatorID				TINYINT UNSIGNED NOT NULL UNIQUE KEY,
    CreateDate				DATE NOT NULL,
    FOREIGN KEY (CreatorID) REFERENCES  `Account`(AccountID) ON DELETE CASCADE
);

CREATE TABLE `GroupAccount` (
	GroupID					TINYINT UNSIGNED NOT NULL,
    AccountID				TINYINT UNSIGNED AUTO_INCREMENT,
    JoinDate				DATE NOT NULL,
	FOREIGN KEY (GroupID) REFERENCES  `Group`(GroupID) ON DELETE CASCADE,
    FOREIGN KEY (AccountID) REFERENCES  `Account`(AccountID) ON DELETE CASCADE
);

CREATE TABLE `TypeQuestion` (
	TypeID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    TypeName				ENUM('Essay', 'Multiple-Choice') NOT NULL
);

CREATE TABLE `CategoryQuestion` (
	CategoryID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CategoryName			ENUM('Java', '.NET', 'SQL', 'Postman', 'Ruby')
);

CREATE TABLE `Question` (
	QuestionID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Content				VARCHAR(100) NOT NULL UNIQUE KEY,
	CategoryID			TINYINT UNSIGNED NOT NULL,
	TypeID 				TINYINT UNSIGNED NOT NULL,
	CreatorID			TINYINT UNSIGNED NOT NULL,
	CreateDate			DATE NOT NULL,
    FOREIGN KEY (CategoryID) REFERENCES  `CategoryQuestion`(CategoryID) ON DELETE CASCADE,
    FOREIGN KEY (TypeID) REFERENCES  `TypeQuestion`(TypeID) ON DELETE CASCADE,
    FOREIGN KEY (CreatorID) REFERENCES  `Group`(CreatorID) ON DELETE CASCADE
);
  
CREATE TABLE `Answer` (
	AnswerID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content				VARCHAR(100) NOT NULL UNIQUE KEY,
    QuestionID			TINYINT UNSIGNED NOT NULL,
    isCorrect			BOOLEAN NOT NULL,
	FOREIGN KEY (QuestionID) REFERENCES  `Question`(QuestionID) ON DELETE CASCADE
);

CREATE TABLE `Exam` (
	ExamID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Code`				TINYINT NOT NULL UNIQUE KEY,
    Title				VARCHAR(50) NOT NULL UNIQUE KEY,
    CategoryID			TINYINT UNSIGNED NOT NULL,
    Duration			TINYINT NOT NULL,
    CreatorID			TINYINT UNSIGNED NOT NULL,
    CreateDate			DATETIME NOT NULL DEFAULT NOW(),
	FOREIGN KEY (CategoryID) REFERENCES  `CategoryQuestion`(CategoryID) ON DELETE CASCADE,
    FOREIGN KEY (CreatorID) REFERENCES  `Group`(CreatorID) ON DELETE CASCADE,
    FOREIGN KEY (CreatorID) REFERENCES  `Account`(AccountID) ON DELETE CASCADE
);

CREATE TABLE `ExamQuestion` (
	ExamID				TINYINT UNSIGNED NOT NULL,
    QuestionID			TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY (ExamID) REFERENCES  `Exam`(ExamID) ON DELETE CASCADE,
    FOREIGN KEY (QuestionID) REFERENCES  `Question`(QuestionID) ON DELETE CASCADE
);