package kr.co.demo04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo {

	public static void main(String[] args) {
		/*
		 * FileOutputStream
		 */
		File f = new File("D:\\입출력테스트.txt");
		
		try(FileOutputStream fos = new FileOutputStream(f, true)) {  // true를 쓰면 기존 내용 유지한 상태로 뒤에 내용 추가 가능(append)
			fos.write(65);  // 입출력테스트 파일에 A 저장됨
			fos.write("한글문자열".getBytes());  // 이런식으로 한글 입력할 수도 있긴함
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
