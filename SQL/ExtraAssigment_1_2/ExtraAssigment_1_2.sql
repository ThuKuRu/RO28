DROP DATABASE IF EXISTS ExtraAssignment_1_2;
CREATE DATABASE ExtraAssignment_1_2;
USE ExtraAssignment_1_2;

-- Exercise 1:Design a table
-- Question 1: Tạo table với các ràng buộc và kiểu dữ liệu
DROP TABLE IF EXISTS `Trainee`;
CREATE TABLE `Trainee` (
	TraineeID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Full_Name				VARCHAR(30) NOT NULL,
    Birth_Date				DATE NOT NULL,
    Gender					ENUM('male', 'female', 'unknown'),
    ET_IQ					TINYINT UNSIGNED NOT NULL,
							CHECK (ET_IQ <= 20),	
    ET_Gmath				TINYINT UNSIGNED NOT NULL,
							CHECK (ET_IQ <= 20),
    ET_English             	TINYINT UNSIGNED NOT NULL,
							CHECK (ET_IQ <= 50),   
	Training_Class			TINYINT UNSIGNED NOT NULL,
    Evaluation_Notes		VARCHAR(200) 
    );
    
-- Question 2: thêm trường VTI_Account với điều kiện not null & unique
ALTER TABLE Trainee ADD COLUMN VTI_Account TINYINT UNSIGNED UNIQUE NOT NULL;
    
-- Exercise 2: Data Types
DROP TABLE IF EXISTS `DataTypes1`;
CREATE TABLE `DataTypes1` (
	ID 						INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Name`					VARCHAR(30) NOT NULL,
    `Code`					CHAR(5) UNIQUE NOT NULL,
    ModifiedDate			DATETIME
);
    
-- Exercise 3: Data Types (2)
DROP TABLE IF EXISTS `DataTypes2`;
CREATE TABLE `DataTypes2` (
	ID 						INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Name`					VARCHAR(30) NOT NULL,
    BirthDate				DATE NOT NULL,
    Gender					ENUM('male', 'female', 'unknown'),
    IsDeletedFlag			BIT NOT NULL
); 
    

    
    
   
   
    
    
    

