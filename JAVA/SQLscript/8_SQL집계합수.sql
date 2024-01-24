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

SELECT COUNT(*) "학번",SUM(JUMSU) "합계", ROUND( AVG(JUMSU) ) "평균", FROM TBL_SCORE; 



--SELECT SUBJECT, COUNT(*)FROM TBL_SCORE ts ; 
SELECT STUNO ,COUNT(*) FROM TBL_SCORE ts GROUP BY STUNO;
SELECT SUBJECT  ,COUNT(*) FROM TBL_SCORE ts GROUP BY SUBJECT ;

/*
 * 집계함수 count, avg , sum, min, max 등 그룹 함수라고도 합니다. 
 * 그룹화 - 지정한 컬럼값이 같을 것을 갖는 행에 대해 집계 함수를 실행합니다.
 *      
 * 
 * select 
 *       그룹화컬럼, 그룹함수
 * from 테이블이름
 * [WHERE] 그룹화하기 이전의 조건식
 * GROUP BY 그룹화에 사용할 컬럼명
 * [HAVING] 그룹화 후에 사용하는 조건식/ 그룹화 결과값을 사용하는 조건식
 * [ORDER BY] 정렬 컬럼
 */
--GROUP BY 는 그룹화컬럼명1,그룹화컬럼명2 로 할 수 있다.

--예시 1: 학번(학생) 별로 수강한 갯수와 평균을 구해보시오
SELECT STUNO,COUNT(*),AVG(JUMSU) FROM TBL_SCORE GROUP BY STUNO;

--예시 2 :위의 결과에 대해 평균이 80점 미만인 학번(학생)을 조회하시오
SELECT STUNO "학번",COUNT(*) "개수",AVG(JUMSU) "평균" FROM TBL_SCORE GROUP BY STUNO HAVING AVG(JUMSU) >=80;
--해빙은 집계함수 결과에 대한 조건식입니다
--예를 들어서 점수가 80점 이상 데이터만 예시 1번을 실행하도록 한다면 WHERE JUMSU >=80 GROUP BY STUNO
--선 계산 및 조건 후 필터, 결과 후 조건


--예시 3 : 점수가 80점 이상 데이터만 예시 1번 실행하도록 한다면 WHERE JUMSU >=80 GROUP BY STUNO
SELECT STUNO "학번",COUNT(*) "개수",AVG(JUMSU) "평균" FROM TBL_SCORE WHERE JUMSU >=80 GROUP BY STUNO ;

--예시 4 : 예시 1번의 결과를 평균 내림차순으로 조회
SELECT STUNO "학번",COUNT(*) "개수",AVG(JUMSU) "평균" FROM TBL_SCORE GROUP BY STUNO ORDER BY "평균" DESC;

--예시 5 : 학기-교사별 COUNT,AVG조회
SELECT TERM "학기",TEACHER "선생",COUNT(*) "학생수",AVG(JUMSU) "평균" FROM TBL_SCORE GROUP BY TERM, TEACHER ORDER BY "평균" DESC; --학기별 그룹화 후 선생별 그룹화
--제대로 된 결과를 보려면 더 많은 데이터 필요