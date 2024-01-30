
--카테고리로 검색하기
--상품 검색하기 SQL
--1) 어떤 카테고리가 있는지 보여주기
SELECT DISTINCT CATEGORY FROM TBL_PRODUCT ORDER BY CATEGORY ASC; 

--2) 특정 카테고리에 대해 상품 목록 보여주기
SELECT DISTINCT CATEGORY FROM TBL_PRODUCT WHERE CATEGORY = 'B1'; 

--데이터 추가
--INSERT INTO TBL_PRODUCT VALUES('BUSA211','B2','부사 사과 3kg',25000);

--3)상품명 유사 (LIKE)
SELECT *FROM TBL_PRODUCT WHERE PNAME LIKE '%'||'사과'||'%'; --프로그램에서 매개변수 처리를 위해 연결연산으로 합니다.