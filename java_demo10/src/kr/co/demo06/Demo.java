package kr.co.demo06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Demo {
	//main에서 진행했다가 다른 개념도 해보기 위해 따로 메서드로 뺌
	public static void charSubStream() {
		File f = new File("D:\\입출력테스트.txt");
		
		StringBuilder sb = new StringBuilder();
		                                   // 보조                 기반
 		try(InputStreamReader isr = new InputStreamReader(new FileInputStream(f))) {
			char[] buf = new char[16];
			while(true) {
				int readCount = isr.read(buf);
				if(readCount == -1) {
					break;
				}
				sb.append(buf,0,readCount);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.print(sb.toString());
		                                                                             
		try(OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(f, true))) {
			osw.write("문자열을 그대로 출력에 사용\r\n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		/*
		 * 보조 스트림
		 *     - 입/출력에서 사용하는 기반 스트림을 보조하는 역할을 수행하는 스트림
		 *     - 보조 스트림을 사용하기 위해서는 반드시 기반 스트림과 같이 사용해야 한다.
		 *     - 보조 스트림은 기반 스트림의 성능 향상 또는 추가 기능을 제공하여 입출력을
		 *       보다 효율적으로 사용하기 위한 용도로 쓰인다.
		 *       
		 * 문자 보조 스트림
		 *     - InputStreamReader / OutputStreamWriter 이 있으며, 바이트 기반 스트림에
		 *       적용하여 사용
		 *     - 바이트 데이터를 문자 데이터로 변환하는 기능을 제공
		 *      
		 * 버퍼 보조 스트림
		 *     - BufferedInputStream / BufferedOutputStream 이 있으며, 바이트 기반 스트림에
		 *       적용하여 사용
		 *     - BufferedReader / BufferedWriter 이 있으며, 문자 기반 스트림에 적용하여 사용
		 *     - 하드디스크와 메모리 사이의 입출력 속도차를 보완하기 위한 중간 완충 영역을 만들어서
		 *       병목 현상을 최소화 하여 원활한 입출력이 이루어질 수 있도록 제공한다.
		 *       
		 * 데이터 타입 보조 스트림
		 *     - DataInputStream / DataOutputStream 이 있으며, 바이트 기반 스트림에 적용하여 사용
		 *     - 프로그램에서 사용하는 기본 데이터 타입을 그대로 입출력에 사용할 수 있도록 하는 기능 제공
		 *     
		 * 객체 타입 보조 스트림
		 *     - ObjectInputStream / ObjectOutputStream 이 있으며 바이트 기반 스트림에 적용하여 사용
		 *     - 프로그램에서 사용하는 객체 타입을 그대로 입출력에 사용할 수 있도록 하는 기능 제공
		 */
	
		File f = new File("D:\\입출력테스트.txt");
		
		StringBuilder sb = new StringBuilder();
		try(BufferedReader br = new BufferedReader(new FileReader(f))) {
			// ready() 읽을 상태이면 읽기. 이전처럼 -1 따질 필요 없음
			while(br.ready()) {
				sb.append(br.readLine() + "\r\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print(sb.toString());
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(f,true))) {
			bw.write("버퍼 보조 스트림을 적용하여 입출력");
			bw.newLine(); // 자동으로 개행 적용
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
