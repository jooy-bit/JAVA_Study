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
INSERT INTO TBL_CONSTR (aname,bname, cno) VALUES ('apple','banana',4);--bname 컬럼값 중복
INSERT INTO TBL_CONSTR (aname,bname, cno) VALUES ('apple','banana',5);--bname 컬럼값 중복
SELECT*FROM TBL_CONSTR;

INSERT INTO TBL_CONSTR (aname,cno,dno) VALUES ('apple',3,13);