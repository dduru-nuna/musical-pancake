/*
 * ALTER TABLE
 *    생성한 테이블의 이름을 변경하거나 컬럼명, 데이터 타입, 제약 조건 등을 수정할 때 사용
 *    테이블에 데이터가 저장되어 있는 경우 수정 작업이 안될 수 있다.
 */

--테이블 이름 바꾸기
ALTER TABLE TEST1 RENAME TO TEST4;
ALTER TABLE TEST2 RENAME TO TEST5;

--컬럼명 바꾸기
ALTER TABLE TEST4 RENAME COLUMN COL1 TO ID;
ALTER TABLE TEST5 RENAME COLUMN REF1 TO ID;

--컬럼 추가
ALTER TABLE TEST5 ADD COL3 VARCHAR2(10);
ALTER TABLE TEST5 ADD COL4 VARCHAR2(10);
ALTER TABLE TEST5 ADD COL5 VARCHAR2(10) DEFAULT(' ') NOT NULL;
--제약조건으로 NOT NULL을 넣고 싶을 때, ORACLE 에서는 '' 를 NULL 취급하기 때문에 ' ' 띄어쓰기를 넣어줘야한다

--컬럼 수정 (기존에 저장되어 있는 데이터가 없어야 타입 변경가능, 크기 변경은 가능)
ALTER TABLE TEST5 MODIFY COL3 NUMBER;
ALTER TABLE TEST5 MODIFY COL3 VARCHAR2(20);

--컬럼 삭제 (해당 컬럼에 값이 있으면 값 모두 삭제됨)
ALTER TABLE TEST5 DROP COLUMN COL5;
ALTER TABLE TEST5 DROP COLUMN COL4;

--제약 조건 수정
ALTER TABLE TEST3 ADD CONSTRAINT TEST3_COL1_PK PRIMARY KEY(COL1);
ALTER TABLE TEST3 ADD CONSTRAINT TEST3_COL2UK UNIQUE(COL2);
ALTER TABLE TEST3 ADD CONSTRAINT TEST3_COL3_FK FOREIGN KEY(COL3) REFERENCES TEST5(ID);
ALTER TABLE TEST3 MODIFY COL4 CONSTRAINT TEST3_COL4_NN NOT NULL;
ALTER TABLE TEST3 MODIFY COL5 CONSTRAINT TEST3_COL5_CK CHECK(COL5 IN ('A', 'B'));

ALTER TABLE TEST3 RENAME CONSTRAINT TEST3_COL2UK TO TEST3_COL2_UK;
--제약 조건 삭제
ALTER TABLE TEST3 DROP CONSTRAINT TEST3_COL1_PK;
ALTER TABLE TEST3 DROP CONSTRAINT TEST3_COL2_UK DROP CONSTRAINT TEST3_COL3_FK;
ALTER TABLE TEST3 DROP CONSTRAINT TEST3_COL5_CK;

--제약 조건 수정은 따로 안되지만 NOT NULL을 NULL 로 바꾸는건 MODIFY 써서 바꾸면 됨
ALTER TABLE TEST3 MODIFY COL4 NULL;


INSERT INTO TEST5 VALUES('A', 'B', 'C');

SELECT * FROM TEST5;
SELECT * FROM USER_TABLES WHERE TABLE_NAME = 'TEST4';
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'TEST5';
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'TEST3';
SELECT * FROM USER_CONSTRAINTS WHERE CONSTRAINT_NAME = 'SYS_C008370';

CREATE TABLE TEST1(
       COL1 NUMBER           PRIMARY KEY
     , COL2 CHAR(5 CHAR)     UNIQUE
     , COL3 VARCHAR2(10)     REFERENCES TEST2(REF1) ON DELETE CASCADE
     , COL4 DATE             NOT NULL
     , COL5 VARCHAR2(10)     CHECK(COL5 IN ('A', 'B'))
     , COL6 VARCHAR2(10)     DEFAULT('')
);

CREATE TABLE TEST3(
       COL1 NUMBER
     , COL2 VARCHAR2(10)
     , COL3 VARCHAR2(10)
     , COL4 DATE             NOT NULL
     , COL5 VARCHAR2(10)
     , COL6 VARCHAR2(10)     DEFAULT('')
     , PRIMARY KEY(COL1)
     , UNIQUE(COL2)
     , FOREIGN KEY(COL3) REFERENCES TEST2(REF1)
     , CHECK(COL5 IN ('A', 'B')) 
);

CREATE TABLE TEST2(
       REF1 VARCHAR2(10) PRIMARY KEY
     , COL2 VARCHAR2(10)
);

INSERT INTO TEST2 VALUES('A', 'Other1');
INSERT INTO TEST1 VALUES(1, 'A', 'A', SYSDATE);

DELETE FROM TEST2 WHERE REF1 = 'A';
DELETE FROM TEST1 WHERE COL2 = 'A';

SELECT * FROM TEST1;  SELECT * FROM TEST2;
SELECT * FROM USER_TABLES WHERE TABLE_NAME = 'TEST1';
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'TEST1';
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'TEST1';

INSERT INTO TEST1 VALUES(NULL, 'C', 'B', NULL);


DROP TABLE TEST1;
DROP TABLE TEST2;
DROP TABLE TEST3;
