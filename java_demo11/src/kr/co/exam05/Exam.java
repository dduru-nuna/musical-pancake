package kr.co.exam05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Random;

public class Exam{

	public static void main(String[] args) {
		/*
		 * 컬렉션에 다른 컬렉션을 담아서 사용하기
		 * 
		 * ArrayList 에 과목정보들이 있는 HashMap 컬렉션을 담아서 사용해보세요.
		 * 
		 * HashMap 에는 다음의 과목명과 과목 점수가 저장될 수 있게 하세요.
		 * 
		 * 과목명 : 국어, 영어, 수학, 과학, 사회, 체육, 미술
		 * 
		 * 과목명은 Key 가 됩니다.
		 * 과목 점수는 Value 가 되며, Score 객체로 임의의 점수와 등급이 저장되게 합니다.
		 * 
		 * 총 5개의 HashMap 을 ArrayList 에 담아 놓고 ArrayList 에 있는 HashMap 별로
		 * 평균과 총점을 구해서 출력하세요.
		 */
		
		HashSet<String> subjects = new HashSet<String>();
		subjects.add("국어"); subjects.add("영어");
		subjects.add("수학"); subjects.add("과학");
		subjects.add("사회"); subjects.add("체육");
		subjects.add("미술");
		
		// 제네릭타입은 앞으로 이 객체를 사용할테니 준비하라는 의미로 생각하면 된다
		ArrayList<HashMap<String, Score>> datas = new ArrayList<HashMap<String, Score>>();
		Random rand = new Random();
		
		for(int i = 0; i < 5; i++) {
			HashMap<String, Score> data = new HashMap<String, Score>();
			for(String subject: subjects) {
				double score = rand.nextInt(40) * rand.nextDouble() + 60;
				data.put(subject, new Score(score));
			}
			datas.add(data);  // datas 는 HashMap 5개를 가지게 되는것
		}
		
		for(HashMap<String, Score> data: datas) {
			System.out.println(data);
		}
		
		for(HashMap<String, Score> data: datas) {
			double sum = 0;
			double avg = 0;
			for(Entry<String, Score> e: data.entrySet()) {
				sum += e.getValue().getScore();
			}
			avg = sum / data.size();
			data.put("총점", new Score(sum));
			data.put("평균", new Score(avg));
		}
		
		int i = 0;
		for(HashMap<String, Score> data: datas) {
			System.out.println(++i + "번 학생의 총점:" + data.get("총점") + ", ");
			System.out.println("평균:" + data.get("평균"));
		}
	}

}
