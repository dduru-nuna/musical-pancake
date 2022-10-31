package java_demo02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		/*
		 * FileInputStream
		 *    - 바이트 기반 스트림으로 바이트 단위로 파일을 읽는다.
		 */

		File f = new File("D:\\입출력테스트.txt");
		// 입출력 할때는 try/catch 구문 많음
		try(FileInputStream fis = new FileInputStream(f)) {    // try~with~resource : close 작업을 알아서 해준다, close 안하면 입출력스트림이 계속 열려있는 상태로 남게된다.
			byte[] buffer = new byte[8]; // 8바이트씩 읽을려고 지정
			byte[] datas = new byte[(int)f.length()]; // 일정 크기만큼 읽어서 바이트배열에 저장하고 활용하는 방법
			
			int offset = 0;
			while(true) {                                    
				int readByte = fis.read(buffer);  // 읽은 바이트 데이터를 담아준다
				if(readByte == -1) { //read 반환타입 int로 되어있으나 실상 byte로 봐야함, -1 반환되면 더이상 읽을 데이터 없음
					break;
				}
				//System.out.print(Integer.toHexString(readByte));  // 16진수로 변환해서 본거, (char)readByte 하면 메모장에 입력한거 문자로 볼 수 있음
				System.arraycopy(buffer, 0, datas, offset, readByte);
				offset += readByte;
			}                           
			System.out.print(Arrays.toString(datas));
			System.out.print(new String(datas));  // print는 바이트배열 출력 지원안해서 new String으로 만들어줌
			
		} catch (FileNotFoundException e) {
			System.out.println("해당 파일을 찾지 못하였습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("파일 읽기 작업 중 문제가 발생했습니다.");
			e.printStackTrace();
		}
	}

}
