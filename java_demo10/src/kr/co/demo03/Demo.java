package kr.co.demo03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo {

	public static void main(String[] args) {
		/*
		 * FileReader
		 *    - 문자 기반 입력스트림으로 문자 단위로 파일을 읽는다.
		 */
		File f = new File("D:\\입출력테스트.txt");
		
		try(FileReader fr = new FileReader(f)){
			char[] buffer = new char[8];
			StringBuilder sb = new StringBuilder(64); // 크기 모자르면 알아서 늘어남
			
			while(true) {
				int readChar = fr.read(buffer);
				if(readChar == -1) {
					break;
				}
				sb.append(buffer, 0, readChar);
			}
			System.out.print(sb.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
