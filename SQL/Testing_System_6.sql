USE Testing_System_Assigment; 

-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó
DROP PROCEDURE IF EXISTS `DEPARTMENT_ACCOUNT`;

DELIMITER $$
CREATE PROCEDURE `DEPARTMENT_ACCOUNT` (IN Department_Name NVARCHAR(30))
			BEGIN
                SELECT A.AccountID, A.FullName
                FROM `Department` D
                INNER JOIN `Account` A
                ON D.DepartmentID = A.DepartmentID
                WHERE D.DepartmentName = Department_Name;
			END $$
DELIMITER ;

CALL `DEPARTMENT_ACCOUNT`('Sale');

-- Question 2: Tạo store để in ra số lượng account trong mỗi group
DROP PROCEDURE IF EXISTS `ACCOUNT_GROUP`;

DELIMITER $$
CREATE PROCEDURE `ACCOUNT_GROUP` ()
			BEGIN
                SELECT		G.GroupID, G.GroupName, COUNT(GA.AccountID) AS 'SO LUONG'
				FROM		`Group` G
				INNER JOIN 	`GroupAccount` GA
				ON			G.GroupID = GA.GroupID
				GROUP BY	G.GroupID
				ORDER BY	COUNT(G.GroupID) ASC;
			END $$
DELIMITER ;

CALL `ACCOUNT_GROUP` ();

-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại
DROP PROCEDURE IF EXISTS `TYPE_QUESTION_PRESENT`;

DELIMITER $$
CREATE PROCEDURE `TYPE_QUESTION_PRESENT` ()
			BEGIN
                SELECT 		T.TypeName, COUNT(Q.TypeID) AS 'SO LUONG'
				FROM 		`Question` Q
				INNER JOIN  `TypeQuestion` T
				ON 			T.TypeID = Q.TypeID
                WHERE 		MONTH(Q.CreateDate) = MONTH(NOW()) AND YEAR(Q.CreateDate) = YEAR(NOW())
				GROUP BY 	Q.TypeID
				ORDER BY 	COUNT(Q.TypeID);
			END $$
DELIMITER ;

CALL `TYPE_QUESTION_PRESENT`();

-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
DROP PROCEDURE IF EXISTS `TYPE_QUESTION_MAX`;

DELIMITER $$
CREATE PROCEDURE `TYPE_QUESTION_MAX` (OUT v TINYINT)
			BEGIN
				SELECT 		Q.TypeID INTO v
				FROM 		`Question` Q
				INNER JOIN  `TypeQuestion` T
				ON 			T.TypeID = Q.TypeID
				GROUP BY 	Q.TypeID
				ORDER BY 	COUNT(Q.TypeID) DESC
                LIMIT 		1;
			END $$
DELIMITER ;

-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question
SET @v = 0;

CALL `TYPE_QUESTION_MAX`(@v);
 
SELECT 		TypeName FROM `TypeQuestion`
WHERE 		TypeID = @v;

-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa chuỗi của người dùng nhập vào
DROP PROCEDURE IF EXISTS `ENTER_USER`;

DELIMITER $$
CREATE PROCEDURE  `ENTER_USER` (IN Enter_Name VARCHAR(100), IN enter TINYINT)
			BEGIN
				IF enter = 1 THEN
					SELECT		G.GroupID, G.GroupName
					FROM		`GroupAccount` GA 
					INNER JOIN 	`Group` G
					ON			G.GroupID = GA.GroupID
					INNER JOIN 	`Account` A
					ON			A.AccountID = GA.AccountID
					WHERE 		A.FullName LIKE Enter_Name;
				ELSE
					SELECT		A.Username
					FROM		`GroupAccount` GA 
					INNER JOIN 	`Group` G
					ON			G.GroupID = GA.GroupID
					INNER JOIN 	`Account` A
					ON			A.AccountID = GA.AccountID
					WHERE 		A.FullName LIKE Enter_Name;
                END IF;
			END $$
DELIMITER ;

CALL `ENTER_USER` ('Nguyen 8', 1);
CALL `ENTER_USER` ('Nguyen 8', 2);

-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và trong store sẽ tự động gán: 
-- username sẽ giống email nhưng bỏ phần @..mail đi
-- positionID: sẽ có default là developer
-- departmentID: sẽ được cho vào 1 phòng chờ
-- Sau đó in ra kết quả tạo thành công
DROP PROCEDURE IF EXISTS `ENTER_ACCOUNT`;
DELIMITER $$
CREATE PROCEDURE `ENTER_ACCOUNT` (IN full_name VARCHAR(100), IN email VARCHAR(50))
			BEGIN
				DECLARE Username VARCHAR(50) DEFAULT SUBSTRING_INDEX(email,'@',1);
				DECLARE PositionID TINYINT UNSIGNED DEFAULT 1;
				DECLARE DepartmentID TINYINT UNSIGNED DEFAULT 25;
				DECLARE CreateDate DATETIME DEFAULT NOW();
	
				INSERT INTO `Account` 	(Email,		Username, 	FullName, 		DepartmentID,	PositionID,		CreateDate)
				VALUES					(email, 	Username, 	full_name, 		DepartmentID, 	PositionID, 	CreateDate);
	
				SELECT 	*
				FROM 	`Account`A
				WHERE	A.Username = Username;
			END $$
DELIMITER ;

CALL `ENTER_ACCOUNT`(N'Nguyễn Thị Thu', 'Thu2552002bn@gmail.com');

-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất
DROP PROCEDURE IF EXISTS `CONTENT_MAX`;

DELIMITER $$
CREATE PROCEDURE `CONTENT_MAX`(IN type_name ENUM('Essay', 'Multiple-Choice'))
			BEGIN
				SELECT 		T.TypeName, Q.Content
				FROM 		`Question` Q
				INNER JOIN  `TypeQuestion` T
				ON 			T.TypeID = Q.TypeID
                WHERE 		T.TypeName = type_name AND length(Q.Content) = (
																			SELECT MAX(length(Q.Content))
																			FROM 		`Question` Q
																			INNER JOIN  `TypeQuestion` T
																			ON 			T.TypeID = Q.TypeID
                                                                            WHERE T.TypeName = type_name
                                                                            );
			END $$
DELIMITER ;

CALL `CONTENT_MAX`('Essay');
CALL `CONTENT_MAX`('Multiple-Choice');

-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
DROP PROCEDURE IF EXISTS `DELETE_EXAM`;

DELIMITER $$
CREATE PROCEDURE `DELETE_EXAM`(IN v TINYINT)
			BEGIN
				DELETE FROM `Exam` WHERE v = ExamID;
            END $$
DELIMITER ;

CALL `DELETE_EXAM`(5);

-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử dụng store ở câu 9 để xóa)
-- Sau đó in số lượng record đã remove từ các table liên quan trong khi removing
DROP PROCEDURE IF EXISTS `DELETE_EXAM_3_YEARS`;

DELIMITER $$
CREATE PROCEDURE `DELETE_EXAM_3_YEARS`()
	BEGIN
		WITH ExamID3Year AS (
												SELECT 	ExamID
												FROM 	Exam
												WHERE	(YEAR(NOW()) - YEAR(CreateDate)) > 3
												)
		DELETE FROM 	Exam
		WHERE 	ExamID = (
						  SELECT * 
						  FROM ExamID3Year
						 );
	END $$
DELIMITER ;

CALL `DELETE_EXAM_3_YEARS`;

-- Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được chuyển về phòng ban default là phòng ban chờ việc
DROP PROCEDURE IF EXISTS `DELETE_DEPARTMENT_NAME`;

DELIMITER $$
CREATE PROCEDURE `DELETE_DEPARTMENT_NAME`(IN var_DepartmentName VARCHAR(30))
	BEGIN
		DECLARE v_DepartmentID TINYINT UNSIGNED;
		SELECT 	DepartmentID INTO v_DepartmentID 
		FROM 	`Department` 
		WHERE 	DepartmentName = var_DepartmentName;
        DELETE FROM `Department` 
		WHERE 	DepartmentName = var_DepartmentName;
		UPDATE 	`Account` 
		SET 	DepartmentID = '25' 
		WHERE 	DepartmentID = v_DepartmentID;
	END $$
DELIMITER ;

Call `DELETE_DEPARTMENT_NAME`('Sale');

-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay
DROP PROCEDURE IF EXISTS `COUNT_QUESTION_MONTH`;

DELIMITER $$
CREATE PROCEDURE `COUNT_QUESTION_MONTH`()
	BEGIN
		WITH CTE_12Months AS (
								SELECT 1 AS MONTH
								UNION SELECT 2 AS MONTH
								UNION SELECT 3 AS MONTH
								UNION SELECT 4 AS MONTH
								UNION SELECT 5 AS MONTH
								UNION SELECT 6 AS MONTH
								UNION SELECT 7 AS MONTH
								UNION SELECT 8 AS MONTH
								UNION SELECT 9 AS MONTH
								UNION SELECT 10 AS MONTH
								UNION SELECT 11 AS MONTH
								UNION SELECT 12 AS MONTH
							 )
		SELECT M.MONTH, COUNT(month(Q.CreateDate)) AS SO_LUONG 
		FROM CTE_12Months M
		LEFT JOIN (
					SELECT * FROM question Q1 
					WHERE YEAR(Q1.CreateDate) = YEAR(NOW()) 
				) Q
		ON M.MONTH = MONTH(Q.CreateDate)
		GROUP BY M.MONTH;
	END $$
DELIMITER ;

Call `COUNT_QUESTION_MONTH`();

-- Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6 tháng gần đây nhất (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong tháng")
DROP PROCEDURE IF EXISTS `COUNT_QUESTION_6_MONTH`;

DELIMITER $$
CREATE PROCEDURE `COUNT_QUESTION_6_MONTH`()
	BEGIN
		WITH CTE_Talbe_6MonthBefore AS (
										SELECT MONTH(DATE_SUB(NOW(), INTERVAL 5 MONTH)) AS MONTH,
										YEAR(DATE_SUB(NOW(), INTERVAL 5 MONTH)) AS `YEAR`
										UNION
										SELECT MONTH(DATE_SUB(NOW(), INTERVAL 4 MONTH)) AS MONTH,
										YEAR(DATE_SUB(NOW(), INTERVAL 4 MONTH)) AS `YEAR`
										UNION
										SELECT MONTH(DATE_SUB(NOW(), INTERVAL 3 MONTH)) AS MONTH,
										YEAR(DATE_SUB(NOW(), INTERVAL 3 MONTH)) AS `YEAR`
										UNION
										SELECT MONTH(DATE_SUB(NOW(), INTERVAL 2 MONTH)) AS MONTH,
										YEAR(DATE_SUB(NOW(), INTERVAL 2 MONTH)) AS `YEAR`UNION
										SELECT MONTH(DATE_SUB(NOW(), INTERVAL 1 MONTH)) AS MONTH,
										YEAR(DATE_SUB(NOW(), INTERVAL 1 MONTH)) AS `YEAR`
										UNION
										SELECT MONTH(NOW()) AS MONTH, YEAR(NOW()) AS `YEAR`
										)
		SELECT M.MONTH,M.YEAR, CASE
		WHEN COUNT(QuestionID) = 0 THEN 'không có câu hỏi nào trong tháng'
		ELSE COUNT(QuestionID)
		END AS SO_LUONG
		FROM CTE_Talbe_6MonthBefore M
		LEFT JOIN (
					SELECT * FROM question 
                    WHERE CreateDate >= DATE_SUB(NOW(), INTERVAL 6 MONTH) AND CreateDate <= now()
				   ) AS Sub_Question 
        ON M.MONTH = MONTH(CreateDate)
		GROUP BY M.MONTH
		ORDER BY M.MONTH ASC;
	END $$
DELIMITER ;

CALL `COUNT_QUESTION_6_MONTH`;

