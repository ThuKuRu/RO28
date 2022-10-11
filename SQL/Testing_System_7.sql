USE Testing_System_Assigment; 

-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo trước 1 năm trước
DROP TRIGGER IF EXISTS `GROUP_1_YEAR`;

DELIMITER $$
CREATE TRIGGER `GROUP_1_YEAR`
BEFORE INSERT ON `Group`
FOR EACH ROW
	BEGIN
		IF NEW.CreateDate > (SELECT DATE_SUB(NOW(), INTERVAL 1 YEAR)) THEN
        SIGNAL SQLSTATE '12345'
        SET MESSAGE_TEXT = N'Không thể thêm';
        END IF;
    END $$
DELIMITER ;

INSERT INTO `Group` 	(GroupName, 		CreatorID, 		 CreateDate)
VALUES 					('GroupName11', 	2, 				'2022-05-30');

-- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào department "Sale" nữa, khi thêm thì hiện ra thông báo "Department "Sale" cannot add more user"
DROP TRIGGER IF EXISTS `INSERT_USER`;

DELIMITER $$
CREATE TRIGGER `INSERT_USER`
BEFORE INSERT ON `Account`
FOR EACH ROW
	BEGIN
		DECLARE var_DepartmentID TINYINT;
		SELECT 	DepartmentID INTO var_DepartmentID
        FROM 	`Department` 
		WHERE 	DepartmentName = 'Sale';
		IF NEW.DepartmentID = var_DepartmentID THEN
        SIGNAL SQLSTATE '12346'
        SET MESSAGE_TEXT = 'Department "Sale" cannot add more user';
        END IF;
    END $$
DELIMITER ;

INSERT INTO `Account` 	(Email, 			 Username, 		 FullName, 			DepartmentID, 	PositionID, 	 CreateDate)
VALUES 					('HA@gmail.com', 	'HA', 			 'HA123', 			2, 				3, 				'1982-05-25');
                                
-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user
DROP TRIGGER IF EXISTS `CAU_HINH_GROUP`;

DELIMITER $$
CREATE TRIGGER `CAU_HINH_GROUP`
BEFORE INSERT ON `GroupAccount`
FOR EACH ROW
	BEGIN
		DECLARE var_CountGroupID TINYINT;
		SELECT 	COUNT(GA.GroupID) INTO var_CountGroupID 
        FROM 	`GroupAccount` GA
		WHERE 	GA.GroupID = NEW.GroupID;
		IF (var_CountGroupID > 5) THEN
		SIGNAL SQLSTATE '12347'
		SET MESSAGE_TEXT = N'Vượt quá số người quy định';
        END IF;
    END $$
DELIMITER ;

INSERT INTO `GroupAccount` 	(GroupID, 	AccountID,		JoinDate)
VALUES 						(5, 		11,				'2022-07-30');

-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question
DROP TRIGGER IF EXISTS `CAU_HINH_EXAM`;

DELIMITER $$
CREATE TRIGGER `CAU_HINH_EXAM`
BEFORE INSERT ON `ExamQuestion`
FOR EACH ROW
	BEGIN
		DECLARE var_CountQuesInExam TINYINT;
		SELECT 	COUNT(EQ.ExamID) INTO var_CountQuesInExam 
        FROM 	`ExamQuestion` EQ
		WHERE 	EQ.ExamID = NEW.ExamID;
		IF (var_CountQuesInExam > 3) THEN
		SIGNAL SQLSTATE '12348'
		SET MESSAGE_TEXT = N'Vượt quá số câu hỏi bài thi quy định';
        END IF;
    END $$
DELIMITER ;

INSERT INTO `ExamQuestion`	(ExamID , 	QuestionID )
VALUES 						(1, 		5);

-- Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là admin@gmail.com (đây là tài khoản admin, không cho phép user xóa), còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông tin liên quan tới user đó
DROP TRIGGER IF EXISTS `DELETE_ACCOUNT`;

DELIMITER $$
CREATE TRIGGER `DELETE_ACCOUNT`
BEFORE DELETE ON `Account`
FOR EACH ROW
	BEGIN
		IF OLD.Email = 'admin@gmail.com' THEN
        SIGNAL SQLSTATE '12349'
		SET MESSAGE_TEXT = N'Đây là tài khoản admin, không cho phép user xóa';
        END IF;
    END $$
DELIMITER ;

DELETE FROM `Account`
WHERE Email = 'admin@gmail.com';

INSERT INTO `Account` 	(Email, 			 Username, 		 FullName, 			DepartmentID, 	PositionID, 	 CreateDate)
VALUES 					('admin@gmail.com',  'admin', 		 'admin', 			 5, 			1, 				'1992-05-25');

-- Question 6: Không sử dụng cấu hình default cho field DepartmentID của table Account, hãy tạo trigger cho phép người dùng khi tạo account không điền vào departmentID thì sẽ được phân vào phòng ban "waiting Department"
DROP TRIGGER IF EXISTS `INSERT_ACCOUNT`;

DELIMITER $$
CREATE TRIGGER `INSERT_ACCOUNT`
BEFORE INSERT ON `Account`
FOR EACH ROW
	BEGIN
		DECLARE v_WaittingRoom VARCHAR(50);
		SELECT 	D.DepartmentID INTO v_WaittingRoom 
        FROM 	`Department` D 
        WHERE 	D.DepartmentName = 'Waitting Room';
		IF (NEW.DepartmentID IS NULL ) THEN
		SET NEW.DepartmentID = v_WaittingRoom;
        END IF;
    END $$
DELIMITER ;

INSERT INTO `Department`(DepartmentName)
VALUES 					('Waitting Room');

INSERT INTO `Account` 	(Email, 			 Username, 		 FullName,  	PositionID, 	 CreateDate)
VALUES 					('123@gmail.com',  	 '123', 		 '123', 		3, 				'2003-05-25');

-- Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi question, trong đó có tối đa 2 đáp án đúng.
DROP TRIGGER IF EXISTS `CAU_HINH_BAI_THI`;

DELIMITER $$
CREATE TRIGGER `CAU_HINH_BAI_THI`
BEFORE INSERT ON `Answer`
FOR EACH ROW
	BEGIN
		DECLARE var_QuestionID TINYINT;
        DECLARE var_isCorrect TINYINT;
		SELECT 	COUNT(A.QuestionID) INTO var_QuestionID 
        FROM 	`Answer` A
		WHERE 	A.QuestionID = NEW.QuestionID;
        SELECT 	COUNT(A.isCorrect) INTO var_isCorrect
        FROM 	`Answer` A
		WHERE 	A.isCorrect = NEW.isCorrect;
		IF (var_QuestionID > 4 OR var_isCorrect > 2) THEN
        SIGNAL SQLSTATE '13333'
		SET MESSAGE_TEXT = N'Vượt quá số lượng cho phép';
        END IF;
    END $$
DELIMITER ;

INSERT INTO `Answer` 	( Content , 	QuestionID , 	isCorrect )
VALUES 					('Answer12', 	2, 				1);

-- Question 8: Viết trigger sửa lại dữ liệu cho đúng: Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database
DROP TRIGGER IF EXISTS `GENDER`;

DELIMITER $$
CREATE TRIGGER `GENDER`
BEFORE INSERT ON `Account`
FOR EACH ROW
	BEGIN
		IF NEW.Gender = 'Nam' THEN
		SET NEW.Gender = 'M';
		ELSEIF NEW.Gender = N'Nữ' THEN
		SET NEW.Gender = 'F';
		ELSEIF NEW.Gender = N'Chưa xác định' THEN
		SET NEW.Gender = 'U';
        END IF;
    END $$
DELIMITER ;

-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày
DROP TRIGGER IF EXISTS `DELETE_EXAM_2_DAYS`;

DELIMITER $$
CREATE TRIGGER `DELETE_EXAM_2_DAYS`
BEFORE DELETE ON `Exam`
FOR EACH ROW
	BEGIN
		IF OLD.CreateDate > (SELECT DATE_SUB(NOW(), INTERVAL 2 DAY)) THEN
        SIGNAL SQLSTATE '12352'
        SET MESSAGE_TEXT = N'Không thể xóa';
        END IF;
    END $$
DELIMITER ;

DELETE FROM `Exam`
WHERE CreateDate = '2022-10-09';

INSERT INTO `Exam` 	(`Code`, 		Title, 		CategoryID, 	Duration, 	CreatorID, 	CreateDate)
VALUES 				('000011', 		'C#', 		5, 				60, 		3, 			'2022-10-09');

-- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các question khi question đó chưa nằm trong exam nào
DROP TRIGGER IF EXISTS 	`UPDATE_DELETE_QUESTION`;

DELIMITER $$
CREATE TRIGGER `UPDATE_DELETE_QUESTION`
BEFORE DELETE ON `Question`
FOR EACH ROW
	BEGIN
		DECLARE var_Count_QuestionID TINYINT;
        SET var_Count_QuestionID = 0;
        SELECT COUNT(1) INTO var_Count_QuestionID 
        FROM `ExamQuestion` E 
        WHERE E.QuestionID = OLD.QuestionID;
		IF var_Count_QuestionID != 0 THEN
        SIGNAL SQLSTATE '44444'
        SET MESSAGE_TEXT = N'Không thể xóa';
        END IF;
    END $$
DELIMITER ;

DROP TRIGGER IF EXISTS 	`UPDATE_DELETE_QUESTION_1`;

DELIMITER $$
CREATE TRIGGER `UPDATE_DELETE_QUESTION_1`
BEFORE UPDATE ON `Question`
FOR EACH ROW
	BEGIN
		DECLARE var_Count_QuestionID_1 TINYINT;
        SET var_Count_QuestionID_1 = 0;
        SELECT COUNT(1) INTO var_Count_QuestionID_1 
        FROM `ExamQuestion` E 
        WHERE E.QuestionID = OLD.QuestionID;
		IF var_Count_QuestionID_1 != 0 THEN
        SIGNAL SQLSTATE '55555'
        SET MESSAGE_TEXT = N'Không thể xóa';
        END IF;
    END $$
DELIMITER ;

DELETE FROM `Question`
WHERE QuestionID = 7;

-- Question 12: Lấy ra thông tin exam trong đó:
-- Duration <= 30 thì sẽ đổi thành giá trị "Short time"
-- 30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time"
-- Duration > 60 thì sẽ đổi thành giá trị "Long time"
SELECT E.ExamID, E.Code, E.Title , CASE
WHEN Duration <= 30 THEN 'Short time'
WHEN Duration <= 60 THEN 'Medium time'
ELSE 'Longtime'
END AS Duration, E.CreateDate
FROM  `Exam` E;

-- Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên là the_number_user_amount và mang giá trị được quy định như sau:
-- Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few
-- Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal
-- Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher
SELECT GA.GroupID, COUNT(GA.GroupID), CASE
WHEN COUNT(GA.GroupID) <= 5 THEN 'few'
WHEN COUNT(GA.GroupID) <= 20 THEN 'normal'
ELSE 'higher'
END AS the_number_user_amount
FROM `GroupAccount` GA
GROUP BY GA.GroupID;

-- Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào không có user thì sẽ thay đổi giá trị 0 thành "Không có User"
SELECT D.DepartmentName, CASE
WHEN COUNT(A.DepartmentID) = 0 THEN 'Không có User'
ELSE COUNT(A.DepartmentID)
END AS SO_LUONG
FROM `Department` D
LEFT JOIN account A 
ON D.DepartmentID = A.DepartmentID
GROUP BY D.DepartmentID;



