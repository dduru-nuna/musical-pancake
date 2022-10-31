package kr.co.exam01.school;

public class Evaluation extends Subject {

	private static final int SCORE_MAX = 10;
	private static final int SCORE_MIN = 1;
	
	private String grade;
	
	private void setGrade() {
		int offset = (int)this.score;
		this.grade = offset >= 6 ? "Pass" : "Fail";
	}
	
	
}
