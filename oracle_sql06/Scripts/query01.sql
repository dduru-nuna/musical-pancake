/* 
 * PL/SQL
 *    - Procedural Language extention to SQL
 *    - SQL 문장에서 변수의 정의, 조건문, 반복문 등의 프로그래밍 언어에서 지원하는 
 *      기능을 일부 지원하는 것
 * 
 * PL/SQL 구조
 *    DECLARE
 *       변수 정의 영역(생략 가능)
 *    BEGIN
 *       실행 영역
 *    EXCEPTION
 *       예외 처리 영역(생략 가능)
 *    END;
 */

--PL/SQL 의 경우 sqlplus 로 많이 사용하기 때문에 그 사용법도 확인해본다
--SET SERVEROUTPUT ON;  SET은 sqlplus 전용 명령어
BEGIN
	DBMS_OUTPUT.PUT_LINE('Hello PL/SQL');
END;

/*
 * 기본 변수 사용 방법
 */
DECLARE
    NUM1 NUMBER := 10;  --선언하고 초기화 함께 하던 선언만 먼저 하던 상관X
    NUM2 NUMBER;   
BEGIN
	NUM2 := 5;
	DBMS_OUTPUT.PUT_LINE(NUM1 + NUM2);
END;

DECLARE
    STR1 VARCHAR2(10) := '문자열';
    STR2 CHAR(10);
BEGIN
	STR2 := 'String';
	DBMS_OUTPUT.PUT_LINE(STR1 || '|');
	DBMS_OUTPUT.PUT_LINE(STR2 || '|');
END;

/*
 * 조회 결과 출력하기
 */
DECLARE
   pID NUMBER;
   pNAME VARCHAR2(50);
BEGIN
   SELECT EMPLOYEE_ID
        , FIRST_NAME || ' ' || LAST_NAME
     INTO pID, pNAME   
     FROM EMPLOYEES
    WHERE EMPLOYEE_ID = :id;
   DBMS_OUTPUT.PUT_LINE(pID || '|' || pNAME);
END;
--PL/SQL 에 SELECT 구문을 쓰면 반드시 1개의 행이 나와야 한다.

--sqlplus 에서는 &id , 디비버에서는 :id

/*
 * IF 문 사용하기
 */
DECLARE
    NUM NUMBER;
BEGIN
	NUM := :num;
	IF(NUM > 10) THEN
	    DBMS_OUTPUT.PUT_LINE('NUM 값은 10 보다 큽니다.');
	ELSIF(NUM = 10) THEN
	    DBMS_OUTPUT.PUT_LINE('NUM 값은 10 입니다.');
	ELSE
	    DBMS_OUTPUT.PUT_LINE('NUM 값은 10 보다 작습니다.');
	END IF;
END;
--ELSEIF 가 아닌 ELSIF 인 것 주의!

/*
 * 반복문 사용하기
 */
BEGIN
	FOR N IN 1..5 LOOP
		DBMS_OUTPUT.PUT_LINE(N || ' 번째 반복 입니다.');
	END LOOP;
END;

BEGIN
	FOR N IN REVERSE 1..5 LOOP
		DBMS_OUTPUT.PUT_LINE(N || ' 번째 반복 입니다.');
	END LOOP;
END;

DECLARE
    CNT NUMBER := 0;
BEGIN
	LOOP
		DBMS_OUTPUT.PUT_LINE(CNT || ' 번째 반복 입니다.');
	    CNT := CNT + 1;
	    IF(CNT > 5) THEN
	        EXIT;
	    END IF;
	END LOOP;
END;
--LOOP 안에 IF문 안썼으면 무한반복 됨

DECLARE
   CNT NUMBER := 1;
BEGIN
   WHILE CNT <= 5 LOOP
	   DBMS_OUTPUT.PUT_LINE(CNT || ' 번째 반복 입니다.');
	   CNT := CNT + 1;
   END LOOP;
END;


DECLARE
    ST_ID NUMBER := 100;
    ED_ID NUMBER := 109;
    ID NUMBER;
    NAME VARCHAR2(50);
BEGIN
	FOR C_ID IN ST_ID..ED_ID LOOP
		SELECT EMPLOYEE_ID, CONCAT(FIRST_NAME, ' ' || LAST_NAME)
		  INTO ID, NAME
		  FROM EMPLOYEES
		 WHERE EMPLOYEE_ID = C_ID;
		DBMS_OUTPUT.PUT_LINE(ID || '|' || NAME);
	END LOOP;
END;

/*
 * INSERT / UPDATE / DELETE 문 사용하기
 */
CREATE TABLE TEST1(
       ID NUMBER PRIMARY KEY
     , NAME VARCHAR2(30)
     , AGE NUMBER
);

BEGIN
	INSERT INTO TEST1 VALUES(:id, :name, :age);
END;
/* sqlplus 에서 사용하는 형식
 * BEGIN
 * INSERT INTO TEST1 VALUES(&id, '&name', &age);
 * END;
 */
SELECT * FROM TEST1;
COMMIT; --커밋해줘야 sqlplus 에서 확인 가능


DECLARE
    CNAME VARCHAR2(30);
    CAGE NUMBER;
    SID NUMBER;
BEGIN
	SID := :select_id;
    CNAME := :change_name;
    CAGE := :change_age;
	UPDATE TEST1
	   SET NAME = CNAME
	     , AGE = CAGE
	 WHERE ID = SID;
	COMMIT;
END;

SELECT * FROM TEST1;


DECLARE
    VID NUMBER;
    VNAME VARCHAR2(30);
    VAGE NUMBER;
    CNT NUMBER;
BEGIN
	VID := :id;
	VNAME := :name;
	VAGE := :age;

--PRIMARY KEY 에 위배되지 않게 SELECT, IF 문 으로 중복 ID 확인
	SELECT COUNT(ID)  --입력값이 없으면 COUNT(ID) = 0
	  INTO CNT
	  FROM TEST1
	 WHERE ID = VID;
	
	IF(CNT > 0) THEN
		DBMS_OUTPUT.PUT_LINE('동일한 ID가 이미 존재합니다.');
	   /*
	    * UPDATE TEST1
	    *    SET NAME = VNAME
	    *      , AGE = VAGE
	    *  WHERE ID = VID;
	    * DBMS_OUTPUT.PUT_LINE('ID:' || VID || '데이터를 수정함');
	    * 이런식으로 UPDATE 문 쓸 수도 있음
	    */
	ELSE
	    INSERT INTO TEST1 VALUES(VID, VNAME, VAGE);
	END IF;
	COMMIT;
END;



DECLARE
    VID NUMBER;
    VNAME VARCHAR2(30);
    VAGE NUMBER;
BEGIN
	VID := :id;
	VNAME := :name;
	VAGE := :age;
--INSERT를 먼저 시도해보고 무결성제약 에러 뜨면 EXCEPTION 으로 예외처리
    INSERT INTO TEST1 VALUES(VID, VNAME, VAGE);
    DBMS_OUTPUT.PUT_LINE('ID:' || VID || '데이터를 추가함');
	COMMIT;
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN --에러 이름 찾으려면 orcle 21c exception handling 검색해서 찾을 수 있다
	     UPDATE TEST1
	        SET NAME = VNAME
	          , AGE = VAGE
	      WHERE ID = VID;
	     DBMS_OUTPUT.PUT_LINE('ID:' || VID || '데이터를 수정함');
	COMMIT;
END;