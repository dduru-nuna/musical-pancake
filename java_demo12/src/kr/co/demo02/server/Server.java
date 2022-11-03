package kr.co.demo02.server;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
// 강사님이 추가로 보여준 내용인데 깃에서 따로 확인하기. 받아적지 않았음
//	public static void temp(String name, byte[] rowData, byte length) {
//		File f = new File("D:\\" + name);
//		
//		try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f,true))) {
//			bos.write(rowData);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	public static void main(String[] args) {

		int port = 51000;  // 만약 소켓 에러뜨면 포트 바꾸면 됨 (0 ~ 65535(16bit) 까지의 범위에서) , 기본프로그램 및 상용프로그램 포트 제외하고 사용하기
		
		try {   // UDP 에서는 datagramsocket(조그만한 메시지만을 주고받아서)이 쓰이고 TCP에서는 그냥 socket이 쓰인다
			DatagramSocket dSocket = new DatagramSocket(port);
			//클라이언트가 보낸 메시지를 받기 위한 작업
			
			while(true) {
				byte recv[] = new byte[4096];   // 수신용이라 byte배열 필요(통신쪽은 다 byte만을 받는다), 4096은 아무값이나 넣은거
				DatagramPacket recvPacket = new DatagramPacket(recv, recv.length);
				
				System.out.println("데이터 수신 대기 중...");
				dSocket.receive(recvPacket);  // 받은 데이터를 패킷에 넣으려고 receive 메서드 사용, receive는 패킷을 받을 준비를 하고 있는것이다(상대방이 데이터를 보내기 기다리고있음)
			// * 네트워크는 혼자만 작동하는게 아니라 서로가 동작해야 하기 때문에 중간에 멈추는 과정이 발생한다.
			
				String recvData = new String(recvPacket.getData(), 0, recvPacket.getLength()); // byte로 받은 데이터를 String으로 반환, getDate()만 쓰면 배열의 크기만큼 다 받아온다 그래서 getLength()로 실제로 받은만큼만 받아올 수 있게 한다.
				System.out.println("클라이언트가 보낸 메시지 : " + recvData);
				
				System.out.println("클라이언트 요청 처리후 결과 전달!");
				byte byteData[] = new String(recvData + " 에 대한 처리가 완료되었습니다.").getBytes();      //clientIp           //clientPort
				DatagramPacket sendPacket = new DatagramPacket(byteData, byteData.length, recvPacket.getAddress(), recvPacket.getPort());
				dSocket.send(sendPacket);
			}
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
