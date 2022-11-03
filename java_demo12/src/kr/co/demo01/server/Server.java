package kr.co.demo01.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {

	public static void main(String[] args) {
		/*
		 * 네트워크 프로그래밍
		 *    - 네트워크로 연결된 컴퓨터 장치 간에 데이터를 송/수신 할 수 있도록 만드는 프로그래밍
		 *    - 서버와 클라이언트로 역할을 나누어서 작성하게 된다.
		 *    - 네트워크 연결에 필요한 정보로 IP 주소와 Port 번호가 있으며, 이 정보를 통해
		 *      연결할 서버와 클라이언트를 식별하게 된다.
		 *    - 네트워크 연결을 통해 데이터를 송/수신 할 때 2가지 전송 방식이 있으며 각각
		 *      TCP, UDP 라고 한다.
		 *    - UDP 의 경우 신뢰성은 낮지만 데이터 전송 속도가 빠른 특징을 갖는다.
		 *    - TCP 의 경우 신뢰성은 높으며 데이터 전송 속도가 느린 특징을 갖는다.
		 *
		 */
		
		/*
		 * UDP 서버
		 *    1. 통신을 위한 Port 지정
		 *    2. 지정한 Port로 데이터소켓 객체 생성  // 소켓 = 연결점
		 *    3. 데이터그램패킷 객체 생성(클라이언트가 보낸 메시지를 받을 패킷 객체를 생성) // 패킷 = 연결점으로 들어온 데이터
		 *    4. 수신 대기
		 *    5. 데이터를 수신한 후에는 클라이언트가 요청한 정보에 맞추어 동작하고 처리 결과를 전달
		 *    6. 처리 결과를 전달하기 위해 데이터그램패킷 객체 생성
		 *    7. 만들어진 패킷 객체로 전송
		 *    8. 3번 ~ 7번 까지의 과정 반복   
		 */

		
	}

}
