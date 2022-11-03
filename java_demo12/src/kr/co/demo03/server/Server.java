package kr.co.demo03.server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		/*
		 * TCP 서버
		 *    1. 통신을 위한 Port 지정
		 *    2. 지정한 Port로 서버소켓 객체 생성 
		 *    3. 서버소켓으로 들어오는 연결 요청 대기 후 승낙
		 *    4. 연결 승낙 후 클라이언트와의 연결 소켓 생성
		 *    5. 입출력스트림 생성
		 *    6. 입출력스트림으로 통신 진행
		 */
		//UDP 는 서버에서 클라이언트로 보낼때던, 클라이언트에서 서버로 보낼때던 데이터 전송하면 끝이다. 따로 체크하는게 없음
		//TCP 는 전송하면 데이터를 잘 받았는지 확인(ack)을 보내준다. 이러한 확인과정은 socket 객체안에서 다 이뤄지기 때문에 따로 뭘 만들 필요x. UDP의 datagramsocket은 이런기능없음
		
		//TCP에서 서버는 소켓이 서버소켓(요청이 들어오는걸 승낙하는 용도)/연결소켓(클라이언트와 계속 통신할 용도) 두 개가 있지만 클라이언트는 소켓 하나만 있다.
		
		int port = 51000;
		
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			// accept 하면 소켓이 만들어짐
			Socket sock = serverSocket.accept();
			// 입출력 스트림 생성
			BufferedInputStream bis = new BufferedInputStream(sock.getInputStream());
			BufferedOutputStream bos = new BufferedOutputStream(sock.getOutputStream());
			
			while(true) {
				byte[] recv = new byte[4096];
				while(true) {
					int len = bis.read(recv);
					if(len == -1) {
						break;
					}
					System.out.print(new String(recv, 0, len));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
