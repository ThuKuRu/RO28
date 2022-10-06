USE Testing_System_Assigment;  

-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
DROP VIEW IF EXISTS `SALE`;
CREATE VIEW `SALE` AS
SELECT 		A.*
FROM 		`Department` D
INNER JOIN  `Account` A
ON 			A.DepartmentID = D.DepartmentID
WHERE 		D.DepartmentName = 'Sale';

-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
DROP VIEW IF EXISTS `AccountGroup`;
CREATE VIEW `AccountGroup` AS
SELECT 		A.*, COUNT(GA.AccountID) AS 'SO LUONG'
FROM 		`Account` A
INNER JOIN 	`GroupAccount` GA
ON			A.AccountID = GA.AccountID
GROUP BY 	GA.AccountID
ORDER BY	COUNT(GA.AccountID) DESC
LIMIT 		1;

-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ được coi là quá dài) và xóa nó đi
CREATE VIEW `CONTENT` AS
SELECT * FROM `Question`
WHERE length(Content) > 13;
DROP VIEW IF EXISTS `CONTENT`;

-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
DROP VIEW IF EXISTS `AccountDepartment`;
CREATE VIEW `AccountDepartment` AS
SELECT D.DepartmentID, D.DepartmentName, COUNT(A.DepartmentID) AS 'SO LUONG'
FROM `Department` D
INNER JOIN  `Account` A
ON 			A.DepartmentID = D.DepartmentID
GROUP BY 	A.DepartmentID
ORDER BY	COUNT(A.DepartmentID) DESC
LIMIT 		1;

-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
DROP VIEW IF EXISTS `NGUYEN`;
CREATE VIEW `NGUYEN` AS
SELECT 		E.*
FROM 		`Exam` E
INNER JOIN 	`Account` A
ON			E.CreatorID = A.AccountID
WHERE 		A.FullName LIKE 'Nguyen%';