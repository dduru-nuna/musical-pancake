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


/**
 * 공지사항이 있는 게시판
 * btype 이 N 인 경우 공지사항 입니다.
 * btype 이 B 인 경우 일반 게시글 입니다.
*/
CREATE TABLE BOARD_T(
	id NUMBER PRIMARY KEY
  , btype VARCHAR2(1) CHECK(btype IN ('N', 'B'))
  , title VARCHAR2(500) NOT NULL
  , writer VARCHAR2(20) REFERENCES USER_T(userId)
  , context VARCHAR2(4000)
  , createDate DATE DEFAULT(SYSDATE)
  , updateDate DATE DEFAULT(SYSDATE)
  , viewCnt NUMBER DEFAULT(0)
);
CREATE SEQUENCE BOARD_S;

INSERT INTO BOARD_T VALUES(BOARD_S.NEXTVAL, 'B', '일반 게시글 테스트 1', 'aaaa', '게시글 테스트 중입니다. 1'
                           , DEFAULT, DEFAULT, DEFAULT);
INSERT INTO BOARD_T VALUES(BOARD_S.NEXTVAL, 'B', '일반 게시글 테스트 2', 'aaaa', '게시글 테스트 중입니다. 2'
                           , DEFAULT, DEFAULT, DEFAULT);
INSERT INTO BOARD_T VALUES(BOARD_S.NEXTVAL, 'B', '일반 게시글 테스트 3', 'aaaa', '게시글 테스트 중입니다. 3'
                           , DEFAULT, DEFAULT, DEFAULT);
INSERT INTO BOARD_T VALUES(BOARD_S.NEXTVAL, 'B', '일반 게시글 테스트 4', 'aaaa', '게시글 테스트 중입니다. 4'
                           , DEFAULT, DEFAULT, DEFAULT);
INSERT INTO BOARD_T VALUES(BOARD_S.NEXTVAL, 'N', '공지글 테스트 1', 'aaaa', '공지글 테스트 중입니다. 1'
                           , DEFAULT, DEFAULT, DEFAULT);
INSERT INTO BOARD_T VALUES(BOARD_S.NEXTVAL, 'N', '공지글 테스트 2', 'aaaa', '공지글 테스트 중입니다. 2'
                           , DEFAULT, DEFAULT, DEFAULT);
INSERT INTO BOARD_T VALUES(BOARD_S.NEXTVAL, 'N', '공지글 테스트 3', 'aaaa', '공지글 테스트 중입니다. 3'
                           , DEFAULT, DEFAULT, DEFAULT);
INSERT INTO BOARD_T VALUES(BOARD_S.NEXTVAL, 'B', '일반 게시글 테스트 5', 'aaaa', '게시글 테스트 중입니다. 5'
                           , DEFAULT, DEFAULT, DEFAULT);
INSERT INTO BOARD_T VALUES(BOARD_S.NEXTVAL, 'B', '일반 게시글 테스트 6', 'aaaa', '게시글 테스트 중입니다. 6'
                           , DEFAULT, DEFAULT, DEFAULT);
INSERT INTO BOARD_T VALUES(BOARD_S.NEXTVAL, 'B', '일반 게시글 테스트 7', 'aaaa', '게시글 테스트 중입니다. 7'
                           , DEFAULT, DEFAULT, DEFAULT);
INSERT INTO BOARD_T VALUES(BOARD_S.NEXTVAL, 'N', '공지글 테스트 4', 'aaaa', '공지글 테스트 중입니다. 4'
                           , DEFAULT, DEFAULT, DEFAULT);      
INSERT INTO BOARD_T VALUES(BOARD_S.NEXTVAL, 'N', '공지글 테스트 5', 'aaaa', '공지글 테스트 중입니다. 5'
                           , DEFAULT, DEFAULT, DEFAULT);
INSERT INTO BOARD_T VALUES(BOARD_S.NEXTVAL, 'B', '일반 게시글 테스트 8', 'aaaa', '게시글 테스트 중입니다. 8'
                           , DEFAULT, DEFAULT, DEFAULT);
INSERT INTO BOARD_T VALUES(BOARD_S.NEXTVAL, 'B', '일반 게시글 테스트 9', 'aaaa', '게시글 테스트 중입니다. 9'
                           , DEFAULT, DEFAULT, DEFAULT);
INSERT INTO BOARD_T VALUES(BOARD_S.NEXTVAL, 'B', '일반 게시글 테스트 10', 'aaaa', '게시글 테스트 중입니다. 10'
                           , DEFAULT, DEFAULT, DEFAULT);
INSERT INTO BOARD_T VALUES(BOARD_S.NEXTVAL, 'B', '일반 게시글 테스트 11', 'aaaa', '게시글 테스트 중입니다. 11'
                           , DEFAULT, DEFAULT, DEFAULT);
INSERT INTO BOARD_T VALUES(BOARD_S.NEXTVAL, 'B', '일반 게시글 테스트 12', 'aaaa', '게시글 테스트 중입니다. 12'
                           , DEFAULT, DEFAULT, DEFAULT);
INSERT INTO BOARD_T VALUES(BOARD_S.NEXTVAL, 'B', '일반 게시글 테스트 13', 'aaaa', '게시글 테스트 중입니다. 13'
                           , DEFAULT, DEFAULT, DEFAULT);
                           
SELECT * FROM BOARD_T;  

SELECT id, btype, title, writer, createDate, viewCnt
  FROM(SELECT ROWNUM AS NUM
            , id, btype, title, writer, createDate, viewCnt
         FROM (SELECT *
                 FROM BOARD_T
                ORDER BY btype DESC, id DESC)
  )
 WHERE NUM BETWEEN 1 AND 10;