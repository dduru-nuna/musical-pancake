package kr.co.demo03;

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
		
		// Query 작성 (쿼리 문자열에 세미콜론 작성X)
		// 사용자 입력을 사용하여 사원ID 를 입력 받고 입력받은 ID에 해당하는 사원만 조회 후 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("사원 ID(100 ~ n) :");
	    String empIds = sc.nextLine();
		
		String query = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, HIRE_DATE FROM EMPLOYEES";
		query += " WHERE EMPLOYEE_ID IN (?, ?)";  // ? -> holder 값 (집어넣을 값 지정)
		
		// PreparedStatement 객체 생성    Statement 와 다르게 순서가 query 작성 후에 온다
		// PreparedStatement는 INSERT,UPDATE 할 때 편함
		PreparedStatement pstat = conn.prepareStatement(query);
		pstat.setString(1, "100");  //string 을 쿼리문에 넣으면 자동으로 ''가 들어간다.
		pstat.setInt(1, 101);
		
		// 작성한 Query 전송 후 ResultSet 반환
		ResultSet rs = pstat.executeQuery();
		
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
		pstat.close();
		conn.close();

	}

}
