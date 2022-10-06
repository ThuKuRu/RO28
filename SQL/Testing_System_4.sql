USE Testing_System_Assigment;
						
-- Exercise 1: Join
-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT 		A.*, D.DepartmentID
FROM 		`Account` A
INNER JOIN 	`Department` D
ON 			A.DepartmentID = D.DepartmentID;

-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010
SELECT * FROM `Account`
WHERE CreateDate > 2010-12-20 ;

-- Question 3: Viết lệnh để lấy ra tất cả các developer
SELECT 		A.*, P.PositionName
FROM 		`Account` A
INNER JOIN 	`Position` P
ON 			A.PositionID = P.PositionID
WHERE 		P.PositionName = 'Dev';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT		D.DepartmentID, D.DepartmentName, COUNT(A.DepartmentID)
FROM		`Department` D 
INNER JOIN  `Account` A
ON			D.DepartmentID = A.DepartmentID
GROUP BY 	A.DepartmentID
HAVING		COUNT(A.DepartmentID) > 3
ORDER BY	A.DepartmentID ;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
SELECT 		E.*, COUNT(E.QuestionID) AS 'SO LUONG'
FROM 		`ExamQuestion` E 
INNER JOIN 	`Question` Q
ON 			E.QuestionID = Q.QuestionID 
GROUP BY 	E.QuestionID 
ORDER BY 	COUNT(E.QuestionID) DESC
LIMIT 		1;

-- Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
SELECT		CQ.CategoryID, CQ.CategoryName, COUNT(Q.CategoryID) AS 'SO LUONG'
FROM		`CategoryQuestion` CQ 
LEFT JOIN 	`Question` Q
ON			CQ.CategoryID = Q.CategoryID
GROUP BY	CQ.CategoryID
ORDER BY	CQ.CategoryID;

-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT		Q.QuestionID, Q.Content, COUNT(Q.QuestionID)
FROM		`Question` Q 
INNER JOIN 	`ExamQuestion` E 
ON			E.QuestionID = Q.QuestionID
GROUP BY	E.QuestionID
ORDER BY	COUNT(E.QuestionID);

-- Question 8: Lấy ra Question có nhiều câu trả lời nhất
SELECT		Q.QuestionID, Q.Content, COUNT(Q.QuestionID) AS 'SO LUONG'
FROM		`Question` Q 
INNER JOIN 	`Answer` A
ON			A.QuestionID = Q.QuestionID
GROUP BY	A.QuestionID
ORDER BY	COUNT(A.QuestionID) DESC
LIMIT 		1;

-- Question 9: Thống kê số lượng account trong mỗi group
SELECT		G.GroupID, G.GroupName, COUNT(GA.AccountID) AS 'SO LUONG'
FROM		`Group` G
INNER JOIN 	`GroupAccount` GA
ON			G.GroupID = GA.GroupID
GROUP BY	G.GroupID
ORDER BY	COUNT(G.GroupID) ASC;

-- Question 10: Tìm chức vụ có ít người nhất
SELECT 		P.PositionName, COUNT(A.PositionID) AS 'SO LUONG'
FROM 		`Account` A
INNER JOIN 	`Position` P
ON 			A.PositionID = P.PositionID
GROUP BY 	A.PositionID
ORDER BY 	COUNT(A.PositionID)
LIMIT 		1;

-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
SELECT 		P.PositionName, COUNT(A.PositionID) AS 'SO LUONG'
FROM 		`Account` A
INNER JOIN 	`Position` P
ON 			A.PositionID = P.PositionID
GROUP BY 	A.PositionID
ORDER BY 	COUNT(A.PositionID);

-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, ...
SELECT		Q.QuestionID, Q.Content, T.TypeName, Q.CreatorID, A.Content
FROM		`Question` Q 
INNER JOIN 	`Answer` A
ON			A.QuestionID = Q.QuestionID
INNER JOIN  `TypeQuestion` T
ON 			T.TypeID = Q.TypeID
WHERE 		A.isCorrect = 1;

-- Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT 		T.TypeName, COUNT(Q.TypeID) AS 'SO LUONG'
FROM 		`Question` Q
INNER JOIN  `TypeQuestion` T
ON 			T.TypeID = Q.TypeID
GROUP BY 	Q.TypeID
ORDER BY 	COUNT(Q.TypeID);

-- Question 14:Lấy ra group không có account nào
SELECT		*
FROM		`Group` 
WHERE		GroupID  NOT IN
					(SELECT		GroupID
					FROM		GroupAccount);

-- Question 15: Lấy ra group không có account nào
SELECT		*
FROM		`Group` 
WHERE		GroupID  NOT IN
					(SELECT		GroupID
					FROM		GroupAccount);
                    
-- Question 16: Lấy ra question không có answer nào
SELECT		*
FROM		`Question` 
WHERE		QuestionID  NOT IN
					(SELECT		QuestionID
					FROM		`Answer`);
                    
-- Exercise 2: Union
-- Question 17:
-- a) Lấy các account thuộc nhóm thứ 1
SELECT		A.AccountID, A.FullName
FROM		`Account` A
INNER JOIN 	`GroupAccount` GA
ON			A.AccountID = GA.AccountID
WHERE 		GA.GroupID = 1;

-- b) Lấy các account thuộc nhóm thứ 2
SELECT		A.AccountID, A.FullName
FROM		`Account` A
INNER JOIN 	`GroupAccount` GA
ON			A.AccountID = GA.AccountID
WHERE 		GA.GroupID = 2;

-- c) Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau
(SELECT		A.AccountID, A.FullName
FROM		`Account` A
INNER JOIN 	`GroupAccount` GA
ON			A.AccountID = GA.AccountID
WHERE 		GA.GroupID = 1)
UNION
(SELECT		A.AccountID, A.FullName
FROM		`Account` A
INNER JOIN 	`GroupAccount` GA
ON			A.AccountID = GA.AccountID
WHERE 		GA.GroupID = 2);

-- Question 18:
-- a) Lấy các group có lớn hơn 5 thành viên
SELECT		G.GroupID, G.GroupName, COUNT(GA.AccountID) AS 'SO LUONG'
FROM		`Group` G
INNER JOIN 	`GroupAccount` GA
ON			G.GroupID = GA.GroupID
GROUP BY	G.GroupID
HAVING		COUNT(GA.GroupID) > 5
ORDER BY	COUNT(G.GroupID);

-- b) Lấy các group có nhỏ hơn 7 thành viên
SELECT		G.GroupID, G.GroupName, COUNT(GA.AccountID) AS 'SO LUONG'
FROM		`Group` G
INNER JOIN 	`GroupAccount` GA
ON			G.GroupID = GA.GroupID
GROUP BY	G.GroupID
HAVING		COUNT(GA.GroupID) < 7
ORDER BY	COUNT(G.GroupID);

-- c) Ghép 2 kết quả từ câu a) và câu b)
(
	SELECT		G.GroupID, G.GroupName, COUNT(GA.AccountID) AS 'SO LUONG'
	FROM		`Group` G
	INNER JOIN 	`GroupAccount` GA
	ON			G.GroupID = GA.GroupID
	GROUP BY	G.GroupID
	HAVING		COUNT(GA.GroupID) > 5
	ORDER BY	COUNT(G.GroupID) 
)
UNION ALL
(
	SELECT		G.GroupID, G.GroupName, COUNT(GA.AccountID) AS 'SO LUONG'
	FROM		`Group` G
	INNER JOIN 	`GroupAccount` GA
	ON			G.GroupID = GA.GroupID
	GROUP BY	G.GroupID
	HAVING		COUNT(GA.GroupID) < 7
	ORDER BY	COUNT(G.GroupID) 
);