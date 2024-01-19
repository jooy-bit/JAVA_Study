/*  
제약 조건
1) 반드시 값이 있어야 한다  NULL 허용?
2) 같은 값을 가질 수 없다   UNIQUE (유일한)
3)1~4 범위로만 한다         CHECK
-------------------------
4)
5)
*/

CREATE TABLE TBL_CONSTR(    --제역 조건 컬럼레벨 설정하기
    bname VARCHAR2(20) UNIQUE ,    
    aname VARCHAR2(20) NOT NULL,
    cno NUMBER(4) NOT NULL UNIQUE,
    dno NUMBER(4)  CHECK (dno BETWEEN 1 AND 4)
);


INSERT INTO TBL_CONSTR (aname,cno) VALUES ('apple',3);
--INSERT INTO TBL_CONSTR (aname,bname, cno) VALUES ('apple','banana',3);--cno 컬럼값 중복
--INSERT INTO TBL_CONSTR (aname,bname, cno) VALUES ('apple','banana',4);--bname 컬럼값 중복
--INSERT INTO TBL_CONSTR (aname,bname, cno) VALUES ('apple','banana',5);--bname 컬럼값 중복
SELECT*FROM TBL_CONSTR;

INSERT INTO TBL_CO NSTR (aname,cno,dno) VALUES ('apple',3,13);

--새로운 연산자 
INSERT  INTO TBL_JAVAWORD VALUES (5,'constraint','제약사항',3);
INSERT  INTO TBL_JAVAWORD VALUES (9,'order','서순',1);
--idx값이 2,5,9인 것만 조회
--SELECT *FROM TBL_JAVAWORD WHERE IDX =2 OR 5 OR 9;
SELECT *
	FROM TBL_JAVAWORD
		WHERE IDX IN (2,5,9); 
SELECT *
	FROM TBL_JAVAWORD
		WHERE IDX BETWEEN 2 AND 5;
	
--SELCET 컬럼명1, 컬럼명2 ... FROM 테이블 명
	--[WHERE 컬럼명 = 값]=>특정 컬럼을 조건식을 ㅗ조회
	--[ORDER BY 컬럼명1,컬럼명2[DESC]]
	--=>지정된 컬럼명으로 정렬, DESC는 내림차순 ASC는 오름차순(생략) 컬럼명1이 같은 값이명 컬럼값2고 정렬
SELECT *
	FROM TBL_JAVAWORD 
		WHERE IDX IN (2,5,9)
		ORDER BY IDX,KOREAN; --1차가 idx 2차가 korean

INSERT INTO TBL_JAVAWORD 
	VALUES (2,'private','사적인','');
