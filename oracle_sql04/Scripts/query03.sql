/*
 * SUB Query
 *    - SQL 구문에 SELECT 구문이 포함되어 실행되는 형태
 *    - 서브쿼리는 반드시 소괄호로 묶어야 함.
 *    - 서브쿼리를 사용하는 대상의 열과 행의 수에 맞추어 서브쿼리의 결과도 동일한
 *      열과 행의 수가 조회되어야 한다.
 */
SELECT EMPLOYEE_ID
     , FIRST_NAME
     , LAST_NAME
     , DEPARTMENT_ID
     , (SELECT DEPARTMENT_NAME 
          FROM DEPARTMENTS WHERE DEPARTMENT_ID = EMPLOYEES.DEPARTMENT_ID) AS DEPT_NAME
  FROM EMPLOYEES;
  
SELECT *
  FROM EMPLOYEES
 WHERE EMPLOYEE_ID = (SELECT MANAGER_ID 
                        FROM DEPARTMENTS WHERE DEPARTMENT_ID = 10);
                        
SELECT *
  FROM EMPLOYEES
 WHERE (DEPARTMENT_ID, EMPLOYEE_ID) IN (SELECT DEPARTMENT_ID, MANAGER_ID 
                                          FROM DEPARTMENTS WHERE DEPARTMENT_ID <= 20);
     
UPDATE 테이블명
   SET 컬럼명 = 값
 WHERE 컬럼명 = (서브쿼리);

UPDATE 테이블명
   SET 컬럼명 = (서브쿼리);

DELETE FROM 테이블명
 WHERE 컬럼명 = (서브쿼리);
 
INSERT INTO 테이블명 VALUES((서브쿼리), (서브쿼리), 값1, 값2, ...);

INSERT INTO 테이블명(
	서브쿼리
);

/*
 * FROM 절에 사용하는 서브쿼리는 INLINE VIEW 라고 한다.
 */
SELECT *
  FROM (SELECT EMPLOYEE_ID
             , FIRST_NAME
             , LAST_NAME
          FROM EMPLOYEES);
          
WITH TEMP
  AS (SELECT EMPLOYEE_ID
           , FIRST_NAME
           , LAST_NAME
           , MANAGER_ID
        FROM EMPLOYEES)
SELECT *
  FROM TEMP T1
  JOIN TEMP T2
    ON T1.MANAGER_ID = T2.EMPLOYEE_ID;
    
/*
 * TOP-N 분석 : 상위/하위 N 개에 해당하는 데이터를 조회할 수 있다.
 */
SELECT ROWNUM       
     , EMPLOYEE_ID
     , FIRST_NAME
     , LAST_NAME
     , SALARY
  FROM (SELECT EMPLOYEE_ID
             , FIRST_NAME
             , LAST_NAME
             , SALARY
          FROM EMPLOYEES
         ORDER BY SALARY DESC)
 WHERE ROWNUM <= 5;
--서브쿼리로 급여 기준으로 내림차순 정렬하여 EMPLOYEES 테이블 조회
--정렬된 Record Set 을 테이블로 사용하여 행번호 5까지(상위 5명)의 데이터를 조회

SELECT *
  FROM (SELECT EMPLOYEE_ID
             , FIRST_NAME
             , LAST_NAME
             , SALARY
             , RANK() OVER(ORDER BY SALARY DESC) AS 순위
         FROM EMPLOYEES);
--RANK OVER 기능은 동률에 대해서는 같은 순위를 가지게 한다. 다음 순위는 동률 갯수만큼 +

SELECT *
  FROM (SELECT EMPLOYEE_ID
             , FIRST_NAME
             , LAST_NAME
             , SALARY
             , DENSE_RANK() OVER(ORDER BY SALARY DESC) AS 순위
         FROM EMPLOYEES);
--동률에 대해 같은 순위를 부여하나 동률 갯수에 상관없이 다음 순위는 +1 이다.