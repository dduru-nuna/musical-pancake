package kr.co.exam02;

public class Subject {
	
	private String name;
	private double score;
	private char grade;
	
	public Subject(String name) {
		this.name = name;     // 자기 자신에 대한 메서드나 변수 사용하면 this 사용
	}
	
	
	public void setScore(double score) {
		if(score >= 0 && score <= 100) {
			this.score = score;
		} else {
			this.score = 0;
		}
		this.setGrade();
	}
	
	private void setGrade() {
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
	
	public String getName() {
		return this.name;
	}
	
	public double getScore() {
		return this.score;
	}
	
	public char getGrade() {
		return this.grade;
	}
}
