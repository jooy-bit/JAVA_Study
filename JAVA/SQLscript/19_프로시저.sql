/*
PL/SQL : Procedure(절차,순서) Language , 기존의 단순한 SQL이 확장된 언어(SQL로 만드는 프로그램)
         변수,제어문(if,반복문)을 사용하여 프로그래밍언어와 같이 sql 실행의 흐름을 제어
- 구성 : 선언부(DECLARE), 실행부(BEGIN), 예외처리부 (EXCEPTION)로 구성됨
- 유형
	1) Anonymous PL/SQL Block(익명블록) 
	익명 블록은 주로 일회성으로 사용
	2)Stored PL/SQL Block (저장 프로시저)
	서버에 파싱해서 저장해 놓고 주기적으로 반복해서 사용할 경우 사용됨
	서브프로그램 또는 프로그램 단위라고도 하며, 
	스키마를 구성하는 오브젝트로서 파싱된 후 오라클 서버 내부에 저장되거나 오라클 툴 안에 라이브러리 형태로 저장되어 있음

Declare (선언부)
Executable (실행부)
Exception (예외 처리부)
*/
SELECT * FROM TBL_CUSTOM tc ;
DECLARE   -- 변수선언부  
	-- vname varchar2(40);			 -- 스칼라변수
	-- vage number(3,0);
	vname tbl_custom.name %TYPE;     -- 참조변수(타입변수)
	vage tbl_custom.age %TYPE;
BEGIN		--프로시저 시작(실행부)
  -- 프로시저 내부에는 주로 트랜잭션을 구성하는 DML 명령문들을 작성
	SELECT name,age 
		INTO vname , vage	-- 프로시저 구문: 검색결과를 프로시저 일반 변수 vname, vage 에 저장
	FROM "TBL_CUSTOM" tc 
	WHERE CUSTOM_ID ='hongGD';		-- 1개 행만 결과 조회되는 조건
									-- 여러개 행 조회될때는 각 행에 접근하기 위한 cursor 필요.
-- DBMS_OUTPUT 는 콘솔에 출력하는 오라클 패키지의 하나이며 PUT_LINE 함수
	DBMS_OUTPUT.PUT_LINE('고객이름 : ' || vname);   -- ||는 문자열 연결 연산
	DBMS_OUTPUT.PUT_LINE('고객나이 : ' || vage);
	EXCEPTION		-- 예외(오류)처리
	WHEN no_data_found THEN   -- no_data_found : 예외 이름 
		DBMS_OUTPUT.PUT_LINE('찾는 데이터가 없습니다.');
END;

/*
	저장 프로시저 생성
	CREATE OR REPLACE PROCEDURE 프로시저 이름
	( 매개변수이름 [IN 또는 OUT] 데이터 타입,.....)
	[IS 또는 AS]
		프로시저 변수 선언
	BEGIN
		프로시저 작업 내용 SQL들....

	EXCEPTION 
		WHEN 예외이름 THEN 처리 내용;

	END ;


*/