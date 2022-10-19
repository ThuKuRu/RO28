DROP DATABASE IF EXISTS Testing_Exam;
CREATE DATABASE  Testing_Exam;
USE  Testing_Exam;

-- 1. Tạo table với các ràng buộc và kiểu dữ liệu.Thêm ít nhất 5 bản ghi vào table.
CREATE TABLE `CUSTOMER`(
	CustomerID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Name`				VARCHAR(100) NOT NULL UNIQUE KEY,
    Phone				CHAR(11) NOT NULL UNIQUE KEY,
    Email				VARCHAR(50) NOT NULL UNIQUE KEY,
    Address				VARCHAR(250) NOT NULL,
    Note				VARCHAR(500) 
);

CREATE TABLE `CAR`(
	CarID				TINYINT UNSIGNED PRIMARY KEY,	
    Maker				ENUM('HONDA', 'TOYOTA', 'NISSAN'),
    Model				VARCHAR(50) NOT NULL UNIQUE KEY,
    `Year`				YEAR NOT NULL,
	Color				VARCHAR(30) NOT NULL,
    Note				VARCHAR(500)
);

CREATE TABLE `CAR_ORDER`(
	OrderID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CustomerID			TINYINT UNSIGNED NOT NULL,
    CarID				TINYINT UNSIGNED NOT NULL,
    Amount				TINYINT UNSIGNED DEFAULT '1',
    SalePrice			BIGINT UNSIGNED,
    OrderDate			DATE NOT NULL,
    DeliveryDate		DATE NOT NULL,
    DeliveryAddress		VARCHAR(250) NOT NULL,
    Staus				ENUM ('0', '1', '2') DEFAULT '0',
    Note 				VARCHAR(500),
    FOREIGN KEY (CustomerID) REFERENCES  `CUSTOMER`(CustomerID) ON DELETE CASCADE,
    FOREIGN KEY (CarID) REFERENCES  `CAR`(CarID) ON DELETE CASCADE
);

INSERT INTO `CUSTOMER`	(`Name`,				 Phone, 			Email,				  		Address,			Note			)
VALUES					(N'Nguyễn Thị Thu',		'0865456605',		'Thu2552002bn@gmail.com',	N'Bắc Ninh',		NULL					),
						(N'Nguyễn Bá Hoàng',	'0987847442',		'Hoangba123@gmail.com',		N'Hà Nội',			N'Khách VIP'			),
                        (N'Ngô Thị Hồng Hạnh',	'0873442204',		'Hanhngo@gmail.com',		N'Bắc Ninh',		N'Khách hàng tiềm năng'	),
                        (N'Trần Bá Học',		'0868448882',		'Hoc1234n@gmail.com',		N'Nam Định',		NULL					),
                        (N'Phạm Văn Đồng',		'0979464646',		'Dongvan123@gmail.com',		N'Nghệ An',			N'Khách hàng tiềm năng' );

INSERT INTO `CAR`		(CarID,		Maker,			 Model,					`Year`,		Color, 			Note		)
VALUES					(1,			'HONDA',		'HONDA ACCORD', 		'2012',		'red',			N'Bán Chạy'	),
						(2,			'TOYOTA',		'TOYOTA RAIZE', 		'2018',		'black',	 	NULL		),
                        (3,			'TOYOTA',		'TOYOTA ALPHARD', 		'2020',		'red',			NULL		),
                        (4,			'NISSAN',		'NISSAN NAVARA', 		'2010',		'black',		N'Bán Chạy'	),
                        (5,			'HONDA',		'HONDA HR-V', 			'2022',		'white',		NULL		);
                        
INSERT INTO `CAR_ORDER` (CustomerID,  	CarID, 	SalePrice,		OrderDate,		DeliveryDate, 	DeliveryAddress,	Staus,	 	Note	)  
VALUES					(1,			  	1,		1319000000,	 	'2022-05-25',	'2022-05-25',	N'Bắc Ninh',		'1',			NULL	),     
						(3,			  	2,		527000000,	 	'2019-06-30',	'2019-07-30',	N'Bắc Ninh',		'1',			NULL	), 
                        (2,			  	5,		998000000,	 	'2020-01-20',	'2021-01-20',	N'Hà Nội',			'0',			NULL	), 
                        (2,			  	4,		945000000,	 	'2021-02-28',	'2021-05-30',	N'Hà Nội',			'2',			NULL	), 
                        (2,			  	1,		1319000000,	 	'2022-06-30',	'2022-07-30',	N'Hà Nội',			'1',			NULL	);

-- 2. Viết lệnh lấy ra thông tin của khách hàng: tên, số lượng oto khách hàng đã mua và sắp sếp tăng dần theo số lượng oto đã mua.
SELECT 		CU.`Name`, COUNT(CA.CustomerID) AS SO_LUONG
FROM 		`CUSTOMER` CU
INNER JOIN 	`CAR_ORDER` CA
ON 			CU.CustomerID = CA.CustomerID
GROUP BY  	CA.CustomerID
ORDER BY 	COUNT(CA.CustomerID);

-- LEFT JOIN : liệt kê toàn bộ kể cả khách hàng không mua

-- 3. Viết hàm (không có parameter) trả về tên hãng sản xuất đã bán được nhiều oto nhất trong năm nay.
SELECT 		C.Maker, COUNT(CA.CarID) AS SO_LUONG
FROM 		`CAR` C
INNER JOIN  `CAR_ORDER` CA
ON			C.CarID = CA.CarID
WHERE 		Staus = '1' AND YEAR(DeliveryDate) = YEAR(NOW())
GROUP BY  	CA.CarID
HAVING COUNT(CA.CarID) = (	
								SELECT 		COUNT(CA.CarID)
								FROM 		`CAR` C
								INNER JOIN  `CAR_ORDER` CA
								ON			C.CarID = CA.CarID
                                WHERE 		Staus = '1' AND YEAR(DeliveryDate) = YEAR(NOW())
								GROUP BY  	CA.CarID
                                ORDER BY	COUNT(CA.CarID) DESC
                                LIMIT 		1
                                );
                                
-- dùng CTE
WITH `CTE_COUNT` AS (
		SELECT 		C.Maker, COUNT(CA.CarID) AS SO_LUONG
		FROM 		`CAR` C
		INNER JOIN  `CAR_ORDER` CA
		ON			C.CarID = CA.CarID
		WHERE 		Staus = '1' AND YEAR(DeliveryDate) = YEAR(NOW())
)
SELECT * FROM `CTE_COUNT` 
WHERE SO_LUONG = (SELECT MAX(SO_LUONG) FROM `CTE_COUNT`);

 -- VIẾT THỦ TỤC : có thể là trigger hoặc procedure
-- 4. Viết 1 thủ tục (không có parameter) để xóa các đơn hàng đã bị hủy của những năm trước. In ra số lượng bản ghi đã bị xóa.
-- xác định yêu cầu bài 
DELETE FROM `CAR_ORDER`
WHERE Staus = '2' AND YEAR(OrderDate) != YEAR(NOW()); 

-- tính số bản ghi bị xóa 
SELECT COUNT(OrderID) 
FROM `CAR_ORDER`
WHERE Staus = '2' AND YEAR(OrderDate) != YEAR(NOW()); 

-- tạo procedure
DROP PROCEDURE IF EXISTS `DELETE_CAR_ORDER`;

DELIMITER $$
CREATE PROCEDURE `DELETE_CAR_ORDER` ()
			BEGIN
				DECLARE v_delete TINYINT;
				SELECT COUNT(OrderID) INTO v_delete
				FROM `CAR_ORDER`
				WHERE Staus = '2' AND YEAR(OrderDate) != YEAR(NOW()); 
                DELETE FROM `CAR_ORDER`
				WHERE Staus = '2' AND YEAR(OrderDate) != YEAR(NOW()); 
                SELECT v_delete;
			END $$
DELIMITER ; 

CALL `DELETE_CAR_ORDER` ();

-- CÂU 5 MẶC ĐỊNH LÀ PROCEDURE
-- 5. Viết 1 thủ tục (có CustomerID parameter) để in ra thông tin của các đơn hàng đã đặt hàng bao gồm: tên của khách hàng, mã đơn hàng, số lượng oto và tên hãng sản xuất.
SELECT 		CU.`Name`, CA.OrderID, CA.Amount, C.Maker
FROM 		`CUSTOMER` CU
INNER JOIN 	`CAR_ORDER` CA
ON 			CU.CustomerID = CA.CustomerID
INNER JOIN  `CAR` C
ON			C.CarID = CA.CarID
WHERE		CA.Staus = '1';
 
 -- procedure
DROP PROCEDURE IF EXISTS `INFORMATION_CAR_ORDER`;

DELIMITER $$
CREATE PROCEDURE `INFORMATION_CAR_ORDER` (IN v_CustomerID TINYINT)
			BEGIN
				SELECT 		CU.`Name`, CA.OrderID, CA.Amount, C.Maker
				FROM 		`CUSTOMER` CU
				INNER JOIN 	`CAR_ORDER` CA
				ON 			CU.CustomerID = CA.CustomerID
				INNER JOIN  `CAR` C
				ON			C.CarID = CA.CarID
				WHERE		CA.Staus = '1' AND CU.CustomerID = v_CustomerID;
			END $$
DELIMITER ;

CALL `INFORMATION_CAR_ORDER`(1);
-- 6. Viết trigger để tránh trường hợp người dụng nhập thông tin không hợp lệ vào database (DeliveryDate < OrderDate + 15).
DROP TRIGGER IF EXISTS `INSERT_DATA`;

DELIMITER $$
CREATE TRIGGER `INSERT_DATA`
BEFORE INSERT ON `CAR_ORDER`
FOR EACH ROW
	BEGIN
		IF (NEW.DeliveryDate < DATE_ADD(NEW.OrderDate, INTERVAL(15) DAY)) THEN
		SIGNAL SQLSTATE '12348'
		SET MESSAGE_TEXT = N'Thông tin không hợp lệ';
        END IF;
    END $$
DELIMITER ;

INSERT INTO `CAR_ORDER` (CustomerID,  	CarID, 	SalePrice,		OrderDate,		DeliveryDate, 	DeliveryAddress,	Staus,	 	Note	)  
VALUES					(5,			  	1,		1319000000,	 	'2022-05-25',	'2022-05-27',	N'Bắc Ninh',		'1',			NULL	);    