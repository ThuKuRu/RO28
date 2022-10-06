USE Testing_System_Assigment;

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
                        
INSERT INTO `Account` 	(Email, 			 Username, 		 FullName, 			DepartmentID, 	PositionID, 	 CreateDate)
VALUES 					('abc1@gmail.com', 	'Username1', 	'FullName12345', 	1, 				3, 				'1972-05-25'),
						('abc2@gmail.com', 	'Username2', 	'FullName2344', 	2, 				2, 				'2006-08-30'),
						('abc3@gmail.com', 	'Username3', 	'FullName312', 		3, 				4, 				'2016-12-08'),
						('abc4@gmail.com', 	'Username4', 	'FullName41',		2, 				1, 				'2000-10-06'),
						('abc5@gmail.com', 	'Username5', 	'FullName5', 		2, 				2,				'2008-03-21'),
						('abc6@gmail.com', 	'Username6', 	'FullName6', 		1, 				3, 				'1997-07-14'),
						('abc7@gmail.com', 	'Username7', 	'FullName7', 		2, 				1, 				'1990-06-25'),
						('abc8@gmail.com', 	'Username8', 	'Nguyen 8', 		7, 				2, 				'2020-11-24'),
						('abc9@gmail.com', 	'Username9', 	'FullName9', 		2, 				4, 				'2015-03-25'),
						('abc10@gmail.com', 'Username10', 	'Dao', 				1, 				3, 				'2014-06-04');

INSERT INTO `Group` 	(GroupName, 		CreatorID, 		 CreateDate)
VALUES 					('GroupName1', 		2, 				'2022-05-30'),
						('GroupName2', 		6, 				'2022-05-30'),
						('GroupName3', 		8, 				'2012-05-25'),
						('GroupName4', 		9, 				'2008-08-02'),
						('GroupName5', 		7, 				'2022-05-30'),
						('GroupName6', 		10, 			'2022-06-04'),
						('GroupName7', 		4, 				'2022-05-30'),
						('GroupName8', 		5, 				'2018-05-30'),
						('GroupName9', 		3,				'2022-05-30'),
						('GroupName10', 	1, 				'2002-05-30');
    
INSERT INTO `GroupAccount` 	(GroupID, 	JoinDate)
VALUES 						(5, 		'2022-05-30'),
							(9, 		'2022-05-30'),
							(5, 		'2022-05-30'),
							(5, 		'2022-05-30'),
							(6, 		'2022-05-30'),
							(5, 		'2022-05-30'),
							(5, 		'2022-05-30'),
							(5, 		'2002-05-25'),
							(5, 		'2022-05-30'),
							(5, 		'2012-05-08');

INSERT INTO `TypeQuestion` 	(TypeName)
VALUES 						('Essay'),
							('Multiple-Choice');

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
VALUES 					('Java Question', 		1,				1, 			2, 			'2022-05-30'),
						('Postman Question', 	10, 			2, 			9, 			'2012-04-05'),
						('SQL Question', 		3, 				1, 			6, 			'2020-04-05'),
						(N'Câu hỏi Ruby', 		5, 				2, 			6, 			'2022-08-08'),
						('.NET Question', 		2, 				1, 			2, 			'2006-04-06'),
						('C Question', 			2, 				1, 			2, 			'2020-04-05'),
						(N'Câu hỏi C++', 		7, 				1, 			9, 			'2018-04-05'),
						('Python Question', 	8, 				1,			2, 			'2020-04-16'),
						('HTML Question', 		3, 				2, 			8, 			'2002-12-05'),
						('CSS Question', 		3, 				1, 			6, 			'2009-05-08');

INSERT INTO `Answer` 	( Content , 	QuestionID , 	isCorrect )
VALUES 					('Answer1', 	2, 				0),
						('Answer2', 	8, 				0),
						('Answer3',	 	2, 				1),
						('Answer4', 	8, 				0),
						('Answer5', 	5, 				1),
						('Answer6', 	2, 				0),
						('Answer7', 	2, 				0),
						('Answer8',	 	2, 				0),
						('Answer9', 	8, 				0),
						('Answer10', 	8, 				1);
        
INSERT INTO `Exam` 	(`Code`, 		Title, 		CategoryID, 	Duration, 	CreatorID, 	CreateDate)
VALUES 				('000001', 		'C', 		5, 				90, 		2, 			'2022-05-30'),
					('000002', 		'Java', 	9, 				120, 		9, 			'2008-12-26'),
					('000003', 		'C++', 		6, 				60, 		2, 			'2002-05-04'),
					('000004', 		'SQL', 		10, 			90, 		8, 			'2012-05-30'),
					('000005', 		'HTML', 	1, 				45, 		8, 			'2020-05-30'),
					('000006', 		'CSS', 		8, 				90, 		6, 			'2022-01-01'),
					('000007', 		'Python', 	4, 				60, 		8, 			'2019-06-30'),
					('000008', 		'Ruby', 	3, 				90, 		2, 			'2012-03-01'),
					('000009', 		'.NET', 	7, 				60, 		8, 			'2005-08-09'),
					('000010', 		'Postman', 	1, 				45, 		9, 			'2010-10-10');

INSERT INTO `ExamQuestion`	(ExamID , 	QuestionID )
VALUES 						(1, 		1),
							(4,	 		5),
							(3, 		10),
							(1, 		1),
							(2, 		10),
							(10, 		4),
							(8,			2),
							(6, 		10),
							(9, 		10),
							(7, 		2);


