package com.fan.net2_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver {
	private int port = 8000;
	private  ServerSocket serverSocket ;
	
	private static int stopWay = 1;
	private final int NUTURAL_STOP = 1;
	private final int SUDDEN_STOP = 2;
	private final int SOCKET_STOP = 3;
	private final int INPUT_STOP = 4;
	private final int SERVERSOCKET_STOP = 5;
	
	
	public Receiver() throws IOException{
		serverSocket = new ServerSocket(port);
		System.out.println("服务器已经启动");
	}
	
	private BufferedReader getReader(Socket socket) throws IOException{
		InputStream socketIn = socket.getInputStream();
		return new BufferedReader(new InputStreamReader(socketIn));
	}
	public void receive() throws IOException, InterruptedException{
		Socket socket = null;
		System.out.println("start receive1");
		socket = serverSocket.accept();
		System.out.println("start receive2");
		BufferedReader br = getReader(socket);
		System.out.println("start receive3");
		for(int i=0;i<20;i++){
			String msg = br.readLine();
//			Thread.sleep(1000);
			System.out.println("receive:"+msg);
			if(i == 2){
				if(stopWay == SUDDEN_STOP){
					System.out.println("突然终止程序");
					System.exit(0);
				}else if(stopWay == SOCKET_STOP){
					System.out.println("关闭Socket并终止程序");
					socket.close();
					break;
				}else if(stopWay == INPUT_STOP){
					System.out.println("关闭输入流并终止程序");
					socket.shutdownInput();
					break;
				}else if(stopWay == SERVERSOCKET_STOP){
					System.out.println("关闭ServerSocket并终止程序");
					serverSocket.close();
				}
			}
		}
		if(stopWay == NUTURAL_STOP){
			System.out.println("自然关闭..");
			socket.close();
			serverSocket.close();
		}
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		if(args.length > 0) stopWay = Integer.parseInt(args[0]);
		
		new Receiver().receive();
	}
	
	
}
