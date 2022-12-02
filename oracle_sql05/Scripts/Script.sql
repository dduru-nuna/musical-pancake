/*
 * 윈도우 - 설정 - 연결 - auto commit by default 해제
 * None : 자동커밋 아닌 상황
 */
SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = 100;

UPDATE EMPLOYEES
   SET MANAGER_ID = 100
 WHERE EMPLOYEE_ID = 100;
 
ROLLBACK; --자동 커밋 아니라 롤백 가능

COMMIT; --COMMIT 수동으로 써줘야 커밋. 커밋 이후에는 롤백 불가

--주의점
--같은 SESSION 에서는 COMMIT 안하고 봐도 변경 사항 잘 보임. 그러나 다른 세션으로 가면 바뀌어있지 않다.
--항상 COMMIT 확인 할 것.
--하나의 데이터베이스를 가지고 여러 사용자가 작업하다보면 LOCK 걸리는 경우 발생. 트랜젝션을 종료해줘야(정기적으로 커밋해야)
--UPDATE, DELETE, INSERT 작업 가능
