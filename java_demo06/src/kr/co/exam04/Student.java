package kr.co.exam04;

import java.util.Arrays;

public class Student {

	public Subject subject[];
	public String name;
	public int level;
	
	public Student(String name) {
		this.name = name;
	}
	
	public Student() {
		//this.subject = new Subject[0];
		Subject sub[] = new Subject[] {new Subject("국어",70.2), new Subject("수학", 80.5), new Subject("영어", 95.6)};
		this.subject = sub;
	}
	
	public String getAll() {
		String str = "";
		for(int i = 0; i < this.subject.length; i++) {
			Subject s = this.subject[i];
//			str += String.format("%s\t%,d\t%s\n", s.subjectName, s.score, s.grade);
			str += String.format("%s\t%d\n", s.subjectName, s.score);
		}                             
		return str;
	}
	
	public void add(String subjectName, int score) {
		boolean isExists = this.findIndex(subjectName) != -1 ? true : false;
		
		if(!isExists) {
			this.subject = Arrays.copyOf(this.subject, this.subject.length + 1);
			this.subject[this.subject.length - 1] = new Subject(subjectName, score);
		} else {
			System.out.println("중복된 과목입니다.");
		}
	}
	
	public boolean update(String subjectName, int score) {
		int idx = this.findIndex(subjectName);
		if(idx != -1) {
		    this.subject[idx].score = score;
		    return true;
		}
		return false;
	}
	
	public void remove(String subjectName) {
		int idx = this.findIndex(subjectName);
		if(idx != -1) {
			for(int i = idx; i < this.subject.length - 1; i++) {
				this.subject[i] = this.subject[i + 1];
			}
			this.subject = Arrays.copyOf(this.subject, this.subject.length - 1);
		}
	}	
	
	public int getScore(String subjectName) {
		int idx = this.findIndex(subjectName);
		return (int) (idx != -1 ? this.subject[idx].score : idx);
	}
	
	private int findIndex(String subjectName) {
		for(int i = 0; i < this.subject.length; i++) {
			if(this.subject[i].getName().equals(subjectName)) {
				return i;
			}
		}
		return -1; 
	}
}
