/*
 *	스키마 : 데이터베이스 스키마는 데이터베이스에서 자료의 구조, 자료의 표현 방법, 자료 간의 관계를 형식 언어로 정의한 구조이다 
 *			ㄴ 풀이 : 사용자가 계정을 받아서 여러가지 방법으로 데이터(자료)를 저장하고 관리하는 공간
 * 					오라클 등 DBMS는 스키마에 여러 객체를 생성하여 사용
 *
 *	비즈니스 로직 처리시 SQL문이 많이 복잡해지기도 한다.(조인 및 서브쿼리 횟수 많아짐)
 *	=> 자주 사용하면서 일회용으로 처리가 되면 성능에 문제가 생깁니다. 비효율적
 *	=> 가상 테이블(뷰) 또는 프로시저(트랜잭션 단위로 구성)를 사용합니다
 *
 * 	view (뷰) : 가상 테이블
 * 				ㄴ select 조회 결과를 미리 컴파일하여 오라클 객체로 저장
 * 				ㄴ select 조회 할 때 테이블처럼 사용
 * 				ㄴ 그러나 insert, update,delete는 제약이 많고 잘 사용되지 않음.
 * 
 *	create view : 권한이 별도로 필요합니다 => 관리자 계정에서 권한 부여 필요
 *		1)SQLPLUS에서 	grant create view to c##idev; 
 *		2)명령 실행하고 디비버에서 접속 재연결
 * */

CREATE OR REPLACE VIEW v_customsale
AS 
	SELECT 
			tb.CUSTOMID ,tb.PCODE ,
			SUM(tp.PRICE* tb.QUANTITY) MONEY
			,RANK() 
			OVER(PARTITION BY tb.CUSTOMID 
				 ORDER BY SUM(tp.PRICE* tb.QUANTITY) DESC)	"RANK"
		FROM 
			TBL_BUY tb ,TBL_PRODUCT tp 
		WHERE 
			tb.PCODE = tp.PCODE 
		GROUP BY 
			tb.CUSTOMID ,tb.PCODE;
	
--일반 테이블 select처럼 조회 형식 모두 사용 가능			
SELECT
	*
FROM
	V_CUSTOMSALE vc 
WHERE CUSTOMID = 'mina012';
	

			
SELECT
	*
FROM
	V_CUSTOMSALE vc 
WHERE RANK = 1;

