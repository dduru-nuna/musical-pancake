package kr.co.exam06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Run {

	private Scanner sc = new Scanner(System.in);
	private HashMap<Student, ArrayList<Subject>> datas = new HashMap<Student, ArrayList<Subject>>();
	
	public void printMenu() {
		String menu = "";
		menu += "<<학생 성적 관리 프로그램>>\n" +
		             "[1]전체 조회\n" +
				     "[2]학생 검색\n" +
		             "[3]성적 수정\n" +
				     "[4]프로그램 종료\n";
		System.out.print(menu);
	}
	
	public void save() {
		StringBuilder sb = new StringBuilder();
		
		for(Entry<Student, ArrayList<Subject>> e: datas.entrySet()) {
			Student student = e.getKey();
			sb.append(student.getName() + ",");
			sb.append(student.getClassYear() + ",");
			sb.append(student.getClassRoom() + ",");
			sb.append(student.getClassNumber() + ",");
			for(Subject subject: e.getValue()) {
				sb.append(subject.getName() + "=");
				sb.append(subject.getScore() + ",");
			}
			sb.replace(sb.length() - 1, sb.length(), "\r\n");
		}
		File f = new File("D:\\학생성적관리정보.info");
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(f))){
			bw.write(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void load() {
		File f = new File("D:\\학생성적관리정보.info");
		
		try(BufferedReader br = new BufferedReader(new FileReader(f))){
			while(br.ready()) {
				this.parse(br.readLine());
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void parse(String data) {
		String[] sArr = data.split(":"); // 학생성적관리정보 에서 : 을 기준으로 나누기
		String[] studentArr = sArr[0].split(","); // : 기준으로 나뉜 첫번째 배열에서 , 로 다시 나누기
		Student student = new Student(studentArr[0], Integer.valueOf(studentArr[1]),
				Integer.valueOf(studentArr[2]), Integer.valueOf(studentArr[3]));
		
		ArrayList<Subject> subjectList = new ArrayList<Subject>();
		this.datas.put(student, subjectList);
		
		String[] subjectArr = sArr[1].split(",");  // : 기준으로 나뉜 두번째 배열에서 , 로 다시 나누기
		for(int i = 0; i < subjectArr.length; i++) {
			String[] arr = subjectArr[i].split("=");  // = 기준으로 다시 나누어서 과목명이랑 점수 저장
			subjectList.add(new Subject(arr[0], Double.valueOf(arr[1])));
		}
	}
	
	public void start() {
		load();
		while(true) {
			printMenu();
			System.out.print("선택 : ");
			int menuNumber = sc.nextInt();
		}
	}
}
