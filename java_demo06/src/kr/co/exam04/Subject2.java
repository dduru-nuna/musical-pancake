package kr.co.exam04;

public class Subject2 {
	private String name;
	private double score;
	private char grade;

	public Subject2(String name) {
		this.name = name;
		this.grade = 'F';
	}

	public Subject2(String name, double score) {
		this.name = name;
		this.score = score;
		this.setGrade();
	}

	public String getName() {
		return this.name;
	}

	public void setScore(double score) {
		this.score = score;
		this.setGrade();
	}

	public double getScore() {
		return this.score;
	}

	private void setGrade() {
		switch((int)(this.score / 10)) {
			case 10:
			case 9:
				this.grade = 'A'; break;
			case 8:
				this.grade = 'B'; break;
			case 7:
				this.grade = 'C'; break;
			case 6:
				this.grade = 'D'; break;
			case 5:
				this.grade = 'E'; break;
			default:
				this.grade = 'F'; break;
		}
	}

	public char getGrade() {
		return this.grade;
	}
}	