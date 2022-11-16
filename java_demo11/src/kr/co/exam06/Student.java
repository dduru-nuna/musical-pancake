package kr.co.exam06;

import java.util.Objects;

public class Student {

	private String name;
	private int classYear;
	private int classRoom;
	private int classNumber;
	
	public Student(String name, int classYear, int classRoom, int classNumber) {
		super();
		this.name = name;
		this.classYear = classYear;
		this.classRoom = classRoom;
		this.classNumber = classNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getClassYear() {
		return classYear;
	}

	public void setClassYear(int classYear) {
		this.classYear = classYear;
	}

	public int getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}

	public int getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(classNumber, classRoom, classYear, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return classNumber == other.classNumber && classRoom == other.classRoom && classYear == other.classYear
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", classYear=" + classYear + ", classRoom=" + classRoom + ", classNumber="
				+ classNumber + "]";
	}
	
	
}	