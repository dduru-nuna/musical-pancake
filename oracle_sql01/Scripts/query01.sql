--한 줄 주석, 한 줄 주석 작성할 때 쿼리문 옆에 작성하지 않기
--쿼리문 윗줄 또는 아랫줄에 작성하기

/*
 * 블럭 주석
 */

-- SELECT Query 문장 예시
-- SQL 문장은 반드시 세미콜론으로 끝나야 한다.
SELECT 'Hello World' FROM DUAL;



/*
 * SYS 나 SYSTEM 과 같은 관리자 계정이 아닌 일반 계정을 생성하여 
 * Oracle 데이터베이스를 사용하기
 */

-- 계정 및 암호 생성
-- CREATE USER 계정명 IDENTIFIED BY 계정암호
CREATE USER dev01 IDENTIFIED BY dev01;

-- 계정에 대한 권한(역할) 부여
-- GRANT 역할명1, 역할명2, ... TO 계정명;
GRANT RESOURCE, CONNECT
    , INSERT ANY TABLE, UPDATE ANY TABLE
    , DELETE ANY TABLE, CREATE VIEW
    , CREATE SESSION TO dev01;  
-- 하나씩 권한 주기 힘들때 DBA 쓰면 됨 (비추. 너무 많은 권한을 주게됨)  
-- GRANT RESOURCE, DBA TO 계정명;   
   

-- 계정에 테이블 스페이스(임시 저장 공간) 할당
ALTER USER dev01 quota 10M ON USERS;
-- 테이블 스페이스 이름을 USERS 로 만든 것 10M짜리 공간

-- 계정 확인(주의 : WHERE절에 사용하는 계정명은 반드시 대문자로 작성)
SELECT USERNAME FROM ALL_USERS WHERE USERNAME = 'DEV01';

-- 패스워드 변경
ALTER USER dev01 IDENTIFIED BY dev01;

-- 계정 삭제
DROP USER dev01;
