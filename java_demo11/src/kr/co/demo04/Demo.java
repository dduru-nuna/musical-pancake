package kr.co.demo04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Demo {

	public static void main(String[] args) {
		/*
		 * Properties
		 */
		Properties prop = new Properties();
		
		File f = new File("C:\\Users\\user2\\eclipse\\jee-2022-09\\eclipse\\configuration\\config.ini");
		
		try {
			prop.load(new BufferedReader(new FileReader(f)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(prop);
		// 값 찾기
		System.out.println(prop.get("eclipse.application"));
		
		// 저장
		f = new File("C:\\Users\\user2\\eclipse\\jee-2022-09\\eclipse\\configuration\\config.ini.bak");
		try {
			prop.store(new BufferedWriter(new FileWriter(f)), "Comment");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
