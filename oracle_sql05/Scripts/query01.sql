/*
 * SEQUENCE 객체
 *    - 번호 발생기 객체
 *    - 정수값을 순차적으로 생성하는 객체
 *    - PRIMARY KEY 로 사용하는 번호(ID) 등에 사용하여 정수값을 생성하기 위한 용도로 많이 사용
 */

--NEXTVAL : 다음 번호 생성
SELECT 시퀸스명.NEXTVAL FROM DUAL;
--CURRVAL : 현재 번호
SELECT 시퀸스명.CURRVAL FROM DUAL;

--PK 가 있는 경우 NEXTVAL 을 사용하면 신경쓰지 않아도 알아서 1씩 증가하는 값 저장(중복 안되는)
CREATE TABLE TEMP(
       ID NUMBER PRIMARY KEY
);
DROP TABLE TEMP;

INSERT INTO TEMP VALUES(시퀸스명.NEXTVAL);

UPDATE TEMP
   SET ID = 시퀸스명.NEXTVAL
 WHERE ID = 130;

SELECT * FROM TEMP;

CREATE SEQUENCE 시퀸스명
     START WITH 10   --10부터 시작
   INCREMENT BY 10   --NEXTVAL 하면 10씩 증가
       MAXVALUE 300  --최대치 100. 그 이상 만들려하면 오류
       MINVALUE 10   --MINVALUE 로 처음 최솟값 정할 수 있음 (MAXVALUE 넘어간 후 나오는 값)
          CYCLE      --순환. MAXVALUE 300 을 넘어가면 기본적으로 1 이 나옴.
        NOCACHE ;    --메모리관련

ALTER SEQUENCE 시퀸스명  --START WITH 은 수정 불가
  INCREMENT BY 5
      MAXVALUE 200
      MINVALUE 0;
DROP SEQUENCE 시퀸스명;

/*
 * NEXTVAL, CURRVAL 을 사용할 수 있는 명령어
 *    1. SELECT 문 (서브쿼리 제외)
 *    2. INSERT 문의 VALUES 절
 *    3. INSERT 문의 SELECT
 *    4. UPDATE 문의 SET 절
 * 
 * NEXTVAL, CURRVAL 을 사용할 수 없는 명령어
 *    1. VIEW 의 SELECT 문
 *    2. DISTINCT 키워드가 있는 SELECT 문
 *    3. GROUP BY, HAVING, ORDER BY 절이 있는 SELECT
 *    4. SELECT, DELETE, UPDATE 의 서브쿼리
 *    5. DEFAULT 값
 */
