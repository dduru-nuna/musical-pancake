package kr.co.demo01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class Demo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		/*
		 * Java 로 Oracle DB 에 접속하여 데이터 조회
		 *    1. JDBC 라이브러리 필요
		 *    2. JDBC 라이브러리를 이클립스 프로젝트에 등록
		 *       a. 프로젝트 설정 메뉴로 이동
		 *       b. Java Build Path 메뉴로 이동
		 *       c. Libraries 탭으로 이동
		 *       d. Classpath 선택 후 Add External JARs... 버튼 클릭
		 *       e. JDBC 라이브러리 파일 선택
		 *       
		 *    3. 다음의 순서에 맞추어 코드 작성
		 *       a. Oracle Driver 등록
		 *       b. Database Connection 생성
		 *       c. Statement 객체 생성
		 *       d. Query 작성
		 *       e. 작성한 Query 전송 후 ResultSet 반환
		 *       f. 반환 받은 ResultSet 의 내용 추출 및 추가 작업
		 *       g. Database 관련 연결정보 close
		 */
		
		// Oracle Driver 등록
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// Database Connection 생성          DB연결정보(jdbc~thin까지는 고정) , 계정명 , 계정암호
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String username = "dev01";
		String password = "dev01";
		Connection conn = DriverManager.getConnection(url, username, password);
		
		// Statement 객체 생성
		Statement stat = conn.createStatement();
		
		// Query 작성 (쿼리 문자열에 세미콜론 작성X)
		String query = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, HIRE_DATE FROM EMPLOYEES";
		
		// 작성한 Query 전송 후 ResultSet 반환
		ResultSet rs = stat.executeQuery(query);
		
		// 반환 받은 ResultSet 의 내용 추출 및 추가 작성    rs.next() 는 boolean 형 반환. record 있으면 true로 반복 진행
		SimpleDateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일");
		System.out.println("+-----+-----------------+-----------------+----------------+");
		System.out.println("| ID  | FIRST_NAME      | LAST_NAME       | HIRE_DATE      |");
		System.out.println("+-----+-----------------+-----------------+----------------+");
		while(rs.next()) {
			int id = rs.getInt("EMPLOYEE_ID");
			String fName = rs.getString("FIRST_NAME");
			String lName = rs.getString("LAST_NAME");
			Date hireDate = rs.getDate("HIRE_DATE");
			
			System.out.printf("| %d | %15s | %15s | %s |\n", id, fName, lName, df.format(hireDate));
		}
		
		// Database 관련 연결 정보 Close      가장 마지막에 열린거를 가장 먼저 닫아줌
		rs.close();
		stat.close();
		conn.close();

	}

}
