package kr.co.demo05;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Demo {

	public static void main(String[] args) {
		/*
		 * FileWriter
		 */
		File f = new File("D:\\입출력테스트.txt");

		try(FileWriter fw = new FileWriter(f, true)){
			fw.write("문자기반출력");
			fw.write("추가");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
