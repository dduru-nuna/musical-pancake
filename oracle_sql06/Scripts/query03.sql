/*
 * PROCEDURE 객체
 *    - PL/SQL 구문을 사용하여 만든 객체
 *    - 함수와 비슷하게 프로시져를 호출(EXEC 명령어 사용)하여 언제든 사용할 수 있다.
 *    - 함수처럼 프로시져 내부에 값을 전달하거나 외부로 값을 내보낼 수 있다.
 *      (값을 내보낼 때의 작업은 반환 작업이 아니다)
 */
CREATE OR REPLACE PROCEDURE PROC_SAMPLE1
IS
BEGIN
	DBMS_OUTPUT.PUT_LINE('프로시져 실행!');
END;

--만든 프로시져에 에러가 있는지 확인하기. 프로시져 생성 과정에서는 로직 관련 에러가 나오지 않는다.
SELECT * FROM USER_ERRORS;

BEGIN
	PROC_SAMPLE1;
END;
--디비버에서는 BEGIN END 로 실행. SQLPlus 에선 EXEC 명령어 사용

/*
 * 프로시져에서 사용할 변수 정의
 */
--DECLARE 필요없이 IS 와 BEGIN 사이에 변수 넣으면 된다
CREATE OR REPLACE PROCEDURE PROC_SAMPLE2
IS
    VAR NUMBER := 0;
BEGIN
	DBMS_OUTPUT.PUT_LINE('프로시져 실행!' || VAR);
END;

BEGIN
	PROC_SAMPLE2;
END;


/*
 * 프로시져 내부로 값 전달하기
 */
CREATE OR REPLACE PROCEDURE PROC_SAMPLE3(X IN NUMBER, Y IN VARCHAR2) --VARCHAR2 에 길이 명시할 필요 없다
IS
BEGIN
	DBMS_OUTPUT.PUT_LINE('외부에서 전달 받은 X=' || X);
	DBMS_OUTPUT.PUT_LINE('외부에서 전달 받은 Y=' || Y);
END;

BEGIN
	PROC_SAMPLE3(10, '문자열');
END;

/*
 * 프로시져 외부로 값 내보내기
 */
CREATE OR REPLACE PROCEDURE PROC_SAMPLE4(X OUT NUMBER) 
IS
BEGIN
	X := 10;
	DBMS_OUTPUT.PUT_LINE('내보낼 값을 설정하였습니다.');
END;

DECLARE
	Y NUMBER;
BEGIN
	PROC_SAMPLE4(Y);  --내보내는 값을 받을 변수 지정
	DBMS_OUTPUT.PUT_LINE(Y || ' 값을 받았습니다.');
END;


CREATE OR REPLACE PROCEDURE PROC_SAMPLE5(NUM1 IN NUMBER, NUM2 IN NUMBER, RES OUT NUMBER) 
IS
BEGIN
	RES := NUM1 + NUM2;
	DBMS_OUTPUT.PUT_LINE('더하기 계산이 완료됨');
END;

DECLARE
	Y NUMBER;
BEGIN
	PROC_SAMPLE5(10, 20, Y);
	DBMS_OUTPUT.PUT_LINE(Y);
END;