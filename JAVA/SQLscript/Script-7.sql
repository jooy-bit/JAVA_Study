CREATE OR REPLACE PROCEDURE "C##IDEV".money_of_day2(
   p_id IN tbl_custom.custom_id %TYPE,      -- 출력(리턴) 변수
   p_date IN varchar2,      -- 출력(리턴) 변수
   p_money OUT NUMBER
)
IS
   v_pcode TBL_BUY.PCODE %TYPE;
   v_quantity TBL_BUY.QUANTITY %TYPE;
   v_price TBL_PRODUCT.PRICE %TYPE;
BEGIN
   SELECT PCODE, QUANTITY                --1일 1구매 조건으로 1개의 행이 조회됨
      INTO v_pcode , v_quantity            --조회 결과가 N개의 행이면 프로시저의 커서 기능을 이용(나중에)
      --INTO는 프로시저에서만 사용
   FROM TBL_BUY
   WHERE CUSTOMID = p_id AND TO_CHAR(BUY_DATE,'YYYY-MM-DD') = p_date;
   --테스트를 위한 코드
   DBMS_OUTPUT.PUT_LINE('* p : ' || v_pcode ||','|| v_quantity );
   SELECT PRICE
      INTO v_price
   FROM TBL_PRODUCT
   WHERE PCODE = v_pcode;
   DBMS_OUTPUT.PUT_LINE('* p : ' || v_price);
   SELECT v_quantity * v_price
      INTO p_money      --수량*가격 수식 연산결과를 출력매개변수 P_MONEY에 저장
   FROM dual;         --특정 테이블과 상관 없으므로 DUAL 임시 테이블 사용하여 연산
   DBMS_OUTPUT.PUT_LINE('* m : ' || p_money);
   EXCEPTION
   WHEN no_data_found then
   DBMS_OUTPUT.PUT_LINE('조건에 맞는 데이터가 없습니다.');
     P_MONEY :=0;
END;
   
--실행
 DECLARE 
    VMONEY NUMBER(8);--프로시저 실행결과 OUT 매개변수 저장(필수)
    vid TBL_CUSTOM.CUSTOM_ID%TYPE; --프로시저 실행에 필요한 IN 매개변수값 저장변수
    VDATE VARCHAR2(20);            --없어도 되지만 출력등 편의상 선언 (VID, VDATE)
 BEGIN
   VID := 'mina012';
   vdate :='2023-11-11';
   --VID, VDATE IN 매개변수값으로 프로시저 실행
   --매개 변수에 저장된 프로시저 실행 결과를 VMONEY에 저장
    MONEY_OF_DAY2(VID,VDATE,vmoney);
    DBMS_OUTPUT.PUT_LINE(CHR(10)||'고객ID: ' || VID|| ' 날짜: '||VDATE);
    DBMS_OUTPUT.PUT_LINE('고객님의 구매금액은 ' || vmoney|| '입니다.');
 END;
   
