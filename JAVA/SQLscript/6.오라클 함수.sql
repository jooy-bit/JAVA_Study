--2024.01.19 수업

--실제로 데이블의 컬럼으로 함수 실행

--문자 함수
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

--숫자 함수 --abs(n): 절대값
SELECT TRUNC (3.1774637,2) FROM DUAL; --trunc(숫자, 자리수): 소숫점 이하 자리수 맞추기 위해 버림 3.177567 -> 3.17
SELECT ROUND (3.1774567,2) FROM DUAL; --ROUND(숫자, 자리수): 소숫점 이하 자리수 맞추기 위해서 버림 3.1774567 -> 3.18
SELECT CEIL (3.1774567) FROM DUAL; --CEIL (숫자) : 실수를 정수 올림으로 변환 4
SELECT FLOOR (3.1774567) FROM DUAL; --FLOOR(숫자) : 실수를 정수 내림으로 변환 3 