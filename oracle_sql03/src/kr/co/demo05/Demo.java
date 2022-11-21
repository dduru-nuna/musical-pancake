package kr.co.demo05;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import kr.co.db.connection.OracleConnection;
import kr.co.vo.EmployeeVO;

public class Demo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		OracleConnection oc = new OracleConnection("localhost:1521/XEPDB1", "dev01", "dev01");
		//SELECT 구문 관련해서도 VO 활용
		String query = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, HIRE_DATE FROM EMPLOYEES";
		
		oc.getPrepared(query);
		
		ResultSet rs = oc.sendSelect();
		
		ArrayList<EmployeeVO> empArr = new ArrayList<EmployeeVO>();
		while(rs.next()) {
			EmployeeVO emp = new EmployeeVO();
			emp.setEmpId(rs.getInt("EMPLOYEE_ID"));
			emp.setFirstName(rs.getString("FIRST_NAME"));
			emp.setLastName(rs.getString("LAST_NAME"));
			emp.setHireDate(rs.getDate("HIRE_DATE"));
			empArr.add(emp);
		}
		
		System.out.println(empArr);
		
		// Database 관련 연결 정보 Close
		rs.close();
		oc.close();
	}

}
