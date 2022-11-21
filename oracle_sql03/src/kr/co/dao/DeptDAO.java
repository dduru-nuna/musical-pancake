package kr.co.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.db.connection.OracleConnection;
import kr.co.vo.DeptVO;
import kr.co.vo.EmployeeVO;

public class DeptDAO {

	private OracleConnection oc;
	
	public DeptDAO() {
		try {
			this.oc = new OracleConnection("localHost:1521/XEPDB1", "dev01", "dev01");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<DeptVO> selectAll() {
		String query = "SELECT * FROM DEPARTMENTS";
		
		ArrayList<DeptVO> arr = new ArrayList<DeptVO>();
		try {
			this.oc.getPrepared(query);
			ResultSet rs = this.oc.sendSelect();
			
			while(rs.next()) {
				DeptVO dept = new DeptVO();
				dept.setDeptId(rs.getInt("DEPARTMENT_ID"));
				dept.setDeptName(rs.getString("DEPARTMENT_NAME"));
				dept.setManagerId(rs.getInt("MANAGER_ID"));
				dept.setLocationId(rs.getInt("LOCATION_ID"));
				arr.add(dept);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return arr;
	}

}
