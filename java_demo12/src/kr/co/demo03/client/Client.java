package kr.co.demo03.client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.rmi.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		/*
		 * TCP 클라이언트
		 *    1. 데이터를 전달할 서버 IP 주소와 Port 지정
		 *    2. 서버와 연결하기 위한 소켓 객체 생성
		 *    3. 서버로부터 연결 승낙이 이루어지면 바로 입출력 스트림 생성
		 *    4. 서버와 통신 진행
		 */
		Scanner sc = new Scanner(System.in);
		int serverPort = 51000;
		InetAddress serverIp;
		
		try {
			serverIp = InetAddress.getByName("127.0.0.1");
			
			Socket sock = new Socket(serverIp, serverPort);
			
			BufferedInputStream bis = new BufferedInputStream(sock.getInputStream());
			BufferedOutputStream bos = new BufferedOutputStream(sock.getOutputStream());
			
			while(true) {
				System.out.print("입력 : ");
				String msg = sc.nextLine();
				
				bos.write(msg.getBytes());
				bos.flush();  // flush를 해야 전송된다.
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
