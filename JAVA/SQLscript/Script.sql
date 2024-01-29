/*                                                                                                                                                                                                                                
 *                                                                                                                                                                                                                                
 * "단어장" 프로그램을 위한 테이블                                                                                                                                                                                                             
 * 0.테이블명 : tbl_javaword                                                                                                                                                                                                          
 * 1. 테이블 구조                                                                                                                                                                                                                      
 *                                                                                                                                                                                                                                
 * 		idx			number(8)                                                                                                                                                                                                     
 * 		english		varchar2(100)                                                                                                                                                                                                 
 * 		korean		nvarchar2(100)                                                                                                                                                                                                
 * 		level		number(1)                                                                                                                                                                                                     
 *                                                                                                                                                                                                                                
 * 2. 테이블 행 추가 - 데이터 입력하기                                                                                                                                                                                                         
 * 		                                                                                                                                                                                                                          
 *                                                                                                                                                                                                                                
 *                                                                                                                                                                                                                                
 *                                                                                                                                                                                                                                
 */                                                                                                                                                                                                                               
                                                                                                                                                                                                                                  
CREATE TABLE tbl_javaword(                                                                                                                                                                                                        
	idx NUMBER(8),                                                                                                                                                                                                                
	english varchar2(100),                                                          
	korean nvarchar2(100),                                                                                                                                                                                                        
	step NUMBER(1)                                                                                                                                                                                                                
);                                                                                                                                                                                                                            
	                                                                                                                                                                                                                              
INSERT INTO tbl_javaword VALUES(100001,'public','공공의',1);
INSERT INTO TBL_JAVAWORD VALUES(100002, 'null', '', 1);
INSERT INTO TBL_JAVAWORD VALUES(200003, 'static', '정적인', 2);
INSERT INTO TBL_JAVAWORD VALUES(100004, 'main', '주요한', 1);
INSERT INTO TBL_JAVAWORD VALUES(200005, 'remove', '삭제하다', 2);
INSERT INTO TBL_JAVAWORD VALUES(300006, 'interface', '접점', 3);
INSERT INTO TBL_JAVAWORD VALUES(100007, '', '', 0);
SELECT *FROM TBL_JAVAWORD;       
SELECT *FROM TBL_JAVAWORD WHERE STEP IS NOT NULL;
SELECT *FROM TBL_JAVAWORD WHERE IDX = 100001;
SELECT *FROM TBL_JAVAWORD WHERE ENGLISH = 'public';
SELECT *FROM TBL_JAVAWORD WHERE ENGLISH  = 'public' AND STEP = 2;