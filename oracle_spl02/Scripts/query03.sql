/*
 * DML : 데이터 조작어
 *       테이블에 데이터를 삽입(INSERT), 수정(UPDATE), 삭제(DELETE) 하기 위한 명령어를 제공한다.
 * 
 * INSERT
 *     INSERT INTO <테이블명> VALUES(값1, 값2, ...);
 *     참고 : VALUES 안에는 테이블에 정의한 컬럼의 순서와 수량, 타입에 맞는 값을 작성해야 한다.
 * 
 *     INSERT INTO <테이블명>(컬럼명1, 컬럼명2, ...) VALUES(값1, 값2, ...);
 *     참고 : 테이블명 옆 소괄호에 데이터를 추가할 컬럼명을 명시하고 VALUES 에는 소괄호에 명시한
 *           컬럼의 타입에 맞는 값을 순서대로 작성해야 한다.
 * 
 * UPDATE
 *     UPDATE <테이블명> SET 컬럼명 = 값;
 *     참고 : SET 절에 명시한 컬럼에 지정한 값으로 수정되며 별도의 WHERE 절이 없으면 모든
 *           Record 에 대한 수정이 이루어진다.
 * 
 *     UPDATE <테이블명> SET 컬럼명 = 값 WHERE 컬럼명 = 값;
 *     참고 : WHERE 절에 작성한 조건의 Record 만 수정한다.
 * 
 *     UPDATE <테이블명> SET 컬럼명1 = 값1, 컬럼명2 = 값2;
 *     참고 : SET 절에 ,(쉼표) 를 사용하여 여러 컬럼에 대한 수정을 할 수 있다.
 * 
 * DELETE
 *     DELETE FROM <테이블명>;
 *     참고 : 테이블의 모든 Record 를 삭제한다.
 * 
 *     DELETE FROM <테이블명> WHERE 컬럼명 = 값;
 *     참고 : WHRER 절에 작성한 조건의 Record 만 삭제한다.
 */
CREATE TABLE DEPTS
AS
SELECT * FROM DEPARTMENTS;

INSERT INTO DEPTS VALUES(11, 'Admin2', 201, 1700);
INSERT INTO DEPTS(DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID) 
           VALUES(12, 'Admin3', 202, 1700);
          
UPDATE DEPTS
   SET DEPARTMENT_NAME = '관리부';
  
UPDATE DEPTS
   SET DEPARTMENT_NAME = '마케팅부'
 WHERE DEPARTMENT_ID = 20;

UPDATE DEPTS
   SET DEPARTMENT_NAME = 'IT부'
     , MANAGER_ID = 106
 WHERE DEPARTMENT_ID = 60;

UPDATE DEPTS
   SET MANAGER_ID = MANAGER_ID + 1
 WHERE DEPARTMENT_ID = 20;

DELETE FROM DEPTS
 WHERE LOCATION_ID = 1700;

DELETE FROM DEPTS;

DROP TABLE DEPTS;

--수정/삭제 작업 하기 전에 미리 데이터 값 확인해보기! 실수를 줄이기 위해~
SELECT COUNT(*) FROM DEPTS WHERE LOCATION_ID = 1700;
SELECT * FROM DEPTS;


