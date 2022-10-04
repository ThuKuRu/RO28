DROP DATABASE IF EXISTS Testing_System_Assigment_3;
CREATE DATABASE Testing_System_Assigment_3;
USE Testing_System_Assigment_3;

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
    CreatorID				TINYINT NOT NULL UNIQUE KEY,
    CreateDate				DATE NOT NULL
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
	CreatorID			TINYINT NOT NULL,
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
    CreatorID			TINYINT NOT NULL,
    CreateDate			DATE NOT NULL,
	FOREIGN KEY (CategoryID) REFERENCES  `CategoryQuestion`(CategoryID) ON DELETE CASCADE,
    FOREIGN KEY (CreatorID) REFERENCES  `Group`(CreatorID) ON DELETE CASCADE
);

CREATE TABLE `ExamQuestion` (
	ExamID				TINYINT UNSIGNED NOT NULL,
    QuestionID			TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY (ExamID) REFERENCES  `Exam`(ExamID) ON DELETE CASCADE,
    FOREIGN KEY (QuestionID) REFERENCES  `Question`(QuestionID) ON DELETE CASCADE
);

-- Question 1: Thêm ít nhất 10 record vào mỗi table
INSERT INTO `Department`(DepartmentName)
VALUES 					('Marketing'	),
						('Sale'		),
						('Bảo vệ'		),
						('Nhân sự'		),
						('Kỹ thuật'	),
						('Tài chính'	),
						('Phó giám đốc'),
						('Giám đốc'	),
						('Thư kí'		),
						('Bán hàng'	);

INSERT INTO `Position` 	(PositionName)
VALUES  				('Dev'), 
						('Test'), 
                        ('Scrum Master'), 
                        ('PM');

INSERT INTO `Account` 	(Email, 			 Username, 		 FullName, 		DepartmentID, 	PositionID, 	 CreateDate)
VALUES 					('abc1@gmail.com', 	'Username1', 	'FullName1', 	10, 			3, 				'1972-05-25'),
						('abc2@gmail.com', 	'Username2', 	'FullName2', 	1, 				2, 				'2006-08-30'),
						('abc3@gmail.com', 	'Username3', 	'FullName3', 	3, 				4, 				'2016-12-08'),
						('abc4@gmail.com', 	'Username4', 	'FullName4',	4, 				1, 				'2000-10-06'),
						('abc5@gmail.com', 	'Username5', 	'FullName5', 	2, 				2,				'2008-03-21'),
						('abc6@gmail.com', 	'Username6', 	'FullName6', 	5, 				3, 				'1997-07-14'),
						('abc7@gmail.com', 	'Username7', 	'FullName7', 	6, 				1, 				'1990-06-25'),
						('abc8@gmail.com', 	'Username8', 	'FullName8', 	7, 				2, 				'2020-11-24'),
						('abc9@gmail.com', 	'Username9', 	'FullName9', 	2, 				4, 				'2015-03-25'),
						('abc10@gmail.com', 'Username10', 	'Dao', 			9, 				3, 				'2014-06-04');

INSERT INTO `Group` 	(GroupName, 		CreatorID, 		 CreateDate)
VALUES 					('GroupName1', 		25, 			'2022-05-30'),
						('GroupName2', 		67, 			'2022-05-30'),
						('GroupName3', 		88, 			'2012-05-25'),
						('GroupName4', 		90, 			'2008-08-02'),
						('GroupName5', 		05, 			'2022-05-30'),
						('GroupName6', 		17, 			'2022-06-04'),
						('GroupName7', 		43, 			'2022-05-30'),
						('GroupName8', 		68, 			'2018-05-30'),
						('GroupName9', 		86,				'2022-05-30'),
						('GroupName10', 	73, 			'2002-05-30');
    
INSERT INTO `GroupAccount` 	(GroupID, 	JoinDate)
VALUES 						(5, 		'2022-05-30'),
							(9, 		'2022-05-30'),
							(3, 		'2022-05-30'),
							(5, 		'2022-05-30'),
							(6, 		'2022-05-30'),
							(2, 		'2022-05-30'),
							(4, 		'2022-05-30'),
							(6, 		'2002-05-25'),
							(8, 		'2022-05-30'),
							(10, 		'2012-05-08');

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
						('Postman Question', 	10, 			2, 			90, 		'2012-04-05'),
						('SQL Question', 		9, 				1, 			68, 		'2020-04-05'),
						(N'Câu hỏi Ruby', 		5, 				2, 			86, 		'2022-08-08'),
						('.NET Question', 		4, 				1, 			05, 		'2006-04-06'),
						('C Question', 			2, 				1, 			25, 		'2020-04-05'),
						(N'Câu hỏi C++', 		7, 				1, 			90, 		'2018-04-05'),
						('Python Question', 	8, 				1,			25, 		'2020-04-16'),
						('HTML Question', 		6, 				2, 			86, 		'2002-12-05'),
						('CSS Question', 		3, 				1, 			05, 		'2009-05-08');

INSERT INTO `Answer` 	( Content , 	QuestionID , 	isCorrect )
VALUES 					('Answer1', 	2, 				0),
						('Answer2', 	8, 				0),
						('Answer3',	 	2, 				1),
						('Answer4', 	8, 				0),
						('Answer5', 	5, 				1),
						('Answer6', 	4, 				1),
						('Answer7', 	2, 				0),
						('Answer8',	 	2, 				0),
						('Answer9', 	8, 				1),
						('Answer10', 	8, 				1);
        
INSERT INTO `Exam` 	(`Code`, 		Title, 		CategoryID, 	Duration, 	CreatorID, 	CreateDate)
VALUES 				('000001', 		'C', 		5, 				90, 		25, 		'2022-05-30'),
					('000002', 		'Java', 	9, 				120, 		90, 		'2008-12-26'),
					('000003', 		'C++', 		6, 				60, 		05, 		'2002-05-04'),
					('000004', 		'SQL', 		10, 			90, 		86, 		'2022-05-30'),
					('000005', 		'HTML', 	1, 				45, 		86, 		'2020-05-30'),
					('000006', 		'CSS', 		8, 				90, 		68, 		'2022-01-01'),
					('000007', 		'Python', 	4, 				60, 		73, 		'2019-06-30'),
					('000008', 		'Ruby', 	3, 				90, 		25, 		'2012-03-01'),
					('000009', 		'.NET', 	7, 				60, 		05, 		'2005-08-09'),
					('000010', 		'Postman', 	1, 				45, 		90, 		'2010-10-10');

INSERT INTO `ExamQuestion`	(ExamID , 	QuestionID )
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

-- Question 2: lấy ra tất cả các phòng ban
SELECT * FROM `Department`;

-- Question 3: lấy ra id của phòng ban "Sale"
SELECT DepartmentID FROM `Department`
WHERE  DepartmentName = 'Sale';

-- Question 4: lấy ra thông tin account có full name dài nhất
SELECT * FROM `Account`
WHERE FullName = (SELECT MAX(FullName) FROM `Account`);

-- Question 5: Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id = 3
SELECT * FROM `Account`
WHERE DepartmentID = '3' AND FullName = (SELECT MAX(FullName) FROM `Account` WHERE DepartmentID = '3');

-- Question 6: Lấy ra tên group đã tham gia trước ngày 20/12/2019
SELECT GroupName FROM `Group`
WHERE CreateDate < '2019-12-20';

-- Question 7: Lấy ra ID của question có >= 4 câu trả lời
SELECT QuestionID FROM `Answer`
WHERE (SELECT COUNT(QuestionID) FROM `Answer`) >= 4
GROUP BY QuestionID
HAVING COUNT(QuestionID) >= 4; 

-- Question 8: Lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày 20/12/2019
SELECT `Code` FROM `Exam` 
WHERE Duration >= 60 AND CreateDate < '2019-12-20';

-- Question 9: Lấy ra 5 group được tạo gần đây nhất
SELECT * FROM `Group`
ORDER BY CreateDate DESC
LIMIT 5;

-- Question 10: Đếm số nhân viên thuộc department có id = 2
SELECT COUNT(DepartmentID) FROM `Account`
WHERE DepartmentID = 2;

-- Question 11: Lấy ra nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o"
SELECT * FROM `Account`
WHERE FullName LIKE 'D%o';

-- Question 12: Xóa tất cả các exam được tạo trước ngày 20/12/2019
DELETE FROM `Exam` WHERE CreateDate < '2019-12-20';

-- Question 13: Xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi"
DELETE FROM `Question` WHERE Content LIKE N'Câu hỏi%';

-- Question 14: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.com.vn
UPDATE `Account`
SET FullName = (N'Nguyễn Bá Lộc'), Email = 'loc.nguyenba@vti.com.vn'
WHERE AccountID = 5;

-- Question 15: update account có id = 5 sẽ thuộc group có id = 4
UPDATE `GroupAccount`
SET GroupID = 4
WHERE AccountID = 5;



