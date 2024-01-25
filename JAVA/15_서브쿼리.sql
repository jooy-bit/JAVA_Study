/*
 * 
 * 서브쿼리 (SUB QUERY) : SELECT 조회 결과가 다른 DML 명령어에 쓰일 수 있습니다
 *											 ㄴSELECT,INSERT,UPDATE,DELECT
 * 						SELECT,INSERT,UPDATE,DELECT에 포함되는 SELECT를 서브 쿼리라 합니다.
 * 
 *
 *  SELECT 함께 쓰이는 서브쿼리
 * 					 : SELECT 컬럼1, 컬럼2 FROM (SELECT ....) WHERE 컬럼명1 = 값(SELECT....)
 * */

--1)WHERE 에서 쓰는 서브 쿼리 : 트와이스가 구매한 상품
--JOIN
SELECT tp.*
FROM TBL_PRODUCT tp ,TBL_BUY tb 
WHERE tp.PCODE  =tb.PCODE			--1)크로스 연산
AND tb.CUSTOMID ='twice';			--2)조건식 연산

--SUB QUERY
SELECT *
FROM TBL_PRODUCT tp 
WHERE PCODE 
--IN ('CJBA12g','APLE5kg','DOWON123a');
IN(SELECT PCODE FROM TBL_BUY tb WHERE tb.CUSTOMID = 'twice');	--1)조건식 연산


--2)FROM에서 사용되는 서브쿼리 : 컬럼명 또는 테이블명 별칭을 줄 때 한글을 쓰려면 ""안에 사용합니다


SELECT 
	SALEMONEY.PCODE,
	SUM(QUANTITY),
	SUM("구매 금액")
FROM
	(
	SELECT
		tp.PCODE,
		tp.PNAME,
		QUANTITY,
		PRICE,
		QUANTITY * PRICE "구매 금액"
	FROM
		TBL_PRODUCT tp,
		TBL_BUY tb
	WHERE
		tp.PCODE = tb.PCODE) SALEMONEY
GROUP BY
	SALEMONEY.PCODE;
	
--오라클 with 구문 : select 조회 결과를 저장해 사용하도록 합니다
WITH SALEMONEY
AS (
SELECT
		tp.PCODE,
		tp.PNAME,
		QUANTITY,
		PRICE,
		QUANTITY * PRICE "구매 금액"
	FROM
		TBL_PRODUCT tp,
		TBL_BUY tb
	WHERE
		tp.PCODE = tb.PCODE
)
SELECT SALEMONEY.PCODE, SUM(SALEMONEY.QUANTITY), SUM("구매 금액")  
FROM SALEMONEY 
GROUP BY SALEMONEY.pcode;
--join
SELECT 
    tp.PCODE,
    SUM(tb.QUANTITY) AS TotalQuantity,
    SUM(tp.PRICE * tb.QUANTITY) AS TotalAmount
FROM 
    TBL_PRODUCT tp
JOIN 
    TBL_BUY tb ON tp.PCODE = tb.PCODE
GROUP BY 
    tp.PCODE;
    
   
--서부쿼리와 조인을 이용한 문제를 한 개씩 만들어 팀별로 공유해보세요
   
--2023년 구매 금액 5만원 이상에게 할인쿠폰을 발송하려 한다. CUSTOMID,구매 총액, 구매 일자를 구하시오. COUPON 사용하기
SELECT  COUPON.CUSTOMID "고객id",
		SUM(COUPON.TOTAL) "구매 총액"
FROM (
		SELECT
			tb.QUANTITY * tp.PRICE AS TOTAL,
			BUY_DATE ,
			tb.CUSTOMID,
			QUANTITY,
			PRICE
		FROM
			TBL_PRODUCT tp,
			TBL_BUY tb
		WHERE
			tp.PCODE = tb.PCODE
			AND TO_CHAR(BUY_DATE,'YYYY')='2023'
	) COUPON
GROUP BY COUPON.CUSTOMID
HAVING SUM(COUPON.TOTAL)>50000;
