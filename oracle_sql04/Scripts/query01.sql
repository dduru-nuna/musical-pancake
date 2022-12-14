/*
 * JOIN
 *    - 하나 이상의 테이블에서 데이터를 조회하기 위해 사용하는 구문
 *    - UNION, UNION ALL 등과 같은 집합 연산과는 다르게 열에 대한 결합으로 결과가 나온다.
 *    - JOIN 을 사용할 때 공통 열 값에 대한 결합을 기본 조건으로 수행한다.
 */
SELECT EMP.EMPLOYEE_ID
     , EMP.FIRST_NAME
     , EMP.LAST_NAME
     , EMP.DEPARTMENT_ID
     , DEPT.DEPARTMENT_ID
     , DEPT.DEPARTMENT_NAME
  FROM EMPLOYEES EMP
  JOIN DEPARTMENTS DEPT
    ON EMP.DEPARTMENT_ID = DEPT.DEPARTMENT_ID
      --열 이름이 같으면 . 으로 테이블 명(별칭으로 간단하게 가능)으로 식별해 준다
 WHERE EMP.DEPARTMENT_ID IN (10, 20, 30, 40, 50, 60, 70, 80)
 ORDER BY EMP.DEPARTMENT_ID;

SELECT *
  FROM EMPLOYEES EMP
  JOIN DEPARTMENTS DEPT
    ON EMP.DEPARTMENT_ID = DEPT.DEPARTMENT_ID;
--ON / USING 결과 비교
SELECT *
  FROM EMPLOYEES EMP
  JOIN DEPARTMENTS DEPT
 USING (DEPARTMENT_ID);
--USING 을 사용하면 공통 열이 앞으로 따로 빠지고 결합된 형태가 나옴. 식별자 필요X
--결합하고자 하는 컬럼명이 다르면 USING 사용 불가

/*
 * ORACLE 전용 JOIN 구문
 */
--JOIN ON 이 표준구문이기 때문에 이건 내용 확인만 하고 쓰지는 말기
SELECT *
  FROM EMPLOYEES E, DEPARTMENTS D
 WHERE E.DEPARTMENT_ID  = D.DEPARTMENT_ID;

/*
 * INNER JOIN 
 *    - JOIN 구문의 가장 기본이 되는 JOIN으로 JOIN 구문만 사용했을 때 INNER JOIN 이다.
 *    - JOIN 결합 조건에 해당하는 행에 대해서만 결합을 수행하고 결합 조건에 해당하지 않는
 *      경우 결합을 하지 않는다.
 */
 SELECT EMP.EMPLOYEE_ID
     , EMP.FIRST_NAME
     , EMP.LAST_NAME
     , EMP.DEPARTMENT_ID
     , DEPT.DEPARTMENT_ID
     , DEPT.DEPARTMENT_NAME
  FROM EMPLOYEES EMP
  JOIN DEPARTMENTS DEPT
    ON EMP.DEPARTMENT_ID = DEPT.DEPARTMENT_ID
 WHERE EMP.DEPARTMENT_ID = 178 /* 부서가 없는 사원은 결합이 안되어 있다 */
 ORDER BY EMP.DEPARTMENT_ID;

/* 
 * OUTER JOIN : INNER JOIN 과 다르게 결합 조건에 해당하지 않는 경우에도 Record Set 에 포함된다.
 *              결합조건에 해당하지 않는 경우가 왼쪽 테이블이냐 오른쪽 테이블이냐 양쪽에 있냐에 따라 나뉨
 *              오른쪽 테이블 기준으로 JOIN 할껀지, 왼쪽 테이블 기준으로 JOIN 할껀지..
 *    - LEFT OUTER JOIN
 *    - RIGHT OUTER JOIN
 *    - FULL OUTER JOIN 
 */
SELECT EMP.EMPLOYEE_ID
     , EMP.FIRST_NAME
     , EMP.LAST_NAME
     , EMP.DEPARTMENT_ID
     , DEPT.DEPARTMENT_ID
     , DEPT.DEPARTMENT_NAME
  FROM EMPLOYEES EMP
  LEFT OUTER JOIN DEPARTMENTS DEPT
    ON EMP.DEPARTMENT_ID = DEPT.DEPARTMENT_ID
 WHERE EMP.DEPARTMENT_ID = 178;

SELECT EMP.EMPLOYEE_ID
     , EMP.FIRST_NAME
     , EMP.LAST_NAME
     , EMP.DEPARTMENT_ID
     , DEPT.DEPARTMENT_ID
     , DEPT.DEPARTMENT_NAME
  FROM EMPLOYEES EMP
  RIGHT OUTER JOIN DEPARTMENTS DEPT
    ON EMP.DEPARTMENT_ID = DEPT.DEPARTMENT_ID;
   
SELECT EMP.EMPLOYEE_ID
     , EMP.FIRST_NAME
     , EMP.LAST_NAME
     , EMP.DEPARTMENT_ID
     , DEPT.DEPARTMENT_ID
     , DEPT.DEPARTMENT_NAME
  FROM EMPLOYEES EMP
  FULL OUTER JOIN DEPARTMENTS DEPT
    ON EMP.DEPARTMENT_ID = DEPT.DEPARTMENT_ID;   

/*
 * CROSS JOIN
 *    - 카테시안 곱(Cartesian Product) 이라고 한다.
 *    - 결합 조건 없이 모든 행이 결합되어 조회되는 형태
 *    - A 테이블의 행이 5개, B 테이블의 행이 3개면 A CROSS JOIN B -> 15개 행
 */ 
SELECT *
  FROM DEPARTMENTS D
 CROSS JOIN JOBS J;

/*
 * NON_EQU JOIN : 지정한 컬럼의 값이 일치하는 경우가 아닌 값의 범위에 포함되는 행들을
 *                연결하기 위한 JOIN 문
 */
SELECT *
  FROM EMPLOYEES E
  JOIN JOBS J
    ON E.JOB_ID = J.JOB_ID 
   AND E.SALARY BETWEEN J.MIN_SALARY AND J.MAX_SALARY;
/* 
 * SELF JOIN : 하나의 테이블을 사용하여 JOIN 을 하는 것
 */
SELECT E1.EMPLOYEE_ID
     , E1.FIRST_NAME
     , E1.LAST_NAME
     , E1.MANAGER_ID
     , E2.FIRST_NAME
     , E2.LAST_NAME
  FROM EMPLOYEES E1
  JOIN EMPLOYEES E2
    ON E1.MANAGER_ID = E2.MANAGER_ID; 
--사수(MANAGER_ID) 도 EMPLOYEE 테이블에 속해있음. 셀프 조인으로 결합 가능
   
   
--JOIN 은 여러번 사용 가능
SELECT *
  FROM EMPLOYEES E
  JOIN DEPARTMENTS D
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID 
  JOIN JOBS J
    ON E.JOB_ID  = J.JOB_ID;
