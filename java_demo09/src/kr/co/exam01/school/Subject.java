package kr.co.exam01.school;

import kr.co.exam01.NegativaNumberException;
import kr.co.exam01.NumberRangeOverException;

public class Subject {

	private String name;
	private char grade;
	private double score;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setScore(double score) throws NumberRangeOverException, NegativaNumberException {
		if(score >= 0 && score <= 100) {
			this.score = score;
			this.setGrade();
			return; 
		} else if(score < 0) {
			throw new NegativaNumberException("음수 값 입력 불가");
		} else {
			throw new NumberRangeOverException("점수는 0 ~ 100 사이의 값만 입력");
		}
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
		
	public double getScore() {
		return this.score;
	}
		
	public char getGrade() {
		return this.grade;
	}
	
	public Subject grateThen(Subject subject) {
		if(this.score > subject.score) {
			return this;
		}
		return subject;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%c : %.2f)", name,grade,score);
	}
}
