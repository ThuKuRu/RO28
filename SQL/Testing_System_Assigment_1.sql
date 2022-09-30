-- Câu lệnh để tạo 1 csdl
CREATE DATABASE Testing_System_Assigment;
USE Testing_System_Assigment;

-- Tạo bảng trong csdl
-- PRIMARY KEY : khóa chính, duy nhất k bị trùng
CREATE TABLE `Department` (
	DepartmentID 			INT PRIMARY KEY,
    DepartmentName			VARCHAR(30) NOT NULL UNIQUE KEY
    );
    
CREATE TABLE `Position` (
	PositionID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    PositionName			ENUM('Dev', 'Test', 'Scrum Master', 'PM') NOT NULL UNIQUE KEY
    );

-- STRING : chuỗi kí tự
-- VARCHAR : chuỗi kí tự ( '111111111111' -> đây là 1 chuỗi)
-- xem kiểu dữ liệu khai báo trên MySQL Data Types
-- * TINYINT : nhỏ ; * SMALLINT ; * INT
-- MEDIUMINT : vừa
-- FLOAT : lẻ, xấp xỉ -> tỉ giá hối đoái
-- * BIGINT: lớn -> những thứ vận dụng trong cuộc sống, giao dịch ngân hàng, viễn thông, tiền, giá trị đơn hàng
-- bài báo : TEXT
-- thêm dấu " `<tên bảng> `" vào trước tên bảng để tránh trùng với keyword
-- IDENTITY (10,1) : giá trị đầu là 10, bước nhảy 1
CREATE TABLE `Account` (
	AccountID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email					VARCHAR(50) NOT NULL UNIQUE KEY,
    Username				VARCHAR(50) NOT NULL UNIQUE KEY,
    FullName				VARCHAR(100) NOT NULL UNIQUE KEY,
    DepartmentID			TINYINT UNSIGNED UNIQUE KEY,
    PositionID				TINYINT UNSIGNED UNIQUE KEY,
    CreateDate				DATE NOT NULL
);
-- DROP TABLE : xóa bảng

CREATE TABLE `Group` (
	GroupID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    GroupName				VARCHAR(50) NOT NULL UNIQUE KEY,
    CreatorID				TINYINT NOT NULL UNIQUE KEY,
    CreateDate				DATE NOT NULL
);

CREATE TABLE `GroupAccount` (
	GroupID					TINYINT NOT NULL UNIQUE KEY,
    AccountID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY ,
    JoinDate				DATE NOT NULL
);

CREATE TABLE `TypeQuestion` (
	TypeID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    TypeName				ENUM('Essay', 'Multiple-Choice')
);

CREATE TABLE `CategoryQuestion` (
	CategoryID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CategoryName			ENUM('Java', '.NET', 'SQL', 'Postman', 'Ruby')
);

CREATE TABLE `Question` (
	QuestionID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Content				NVARCHAR(100) NOT NULL UNIQUE KEY,
	CategoryID			TINYINT NOT NULL UNIQUE KEY,
	TypeID 				TINYINT NOT NULL UNIQUE KEY,
	CreatorID			TINYINT NOT NULL UNIQUE KEY,
	CreateDate			DATE NOT NULL
	);
    
CREATE TABLE `Answer` (
	AnswerID			INT AUTO_INCREMENT,
    Content				NVARCHAR(100),
    QuestionID			INT,
    isCorrect			BOOLEAN
);
DROP TABLE `GroupAccount`;

CREATE TABLE `Exam` (
	ExamID 				INT AUTO_INCREMENT,
    `Code`				INT,
    Title				NVARCHAR(50),
    CategoryID			INT,
    Duration			TIME,
    CreatorID			INT,
    CreateDate			DATE
);
DROP TABLE `GroupAccount`;

CREATE TABLE `ExamQuestion` (
	ExamID				INT,
    QuestionID			INT
);
DROP TABLE `GroupAccount`;

-- DROP DATABASE IF EXISTS: xóa database nếu nó tồn tại
-- USE <tên database> -> sử dụng database
-- DROP TABLE IF EXIST: xóa bảng nếu nó tồn tại
-- UNSIGNED: không nhận số nguyên âm
-- AUTO_INCREMENT: tự động tăng không cần điền
-- NOT NULL: không được bỏ trống
-- UNIQUE KEY: tên không được trùng nhau
-- FOREIGN KEY: dùng để ánh xạ sang 1 bảng khác
-- DEFAULT: mặc định

    
    
    
        

    
    
    
    
