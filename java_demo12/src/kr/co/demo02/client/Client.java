package kr.co.demo02.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.rmi.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int serverPort = 51000;
		InetAddress serverIp;
		
		try {
			serverIp = InetAddress.getByName("127.0.0.1");
			DatagramSocket dSocket = new DatagramSocket();
			
			while(true) {
				System.out.print("입력 : ");
				String msg = sc.nextLine();
				byte byteData[] = msg.getBytes();
				// 클라이언트가 서버에 보내는 패킷 (요청 정보 전달)
				DatagramPacket sendPacket = new DatagramPacket(byteData, byteData.length, serverIp, serverPort);
				dSocket.send(sendPacket);
				
				byte recv[] = new byte[4096];
				// 클라이언트가 서버에서 받는 패킷 (요청 처리 결과 받기)
				DatagramPacket recvPacket = new DatagramPacket(recv, recv.length);
				dSocket.receive(recvPacket);
				
				String recvData = new String(recvPacket.getData(), 0, recvPacket.getLength());
				System.out.println("서버가 보낸 메시지 : " + recvData);
			}	
				
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
