/*
 * 		오라클 ROWNUM 컬럼 : 오라클이 SELECT 결과에 부여하는 행번호
 * 						 오라클이 내부적으로 관리를 위한 컬럼
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
--1) 상품테이블의 상품 가격을 내림차순으로 정렬하여 조회
SELECT
	*
FROM
	TBL_PRODUCT tp
ORDER BY
	PRICE DESC
;

--2) ROWNUM 컬럼을 출력해봅시다 정렬이전의 ROWNUM입니다
SELECT
	ROWNUM,tp.*
FROM
	TBL_PRODUCT tp
ORDER BY
	PRICE DESC
;

--3) 서브쿼리로 변경
SELECT ROWNUM, tp.*
FROM(
		SELECT *
		FROM TBL_PRODUCT
		ORDER BY PRICE DESC
	)tp;

--4) 위의 3번 결과에 ROWNUM 조건을 적용해봅시다
SELECT ROWNUM , tp.*
FROM(
		SELECT *
		FROM TBL_PRODUCT
		ORDER BY PRICE DESC
	)tp
WHERE ROWNUM =1		--잘 실행됩니다	1이 포함하는 조건식만 사용 가능하다
--WHERE ROWNUM =3     --잘 실행 안됩니다	
;

--5)중간 일부를 가져오기 위해서 BETWEEN AND 연산을 합니다. 단, 4)번을 서브쿼리를 또 써야합니다.
--예시 : 게시판의 글목록에 대해 페이지 번호 적용
SELECT *
FROM (
		SELECT ROWNUM R, tp.*	--ROWNUM에 대한 별칭이 필요합니다
		FROM(
				SELECT *
				FROM TBL_PRODUCT
				ORDER BY PRICE DESC
			)tp
	)
WHERE R BETWEEN 3 AND 5;  
--6)오라클 12C 버전부터는  FETCH 명령이 있습니다
SELECT *
FROM TBL_PRODUCT tp 
ORDER BY PRICE DESC 
FETCH FIRST 2 ROWS ONLY;