/*
 * 
 * 프로시저 직접 만들어보기 : money_of_day
 * 매개변수 IN : 고객ID, 날짜(패턴 'yyyy-mm-dd')
 * 매개변수 OUT : IN으로 받은 값들을 TBL_BUY에서 상품코드를 조회하여 '총 구매금액'을 구합니다
 * 
 * 프로시저 실행
 * declare
 * 		vmoney number(8);
 * begin
 * 		money_of_day('mina012','2023-11-10',vmoney)
 * 		dbms_output.put_line('고객님의 구매금액은 '|| vmoney || '원 입니다');
 * 1) 고객id, 날짜 값으로 구매 테이블에서 수량과 pcode조회하고 변수에 저장
 * 2)  1)에서 pcode의 가격을 조회하여 저장하기
 * 3) 2)번 가격과 1)번 수량을 곱하기 하여 결과값을 변수에 저장 => 출력변수
 *  
 * 
 * --실행을 위한 주요 SQL : 
 */


SELECT * FROM p_buy;

CREATE OR REPLACE PROCEDURE money_of_day(
	acustom_id IN tbl_buy.CUSTOMID %TYPE ,
	adate IN tbl_buy.BUY_DATE %TYPE,
	totalPayment OUT number
)
IS 
	vpcode varchar;
	vprice NUMBER;
	vquantity NUMBER;
BEGIN
	--1)
	SELECT tbl_buy.pcode, tbl_buy.QUANTITY
		INTO vpcode, vquantity
	FROM tbl_buy
	WHERE CUSTOMID =acustom_id 
	AND TO_CHAR(tbl_buy.BUY_DATE,'yyyy-mm-dd') = adate ;
	--2)
	SELECT PRICE 
		INTO vprice 
	FROM TBL_PRODUCT tp
	WHERE pcode = vpcode;
	--3)
	SELECT vquantity*vprice
		INTO totalPayment
	FROM dual;
END;

--프로시저 실행
	DECLARE 
		vmoney number(8);				--프로시저 실행결과 OUT 매개변수 저장 (꼭 필요한 변수)
		vid tbl_custom.custom_id %TYPE;	--프로시저 실행에 필요한 IN 매개변수값 저장변수
		vdate varchar2(20);				--없어도 되지만 출력 등 편의상 선언합니다
	BEGIN 
		vid := 'mina012';
		vdate := '2023-11-10';
		money_of_day(vid,vdate,vmoney);
	--vid vdate IN 매개변수값으로 프로시저를 실행
	--vmoney OUR 매개변수에 프로시저 실행 결과를 전달
		dbms_output.put_line(char(10) ||'고객ID: '|| vid || '날짜: '|| vdate);
		dbms_output.put_line('고객님의 구매금액은 '|| vmoney || '원 입니다');
	EXCEPTION 
		WHEN no_data_found THEN
		DBSM_OUTPUT.PUT_LINE(char(10) || '조건에 맞는 데이터가 없습니다');
		
	END;
