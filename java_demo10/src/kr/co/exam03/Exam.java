package kr.co.exam03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Exam {

	public static void main(String[] args) {
		/*
		 * subject.list 파일에 작성된 과목명을 이용하여 subjects[] 을
		 * 생성하도록 하는 코드를 작성한다.
		 * 
		 * subject2.list 파일에는 다음과 같은 형식으로 과목명이 나열되어 있다.
		 * 
		 * subject2.list 파일
		 *    국어:87,영어:79,수학:67,과학:92,사회:84,체육:95,미술:86
		 *    
		 * 모든 점수를 -5점 한 후 동일한 파일에 저장하기.
		 */
		
		File f = new File("D:\\subject2.list");
		StringBuilder datas = new StringBuilder();

		try(FileReader fr = new FileReader(f)){
			char buffer[] = new char[8];
			while(true) {
				int readChar = fr.read(buffer);
				if(readChar == -1) {
					break;
				}
				datas.append(buffer, 0, readChar);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String strArr[] = datas.toString().split(",");
		Subject subjects[] = new Subject[strArr.length];
		
		for(int i = 0; i < strArr.length; i++) {
			String data[] = strArr[i].split(":");
			Subject s = new Subject(data[0], Double.parseDouble(data[1]));
			s.setScore(s.getScore() - 5);
			subjects[i] = s;
		}
		
		datas = new StringBuilder();
		for(int i = 0; i < subjects.length; i++) {
			datas.append(subjects[i].getName() + ":" + subjects[i].getScore() + ",");
		}
		try(FileWriter fw = new FileWriter(f)) {
			fw.write(datas.toString(), 0 , datas.toString().length() -1); //마지막에 생기는 , 빼려고 -1 해주기
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
