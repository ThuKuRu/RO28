DROP DATABASE IF EXISTS SQL_Final_Exam;
CREATE DATABASE  SQL_Final_Exam;
USE  SQL_Final_Exam;

-- 1. Tạo table với các ràng buộc và kiểu dữ liệu
DROP TABLE IF EXISTS `GiangVien`;
CREATE TABLE `GiangVien`(
	magv			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    hoten			VARCHAR(50) NOT NULL UNIQUE KEY,
    luong			BIGINT UNSIGNED
);

DROP TABLE IF EXISTS `SinhVien`;
CREATE TABLE `SinhVien`(
	masv			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    hoten			VARCHAR(50) NOT NULL UNIQUE KEY,
    namsinh			YEAR NOT NULL,
    quequan			VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS `DeTai`;
CREATE TABLE `DeTai`(
	madt 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    tendt			VARCHAR(100) NOT NULL,
    kinhphi			BIGINT UNSIGNED,
    NoiThucTap		VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS `HuongDan`;
CREATE TABLE `HuongDan`(
	id				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	masv			TINYINT UNSIGNED ,
    madt			TINYINT UNSIGNED,
    magv			TINYINT UNSIGNED,
    ketqua			ENUM ('Pass', 'Failed', 'Waiting for approval'),
    FOREIGN KEY (masv) REFERENCES `SinhVien`(masv) ON DELETE CASCADE,
    FOREIGN KEY (madt) REFERENCES `DeTai`(madt) ON DELETE CASCADE,
    FOREIGN KEY (magv) REFERENCES `GiangVien`(magv) ON DELETE CASCADE
);

-- Thêm ít nhất 3 bản ghi vào table
INSERT INTO `GiangVien`	(	hoten, 					luong		)
VALUES					(	N'Ngô Thị Hồng Hạnh',		15000000	),
						(	N'Trần Bá Hoàng',			16000000	),
                        (	N'Nguyễn Thị Lan Anh',		12500000	),
                        (	N'Đinh Văn Hùng',			10000000	),
                        (	N'Chu Văn An',				20000000	);
                        
INSERT INTO `SinhVien`	(	hoten, 						namsinh, 	quequan			)
VALUES					( 	N'Nguyễn Thị Thu',			'2002',		N'Bắc Ninh'		),
						( 	N'Nguyễn Hà Phú Thịnh',		'2000',		N'Hải Dương'	),
                        (	N'Ngô Thị Dương',			'2001',		N'Đà Nẵng'		),
                        ( 	N'Nguyễn Thị Như Quỳnh',	'1999',		N'Hà Nội'		),
                        ( 	N'Lê Bảo Bình',				'2003',		N'Sơn La'		);
                        
INSERT INTO `DeTai`		( 	tendt, 						kinhphi,	 	NoiThucTap 									)
VALUES					(	'CONG NGHE SINH HOC', 		25000000,		'Viện Nghiên Cứu Sinh Học Công Nghệ Cao'	),
						(	N'Ô NHIỄM NGUỒN NƯỚC', 		25000000,		'Trung Tâm Bảo Vệ Tài Nguyên Nước'			),
                        ( 	N'VẬT LÍ KĨ THUẬT ', 		25000000,		'Viện Vật lý Địa cầu '						),
                        (	N'MẠNG 5G', 				25000000,		'Viện Công nghệ Thông tin và Truyền thông '	),
                        ( 	N'LUẬT QUỐC TẾ', 			25000000,		'Trung Tâm Nghiên cứu Luật'					);

INSERT INTO `HuongDan` 	(masv, 	madt, 	magv, 	ketqua					)
VALUES					(5,		1,		1,		'Pass'					),
						(1,		4,		5,		'Pass'					),
                        (2,		3,		2,		'Failed'				),
                        (4,		5,		3,		'Waiting for approval'	);
                        
-- 2. Viết lệnh để
-- a) Lấy tất cả các sinh viên chưa có đề tài hướng dẫn
SELECT * 
FROM `SinhVien`
WHERE masv NOT IN ( SELECT 	masv
					FROM 	`HuongDan`);
				
-- b) Lấy ra số sinh viên làm đề tài ‘CONG NGHE SINH HOC’
	SELECT 		COUNT(H.masv)
    FROM		`HuongDan` H
    INNER JOIN 	`DeTai` D
    ON 			H.madt = D.madt
    WHERE 		H.madt = (	SELECT D.madt
							FROM		`DeTai` D
                            WHERE D.tendt = 'CONG NGHE SINH HOC');

-- 3. Tạo view có tên là "SinhVienInfo" lấy các thông tin về học sinh bao gồm: mã số, họ tên và tên đề tài
-- (Nếu sinh viên chưa có đề tài thì column tên đề tài sẽ in ra "Chưa có")
DROP VIEW IF EXISTS `SinhVienInfo`;

CREATE VIEW `SinhVienInfo` AS
	SELECT S.masv, S.hoten,
        CASE
            WHEN S.masv NOT IN (SELECT 		masv
								FROM 		`HuongDan`
								GROUP BY 	masv
                                )
            THEN N'Chưa có'
            ELSE D.tendt
        END AS Detai
    FROM 		`SinhVien` S
    LEFT JOIN 	`HuongDan` H 
    ON 			S.masv = H.masv
	LEFT JOIN 	`DeTai` D 
    ON 			D.madt = H.madt
    ORDER BY 	S.masv;

SELECT * FROM `SinhVienInfo`;

--  trigger cho table SinhVien khi insert sinh viên có năm sinh <= 1900 thì hiện ra thông báo "năm sinh phải > 1900"
DROP TRIGGER IF EXISTS `INSERT_DATE`;

DELIMITER $$
CREATE TRIGGER `INSERT_DATE`
BEFORE INSERT ON `SinhVien`
FOR EACH ROW
	BEGIN
		IF (NEW.namsinh <= 1900) THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = N'Năm sinh phải > 1900';
        END IF;
    END $$
DELIMITER ;

INSERT INTO `SinhVien`	(	hoten, 							namsinh, 	quequan			)
VALUE					( 	N'Nguyễn Thị Huệ',				'1900',		N'Bắc Ninh'		);

-- 5. Hãy cấu hình table sao cho khi xóa 1 sinh viên nào đó thì sẽ tất cả thông tin trong table HuongDan liên quan tới sinh viên đó sẽ bị xóa đi
DROP PROCEDURE IF EXISTS `DELETE_INFORMATION`;

DELIMITER $$
CREATE PROCEDURE `DELETE_INFORMATION`(IN v_masv TINYINT UNSIGNED)
	BEGIN
		DECLARE v TINYINT UNSIGNED;
		SELECT 	masv INTO  v_masv
		FROM 	`SinhVien`
		WHERE 	masv = v_masv;
        DELETE FROM `SinhVien`
		WHERE 	masv = v_masv;
		DELETE FROM `HuongDan`
		WHERE 	masv = v_masv;
	END $$
DELIMITER ;

CALL `DELETE_INFORMATION`(5);
