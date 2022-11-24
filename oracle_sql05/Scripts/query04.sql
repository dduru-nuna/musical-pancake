/*
 * SYNONYM(동의어) 객체
 *    - 테이블에 별칭을 부여하여 간단한 이름으로 사용할 수 있도록 하는 기능
 * 
 * 비공개 동의어
 *    - 객체에 대한 접근 권한을 부여 받은 사용자가 정의한 동의어
 *    - 사용자명에 해당하는 스키마를 통해서만 사용할 수 있다.
 * 
 * 공개 동의어
 *    - DBA 가 정의한 동의어로 접근 권한을 부여 받은 모든 사용자가 접근하여 사용할 수 있다.
 *    - 사용자명에 해당하는 스키마를 사용하지 않아도 된다.
 */

--관리자 계정에서 계정 생성
CREATE USER user1 IDENTIFIED BY user1;
CREATE USER user2 IDENTIFIED BY user2;

GRANT CONNECT, RESOURCE, CREATE SYNONYM TO user1;
GRANT CONNECT, RESOURCE TO user2;

ALTER USER user1 quota 10M ON USERS;
ALTER USER user2 quota 10M ON USERS;

--USER1 계정에서 생성 (비공개 동의어용 테스트 테이블)
CREATE TABLE SAMPLE(
       ID NUMBER PRIMARY KEY
     , NAME VARCHAR2(50)
);
INSERT INTO SAMPLE VALUES(1, 'sample');
INSERT INTO SAMPLE VALUES(2, 'table');
INSERT INTO SAMPLE VALUES(3, 'data');

SELECT * FROM USER1.SAMPLE; --사용자명 스키마 USER1. (관리자계정에서 조회할때 )
--(USER2에서는 이대로 조회 못함)

GRANT SELECT ON SAMPLE TO USER2;
--USER1 에서 권한 부여해 주고 나면 USER2 에서 USER1.SAMPLE 조회 가능

--USER2 입장에서 계속 USER1. 이렇게 해줘야하니 귀찬.. 이럴때 공개 동의어 사용한다.

--USER1 입장에서 내가 만든 테이블 쓸 때 타이핑 하기 귀찮으면 비공개 동의어로 만들 수 있고, 
--공개 동의어로 사용하게 만들때(테이블명 숨기고 싶을때) 비공개 동의어로 만들 수 있다.

--비공개 동의어 만들기 (USER1 에서 만들기)
CREATE SYNONYM SAM FOR SAMPLE; --동의어 : SAM, 테이블명 : SAMPLE
SELECT * FROM SAM; --단순 테이블명 줄이기

SELECT * FROM USER1.SAM; --관리자 계정과 USER2 에서 조회 가능

--USER1 에서 테이블 하나 더 만들기 (공개 동의어용 테이블 생성)
CREATE TABLE PUBLIC_SAMPLE(
       ID NUMBER PRIMARY KEY
     , NAME VARCHAR2(50)
);
INSERT INTO PUBLIC_SAMPLE VALUES(1, 'sample');
INSERT INTO PUBLIC_SAMPLE VALUES(2, 'table');
INSERT INTO PUBLIC_SAMPLE VALUES(3, 'data');

--공개 동의어 만들기 (반드시 관리자 계정으로 접속해서 만들어야 함)
CREATE PUBLIC SYNONYM PSAM FOR USER1.PUBLIC_SAMPLE;

GRANT SELECT ON PUBLIC_SAMPLE TO USER2;
SELECT * FROM PSAM; --사용자명 스키마 없이 그냥 쓰면됨. USER2에서 쓰려면 소유주 USER1에서 권한은 줘야함

--권한 다시 뺏기
REVOKE SELECT ON PUBLIC_SAMPLE FROM USER2;