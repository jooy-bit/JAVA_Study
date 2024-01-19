--2024.01.19 수업

--실제로 데이블의 컬럼으로 함수 실행

--1.문자 함수
SELECT INITCAP ('hello') FROM DUAL; --예상 : Hello intitail capital : 첫문자 대문자
SELECT UPPER ('hello') FROM DUAL; --대문자로 변환 결과: HELLO
SELECT LOWER ('OraCle') FROM DUAL; --소문자로 변환 결과: oracle
SELECT LENGTH ('oracle') FROM DUAL; --문자열 길이 결과: 6
SELECT SUBSTR('java program',3,5) FROM DUAL; -- 부분 추출(문자열, 위치, 길이) 결과 : va pr *오라클에서 문자열 위치 인덱스는 1부터 시작*
SELECT SUBSTR('java program',-5,3) FROM DUAL; --부분 추출값 결과 : ogr 위치 음수이면 뒤에서 부터
SELECT REPLACE ('java program','pro','프로') FROM DUAL;	--문자열 바꾸기 결과: java 프로gram
SELECT INSTR ('java program','og') FROM DUAL; --자바의 indexOf --결과: 8 해당 문자열이 없으면 결과 0
SELECT TRIM ('java program') FROM DUAL; --공백(불필요한 앞뒤 공백)제거
SELECT LENGTH (' java program   ') FROM DUAL; 
SELECT LENGTH (TRIM('java program')) FROM DUAL;

--2.숫자 함수 --abs(n): 절대값
SELECT TRUNC (3.1774637,2) FROM DUAL; --trunc(숫자, 자리수): 소숫점 이하 자리수 맞추기 위해 버림 3.177567 -> 3.17
SELECT ROUND (3.1774567,2) FROM DUAL; --ROUND(숫자, 자리수): 소숫점 이하 자리수 맞추기 위해서 버림 3.1774567 -> 3.18
SELECT CEIL (3.1774567) FROM DUAL; --CEIL (숫자) : 실수를 정수 올림으로 변환 4
SELECT FLOOR (3.1774567) FROM DUAL; --FLOOR(숫자) : 실수를 정수 내림으로 변환 3 

--3.날짜 함수 : TO_CHAR , TO_DATE
--YYYY-MM-DD HH24:MI:SS 24시간 기준
--YYYY-MM-DD HH:MI:SS AM 12시간 기준(AM대신 PM도 가능)
SELECT  SYSDATE, SYSTIMESTAMP FROM DUAL;--SYSTIMESTAMP는 표준시와의 시차(타임존) 표시, 
SELECT TO_CHAR (SYSDATE,'YYYY/MM/DD') FROM DUAL; --날짜를 문자열로 변환
SELECT TO_CHAR (SYSDATE,'YYYY"년"',) FROM DUAL; --
SELECT TO_CHAR (SYSDATE,'MM"월"',) FROM DUAL; --
SELECT TO_CHAR (SYSDATE,'DD"일"',) FROM DUAL; --
SELECT TO_CHAR (SYSDATE,'YYYY"년" MM"월" DD"일"') FROM DUAL; --
SELECT TO_DATE() FROM DUAL; --문자열을 날짜로 변환

--TBL_MEMBER 테이블에 JOIN_DATE 컬럼 INSERT
--자동 캐스팅 패턴 YYYY-MM-DD만 가능
--INSERT INTO TBL_MEMBER VALUES (3,'최슬기','slgichoi@naver.com','2021-09-24 13:24:55'); --오류 
INSERT INTO TBL_MEMBER VALUES (3,'최슬기','slgichoi@naver.com',TO_DATE('2021-09-24 13:24:55','YYYY-MM-DD HH24:MI:SS'));
--******* 저장할 날짜 문자열을 날짜패턴을 알려주고 날짜 형식으로 변경하기
SELECT JOIN_DATE FROM TBL_MEMBER tm WHERE NAME IN ('최슬기');
INSERT INTO TBL_MEMBER tm  VALUES (10,'홍길동',LOWER('GDHONG@DAUM.NET'),TO_DATE('2023109','YYYYMMDD'));
SELECT * FROM TBL_MEMBER tm WHERE NAME IN ('홍길동');

--1)'월' 관련 함수
SELECT
	ADD_MONTHS(SYSDATE, 3)
FROM
	DUAL;--오늘 날짜 3개월 이후. 첫번째 인자는 날짜형식, 두번째 더해지는 값

SELECT
	TO_CHAR(ADD_MONTHS(SYSDATE, 3), 'YYYY/MM/DD')
FROM
	DUAL; --문자별 패턴 기호 - 또는 / 또는 구분기호없음 가능

SELECT
	MONTHS_BETWEEN(SYSDATE, TO_DATE('2022-09-23'))
	FROM DUAL; --날짜사이 간격(월) 결과는 소수점

SELECT
	TRUNC(SYSDATE) - TO_DATE('20240110', 'YYYYMMDD')
FROM
	DUAL;  --2개의 날짜 형식 값 간격(일), 2개의 날짜의 간격 일 TRUNC(SYSDATE)는 일(DAY)까지 변환

SELECT SYSDATE +5 FROM DUAL;
SELECT SYSDATE +15 FROM DUAL;