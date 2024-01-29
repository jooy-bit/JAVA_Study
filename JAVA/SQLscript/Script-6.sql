	DECLARE 
		vmoney number(8);
		vid varchar2(20);
		vdate varchar2(20);
	BEGIN 
		vid := 'mina012';
		vdate := '2023-11-10';
		money_of_day(vid,vdate,vmoney);
		dbms_output.put_line(char(10) ||'고객ID: '|| vid || '날짜: '|| vdate);
		dbms_output.put_line('고객님의 구매금액은 '|| vmoney || '원 입니다');
	END;