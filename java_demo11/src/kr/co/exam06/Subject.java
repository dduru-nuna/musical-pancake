package kr.co.exam06;

import java.util.Objects;

public class Subject {

	private String name;
	private double score;
	private char grade;
	
	public Subject(String name, double score) {
		this.name = name;
		this.score = score;
		this.setGrade();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public char getGrade() {
		return grade;
	}
	
	public void setGrade() {
		switch((int)(this.score /  10)) {
		case 10:
		case 9:
			this.grade = 'A';
			break;
		case 8:
			this.grade = 'B';
			break;
		case 7:
			this.grade = 'C';
			break;
		case 6:
			this.grade = 'D';
			break;
		case 5:
			this.grade = 'E';
			break;
		default:
			this.grade = 'F';
		}
	}
	
	public void setGrade(char grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "Subject [subjectName=" + name + ", score=" + score + ", grade=" + grade + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(grade, score, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		return grade == other.grade && Double.doubleToLongBits(score) == Double.doubleToLongBits(other.score)
				&& Objects.equals(name, other.name);
	}
	
	
}
