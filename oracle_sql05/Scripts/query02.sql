/*
 * VIEW 객체
 *    - SELECT 문의 실행 결과를 저장한 가상 테이블
 *    - 테이블과 다르게 실제 데이터를 저장하고 있지는 않으나 실제 테이블을
 *      사용하는 것과 동일하게 사용 가능
 *    - 복잡한 SELECT 구문을 VIEW 로 만들어 간단하게 사용하기 위해 사용 *이게 주된 용도
 */
CREATE OR REPLACE VIEW V_EMP  --REPLACE : 수정, V_EMP 란 객체가 없으면 CREATE 하고 있으면 수정해라
AS
SELECT EMPLOYEE_ID AS EMP_ID
     , FIRST_NAME || ' ' || LAST_NAME AS EMP_NAME
     , EMAIL || '@emp.co.kr' AS EMAIL
     , SALARY
     , MANAGER_ID
     , DEPARTMENT_ID
  FROM EMPLOYEES
/* WHERE MANAGER_ID BETWEEN 200 AND 220
   WITH CHECK OPTION;  --WHERE 절에 해당하는 범위인지 확인해서 제한 걸기 */
  /*WITH READ ONLY;  --VIEW 를 읽기 전용으로만 쓰겠다*/

--VIEW 를 먼저 만들고 테이블을 만들 때는 FORCE 라는 옵션도 쓸 수 있긴함. 쓸 일 별로 없음.

 SELECT * FROM V_EMP;

/*
 * VIEW 를 사용하여 INSERT, UPDATE, DELETE 작업을 할 수 있지만 다음의 경우에는
 * 사용할 수 없다. (READ ONLY 인 경우도 당연히 안됨)
 *    1. VIEW 에 포함되지 않은 컬럼을 사용하는 경우
 *    2. VIEW 에 포함되지 않은 컬럼 중 NOT NULL 제약조건이 있는 경우
 *    3. 산술 표현식으로 정의된 경우
 *    4. 그룹함수나 GROUP BY 절이 포함된 경우
 *    5. DISTINCT 키워드가 있는 경우
 *    6. JOIN 을 사용하여 여러 테이블이 결합된 경우
 */
UPDATE V_EMP
   SET MANAGER_ID = 190
 WHERE DEPARTMENT_ID = 280;
 
SELECT * FROM EMPLOYEES;