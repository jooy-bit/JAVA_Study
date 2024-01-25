/*
 * 테이블 조인(join) : 테이블의 컬럼을 합하는 연산이다.
 * 			(참고로 UNION	연산은 테이블 행을 합하는 연산도 있다 )	
 * 
 * 
 * */

--STEP 1 FROM 뒤에 2개의 테이블 나열
SELECT * FROM TBL_CUSTOM tc ,TBL_BUY tb;
--결과 : 2개의 테이브 공통 컬럼인 CUSTOMID로 모든 경우의 수를 조합하여 합칩니다.

--STEP 2 동등 조인은 위의 결과 중 고객ID값이 같은 것만 의미가 있으므로 조건식으 추가한 것입니다.
SELECT *
FROM TBL_CUSTOM tc , TBL_BUY tb 
WHERE tc.CUSTOM_ID =tb.CUSTOMID ;
--참고 : 고객 중 구매룰 한번도 하지 않았다면 조인 결과에 없습니다.


--STEP 3 위 2단계 결과로 예시를 만듭시다
--1)2024년에 상품을 구매한 고객의 이메일을 모두 조회하세요
SELECT tb.CUSTOMID ,tc.EMAIL,tb.BUY_DATE
FROM TBL_CUSTOM tc , TBL_BUY tb 
WHERE tc.CUSTOM_ID =tb.CUSTOMID
AND TO_CHAR(BUY_DATE,'YYYY')='2024'; 
 
--2)테이블을 바꾼 예시 : 회원 'twice'가 구매한 상품명과 가격을 조회하세요
SELECT tp.PNAME , tb.QUANTITY,tp.PRICE, tb.QUANTITY*tp.PRICE "구매 금액"
FROM TBL_BUY tb ,TBL_PRODUCT tp 
WHERE tb.PCODE = tp.PCODE
AND tb.CUSTOMID ='twice';

--3) 2개 테이블 조인하는 예시를 생각해보자 
--구매고객 중 구매 횟수 1등에 해당하는 사람의 1회당 구매 평균
--SELECT tb.CUSTOMID, COUNT() FROM TBL_BUY tb,TBL_CUSTOM tc WHERE tb.CUSTOMID =tc.CUSTOM_ID AND MAX ;
--B1 카테고리 상품의 구매 현황(상품명, 가격, 구매수량, 구매날짜)을 조회하세요.
SELECT
	tp.PNAME,
	tp.PRICE ,
	tb.QUANTITY ,
	tb.BUY_DATE
FROM
	TBL_PRODUCT tp ,
	TBL_BUY tb
WHERE
	tp.PCODE = tb.PCODE
	AND tp.CATEGORY = 'B1';
	
--동등 조인 형식 1) SELECT*FROM 테이블명(1) t1,테이블명(2) t2 WHERE t1.공통컬럼 =t2.공통컬럼;
--			  2) SELECT*FROM 테이블명(1) t1 JOIN 테이블명(2) t2 ON t1.공통컬럼 =t2.공통컬럼;

SELECT
	tp.PNAME,
	tp.PRICE ,
	tb.QUANTITY ,
	tb.BUY_DATE
FROM 
	TBL_PRODUCT tp 
JOIN
	TBL_BUY tb 
ON
	tp.PCODE = tb.PCODE
AND 
	tp.CATEGORY ='B1';

--외부 조인 : 
/*
 * 
 * SELECT*
 * FROM
 * 		TABLE1 t1
 * LEFT [OUTER] JOIN 
 * 		TEBLE2 t2
 * ON
 * 		t1.COL =t2.COL;
 * 
 * 테이블2에 없는 값도 테이블1에 있으면 조인에 포함시킨다 t2에 해당하는 컬럼 값은 [NULL]
 * 
 * 
 * */

SELECT *
FROM 
	TBL_CUSTOM tc 
LEFT JOIN 
	TBL_BUY tb 
ON 
	tc.CUSTOM_ID =tb.CUSTOMID 
WHERE BUY_IDX IS NULL;

--상품과 구매에 대한 외부 조인 연습
INSERT INTO TBL_PRODUCT tp (PCODE,CATEGORY,PNAME,PRICE)
VALUES('SNACK99','C1','새우깡번들','5500');

--구매 이력이 없는 상품(이름,가격)을 조회하세여
SELECT tp.PNAME,tp.PRICE 
FROM TBL_PRODUCT tp 
LEFT JOIN TBL_BUY tb 
ON tp.PCODE =tb.PCODE
WHERE tb.BUY_DATE IS NULL;

--오라클에만 있는 
SELECT
	tp.PNAME,tp.PRICE 	
FROM TBL_BUY tb,TBL_PRODUCT tp 
WHERE tp.PCODE = tb.PCODE(+);


