package kr.co.demo01.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.rmi.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		/*
		 * UDP 클라이언트
		 *    1. 데이터를 전달할 서버 IP 주소와 Port 지정
		 *    2. 데이터소켓 객체 생성
		 *    3. 데이터패킷 객체 생성(서버에게 보낼 메시지를 위한 패킷 객체 생성)
		 *    4. 데이터패킷 전송
		 *    5. 서버의 처리가 완료되어 데이터 패킷을 보낼 것을 대비해 클라이언트도 수신용
		 *       데이터패킷 객체를 생성(수신 대기)
		 *    6. 서버가 보낸 메시지 확인
		 *    7. 3번 ~ 6번 까지의 과정 반복   
		 */
		
		
	//	String serverIp = "127.0.0.1"; // local host : 자기자신 가리키는 ip
		
	}	

}
