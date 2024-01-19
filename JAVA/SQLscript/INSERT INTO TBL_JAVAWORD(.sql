INSERT INTO TBL_JAVAWORD(
    IDX,
    ENGLISH,
    KOREAN,
    STEP
  )
VALUES
  (
    IDX:NUMBER(8),
    'ENGLISH:VARCHAR2(100)',
    'KOREAN:NVARCHAR2(100)',
    STEP:NUMBER(1)
  );

/*3. todo list =>요구사상에 대한 제약조건

idx, english, korean 컬럼 값이 가져야할 규칙
같은 값을 가질 수 없다. 반드시 IS NOT NULL
STEP 값이 없는 NULL이 가능하다. 1~4만 가능하다
4. Todo:  검색 속도를 향상시키기 위한 컬럼을 정해라.데이터행을 식별 할 수 있는 컬럼을 정해라 (기본키 설정)
*/
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               

SELECT*FROM TBL_JAVAWORD WHERE ENGLISH LIKE '%ic%';
/*SELECT*FROM TBL_JAVAWORD IDX BETWEEN 10 AND 20;*/
