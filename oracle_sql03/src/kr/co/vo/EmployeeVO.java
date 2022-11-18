package kr.co.vo;

import java.sql.Date;
import java.util.Objects;

/**
 * VO 객체
 *    Value Object 로 데이터베이스 테이블의 Record 값을 저장 하기 위한 용도로 사용
 *    (데이터 저장용 객체이다)   //String, int, Date 등의 값을 따로 보지 않고 하나의 데이터로 모아두는 객체
 * @author user2
 */
public class EmployeeVO {

	private int empId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private int salary;
	private double commission;
	private int managerId;
	private int deptId;
	
	//getter&setter   Date는 유의
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(java.util.Date hireDate) {
		this.hireDate = new Date(hireDate.getTime());
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public double getCommission() {
		return commission;
	}
	public void setCommission(double commission) {
		this.commission = commission;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	
	//동일인인지 구분하기 위한 empId 만 hashcode,equals 생성
	@Override
	public int hashCode() {
		return Objects.hash(empId);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeVO other = (EmployeeVO) obj;
		return empId == other.empId;
	}
	
	//출력할 내용만 toString 생성
	@Override
	public String toString() {
		return "EmployeeVO [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
}
