CREATE TABLE VISIT_T(
    id NUMBER PRIMARY KEY
   ,nickname VARCHAR2(25 CHAR)
   ,context VARCHAR2(500 CHAR)
);

SELECT * FROM VISIT_T;

CREATE SEQUENCE VISIT_S;

SELECT VISIT_S.NEXTVAL FROM DUAL;

INSERT INTO VISIT_T VALUES('context', 'nickname');

DELETE FROM VISIT_T;
DROP TABLE VISIT_T;

DROP TABLE BOOKMARK_T;

/*사용자별 북마크 목록이 달라지게 변경*/
CREATE TABLE BOOKMARK_T(
	id NUMBER PRIMARY KEY
   ,userid VARCHAR2(20) REFERENCES USER_T(USERID)	
   ,url VARCHAR2(100 CHAR)
   ,name VARCHAR2(100 CHAR)	
);

SELECT * FROM BOOKMARK_T;

CREATE SEQUENCE BOOKMARK_S;

INSERT INTO BOOKMARK_T VALUES(1, 'abcd', 'https://naver.com', '네이버');
INSERT INTO BOOKMARK_T VALUES(2, 'https://google.com', '구글');
INSERT INTO BOOKMARK_T VALUES(3, 'https://nate.com', '네이트');

SELECT BOOKMARK_S.NEXTVAL FROM DUAL;

DELETE FROM BOOKMARK_T;

drop sequence VISIT_S;
drop sequence bookmark_s;

CREATE TABLE USER_T(
	USERID VARCHAR2(20) PRIMARY KEY
  , PASSWORD VARCHAR2(20) NOT NULL
  , EMAIL VARCHAR2(100)
);

SELECT * FROM USER_T;


SELECT * /*TOP N 분석으로 설정하고 다시 셀렉트해서 번호 찾기(정렬 해주기)*/
  FROM(SELECT ROWNUM AS NUM  
		    , id, nickname, context
		 FROM (SELECT *
		         FROM VISIT_T
		        ORDER BY ID)
  )
 WHERE NUM BETWEEN 16 AND 20;  /*TOP N 분석 하지않고 중간 번호부터 조회할 순 없음*/
 
 /*북마크용 TOPN 분석 */
SELECT *
  FROM(SELECT ROWNUM AS NUM
            , id, userid, url, name
         FROM (SELECT *
                 FROM BOOKMARK_T
                WHERE userId = 'aaaa'
                ORDER BY ID)
  )
 WHERE NUM BETWEEN 4 AND 6;
 
SELECT COUNT(*) FROM BOOKMARK_T WHERE USERID = 'aaaa';