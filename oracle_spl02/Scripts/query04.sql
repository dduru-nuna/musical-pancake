CREATE TABLE EMPS
AS
SELECT * FROM EMPLOYEES;


SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'EMPS';
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'EMPS';
/*
 * 홍길동 사원 정보를 추가한다.
 * 홍길동 사원의 EMPLOYEE_ID 는 기존 EMPLOYEE_ID 값 중 가장 큰 EMPLOYEE_ID + 1 한 값이 저장되게 한다.
 * 홍길동 사원의 입사일은 2022년 03월 05일 이다.
 * 홍길동 사원의 부서 ID 는 80이다.
 * 홍길동 사원의 급여는 2800 이며 보너스(COMMISSION_PCT)는 없다.
 * 위에서 제시한 사항을 참고하여 데이터를 추가하며 없는 정보는 NULL로 채워 넣는다.
 */

ALTER TABLE EMPS MODIFY EMAIL NULL;
ALTER TABLE EMPS MODIFY JOB_ID NULL;

--INSERT 안에 SELECT 구문이 들어가면 서브쿼리(하위쿼리) 라고 한다
INSERT INTO EMPS(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, HIRE_DATE, DEPARTMENT_ID, SALARY) 
           VALUES((SELECT MAX(EMPLOYEE_ID)+1 FROM EMPS), '길동', '홍', TO_DATE('20220305'), 80, 2800);

DELETE FROM EMPS WHERE EMPLOYEE_ID = 207;
          
SELECT * FROM EMPS; 
/*
 * 기존 전화번호 형식이 .(온점) 을 구분자로 하는 전화번호였는데 이를 -(하이픈)을 구분자로 하는
 * 전화번호로 수정하세요.
 */
UPDATE EMPS
   SET PHONE_NUMBER = REPLACE(PHONE_NUMBER, '.', '-');
  
SELECT * FROM EMPS;   
/*
 * 이메일 주소에 도메인 주소 '@emp.co.kr' 가 같이 저장되도록 하세요.
 */
UPDATE EMPS
   SET EMAIL = EMAIL || '@emp.co.kr';
/*
 * 홍길동 사원의 부서ID 는 60으로 수정하세요.
 * 홍길동 사원의 EMAIL 주소는 영문이름으로 만들어서 수정해주세요
 * 홍길동 사원의 전화번호는 590-423-4561 으로 수정해주세요.
 */ 
UPDATE EMPS
   SET DEPARTMENT_ID = 60
     , EMAIL = 'HGILDONG@emp.co.kr'
     , PHONE_NUMBER = '590-423-4561'
 WHERE LAST_NAME = '홍';
 
SELECT * FROM EMPS;

/*
 * 1990년 이전 입사자들의 정보를 조회하고 조회된 정보 중에서 급여가 10000 이상인
 * 사원의 급여를 25% 삭감하세요.
 */
UPDATE EMPS
   SET SALARY = SALARY - (SALARY * 0.25)
 WHERE HIRE_DATE < TO_DATE('19990101') AND SALARY >= 10000;

SELECT * FROM EMPS WHERE HIRE_DATE < TO_DATE('19900101') AND SALARY >= 10000;

/*
 * 부서ID 가 50,60,70 인 사원들에 대해 기존 급여에 10% 인상한 급여로 수정하세요.
 */
UPDATE EMPS
   SET SALARY = SALARY * 1.1
 WHERE DEPARTMENT_ID IN (50,60,70);

SELECT * FROM EMPS WHERE DEPARTMENT_ID IN (50,60,70);

