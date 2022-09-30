DROP DATABASE IF EXISTS Testing_System_Assigment_2;
CREATE DATABASE Testing_System_Assigment_2;
USE Testing_System_Assigment_2;

-- phòng ban
CREATE TABLE `Department` (
	DepartmentID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    DepartmentName			VARCHAR(30) NOT NULL UNIQUE KEY
);
    
-- chức vụ
CREATE TABLE `Position` (
	PositionID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    PositionName			ENUM('Dev', 'Test', 'Scrum Master', 'PM') NOT NULL UNIQUE KEY 
);
    
-- tài khoản
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

-- nhóm
CREATE TABLE `Group` (
	GroupID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    GroupName				VARCHAR(50) NOT NULL UNIQUE KEY,
    CreatorID				TINYINT NOT NULL UNIQUE KEY,
    CreateDate				DATE NOT NULL
);

-- tài khoản nhóm
CREATE TABLE `GroupAccount` (
	GroupID					TINYINT UNSIGNED NOT NULL,
    AccountID				TINYINT UNSIGNED AUTO_INCREMENT,
    JoinDate				DATE NOT NULL,
	FOREIGN KEY (GroupID) REFERENCES  `Group`(GroupID) ON DELETE CASCADE,
    FOREIGN KEY (AccountID) REFERENCES  `Account`(AccountID) ON DELETE CASCADE
);

-- dạng câu hỏi
CREATE TABLE `TypeQuestion` (
	TypeID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    TypeName				ENUM('Essay', 'Multiple-Choice') NOT NULL
);

-- thể loại
CREATE TABLE `CategoryQuestion` (
	CategoryID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CategoryName			ENUM('Java', '.NET', 'SQL', 'Postman', 'Ruby')
);

-- câu hỏi
CREATE TABLE `Question` (
	QuestionID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Content				VARCHAR(100) NOT NULL UNIQUE KEY,
	CategoryID			TINYINT UNSIGNED NOT NULL,
	TypeID 				TINYINT UNSIGNED NOT NULL,
	CreatorID			TINYINT NOT NULL,
	CreateDate			DATE NOT NULL,
    FOREIGN KEY (CategoryID) REFERENCES  `CategoryQuestion`(CategoryID) ON DELETE CASCADE,
    FOREIGN KEY (TypeID) REFERENCES  `TypeQuestion`(TypeID) ON DELETE CASCADE,
    FOREIGN KEY (CreatorID) REFERENCES  `Group`(CreatorID) ON DELETE CASCADE
);
  
-- câu trả lời
CREATE TABLE `Answer` (
	AnswerID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content				VARCHAR(100) NOT NULL UNIQUE KEY,
    QuestionID			TINYINT UNSIGNED NOT NULL,
    isCorrect			BOOLEAN NOT NULL,
	FOREIGN KEY (QuestionID) REFERENCES  `Question`(QuestionID) ON DELETE CASCADE
);

-- bài kiểm tra
CREATE TABLE `Exam` (
	ExamID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Code`				TINYINT NOT NULL UNIQUE KEY,
    Title				VARCHAR(50) NOT NULL UNIQUE KEY,
    CategoryID			TINYINT UNSIGNED NOT NULL,
    Duration			TINYINT NOT NULL,
    CreatorID			TINYINT NOT NULL,
    CreateDate			DATE NOT NULL,
	FOREIGN KEY (CategoryID) REFERENCES  `CategoryQuestion`(CategoryID) ON DELETE CASCADE,
    FOREIGN KEY (CreatorID) REFERENCES  `Group`(CreatorID) ON DELETE CASCADE
);

-- câu hỏi bài kiểm tra
CREATE TABLE `ExamQuestion` (
	ExamID				TINYINT UNSIGNED NOT NULL,
    QuestionID			TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY (ExamID) REFERENCES  `Exam`(ExamID) ON DELETE CASCADE,
    FOREIGN KEY (QuestionID) REFERENCES  `Question`(QuestionID) ON DELETE CASCADE
);

INSERT INTO `Department`(DepartmentName)
VALUES 					('Phong 1'), 
						('Phong 2'), 
						('Phong 3'), 
						('Phong 4'), 
						('Phong 5'), 
						('Phong 6'), 
						('Phong 7'), 
						('Phong 8'), 
						('Phong 9'), 
						('Phong 10');

INSERT INTO `Position` 	(PositionName)
VALUES  				('Dev'), 
						('Test'), 
                        ('Scrum Master'), 
                        ('PM');

INSERT INTO `Account` 	(Email, 			 Username, 		 FullName, 		DepartmentID, 	PositionID, 	CreateDate)
VALUES 					('abc1@gmail.com', 	'Username1', 	'FullName1', 	10, 			5, 				'1972-05-25'),
						('abc2@gmail.com', 	'Username2', 	'FullName2', 	1, 				6, 				'2006-08-30'),
						('abc3@gmail.com', 	'Username3', 	'FullName3', 	3, 				5, 				'2016-12-08'),
						('abc4@gmail.com', 	'Username4', 	'FullName4',	4, 				7, 				'2000-10-06'),
						('abc5@gmail.com', 	'Username5', 	'FullName5', 	2, 				6,				'2008-03-21'),
						('abc6@gmail.com', 	'Username6', 	'FullName6', 	5, 				9, 				'1997-07-14'),
						('abc7@gmail.com', 	'Username7', 	'FullName7', 	6, 				10, 			'1990-06-25'),
						('abc8@gmail.com', 	'Username8', 	'FullName8', 	7, 				2, 				'2020-11-24'),
						('abc9@gmail.com', 	'Username9', 	'FullName9', 	8, 				9, 				'2015-03-25'),
						('abc10@gmail.com', 'Username10', 	'FullName10', 	9, 				3, 				'2014-06-04');

INSERT INTO `Group` 	(GroupName, 		CreatorID, 		 CreateDate)
VALUES 					('GroupName1', 		25, 			'2022-05-30'),
						('GroupName2', 		67, 			'2022-05-30'),
						('GroupName3', 		88, 			'2022-05-30'),
						('GroupName4', 		90, 			'2022-05-30'),
						('GroupName5', 		05, 			'2022-05-30'),
						('GroupName6', 		17, 			'2022-05-30'),
						('GroupName7', 		43, 			'2022-05-30'),
						('GroupName8', 		68, 			'2022-05-30'),
						('GroupName9', 		86,				'2022-05-30'),
						('GroupName10', 	73, 			'2022-05-30');
    
INSERT INTO `GroupAccount` 	(GroupID, 	JoinDate)
VALUES 						(5, 		'2022-05-30'),
							(9, 		'2022-05-30'),
							(3, 		'2022-05-30'),
							(5, 		'2022-05-30'),
							(6, 		'2022-05-30'),
							(2, 		'2022-05-30'),
							(4, 		'2022-05-30'),
							(6, 		'2022-05-30'),
							(8, 		'2022-05-30'),
							(10, 		'2022-05-30');

INSERT INTO `TypeQuestion` 	(TypeName)
VALUES 						('Essay'),
							('Multiple-Choice'), 
                            ('Multiple-Choice'), 
                            ('Multiple-Choice'), 
                            ('Essay'), 
                            ('Essay'), 
                            ('Multiple-Choice'), 
                            ('Essay'), 
                            ('Multiple-Choice'), 
                            ('Essay');

INSERT INTO `CategoryQuestion` 	(CategoryName)
VALUES 							('Java'), 
								('.NET'), 
                                ('SQL'), 
                                ('Postman'), 
                                ('Ruby'), 
                                ('Java'), 
                                ('.NET'), 
                                ('SQL'), 
                                ('Postman'), 
                                ('Ruby');

INSERT INTO `Question` 	(Content, 				CategoryID, 	TypeID, 	CreatorID, 	CreateDate)
VALUES 					('Java Question', 		1,				1, 			25, 		'2022-05-30'),
						('Postman Question', 	10, 			2, 			90, 		'2022-04-05'),
						('SQL Question', 		9, 				1, 			68, 		'2020-04-05'),
						('Ruby Question', 		5, 				2, 			86, 		'2022-05-30'),
						('.NET Question', 		4, 				1, 			05, 		'2020-04-05'),
						('C Question', 			2, 				1, 			25, 		'2020-04-05'),
						('C++ Question', 		7, 				1, 			90, 		'2018-04-05'),
						('Python Question', 	8, 				1,			25, 		'2020-04-16'),
						('HTML Question', 		6, 				2, 			86, 		'2020-04-05'),
						('CSS Question', 		3, 				1, 			05, 		'2020-05-05');

INSERT INTO `Answer` 	( Content , 	QuestionID , 	isCorrect )
VALUES 					('Answer1', 	10, 			0),
						('Answer2', 	8, 				0),
						('Answer3',	 	2, 				1),
						('Answer4', 	6, 				0),
						('Answer5', 	5, 				1),
						('Answer6', 	4, 				1),
						('Answer7', 	2, 				0),
						('Answer8',	 	7, 				0),
						('Answer9', 	8, 				1),
						('Answer10', 	9, 				1);
        
INSERT INTO Exam 	(`Code`, 		Title, 		CategoryID, 	Duration, 	CreatorID, 	CreateDate)
VALUES 				('000001', 		'C', 		5, 				90, 		25, 		'2022-05-30'),
					('000002', 		'Java', 	9, 				120, 		90, 		'2022-05-30'),
					('000003', 		'C++', 		6, 				60, 		05, 		'2022-05-30'),
					('000004', 		'SQL', 		10, 			90, 		86, 		'2022-05-30'),
					('000005', 		'HTML', 	1, 				90, 		86, 		'2022-05-30'),
					('000006', 		'CSS', 		8, 				90, 		68, 		'2022-05-30'),
					('000007', 		'Python', 	4, 				60, 		73, 		'2022-05-30'),
					('000008', 		'Ruby', 	3, 				90, 		25, 		'2022-05-30'),
					('000009', 		'.NET', 	7, 				60, 		05, 		'2022-05-30'),
					('000010', 		'Postman', 	1, 				120, 		90, 		'2022-05-30');

INSERT INTO ExamQuestion	(ExamID , 	QuestionID )
VALUES 						(1, 		1),
							(4,	 		5),
							(3, 		10),
							(1, 		1),
							(2, 		10),
							(10, 		4),
							(8,			2),
							(6, 		2),
							(9, 		10),
							(7, 		4);


