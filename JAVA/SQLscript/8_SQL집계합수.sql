/*
 * SQL 집계(개수, 최댓값,최솟값, ) 함수
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 *
 *  */

--1) 성적 테이블의 전체 행 개수
SELECT COUNT(*) AS "COUNT" FROM TBL_SCORE ts ; --조회된 함수 별칭 AS ____ 로 작성
--2) 성적 테이블의 과목 컬럼 '국어' 값을 갖는 전체 행 개수
SELECT COUNT(*) FROM TBL_SCORE ts WHERE SUBJECT ='국어' ;
--3) 성적 테이블의 점수 컬럼의 합계
SELECT SUM(JUMSU)FROM TBL_SCORE ts ; 
--4) 성적 테이블의 국어 과목 점수 컬럼의 합계
SELECT SUM(JUMSU)FROM TBL_SCORE ts WHERE SUBJECT ='국어'; 
--오류가 생김 : 집계 함수는 다르 컬럼과 함께 조회하려면 GROUP BY 가 필요하다
--5) 성적 테이블의 점수 컬럼의 평균
SELECT AVG(JUMSU) FROM TBL_SCORE ts; 
--6) 성적 테이블의 국어 과목 점수 컬럼의 평균
SELECT ROUND( AVG(JUMSU)) FROM TBL_SCORE ts WHERE SUBJECT = '국어'; 
--7) 성적 테이블의  점수 컬럼의 최댓값
SELECT MAX((JUMSU)) FROM TBL_SCORE ts ; 
--8) 성적 테이블의 국어 과목 점수 컬럼의 최댓값
SELECT MAX((JUMSU)) FROM TBL_SCORE ts WHERE SUBJECT = '국어'; 

SELECT COUNT(*) "GKQRp",SUM(JUMSU) "합계", ROUND( AVG(JUMSU) ) "평균", FROM TBL_SCORE; 



--SELECT SUBJECT, COUNT(*)FROM TBL_SCORE ts ; 
SELECT STUNO ,COUNT(*) FROM TBL_SCORE ts GROUP BY STUNO;
SELECT SUBJECT  ,COUNT(*) FROM TBL_SCORE ts GROUP BY SUBJECT ;
--GROUP BY 는 그룹화컬럼명1,그룹화컬럼명2 로 할 수 있다.