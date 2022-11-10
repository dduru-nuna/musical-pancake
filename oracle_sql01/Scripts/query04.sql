/*
 * 함수
 *   - 단일함수(문자,숫자,날짜,형변환함수) : 레코드 하나에 결과 값 하나가 나오는 함수
 *   - 그룹함수(그룹함수) : 레코드 여러개에 결과 값 하나가 나오는 함수
 *   
 *   - 문자 함수 : 문자열에서 일부 문자열만 잘라내거나, 공백제거, 대소문자변환, 일부내용변경 등의
 *               기능을 제공
 *   - 숫자 함수 : 소수점 처리에 대한 기능 제공
 *   - 날짜 함수 : 시스템날짜 생성 및 날짜에서 년, 월, 일 등의 정보를 추출하기 위한 기능 제공
 *   - 형변환 함수 : 문자 데이터를 숫자 데이터로 또는 그 반대로 변환하거나 문자 데이터를 날짜
 *                데이터로 변환 또는 그 반대로 변환하기 위한 기능 제공
 *   - 그룹 함수 : Record Set 을 이용하여 전체 레코드 수, 최대값, 최소값 등의 정보를 얻을 수
 *              있는 기능을 제공
 */

/* 
 * 문자 함수
 */
SELECT EMAIL
     , LENGTH(EMAIL) AS 문자열길이
  FROM EMPLOYEES;
  
SELECT JOB_ID
     , INSTR(JOB_ID, '_') AS 문자위치
  FROM EMPLOYEES;
  
SELECT JOB_ID
     , SUBSTR(JOB_ID, 1, 2) AS 잘라내기
     , SUBSTR(JOB_ID, 4) AS 잘라내기2
  FROM EMPLOYEES;
 
SELECT FIRST_NAME || ' ' || LAST_NAME AS 이름
     , UPPER(FIRST_NAME || ' ' || LAST_NAME) AS 대문자이름
     , LOWER(FIRST_NAME || ' ' || LAST_NAME) AS 소문자이름
     , INITCAP(FIRST_NAME || ' ' || LAST_NAME) AS 단어의첫번째문자만대문자
     , CONCAT(FIRST_NAME, LAST_NAME) AS 결합
  FROM EMPLOYEES;
 --CONCAT은 공백을 줄 순 없음
 
SELECT EMAIL
     , RPAD(EMAIL, 20) AS 오른쪽에여백추가1
     , LPAD(EMAIL, 20) AS 왼쪽에여백추가1
     , RPAD(EMAIL, 20, '*') AS 오른쪽에여백추가2
     , LPAD(EMAIL, 20, '*') AS 왼쪽에여백추가2
  FROM EMPLOYEES;
 -- 자릿수 : 20
 
SELECT TRIM(EMAIL || '   ') AS 이메일1
     , TRIM('   ' || EMAIL) AS 이메일2
     , EMAIL || '@emp.co.kr' AS 원본이메일형식
     , RTRIM(EMAIL || '@emp.co.kr', '@emp.co.kr') AS 도메인제거
     , LTRIM(EMAIL || '@emp.co.kr', EMAIL) AS 계정명제거
  FROM EMPLOYEES;
 
SELECT PHONE_NUMBER
     , REPLACE(PHONE_NUMBER, '.', '-') AS 전화번호
  FROM EMPLOYEES;
 
SELECT EMAIL || '@emp.co.kr' AS 원본이메일형식
     , SUBSTR(EMAIL || '@emp.co.kr', 1, INSTR(EMAIL || '@emp.co.kr', '@') -1) 계정명
     , SUBSTR(EMAIL || '@emp.co.kr', INSTR(EMAIL || '@emp.co.kr', '@')) 도메인
  FROM EMPLOYEES;
 
 /*
  * 숫자 함수
  */
 
  
 