package kr.co.demo01;
                         // 컬렉션 sort 기능 이용하려면 필요
public class Subject implements Comparable<Subject> {

	private String name;
	private double score;
	
	public Subject(String name, double score) {
		this.name = name;
		this.score = score;
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
	@Override
	public String toString() {
		return "Subject [name=" + name + ", score=" + score + "]";
	}
	
	public int compareTo(Subject o) {
		if(this.score > o.score) {
			return 1; // 내림차순 하려면 -1
		} else if(this.score < o.score) {
			return -1; // 내림차순 하려면 1
		}
		return 0;
	}
	
}
