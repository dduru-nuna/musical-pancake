/*
 * GROUP BY 절
 *    - 그룹 함수를 사용하여 그룹에 대한 집계를 나타낼 때 전체 그룹이 아닌
 *      특정 그룹에 대한 집계가 이루어 질 수 있도록 그룹을 묶어주는 역할 수행
 */
SELECT DEPARTMENT_ID
     , COUNT(*) AS 부서별총원
     , MAX(SALARY) AS 부서별최고급여액
     , MIN(SALARY) AS 부서별최저급여액
     , ROUND(AVG(SALARY), 2) AS 부서별평균급여액
  FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID;

SELECT JOB_ID
     , COUNT(*) AS 직무별총원
     , MAX(SALARY) AS 직무별최고급여액
     , MIN(SALARY) AS 직무별최저급여액
     , ROUND(AVG(SALARY), 2) AS 직무별평균급여액
  FROM EMPLOYEES
 GROUP BY JOB_ID;

SELECT DEPARTMENT_ID, JOB_ID
     , COUNT(*) AS "부서/직무별총원"
     , MAX(SALARY) AS "부서/직무별최고급여액"
     , MIN(SALARY) AS "부서/직무별최저급여액"
     , ROUND(AVG(SALARY), 2) AS "부서/직무별평균급여액"
  FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID, JOB_ID
 ORDER BY DEPARTMENT_ID;
 

SELECT DECODE(COMMISSION_PCT, NULL, '없다', '있다') AS 커미션유무
     , COUNT(*)
     , MAX(SALARY) AS 최고급여액
     , MIN(SALARY) AS 최저급여액
     , MAX(COMMISSION_PCT) AS 최고커미션퍼센트
     , MIN(COMMISSION_PCT) AS 최저커미션퍼센트
  FROM EMPLOYEES
 GROUP BY DECODE(COMMISSION_PCT, NULL, '없다', '있다');
 
/*
 * 부서별 커미션 유무와 커미션퍼센트 집계(MAX, MIN)
 */
SELECT DEPARTMENT_ID 부서
     , DECODE(COMMISSION_PCT, NULL, '없다', '있다') 커미션유무
     , MAX(NVL(COMMISSION_PCT,0)) 최고커미션퍼센트
     , MIN(NVL(COMMISSION_PCT,0)) 최저커미션퍼센트
  FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID, DECODE(COMMISSION_PCT, NULL, '없다', '있다');
 
/*
 * 년도별 입사자 수를 구하세요.
 *    - 년도는 1980년 부터 10년 단위로 묶어서 구할 수 있게 하세요. 
 */
SELECT FLOOR(EXTRACT(YEAR FROM HIRE_DATE)/10)*10 년도별
     , COUNT(*) 입사자수
  FROM EMPLOYEES
 GROUP BY FLOOR(EXTRACT(YEAR FROM HIRE_DATE)/10)*10;
 
/*
 * HAVING 절
 *    - 그룹에 대한 조건절로 사용한다.
 *    - WHERE 절에서 사용하는 조건은 GROUP BY 로 묶이기 전의 조건으로 사용
 */
SELECT DEPARTMENT_ID
     , COUNT(*) AS 부서별총원
     , MAX(SALARY) AS 부서별최고급여액
     , MIN(SALARY) AS 부서별최저급여액
     , ROUND(AVG(SALARY), 2) AS 부서별평균급여액
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IS NOT NULL 
 GROUP BY DEPARTMENT_ID
HAVING COUNT(*) <= 5
 ORDER BY 부서별총원;
 
SELECT JOB_ID
     , COUNT(*) AS 직무별총원
     , MAX(SALARY) AS 직무별최고급여액
     , MIN(SALARY) AS 직무별최저급여액
     , ROUND(AVG(SALARY), 2) AS 직무별평균급여액
  FROM EMPLOYEES
 GROUP BY JOB_ID
HAVING AVG(SALARY) >= 10000
 ORDER BY 직무별평균급여액 DESC;

/*
 * 문제
 */
SELECT DEPARTMENT_ID 부서ID
     , SUBSTR(PHONE_NUMBER,1,3) 전화번호앞3자리
     , COUNT(*) 갯수
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IS NOT NULL
 GROUP BY DEPARTMENT_ID, SUBSTR(PHONE_NUMBER,1,3)
HAVING COUNT(*) > 1
 ORDER BY 2,3,1;
--컬럼명이나 별칭 말고 컬럼위치만 써도 정렬가능. 위는 두번째컬럼(부서id)->세번째컬럼->첫번째컬럼 기준으로 정렬
 
