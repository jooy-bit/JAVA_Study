CREATE TABLE TBL_excustomer(
	ID VARCHAR2(10),
	NAME NVARCHAR2(10) NOT NULL,
	EMAIL VARCHAR2(100) UNIQUE NOT NULL,
	AGE NUMBER(3) NOT NULL,
	JOIN_DATE DATE DEFAULT SYSDATE ,
	PRIMARY KEY(ID)
);

CREATE TABLE TBL_exproduct(
	CODE VARCHAR2(16),
	CATEGORY VARCHAR2(2),
	ITEMNAME NVARCHAR2(100) NOT NULL,
	PRICE NUMBER(10) NOT NULL,
	PRIMARY KEY(CODE)	
);

CREATE TABLE TBL_exbuy(
	ID VARCHAR2(10),
	CODE VARCHAR2(16),
	BUYCOUNT NUMBER(3) NOT NULL,
	BUYDATE DATE DEFAULT SYSDATE ,
	PRIMARY KEY(ID,CODE),
	FOREIGN KEY(ID) REFERENCES tbl_EXCUSTOMER(ID),
	FOREIGN KEY(CODE) REFERENCES TBL_EXPRODUCT(CODE)
);

INSERT INTO TBL_excustomer VALUES ('mina012', '김미나', 'kimm@gmail.com', 20, TO_DATE('2022-03-10 14:23:25','yyyy-mm-dd HH24:MI:SS'));
INSERT INTO TBL_excustomer VALUES ('hongGD', '홍길동', 'gil@korea.com', 32, TO_DATE('2021-10-21 11:12:23','yyyy-mm-dd HH24:MI:SS'));
INSERT INTO TBL_excustomer VALUES ('twice', '박모모', 'momo@daum.net', 29, TO_DATE('2021-12-25 19:23:45','yyyy-mm-dd HH24:MI:SS'));
INSERT INTO TBL_excustomer VALUES ('wonder', '이나나', 'lee@naver.com', 40,TO_DATE(SYSDATE ,'yyyy-mm-dd HH24:MI:SS'));


INSERT INTO TBL_exproduct VALUES ('DOWON123a', 'B2', '동원참치선물세트', 54000);
INSERT INTO TBL_exproduct VALUES ('CJBAb12g', 'B1', '햇반 12개입', 14500);
INSERT INTO TBL_exproduct VALUES ('JINRMn5', 'B1', '진라면 5개입', 6350);
INSERT INTO TBL_exproduct VALUES ('APLE5kg', 'A1', '청송사과 5kg', 66000);
INSERT INTO TBL_exproduct VALUES ('MANGOTK4r', 'A2', '애플망고 1kg', 32000);


INSERT INTO TBL_exbuy VALUES ('mina012' , 'CJBAb12g' , 5 ,TO_DATE('2022-03-10 14:33:15','yyyy-mm-dd HH24:MI:SS') );
INSERT INTO TBL_exbuy VALUES ('mina012' , 'APLE5kg' , 2 , TO_DATE('2022-03-10 14:33:15','yyyy-mm-dd HH24:MI:SS'));
INSERT INTO TBL_exbuy VALUES ('mina012' , 'JINRMn5' , 2 , TO_DATE('2022-03-16 10:13:15','yyyy-mm-dd HH24:MI:SS'));
INSERT INTO TBL_exbuy VALUES ('twice' , 'JINRMn5' , 3 , TO_DATE('2021-12-25 19:32:15','yyyy-mm-dd HH24:MI:SS'));
INSERT INTO TBL_exbuy VALUES ('twice' , 'MANGOTK4r' , 2 , TO_DATE('2021-12-25 19:32:15','yyyy-mm-dd HH24:MI:SS'));
INSERT INTO TBL_exbuy VALUES ('hongGD' , 'DOWON123a' , 1 , TO_DATE('2021-10-21 11:13:25','yyyy-mm-dd HH24:MI:SS'));
INSERT INTO TBL_exbuy VALUES ('hongGD' , 'APLE5kg' , 1 , TO_DATE('2021-10-21 11:13:25','yyyy-mm-dd HH24:MI:SS'));




--(조지수)이름 내림차순 정렬하기
SELECT * FROM  TBL_EXCUSTOMER tc  ORDER BY NAME DESC;

--(조하연)ID가 'mina012' 인 회원의 가입날짜부터 현재까지 며칠(day)이 지났는지 출력하시오. 
SELECT TO_DATE(SYSDATE,'YYYY-MM-DD') - TO_DATE(JOIN_DATE,'YYYY-MM-DD') FROM TBL_EXCUSTOMER WHERE ID = 'mina012';

--(차정호)구글 이메일 유저를 구하세요
SELECT * FROM TBL_EXCUSTOMER  WHERE EMAIL LIKE '%gmail.com';

--(한주영)고객이 가장 많이 구매한 상품을 구하시오(판매 갯수로 내림차순)
SELECT CODE ,SUM(BUYCOUNT) AS BC FROM TBL_EXBUY GROUP BY CODE ORDER BY BC DESC;

--(한진만)twice ID를 사용하는 고객이 구매한 상품을 모두 구하시오
SELECT * FROM TBL_EXBUY where ID = 'twice';

--(황병훈)카테고리별로 상품갯수 구하기 (앞에 카테코리 번호 나와야 됨)
SELECT CATEGORY ,COUNT(*) FROM TBL_EXPRODUCT GROUP BY CATEGORY;


