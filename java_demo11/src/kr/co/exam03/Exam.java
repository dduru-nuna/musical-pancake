package kr.co.exam03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Exam {

	public static void main(String[] args) {
		/*
		 * 과목 정보를 담기위한 HashMap 컬렉션을 사용해 보세요.
		 * 다음의 과목명과 과목 점수가 HashMap 에 저장될 수 있게 하세요.
		 * 
		 * 과목명 : 국어, 영어, 수학, 과학, 사회, 체육, 미술
		 * 
		 * 과목명은 Key 가 됩니다.
		 * 과목 점수는 Value 가 되며, Double 형으로 임의의 점수를 저장하세요.
		 * 
		 * 모든 정보를 입력 후에는 평균과 총점을 구해서 출력하세요.
		 */
		
		HashMap<String, Double> subject = new HashMap<String, Double>();
		subject.put("국어", Double.valueOf(80.5));
		subject.put("영어", Double.valueOf(92.3));
		subject.put("수학", Double.valueOf(75.8));
		subject.put("과학", Double.valueOf(59.1));
		subject.put("사회", Double.valueOf(83.7));
		subject.put("체육", Double.valueOf(66.8));
		subject.put("미술", Double.valueOf(97.4));
		
		System.out.println(subject);
		/* 강사님은 점수 값을 랜덤 이용해서 함
		 * HashMap<String, Double> datas = new HashMap<String, Double>();
		 * Random rand = new Random();
		 * for(String subject: subjects) {
		 *     datas.put(subject, Double.valueOf(rand.nextInt(40) * rand.nextDouble() + 60));
		 */
		
		
		double sum = 0;
		double avg = 0;
		for(Double score: subject.values()) {
			sum += score;
		}
		avg = sum / subject.size();
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + avg);

	}

}
