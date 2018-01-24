package com.fan.net2_4;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Sender {

	private String host="localhost";
	private int port = 8000;
	private Socket socket;
	private static int stopWay = 1;
	
	private final int N = 1;
	private final int S = 2;
	private final int SKT = 3;
	private final int O = 4;
	
	public Sender() throws UnknownHostException, IOException{
		socket = new Socket(host,port);
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		if(args.length > 0) stopWay = Integer.parseInt(args[0]);
		
		new Sender().send();
	}
	
	private PrintWriter getWriter(Socket socket) throws IOException{
		OutputStream outputStream = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(outputStream);
		return pw;
	}
	
	public void send() throws IOException, InterruptedException{
		PrintWriter pw = getWriter(socket);
		for(int i=0;i<20;i++){
			String msg = "Hello_"+i;
			pw.println(msg);
			pw.write(msg);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bw.write("测试");
			bw.flush();
			System.out.println("send:"+msg);
			Thread.sleep(500);
			if(i==2){
				if(stopWay == S){
					System.out.println("突然终止程序");
					System.exit(0);
				}else if(stopWay == SKT){
					System.out.println("关闭socket并终止程序");
					socket.close();
					break;
				}else if(stopWay == O){
					socket.shutdownOutput();
					System.out.println("关闭输出流并终止程序");
					break;
				}
			}
		}
		if(stopWay == N){
			System.out.println("sender closed");
			socket.close();
		}
	}
	
	

}
