/*
 * EMPLOYEES 의 HIRE_DATE 열의 값을 +10 년 하여 수정한다.
 */
/*내풀이
UPDATE EMPLOYEES 
   SET HIRE_DATE = HIRE_DATE + INTERVAL '10' YEAR;
SELECT * FROM EMPLOYEES; */
UPDATE EMPLOYEES
   SET HIRE_DATE = ADD_MONTHS(HIRE_DATE, 120);
/*
 * LOCATIONS 테이블에 학원 주소 정보를 추가하세요.
 */
/*내풀이
INSERT INTO LOCATIONS (LOCATION_ID, STREET_ADDRESS, CITY) 
       VALUES (3300, '테헤란로 14길6', '서울특별시');
SELECT * FROM LOCATIONS;
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'LOCATIONS';
SELECT * FROM USER_CONS_COLUMNS WHERE TALBE_NAME = 'LOCATIONS';*/
INSERT INTO COUNTRIES VALUES('KR', 'Korea', 3);
INSERT INTO LOCATIONS VALUES(
       (SELECT MAX(LOCATION_ID) + 100 FROM LOCATIONS)
     , '테헤란로14길 6'
     , '06234'
     , '강남구'
     , '서울시'
     , 'KR'  --> COUNTRIES TABLE 참조. 따라서 부모 테이블 COUNTRIES 에 데이터 추가해놔야 오류 없음 
     );
SELECT * FROM LOCATIONS L 
  JOIN COUNTRIES C ON L.COUNTRY_ID = C.COUNTRY_ID
 WHERE L.COUNTRY_ID = 'KR';  --데이터 추가 확인용 SELECT 구문
/*
 * DEPARTMENTS의 IT 부서에 대한 LOCATION_ID 를 학원 주소로 수정하세요.
 */
UPDATE DEPARTMENTS
   SET LOCATION_ID = 3300
 WHERE DEPARTMENT_NAME = 'IT';

SELECT * FROM DEPARTMENTS;
/*
 * EMPLOYEES 에서 COMMISSION_PCT 가 NULL 인 경우 0으로 수정하세요.
 */
UPDATE EMPLOYEES
   SET COMMISSION_PCT = 0
 WHERE COMMISSION_PCT IS NULL;

SELECT * FROM EMPLOYEES;
/*
 * EMPLOYEES 에서 MANAGER_ID 가 NULL 인 사원은 DEPARTMENTS 테이블의 MANAGER_ID 로
 * 수정하세요. 
 */
SELECT * FROM EMPLOYEES WHERE MANAGER_ID IS NULL;
UPDATE EMPLOYEES E
   SET E.MANAGER_ID = (SELECT D.MANAGER_ID 
                         FROM DEPARTMENTS D 
                        WHERE D.DEPARTMENT_ID = E.DEPARTMENT_ID)
 WHERE E.MANAGER_ID IS NULL;

SELECT * FROM EMPLOYEES;
/*
 * EMPLOYEES 에서 DEPARTMENT_ID 가 NULL 인 사원은 MANAGER_ID 의 값을 활용하여 해당 MANAGER_ID 와
 * 동일한 DEPARTMENT_ID 값을 가지도록 수정하세요.
 * (MANAGER_ID 는 EMPLOYEE_ID 와 외래키 관계입니다.)
 */
UPDATE EMPLOYEES E1
   SET DEPARTMENT_ID = (SELECT DEPARTMENT_ID
                          FROM EMPLOYEES E2
                         WHERE EMPLOYEE_ID = E1.MANAGER_ID)
 WHERE DEPARTMENT_ID IS NULL;

SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID IS NULL;
SELECT * FROM EMPLOYEES;
/*
 * DEPARTMENTS 에서 MANAGER_ID 가 NULL 인 데이터는 삭제하세요.
 */
DELETE FROM DEPARTMENTS WHERE MANAGER_ID IS NULL;
SELECT * FROM DEPARTMENTS;
/*
 * JOBS 테이블과 동일한 구조의 KJOBS 테이블을 만들고 JOB_TITLE 열의 값을
 * 한글로 번역하여 수정한다.
 * 단, MIN_SALARY, MAX_SALARY 컬럼은 만들 필요 없음.
 */
CREATE TABLE KJOBS(
       JOB_ID VARCHAR2(10) PRIMARY KEY
      ,JOB_TITLE VARCHAR2(35) 
);
INSERT INTO KJOBS(SELECT JOB_ID, JOB_TITLE FROM JOBS);
SELECT * FROM KJOBS;
UPDATE KJOBS SET JOB_TITLE = '회장' WHERE JOB_TITLE = 'President';
UPDATE KJOBS SET JOB_TITLE = '행정부 부총재' WHERE JOB_TITLE = 'Administration Vice President';
UPDATE KJOBS SET JOB_TITLE = '관리 관리자' WHERE JOB_TITLE = 'Administration Assistant';
UPDATE KJOBS SET JOB_TITLE = '재무 관리자' WHERE JOB_TITLE = 'Finance Manager';
UPDATE KJOBS SET JOB_TITLE = '회계사' WHERE JOB_TITLE = 'Accountant';
UPDATE KJOBS SET JOB_TITLE = '회계 관리자' WHERE JOB_TITLE = 'Accounting Manager';
UPDATE KJOBS SET JOB_TITLE = '공인회계사' WHERE JOB_TITLE = 'Public Accountant';
UPDATE KJOBS SET JOB_TITLE = '판매 관리자' WHERE JOB_TITLE = 'Sales Manager';
UPDATE KJOBS SET JOB_TITLE = '판매 담당자' WHERE JOB_TITLE = 'Sales Representative';
UPDATE KJOBS SET JOB_TITLE = '구매 관리자' WHERE JOB_TITLE = 'Purchasing Manager';
UPDATE KJOBS SET JOB_TITLE = '구매 담당자' WHERE JOB_TITLE = 'Purchasing Clerk';
UPDATE KJOBS SET JOB_TITLE = '재고 관리자' WHERE JOB_TITLE = 'Stock Manager';
UPDATE KJOBS SET JOB_TITLE = '재고 담당자' WHERE JOB_TITLE = 'Stock Clerk';
UPDATE KJOBS SET JOB_TITLE = '배송 담당자' WHERE JOB_TITLE = 'Shipping Clerk';
UPDATE KJOBS SET JOB_TITLE = '프로그래머' WHERE JOB_TITLE = 'Programmer';
UPDATE KJOBS SET JOB_TITLE = '마케팅 관리자' WHERE JOB_TITLE = 'Marketing Manager';
UPDATE KJOBS SET JOB_TITLE = '마케팅 담당자' WHERE JOB_TITLE = 'Marketing Representative';
UPDATE KJOBS SET JOB_TITLE = '인사 담당자' WHERE JOB_TITLE = 'Human Resources Representative';
UPDATE KJOBS SET JOB_TITLE = '홍보 담당자' WHERE JOB_TITLE = 'Public Relations Representative';
/*
 * DEPARTMENTS 테이블에 DEPARMENT_NAME_KR 컬럼을 추가 후 DEPARTMENT_NAME 을
 * 한글로 변역한 데이터가 수정되게 한다.
 */
SELECT * FROM DEPARTMENTS;
ALTER TABLE DEPARTMENTS ADD DEPARTMENT_NAME_KR VARCHAR2(20);
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '관리부' WHERE DEPARTMENT_ID = 10;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '마케팅' WHERE DEPARTMENT_ID = 20;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '구매팀' WHERE DEPARTMENT_ID = 30;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '인사팀' WHERE DEPARTMENT_ID = 40;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '배송팀' WHERE DEPARTMENT_ID = 50;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '아이티' WHERE DEPARTMENT_ID = 60;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '홍보팀' WHERE DEPARTMENT_ID = 70;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '판매팀' WHERE DEPARTMENT_ID = 80;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '경영팀' WHERE DEPARTMENT_ID = 90;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '자금팀' WHERE DEPARTMENT_ID = 100;
UPDATE DEPARTMENTS SET DEPARTMENT_NAME_KR = '회계팀' WHERE DEPARTMENT_ID = 110;
/*
 * KJOBS 테이블에 한글로 번역한 직무 타이틀을 JOBS 테이블에 JOB_TITLE_KR 컬럼을
 * 추가후 수정이 되도록 한다.(DEPARTMENTS 테이블 처럼 하나의 테이블에 영문/한글이
 * 모두 들어가게 한다.) 모든 작업을 완료 후 KJOBS 테이블은 제거 한다.
 */
ALTER TABLE JOBS ADD JOB_TITLE_KR VARCHAR2(20);
ALTER TABLE JOBS MODIFY JOB_TITLE_KR VARCHAR2(35);
UPDATE JOBS 
   SET JOB_TITLE_KR = (SELECT JOB_TITLE FROM KJOBS WHERE JOB_ID = JOBS.JOB_ID);
SELECT * FROM JOBS;
DROP TABLE KJOBS;
/*
 * JOBS 테이블에 다음의 데이터를 추가 한다.(JOB_TITLE_KR 도 추가되어 있어야 함)
 *     JOB_ID    JOB_TITLE           MIN_SALARY    MAX_SALARY
 *     IT_ITRN   Intern Programmer   3200          3800
 *     SV_MGR    Server Manager      4000          10000
 *     SV_ENG    Server Engineer     6000          12000
 *     NT_MGR    Network Manager     5000          11000
 *     NT_ENG    Network Engineer    7000          13000
 */
INSERT INTO JOBS VALUES('IT_ITRN', 'Intern Programmer', 3200, 3800, '인턴 프로그래머');
INSERT INTO JOBS VALUES('SV_MGR', 'Server Manager', 4000, 10000, '서버 담당자');
INSERT INTO JOBS VALUES('SV_ENG', 'Server Engineer', 6000, 12000, '서버 엔지니어');
INSERT INTO JOBS VALUES('NT_MGR', 'Network Manager', 5000, 11000, '네트워크 담당자');
INSERT INTO JOBS VALUES('NT_ENG', 'Network Engineer', 7000, 13000, '네트워크 엔지니어');
SELECT * FROM JOBS;
/*
 * DEPARTMENTS 테이블에 다음의 데이터를 추가 한다.(DEPARTMENT_NAME_KR 도 추가되어 있어야 함)
 *     DEPARTMENT_ID    DEPARTMENT_NAME    MANAGER_ID    LOCATION_ID
 *     280              Server             NULL          (학원주소에 해당하는 ID)
 *     290              Network            NULL          (학원주소에 해당하는 ID)
 */
INSERT INTO DEPARTMENTS VALUES(280, 'Server', NULL, (SELECT LOCATION_ID FROM LOCATIONS WHERE STREET_ADDRESS = '테헤란로14길 6'), '서버팀');
INSERT INTO DEPARTMENTS VALUES(290, 'Network', NULL, (SELECT LOCATION_ID FROM LOCATIONS WHERE STREET_ADDRESS = '테헤란로14길 6'), '네트워크팀');
SELECT * FROM DEPARTMENTS;   

/*
 * 새로 신설된 Server, Network 부서를 위한 인력을 충원하고 있는 것으로 가정하여 각 부서마다
 * 3명의 인원을 EMPLOYEES 에 추가한다.(Manager 직무 1명, Engineer 직무 2명)
 *     - 초기에 모든 인원은 JOBS 테이블의 MIN_SALARY 의 급여를 받는 것으로 한다.
 *     - Server, Network 부서에 인원을 추가 할 때 반드시 1명의 부서장이 필요하기 때문에 인원 중 1명을
 *       부서장으로 만든다.(DEPARTMENTS 테이블의 MANAGER_ID 를 설정한다.)
 *     - 부서장으로 선택된 인원은 JOBS 테이블의 MIN_SALARY 급여에서 +2000 상승된 급여로 받을 수 있게
 *       데이터를 수정한다.
 */
INSERT INTO EMPLOYEES(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, HIRE_DATE, SALARY, JOB_ID, DEPARTMENT_ID)
               VALUES((SELECT MAX(EMPLOYEE_ID) + 1 FROM EMPLOYEES)
                    , '철수', '김', 'KCHUL', SYSDATE
                    , (SELECT MIN_SALARY FROM JOBS WHERE JOB_ID = 'SV_MGR')
                    , 'SV_MGR', 280);
INSERT INTO EMPLOYEES(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, HIRE_DATE, SALARY, JOB_ID, DEPARTMENT_ID)
               VALUES((SELECT MAX(EMPLOYEE_ID) + 1 FROM EMPLOYEES)
                    , '영수', '박', 'PYOUNG', SYSDATE
                    , (SELECT MIN_SALARY FROM JOBS WHERE JOB_ID = 'SV_ENG')
                    , 'SV_ENG', 280);
INSERT INTO EMPLOYEES(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, HIRE_DATE, SALARY, JOB_ID, DEPARTMENT_ID)
               VALUES((SELECT MAX(EMPLOYEE_ID) + 1 FROM EMPLOYEES)
                    , '강석', '이', 'LKANG', SYSDATE
                    , (SELECT MIN_SALARY FROM JOBS WHERE JOB_ID = 'SV_ENG')
                    , 'SV_ENG', 280);


INSERT INTO EMPLOYEES(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, HIRE_DATE, SALARY, JOB_ID, DEPARTMENT_ID)
               VALUES((SELECT MAX(EMPLOYEE_ID) + 1 FROM EMPLOYEES)
                    , '주식', '강', 'KJU', SYSDATE
                    , (SELECT MIN_SALARY FROM JOBS WHERE JOB_ID = 'NT_MGR')
                    , 'NT_MGR', 290);
INSERT INTO EMPLOYEES(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, HIRE_DATE, SALARY, JOB_ID, DEPARTMENT_ID)
               VALUES((SELECT MAX(EMPLOYEE_ID) + 1 FROM EMPLOYEES)
                    , '장원', '서', 'SJANG', SYSDATE
                    , (SELECT MIN_SALARY FROM JOBS WHERE JOB_ID = 'NT_ENG')
                    , 'NT_ENG', 290);
INSERT INTO EMPLOYEES(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, HIRE_DATE, SALARY, JOB_ID, DEPARTMENT_ID)
               VALUES((SELECT MAX(EMPLOYEE_ID) + 1 FROM EMPLOYEES)
                    , '지원', '임', 'IJI', SYSDATE
                    , (SELECT MIN_SALARY FROM JOBS WHERE JOB_ID = 'NT_ENG')
                    , 'NT_ENG', 290);


UPDATE DEPARTMENTS
   SET MANAGER_ID = (SELECT EMPLOYEE_ID
                       FROM EMPLOYEES
                      WHERE DEPARTMENT_ID = 120
                        AND FIRST_NAME = '철수'
                        AND LAST_NAME = '김')
 WHERE DEPARTMENT_ID = 120;

UPDATE DEPARTMENTS
   SET MANAGER_ID = (SELECT EMPLOYEE_ID
                       FROM EMPLOYEES
                      WHERE DEPARTMENT_ID = 130
                        AND FIRST_NAME = '주식'
                        AND LAST_NAME = '강')
 WHERE DEPARTMENT_ID = 130;


UPDATE EMPLOYEES
   SET SALARY = SALARY + 2000
 WHERE EMPLOYEE_ID IN (SELECT MANAGER_ID
                         FROM DEPARTMENTS
                        WHERE DEPARTMENT_ID IN (120, 130));

SELECT * FROM EMPLOYEES;
SELECT * FROM DEPARTMENTS;
/*
 * 모든 급여 정보를 수정하려고 한다.
 * JOBS 테이블과 EMPLOYEES 테이블의 모든 급여 정보를 기존보다 5% ~ 10% 상승 시키도록 한다.
 *     - 급여가 4000 미만인 경우 10% 상승
 *     - 급여가 4000 이상 8000 미만인 경우 8% 상승
 *     - 급여가 8000 이상 12000 미만인 경우 6% 상승
 *     - 급여가 12000 이상인 경우 5% 상승
 *     - 정수 1번째 자리에서 절삭할 것. 예) 4333.333 은 4330 으로 절삭.
 */
SELECT SALARY FROM EMPLOYEES;

UPDATE JOBS
   SET (MIN_SALARY, MAX_SALARY) = (SELECT CASE WHEN MIN_SALARY < 4000 THEN TRUNC(MIN_SALARY * 1.1, -1)
                    			   			   WHEN MIN_SALARY < 8000 THEN TRUNC(MIN_SALARY * 1.08, -1) 
                  			      		       WHEN MIN_SALARY < 12000 THEN TRUNC(MIN_SALARY * 1.06, -1)
                 			     		       ELSE TRUNC(MIN_SALARY * 1.05, -1)
                 		    		      END AS MIN_SALARY
                				       , CASE WHEN MAX_SALARY < 4000 THEN TRUNC(MAX_SALARY * 1.1, -1)
                    			  			  WHEN MAX_SALARY < 8000 THEN TRUNC(MAX_SALARY * 1.08, -1) 
                  			     		      WHEN MAX_SALARY < 12000 THEN TRUNC(MAX_SALARY * 1.06, -1)
                 			     			  ELSE TRUNC(MAX_SALARY * 1.05, -1)
                					      END AS MAX_SALARY
                				    FROM JOBS J
                				   WHERE J.JOB_ID = JOBS.JOB_ID);

UPDATE EMPLOYEES
   SET SALARY = (SELECT CASE WHEN SALARY < 4000 THEN TRUNC(SALARY * 1.1, -1)
                             WHEN SALARY < 8000 THEN TRUNC(SALARY * 1.08, -1) 
                  			 WHEN SALARY < 12000 THEN TRUNC(SALARY * 1.06, -1)
                 		     ELSE TRUNC(SALARY * 1.05, -1)
                 		 END AS SALARY
                   FROM EMPLOYEES E
                  WHERE E.EMPLOYEE_ID = EMPLOYEES.EMPLOYEE_ID);

SELECT * FROM EMPLOYEES;
SELECT * FROM JOBS;

/*
 * 사내 공지를 위한 게시판 기능을 추가하려 한다. 다음의 요구사항에 맞추어 테이블을 생성하고
 * 첫번째 공지를 작성하도록 한다.(첫번째 공지는 모든 부서가 열람할 수 있게 한다.)
 *     - 공지 게시판은 부서별 공지와 전체 공지로 나누어져 운영돼야 한다.
 *     - 전체 공지는 모든 부서가 확인할 수 있는 공지이며 부서별 공지는 지정한 부서에 소속된
 *       사원만 볼수 있는 공지이다.
 *     - 공지를 작성할 때 다음의 정보가 저장되어야 한다.
 *         번호, 제목, 내용, 작성일자, 부서ID
 */
CREATE TABLE NOTICE(
       ID NUMBER PRIMARY KEY
      ,TITLE VARCHAR2(150) NOT NULL
      ,CONTENT VARCHAR2(2000)
      ,WRITE_DATE DATE
      ,DEPT_ID NUMBER NOT NULL
);
INSERT INTO NOTICE VALUES(1, '전체 공지', '전체 부서를 위한 공지사항 입니다.', SYSDATE, 0);

/*
 * 사내 공지 게시판 테이블을 생성 후에 다음의 공지를 추가로 작성한다.
 *     - 모든 부서마다 'xxx 부서만 확인할 수 있는 공지 입니다.' 라는 메시지를 추가한다.
 */
INSERT INTO NOTICE(
    SELECT (SELECT MAX(ID) FROM NOTICE) + ROWNUM
         , DEPARTMENT_NAME_KR || '용 공지사항 2'
         , DEPARTMENT_NAME_KR || '용 공지사항 입니다. ' || DEPARTMENT_NAME_KR || '만 확인할 수 있습니다.'
         , SYSDATE
         , DEPARTMENT_ID
      FROM DEPARTMENTS
);
SELECT * FROM NOTICE;
/*
 * 100 번 사원이 공지를 열람한다는 가정하에 100 번 사원이 소속된 부서의 공지와 전체 공지가
 * 보일수 있는 SELECT 쿼리문을 작성하세요.
 */
INSERT INTO NOTICE VALUES((SELECT MAX(ID) + 1 FROM NOTICE), '전체 공지 2', '전체 부서를 위한 공지사항 입니다.', SYSDATE, 0);
SELECT N.ID
     , N.TITLE
     , N.CONTENT
     , N.WRITE_DATE
     , N.DEPT_ID
     , NVL((SELECT DEPARTMENT_NAME_KR FROM DEPARTMENTS D WHERE D.DEPARTMENT_ID = N.DEPT_ID), '전체') AS DEPT_NAME
   FROM NOTICE N
  LEFT OUTER JOIN EMPLOYEES E   --그냥 JOIN 하면 NOTICE 의 0번 (전체공지)는 빠지기 때문에 LEFT OUTER JOIN 으로 써준다
    ON N.DEPT_ID = E.DEPARTMENT_ID
 WHERE E.EMPLOYEE_ID = 100
    OR N.DEPT_ID = 0;
/*
 * 공지 게시판에 중요도 기능을 추가하여 가장 중요한 공지가 가장 먼저 조회될 수 있도록 테이블을
 * 수정하도록 한다.
 *     - 중요도는 1 ~ 5 까지 사용할 수 있게 한다.
 *     - 중요도를 설정하지 않으면 기본 3으로 저장되게 한다.
 *     - 전체 공지용으로 중요도 1 ~ 5 까지 총 5개의 공지 데이터를 추가한다.
 *     - 추가한 공지 데이터를 조회할 때 중요도 순으로 조회가 될 수 있도록
 *       SELECT 구문을 작성한다.
 */
ALTER TABLE NOTICE ADD IMPORTANCE NUMBER DEFAULT(3);
ALTER TABLE NOTICE ADD CONSTRAINTS NOTICE_IMPORTANCE_CK CHECK(IMPORTANCE BETWEEN 1 AND 5);

INSERT INTO NOTICE VALUES((SELECT MAX(ID) + 1 FROM NOTICE), '전체 공지 3', '전체 부서를 위한 공지사항 입니다.', SYSDATE, 0, 1);
INSERT INTO NOTICE VALUES((SELECT MAX(ID) + 1 FROM NOTICE), '전체 공지 4', '전체 부서를 위한 공지사항 입니다.', SYSDATE, 0, 2);
INSERT INTO NOTICE VALUES((SELECT MAX(ID) + 1 FROM NOTICE), '전체 공지 5', '전체 부서를 위한 공지사항 입니다.', SYSDATE, 0, 3);

UPDATE NOTICE
   SET IMPORTANCE = 1
 WHERE DEPT_ID = 0;

SELECT * FROM NOTICE;
   