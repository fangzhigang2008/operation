package com.fan.net;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {
	public static void main(String agrs []) throws IOException{
		final int length=100;
		String host = "localhost";
		int port = 8000;
		
		Socket [] sockets = new Socket[length];
		
		for(int i=0;i<length;i++){
			try {
				sockets[i] = new Socket(host,port);
				System.out.println("客户端"+i+"已连接上");
				System.out.println(sockets[i].getInetAddress().toString()+sockets[i].getPort());
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		for(int i=0;i<length;i++){
			sockets[i].close();
		}
	}
}
