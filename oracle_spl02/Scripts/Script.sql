SELECT * FROM JOBS;



--이름 : john
SELECT *
  FROM EMPLOYEES
 WHERE LOWER(FIRST_NAME) LIKE LOWER('%john%')
    OR LOWER(LAST_NAME) LIKE LOWER('%john%');
      --Oracle Function      --Oracle Function or java String method 선택