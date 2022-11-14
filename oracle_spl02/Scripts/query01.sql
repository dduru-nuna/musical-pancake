/*
 * DDL
 *    - 데이터 정의어로 데이터를 저장하고 다루기 위한 객체를 생성(CREATE), 수정(ALTER), 삭제(DROP)
 *      하기 위한 구문을 제공한다.
 *    - ORACLE 에서 사용하는 객체들로는 TABLE, SEQUENCE, VIEW, USER, PROCEDUAL, FUNCTION 등이 있다.
 * 
 * TABLE 객체를 생성, 수정, 삭제 하기 위한 구문        <>안의 내용은 필수, []안의 내용은 옵션 (기호는 작성X)
 *    CREATE TABLE <테이블명> (
 *           <컬럼명1> <데이터타입> [제약조건]
 *         , <컬럼명2> <데이터타입> [제약조건]
 *         ...
 *    );
 * 
 * 데이터 타입
 *    CHAR(크기)     : 고정 길이 문자 타입, 크기는 바이트 단위로 입력,
 *                    문자의 길이로 크기를 정하는 경우 'CHAR(크기 CHAR)' 형식으로 사용
 *                    최대 2000 Byte 까지 저장 가능, 한글은 3 Byte 로 처리됨
 *    VARCHAR2(크기) : 가변 길이 문자 타입, 크기는 바이트 단위로 입력,
 *                    문자의 길이로 크기를 정하는 경우 'VARCHAR2(크기 CHAR)' 형식으로 사용
 *                    예상되는 가장 큰 문자길이로 크기CHAR 정하면 됨
 *                    최대 4000 Byte 까지 저장 가능, 한글은 3 Byte 로 처리됨
 *    NUMBER                   : 숫자 타입(실수도 숫자타입에 포함됨)
 *    NUMBER(크기[, 소수점자릿수]) : 지정한 소수점 자리수의 실수 데이터 저장 가능
 *                               NUMBER(5, 2) 의 경우 정수 3자리 소수점 2자리 범위로 저장 가능
 *    DATE          : 날짜 타입
 * 
 *    LONG          : 가변 길이 문자 타입, 2GB 까지 저장 가능
 *    LOB           : 가변 길이 바이너리 타입, 2GB 까지 저장 가능
 *    BLOB          : 대용량 데이터 저장용 객체, 4GB 까지 저장 가능(바이너리 타입)
 *    CLOB          : 대용량 데이터 저장용 객체, 4GB 까지 저장 가능(문자 타입)
 *    TIMESTAMP     : 타임스탬프 타입(날짜 타입 확장)
 * 
 * 제약 조건
 *    NOT NULL    : NULL 데이터 저장을 허용하지 않음
 *    UNIQUE      : 중복값 저장을 허용하지 않음 (NULL 에 대해서는 중복 체크 하지 않는다)
 *    PRIMARY KEY : NULL, 중복값 저장을 허용하지 않음(NOT NULL + UNIQUE 결합), 기본키 라고 한다.
 *    FOREIGN KEY : 참조하는 테이블의 컬럼의 값이 존재하는 경우에만 허용(다른 테이블의 값을 참조), 외래키 라고 한다.
 *    CHECK       : 지정된 값만 저장할 수 있게 만드는 용도
 *    DEFAULT     : 기본값을 설정하여 데이터 추가 작업에 누락이 되어 있어도 기본값이 저장되도록 한다.
 *                  제약조건이 아니지만 제약조건이 작성되는 부분에 사용되어 여기에 작성함.
 * 
 * 위의 제약 조건을 위반하는 데이터의 추가/수정/삭제 작업이 이루어지는 경우 "제약조건 위반"이라는 에러가 발생
 * 
 * 제약 조건 작성 방법
 *    - 컬럼 레벨 : 컬럼명, 데이터 타입 옆에 작성하는 것
 *                기본키, 유니크키, 외래키, NOT NULL, CHECK, DEFAULT 가 해당
 * 
 *    - 테이블 레벨 : 컬럼명, 데이터 타입 처럼 쉼표 이후에 작성하는 것
 *                  단, 모든 컬럼정보를 작성 후 제약조건을 작성한다
 *                  기본키, 유니크키, 외래키, CHECK 가 해당
 */

CREATE TABLE TEST1(
       COL1 NUMBER NOT NULL
     , COL2 CHAR(5 CHAR) UNIQUE
     , COL3 VARCHAR2(5 CHAR) CHECK(COL3 IN ('A','B','C'))
     , COL4 DATE  DEFAULT(SYSDATE)   
);

CREATE TABLE TEST2(
       COL1 NUMBER PRIMARY KEY
     , COL2 VARCHAR2(10) REFERENCES TEST3(REF1) ON DELETE CASCADE
     , COL3 VARCHAR2(10) NOT NULL
     , COL4 DATE NOT NULL
     , COL5 VARCHAR2(10) CHECK(COL5 IN ('A', 'B'))
     , COL6 VARCHAR2(10) DEFAULT('')
);

CREATE TABLE TEST3(
       REF1 VARCHAR2(10) PRIMARY KEY
     , COL2 VARCHAR2(10)
);
--참조하는 키에 유니크/기본키 설정 되어있어야 한다.

--테이블레벨 작성
CREATE TABLE TEST4(
       COL1 NUMBER
     , COL2 VARCHAR2(10)
     , COL3 VARCHAR2(10)
     , COL4 DATE NOT NULL
     , COL5 VARCHAR2(10)
     , COL6 VARCHAR2(10) DEFAULT('')
     , PRIMARY KEY(COL1)
     , UNIQUE(COL2)
     , FOREIGN KEY(COL3) REFERENCES TEST3(REF1)
     , CHECK(COL5 IN ('A', 'B'))
);


--TABLE 제대로 만들어졌는지 확인
SELECT * FROM TEST1;
SELECT * FROM USER_TABLES WHERE TABLE_NAME = 'TEST1';
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'TEST1';
--USER_TAB_COLUMNS로 데이터타입,DEFAULT 확인 가능
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'TEST1';


INSERT INTO TEST1 VALUES(1, 'A', 'B', TO_DATE('20221114'));
INSERT INTO TEST1(COL1, COL2, COL3) VALUES(1, 'A', 'B');
INSERT INTO TEST1 VALUES(1, 'B', 'B', DEFAULT);
INSERT INTO TEST1 VALUES(1, NULL, 'A', NULL);


INSERT INTO TEST3 VALUES('A', 'Other1');
INSERT INTO TEST2 VALUES(1, 'A', 'A', SYSDATE);
INSERT INTO TEST2 VALUES(NULL, 'C', 'B', NULL);
SELECT * FROM TEST2;
SELECT * FROM TEST3;
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'TEST2';

--DELETE FROM TEST3 WHERE REF1 = 'A';
--자식레코드에서 부모레코드를 참조하는게 있으면 부모레코드는 삭제가 안된다
--ON DELETE SET NULL 제약조건에 넣어주면 삭제 가능. 삭제하면 NULL값으로 나온다
--ON DELETE CASCADE 는 부모레코드를 지우면 그를 참조하고 있는 자식 레코드도 제거
DELETE FROM TEST2 WHERE COL2 = 'A';
DELETE FROM TEST3 WHERE REF1 = 'A';

DROP TABLE TEST1;
DROP TABLE TEST2;
DROP TABLE TEST3;
--외래키 참조할 때는 자식 테이블 먼저 지우고 부모 테이블을 지워야 오류가 안남