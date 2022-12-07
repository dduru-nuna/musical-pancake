CREATE TABLE REQ_ACCOUNTS(
	   ID NUMBER PRIMARY KEY
	 , NICKNAME VARCHAR2(35) UNIQUE
	 , EMAIL VARCHAR2(100) UNIQUE
	 , ISALLOW CHAR(1) DEFAULT('N') CHECK (ISALLOW IN ('N', 'Y'))
	 , REQDATE DATE DEFAULT(SYSDATE)
);

CREATE SEQUENCE SEQ_REQ_ACCOUNTS NOCACHE;

CREATE TABLE ACCOUNTS(
	   ID NUMBER PRIMARY KEY
	 , NICKNAME VARCHAR2(35) UNIQUE
	 , EMAIL VARCHAR2(100) UNIQUE
	 , PASSWORD VARCHAR2(100) NOT NULL
	 , LOGINDATE DATE NOT NULL
);

CREATE SEQUENCE SEQ_ACCOUNTS NOCACHE;

CREATE TABLE ACCOUNTS_ACCESS_LOG(
	   ID NUMBER PRIMARY KEY
	 , AID NUMBER REFERENCES ACCOUNTS(ID)
	 , LOGTYPE VARCHAR2(8) CHECK (LOGTYPE IN ('LOGIN', 'LOGOUT'))
	 , LOGDATE DATE DEFAULT(SYSDATE)
);

CREATE SEQUENCE SEQ_ACCOUNTS_ACCESS_LOG NOCACHE;

--회원가입 위한 요청 SQL 구문
INSERT INTO REQ_ACCOUNTS(ID, NICKNAME, EMAIL) 
       VALUES(SEQ_REQ_ACCOUNTS.NEXTVAL, 'yoon', 'yoon@gmail.com');
INSERT INTO REQ_ACCOUNTS(ID, NICKNAME, EMAIL) 
       VALUES(SEQ_REQ_ACCOUNTS.NEXTVAL, 'ji', 'ji@gmail.com');
INSERT INTO REQ_ACCOUNTS(ID, NICKNAME, EMAIL) 
       VALUES(SEQ_REQ_ACCOUNTS.NEXTVAL, 'seo', 'seo@gmail.com');
INSERT INTO REQ_ACCOUNTS(ID, NICKNAME, EMAIL) 
       VALUES(SEQ_REQ_ACCOUNTS.NEXTVAL, 'suh', 'suh@gmail.com');
      
SELECT * FROM REQ_ACCOUNTS;
SELECT * FROM ACCOUNTS;

/* 회원 가입 요청을 승낙하기 위한 SQL 구문 */
--ID 하나 정해서 승낙하기
UPDATE REQ_ACCOUNTS
   SET ISALLOW = 'Y'
 WHERE ID = 7
   AND ISALLOW = 'N';

--승낙하려는 ID 지정해서 승낙하기 
UPDATE REQ_ACCOUNTS
   SET ISALLOW = 'Y'
 WHERE ID IN (8, 10)
   AND ISALLOW = 'N';

--날짜로 범위 지정해서 승낙 안된 사용자 처리하는 방법
UPDATE REQ_ACCOUNTS
   SET ISALLOW = 'Y'
 WHERE REQDATE BETWEEN TO_DATE('20221128') AND TO_DATE('20221201')
   AND ISALLOW = 'N';
  
/*
 * 가입 요청 처리가 안된 사용자 조회
 */  
SELECT ID
     , NICKNAME
     , EMAIL
     , ISALLOW
     , REQDATE
  FROM REQ_ACCOUNTS
 WHERE ISALLOW = 'N';
  
/*
 * 요청이 승낙된 회원을 회원 테이블에 추가하기 위한 SQL 구문 (이 방법 말고 밑에 프로시져로 한 방법있음)
 */  
INSERT INTO ACCOUNTS(
	SELECT SEQ_ACCOUNTS.NEXTVAL
	     , RA.NICKNAME
	     , RA.EMAIL
	     , 'temppassword'
	     , SYSDATE
	  FROM REQ_ACCOUNTS RA
      LEFT OUTER JOIN ACCOUNTS A
        ON RA.NICKNAME = A.NICKNAME 
       AND RA.EMAIL = A.EMAIL
	 WHERE RA.ISALLOW = 'Y'
	   AND A.ID IS NULL
);
--LEFT OUTER JOIN 이용해서 만들기 위해 조회 먼저 해보기
SELECT *
  FROM REQ_ACCOUNTS RA
  LEFT OUTER JOIN ACCOUNTS A
    ON RA.NICKNAME = A.NICKNAME
   AND RA.EMAIL = A.EMAIL
 WHERE RA.ISALLOW = 'Y'
   AND A.ID IS NULL;


/*
 * 회원이 로그인 요청을 할 때 닉네임과 암호를 확인 하기 위한 조회 
 */
SELECT ID
     , NICKNAME
     , EMAIL
     , LOGINDATE
  FROM ACCOUNTS
 WHERE NICKNAME = 'yoon'
   AND PASSWORD = 'temppassword';
  
/*
 * 회원 확인 후 최근 로그인 시간 기록 (LOG 테이블 포함)
 */
UPDATE ACCOUNTS
   SET LOGINDATE = SYSDATE
 WHERE NICKNAME = 'yoon'
   AND PASSWORD = 'temppassword';
  
INSERT INTO ACCOUNTS_ACCESS_LOG
    VALUES(SEQ_ACCOUNTS_ACCESS_LOG.NEXTVAL
           , (SELECT ID
                FROM ACCOUNTS
               WHERE NICKNAME = 'yoon'
                 AND PASSWORD = 'temppassword')
           , 'LOGIN'
           , (SELECT LOGINDATE
                FROM ACCOUNTS
               WHERE NICKNAME = 'yoon'
                 AND PASSWORD = 'temppassword')
          );       
  
SELECT * FROM ACCOUNTS WHERE NICKNAME = 'yoon';
SELECT * FROM ACCOUNTS_ACCESS_LOG WHERE AID = (SELECT ID FROM ACCOUNTS WHERE NICKNAME = 'yoon'); 

/*
 * 로그아웃 할 때 LOG 테이블에 기록
 */
INSERT INTO ACCOUNTS_ACCESS_LOG VALUES(SEQ_ACCOUNTS_ACCESS_LOG.NEXTVAL, 10, 'LOGOUT', SYSDATE);

/*
 * 회원이 암호 변경 요청을 했을 때 암호를 변경하기 위한 수정 구문
 */
UPDATE ACCOUNTS
   SET PASSWORD = 'passchange'
 WHERE NICKNAME = 'yoon'
   AND PASSWORD = 'temppassword';


/*
 * 회원이 암호를 변경할 때 현재 사용했던 암호가 새로운 암호에 포함되지 않게 하기 위해서
 * 이전 암호가 새로운 암호에 포함되어있으면 조회가 되게 한다.
 */
SELECT *
  FROM ACCOUNTS A1
  JOIN (SELECT ID, NICKNAME, EMAIL, 'passchange1234' AS CPASSWORD
          FROM ACCOUNTS
         WHERE NICKNAME = 'yoon'
           AND PASSWORD = 'passchange') A2
    ON A1.ID = A2.ID
 WHERE A1.NICKNAME = 'yoon'
   AND A2.CPASSWORD LIKE '%' || A1.PASSWORD || '%';

/*
 * 로그인을 한 회원의 정보를 조회 할 때 몇 분 또는 몇 시간, 일, 개월, 년 만에 접속을 했는지 포함하여 조회
 */

--현재 시간으로부터 2022년 12월 01일 00시 00분 00초 는 몇시간, 몇분, 몇초전인가 구하기
SELECT 시간
     , 분 - (시간 * 60) AS 분
     , 초 - (분 * 60) AS 초
  FROM (SELECT FLOOR((SYSDATE - TO_DATE('20221201')) * 24) AS 시간
             , FLOOR((SYSDATE - TO_DATE('20221201')) * 24 * 60) AS 분
             , FLOOR((SYSDATE - TO_DATE('20221201')) * 24 * 60 * 60) AS 초 
      FROM DUAL);



/*
 * 회원 가입 요청을 승낙 -> 회원 테이블에 회원으로 등록
 */
CREATE OR REPLACE PROCEDURE PROC_ALLOW_ACCOUNT(
	   IN_ID IN NUMBER
	 , OUT_ID OUT NUMBER
)
IS
	VAR_NICKNAME VARCHAR2(35)
	VAR_EMAIL VARCHAR2(100)
BEGIN
	SELECT NICKNAME, EMAIL
	  INTO VAR_NICKNAME, VAR_EMAIL
	  FROM REQ_ACCOUNTS
	 WHERE ISALLOW = 'N'
	   AND ID = IN_ID;
	  
	UPDATE REQ_ACCOUNTS
	   SET ISALLOW = 'Y'
	 WHERE ID = IN_ID;
	
	INSERT INTO ACCOUNTS VALUES(SEQ_ACCOUNTS.NEXTVAL, VAR_NICKNAME, VAR_EMAIL, 'temppassword', SYSDATE);
	
	OUT_ID := SEQ_ACCOUNTS.CURRVAL;

    COMMIT;
EXCEPTION
   WHEN NO_DATA_FOUND THEN
      OUT_ID := -1;
      DBMS_OUTPUT.PUT_LINE('회원으로 승낙할 데이터가 없습니다.');
      ROLLBACK;
END;

DECLARE
	ACCOUNT_ID NUMBER;
BEGIN
	INSERT INTO REQ_ACCOUNTS(ID, NICKNAME, EMAIL) VALUES(SEQ_REQ_ACCOUNTS.NEXTVAL, 'tester1', 'tester1@gmail.com');
	PROC_ALLOW_ACCOUNT(SEQ_REQ_ACCOUNTS.CURRVAL, ACCOUNT_ID);
	DBMS_OUTPUT.PUT_LINE(ACCOUNT_ID);
END;


/*
 * 로그인 시도 -> 계정 정보 확인 -> 있음 -> 로그인 시간 기록(ACCOUNTS, ACCOUNTS_ACCESS_LOG)
 *                            없음 -> 로그인 시간 기록 X
 */
CREATE OR REPLACE PROCEDURE PROC_LOGIN_ACCOUNT(
	   IN_NICKNAME IN VARCHAR2
	 , IN_PASSWORD IN VARCHAR2
	 , OUT_RESULT OUT NUMBER
)
IS
	VAR_ID NUMBER;
	VAR_LOGDATE DATE := SYSDATE;
BEGIN
	SELECT ID
	  INTO VAR_ID
	  FROM ACCOUNTS
	 WHERE NICKNAME = IN_NICKNAME
	   AND PASSWORD = IN_PASSWORD;
	  
	UPDATE ACCOUNTS
	   SET LOGINDATE = VAR_LOGDATE
	 WHERE ID = VAR_ID;
	
	INSERT INTO ACCOUNTS_ACCESS_LOG VALUES(SEQ_ACCOUNTS_ACCESS_LOG.NEXTVAL, VAR_ID, 'LOGIN', VAR_LOGDATE);
	
	OUT_RESULT := VAR_ID;
	COMMIT;
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		OUT_RESULT := -1;
		DBMS_OUTPUT.PUT_LINE('닉네임 또는 암호가 잘못되었습니다.');
		ROLLBACK;
END;

SELECT * FROM USER_ERRORS;

DECLARE
	ACCOUNT_ID NUMBER;
BEGIN
	PROC_LOGIN_ACCOUNT('tester1', 'tester1', ACCOUNT_ID);
	DBMS_OUTPUT.PUT_LINE(ACCOUNT_ID);
END;


/*
 * 패스워드 변경 요청 -> 이전 패스워드와 동일한지 혹은 일부가 포함되어 있지 않은지 검사
 * -> 동일 혹은 포함 -> 변경 안함
 *     포함 안됨    -> 변경 후 강제로 로그아웃 처리 (LOG 기록)
 */
CREATE OR REPLACE PROC_CHANGE_PASSWORD(
	   IN_PASSWORD IN VARCHAR2(35)
	   
)
IS
BEGIN
	SELECT PASSWORD
	  INTO VAR_PASSWORD
	  FROM ACCOUNTS
	 WHERE NICKNAME = IN_NICKNAME;
	  
	UPDATE ACCOUNTS
	   SET LOGINDATE = VAR_LOGDATE
	 WHERE ID = VAR_ID;
	
	INSERT INTO ACCOUNTS_ACCESS_LOG VALUES(SEQ_ACCOUNTS_ACCESS_LOG.NEXTVAL, VAR_ID, 'LOGIN', VAR_LOGDATE);
	
	OUT_RESULT := VAR_ID;
	COMMIT;
END;





DECLARE
	VAR VARCHAR2(24);
BEGIN
	VAR := DBMS_RANDOM.STRING('U', 24);
	DBMS_OUTPUT.PUT_LINE(VAR);
END;