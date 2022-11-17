/*
 * 가계부 작성을 위한 테이블을 생성하고 데이터를 추가하세요.
 * 
 * 가계부 테이블에는 ID, 입금/출금 구분, 금액, 날짜, 지출구분, 비고 정보가 저장될 수 있도록 합니다.
 *   - ID 는 레코드를 식별하기 위한 식별 값으로 사용합니다.
 *   - 입금/출금 구분은 입금의 경우 'I', 출금의 경우 'O' 으로 사용합니다.
 *   - 지출구분은 식비, 교통비, 통신비, 물품구입비 등 정해진 항목 안에서 사용할 수 있게 합니다.
 *     정해진 항목 안에서 사용할 수 있도록 지출구분 테이블을 별도로 만들어 참조할 수 있게 합니다.
 *   - 비고에는 지출구분으로 작성할 수 없는 좀 더 상세한 내용을 작성하기 위해 사용합니다.
 * 
 * 지출구분 테이블에는 CODE, 항목 정보가 저장될 수 있도록 합니다.
 *   - CODE 는 지출항목에 대응할 수 있는 5자리 영문자값으로 사용합니다.
 *   - 항목에는 식비, 교통비, 통신비 등 정해진 값을 작성합니다.
 * 
 * 임의의 데이터를 가계부에 작성해봅니다. 최소 개월마다 5개 정도의 데이터를 2개월분 추가합니다. 
 */

CREATE TABLE 가계부(
       ID NUMBER CONSTRAINT 가계부_ID_PK PRIMARY KEY
     , 입출금구분 CHAR(1 CHAR) CONSTRAINT 가계부_입출금구분_CK CHECK(입출금구분 IN ('I', 'O'))
     , 금액 NUMBER DEFAULT(0)
     , 날짜 DATE DEFAULT(SYSDATE)
     , 지출구분 CHAR(5) CONSTRAINT 가계부_지출구분_FK REFERENCES 지출구분(CODE)
     , 비고 VARCHAR(100 CHAR)
);

CREATE TABLE 지출구분(
       CODE CHAR(5 CHAR) CONSTRAINT 지출구분_CODE_PK PRIMARY KEY
     , 항목 VARCHAR2(50 CHAR) CONSTRAINT 지출구분_항목_NN NOT NULL
);



SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = '가계부';
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = '가계부';


INSERT INTO 지출구분 VALUES('0000A', '급여');
INSERT INTO 지출구분 VALUES('0000B', '식비');
INSERT INTO 지출구분 VALUES('0000C', '교통비');
INSERT INTO 지출구분 VALUES('0000D', '통신비');
INSERT INTO 지출구분 VALUES('0000E', '물품구입비');
INSERT INTO 지출구분 VALUES('0000F', '전기세');
INSERT INTO 지출구분 VALUES('0000G', '수도세');
INSERT INTO 지출구분 VALUES('0000H', '관리비');
SELECT * FROM 지출구분;

INSERT INTO 가계부 VALUES(1, 'I', 2500000, TO_DATE(20221117), '0000A', '11월급여');
INSERT INTO 가계부 VALUES(2, 'O', 120000, TO_DATE(20221015), '0000B', NULL);
INSERT INTO 가계부 VALUES(3, 'O', 56000, TO_DATE(20220910), '0000C', NULL);
INSERT INTO 가계부 VALUES(4, 'O', 16500, TO_DATE(20221117), '0000D', NULL);
INSERT INTO 가계부 VALUES(5, 'O', 59500, TO_DATE(20221117), '0000E', '신발구매');
INSERT INTO 가계부 VALUES(6, 'O', 60000, TO_DATE(20221117), '0000F', NULL);
INSERT INTO 가계부 VALUES(7, 'O', 42000, TO_DATE(20221117), '0000G', NULL);
INSERT INTO 가계부 VALUES(8, 'O', 181000, TO_DATE(20221117), '0000H', NULL);
SELECT * FROM 가계부;


DROP TABLE 가계부;
DROP TABLE 지출구분;


