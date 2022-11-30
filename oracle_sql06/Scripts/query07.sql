/*
 * 풀다말음
 * 
 * 웹 사이트에 사용할 회원 관리용 테이블을 생성하고 다음의 요구사항에 적합한 SQL 문과 ORACLE 객체를 생성한다.
 *    - 일반 사용자는 웹사이트 이용을 위해 회원 가입을 진행해야 한다.
 *    - 회원 가입은 즉시 이루어 지지 않으며, 관리자의 승낙을 통해서만 이루어져야 한다.
 *    - 회원 가입에 필요한 정보는 닉네임과 이메일만 있으면 된다.(관리를 위해서 추가 정보가 필요하지만 사용자가
 *      입력하는 정보는 닉네임과 이메일 뿐이다.)
 *    - 회원 가입을 요청한 사용자는 관리자의 승낙 이후 전달되는 메일 메시지 안의 암호를 통해 로그인을 할 수 있다.
 *    - 최초 로그인을 시도하는 회원은 필수적으로 암호를 변경해야 하며, 암호를 변경할 때는 회원이 사용할 암호만
 *      있으면 된다.
 * 테이블은 총 3개의 테이블을 생성하도록 한다.
 *    - 회원 테이블 : 회원으로 가입된 사용자의 정보가 기록되는 테이블
 *    - 회원 요청 테이블 : 회원 가입을 위해 가입 요청 정보가 기록되는 테이블
 *    - 접속 이력 테이블 : 로그인 및 로그아웃한 회원의 접속 시간을 기록하기 위한 테이블
 */
CREATE TABLE MEMBERS(
	   ID NUMBER PRIMARY KEY
	 , NICKNAME VARCHAR2(15)
	 , PASSWORD VARCHAR2(20)
	 , EMAIL VARCHAR2(15)
);

CREATE TABLE REQUEST(
	   NICKNAME VARCHAR2(15) PRIMARY KEY
	 , EMAIL VARCHAR2(15)
	 , APPROVE CHAR(1)
);

CREATE TABLE ACCESSHISTORY(
	   NICKNAME VARCHAR2(15) PRIMARY KEY
	 , PASSWORD VARCHAR2(15)
	 , EMAIL VARCHAR2(15)
	 , LOGIN CHAR(1)
	 , LOGIN_DATE DATE
);

CREATE SEQUENCE SEQ_M NOCACHE;

CREATE OR REPLACE TRIGGER TRI_REQUEST
BEFORE INSERT ON REQUEST FOR EACH ROW
BEGIN
	INSERT INTO MEMBERS VALUES(SEQ_M.NEXTVAL, :NEW.NICKNAME, :NEW.PASSWORD, :NEW.EMAIL);
END;

DECLARE
	VNICKNAME VARCHAR2(15);
	VEMAIL VARCHAR2(15);
	VPASSWORD VARCHAR2(15);
	EXISTS_NAME NUMBER;
BEGIN
	VNICKNAME := :닉네임;
	VEMAIL := :이메일;
	
	SELECT COUNT(*)
	  INTO EXISTS_NAME
	  FROM REQUEST
	 WHERE NICKNAME = VNICKNAME;
	
	SELECT COUNT(*)
	  INTO EXISTS_EMAIL
	  FROM REQUEST
	 WHERE EMAIL = VEMAIL;
	
	IF(EXISTS_NAME = 0 AND EXISTS_EMAIL = 0) THEN
		DBMS_OUTPUT.PUT_LINE('중복 계정 없습니다. 가입 가능합니다!');
	
		UPDATE REQUEST
		   SET APPROVE = 'Y'
		 WHERE NICKNAME = VNICKNAME;
		
		VPASSWORD := :암호;
		INSERT INTO REQUEST VALUES(VNICKNAME, VPASSWORD, VEMAIL);
	ELSE
		IF(EXISTS_NAME > 0) THEN
	    	DBMS_OUTPUT.PUT_LINE('이미 있는 닉네임입니다. 다른 닉네임을 입력하세요.');
	    ELSIF(EXISTS_EMAIL > 0) THEN
	        DBMS_OUTPUT.PUT_LINE('이미 사용 중인 이메일입니다. 다른 이메일로 가입하세요.');
	    END IF;
	END IF;
    COMMIT;
END;


DECLARE
	VNICKNAME VARCHAR2(15);
	VPASSWORD VARCHAR2(15);
	EXISTS_USER NUMBER;
    CUSERNAME VARCHAR2(30);
    CPASSWORD VARCHAR2(30);
    CLOGIN_DATE DATE;
BEGIN
	VNICKNAME := :닉네임;
	VPASSWORD := :암호;
	
	SELECT COUNT(*)
	  INTO EXISTS_USER
	  FROM ACCESSHISTORY
	 WHERE NICKNAME = VNICKNAME;
	  
	IF(EXISTS_USER = 0) THEN
		DBMS_OUTPUT.PUT_LINE('계정 정보 없음');
	ELSE
	  SELECT USERNAME, PASSWORD, LOGIN_DATE
	    INTO CUSERNAME, CPASSWORD, CLOGIN_DATE
	    FROM ACCESSHISTORY
	   WHERE NICKNAME = VNICKNAME;
	  
	  UPDATE ACCESSHISTORY
	     SET PASSWORD = CPASSWORD
	       , LOGIN = 'I'
	   WHERE NICKNAME = VNICKNAME;
	  
	  IF LOGIN = 'I' THEN
	  	  DBMS_OUTPUT.PUT_LINE('로그인 시간 :' || TO_CHAR(SYSDATE, 'YYYY.MM.DD HH24:MI:SS')); 
	  ELSE
		
	  END IF;
	END IF;	 
    COMMIT;
END;