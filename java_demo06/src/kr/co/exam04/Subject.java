package kr.co.exam04;

public class Subject {
	public String subjectName;
	public double score;
	public char grade;
	
	
	public Subject(String subjectName, double score) {
		this.subjectName = subjectName;
		this.score = score;
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
		return this.subjectName;
	}
	
	public double getScore() {
		return this.score;
	}
	
	public char getGrade() {
		return this.grade;
	}

	
}
