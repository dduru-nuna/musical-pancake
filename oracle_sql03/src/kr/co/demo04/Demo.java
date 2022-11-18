package kr.co.demo04;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import kr.co.db.connection.OracleConnection;
import kr.co.vo.EmployeeVO;

public class Demo {
    //OracleConnection 이용함
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		OracleConnection oc = new OracleConnection("localhost:1521/XEPDB1", "dev01", "dev01");
		
		EmployeeVO emp = new EmployeeVO();
		emp.setEmpId(210);
		emp.setFirstName("길동");
		emp.setLastName("홍");
		emp.setEmail("HGILDONG");
		emp.setPhoneNumber("512,123,1234");
		emp.setHireDate(new Date());
		emp.setJobId("IT_PROG");
		emp.setSalary(2800);
		emp.setCommission(0);
		emp.setManagerId(103);
		emp.setDeptId(60);
		
		//나중에는 이 코드들을 함수로 만들어서 외부에서 EmployeeVO 란 객체로 emp 에 데이터 담아 보내면 emp.get으로 추출해서 저장
		// INSERT, UPDATE, DELETE Query 작성    테이블 구조 확인해서 ? 개수 확인
		String query = "INSERT INTO EMPLOYEES VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		// PreparedStatement 객체 생성 
		PreparedStatement pstat = oc.getPrepared(query);
		pstat.setInt(1, emp.getEmpId());
		pstat.setString(2, emp.getFirstName());
		pstat.setString(3,emp.getLastName());
		pstat.setString(4, emp.getEmail());
		pstat.setString(5, emp.getPhoneNumber());
		//(이전내용)java.sql.Date 객체로는 현재 시스템 날짜를 불러올 수 없어서 java.util.Date를 불러와야한다. 이름이 같아서 import는 한번만 가능
		pstat.setDate(6, emp.getHireDate());
		pstat.setString(7,emp.getJobId());
		pstat.setInt(8, emp.getSalary());
		pstat.setDouble(9, emp.getCommission()); // null 넣을꺼면 pstat.setNull(9, 0) 쓸 수 있다
		pstat.setInt(10, emp.getManagerId());
		pstat.setInt(11,emp.getDeptId());
		
		// 작성한 Query 전송 후 int 반환 (반영된 행의 갯수)
		int rs = oc.sendInsert();  //executeUpdate 는 INSERT,DELETE,UPDATE 사용 , executeQuery 는 SELECT
		
		// 반환 받은 ResultSet 의 내용 추출 및 추가 작성    rs.next() 는 boolean 형 반환. record 있으면 true로 반복 진행
		System.out.println(rs + " 개 행이 반영되었습니다.");
		
		// Database 관련 연결 정보 Close      가장 마지막에 열린거를 가장 먼저 닫아줌
		oc.close();

	}

}
