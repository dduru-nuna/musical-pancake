package kr.co.demo04;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Demo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// Oracle Driver 등록
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// Database Connection 생성          DB연결정보(jdbc~thin까지는 고정) , 계정명 , 계정암호
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String username = "dev01";
		String password = "dev01";
		Connection conn = DriverManager.getConnection(url, username, password);
		
		// INSERT, UPDATE, DELETE Query 작성    테이블 구조 확인해서 ? 개수 확인
		String query = "INSERT INTO EMPLOYEES VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		// PreparedStatement 객체 생성 
		PreparedStatement pstat = conn.prepareStatement(query);
		pstat.setInt(1, 210);
		pstat.setString(2, "길동");
		pstat.setString(3, "홍");
		pstat.setString(4, "HGILDONG");
		pstat.setString(5, "515.123.1234");
		//java.sql.Date 객체로는 현재 시스템 날짜를 불러올 수 없어서 java.util.Date를 불러와야한다. 이름이 같아서 import는 한번만 가능
		pstat.setDate(6, new Date((new java.util.Date()).getTime()));
		pstat.setString(7, "IT_PROG");
		pstat.setInt(8, 2800);
		pstat.setDouble(9, 0); // null 넣을꺼면 pstat.setNull(9, 0) 쓸 수 있다
		pstat.setInt(10, 103);
		pstat.setInt(11, 60);
		
		// 작성한 Query 전송 후 int 반환 (반영된 행의 갯수)
		int rs = pstat.executeUpdate();  //executeUpdate 는 INSERT,DELETE,UPDATE 사용 , executeQuery 는 SELECT
		
		// 반환 받은 ResultSet 의 내용 추출 및 추가 작성    rs.next() 는 boolean 형 반환. record 있으면 true로 반복 진행
		System.out.println(rs + " 개 행이 반영되었습니다.");
		
		// Database 관련 연결 정보 Close      가장 마지막에 열린거를 가장 먼저 닫아줌
		pstat.close();
		conn.close();

	}

}
