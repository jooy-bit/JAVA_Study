/*
 * 
 * 	오라클 RANK 함수
 * 	예제 : 고객 - 상품별 최대구매금액을 구하고 해당 상품코드 조회하기
 * 		ㄴ 고객ID별 1차 그룹화. 고객내에서 상품코드로 2차 그룹화
 * */
--준비 : mina012에게 구매이력이 있는 상품 한번 더 구매 시키기
INSERT INTO TBL_BUY VALUES(BUY_PK_SEQ.NEXTVAL,'mina012','JINRMn5',13,'2024-01-26');
SELECT *
FROM 
	TBL_BUY tb ,TBL_PRODUCT tp 
WHERE 
	tb.PCODE = tp.PCODE ;

--1)GROUP BY
SELECT 
	tb.CUSTOMID ,tb.PCODE ,
	SUM(tp.PRICE* tb.QUANTITY)  --가격 *수량에 대한 그룹화 함수 SUM 실행
FROM 
	TBL_BUY tb ,TBL_PRODUCT tp 
WHERE 
	tb.PCODE = tp.PCODE 
GROUP BY 
	tb.CUSTOMID ,tb.PCODE ;
	
--2) 1)번 결과에 정렬,
SELECT 
	tb.CUSTOMID ,tb.PCODE ,
	SUM(tp.PRICE* tb.QUANTITY) MONEY
FROM 
	TBL_BUY tb ,TBL_PRODUCT tp 
WHERE 
	tb.PCODE = tp.PCODE 
GROUP BY 
	tb.CUSTOMID ,tb.PCODE
ORDER BY 
	tb.CUSTOMID, MONEY  DESC;
	
--3) 1)번 결과에 RANK함수 적용 -RANK() 함수 결과값으로 컬럼 추가
SELECT 
	tb.CUSTOMID ,tb.PCODE ,
	SUM(tp.PRICE* tb.QUANTITY) MONEY
	,RANK() 
	OVER(PARTITION BY tb.CUSTOMID 
		 ORDER BY SUM(tp.PRICE* tb.QUANTITY) DESC)	"RANK"			--전체 MONEY에 대한 순위
	--OVER()안에는 어떤 컬럼으로 정렬해서 순위를 매기는지에 대한 내용
FROM 
	TBL_BUY tb ,TBL_PRODUCT tp 
WHERE 
	tb.PCODE = tp.PCODE 
GROUP BY 
	tb.CUSTOMID ,tb.PCODE
;

--4) 3)번에 서브쿼리로 하여 RANK =1 인 조건을 적용해보기
WITH customSale
AS(
	SELECT 
		tb.CUSTOMID ,tb.PCODE ,
		SUM(tp.PRICE* tb.QUANTITY) MONEY
		,RANK() 
		OVER(PARTITION BY tb.CUSTOMID 
			 ORDER BY SUM(tp.PRICE* tb.QUANTITY) DESC)	"RANK"			--전체 MONEY에 대한 순위
	--OVER()안에는 어떤 컬럼으로 정렬해서 순위를 매기는지에 대한 내용
	FROM 
		TBL_BUY tb ,TBL_PRODUCT tp 
	WHERE 
		tb.PCODE = tp.PCODE 
	GROUP BY 
		tb.CUSTOMID ,tb.PCODE
)
SELECT *
FROM customSale
WHERE RANK = 1;
