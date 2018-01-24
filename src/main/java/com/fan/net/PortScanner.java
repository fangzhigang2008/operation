package com.fan.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

public class PortScanner {
	public static void main(String[] args) throws UnknownHostException {
//		String host="localhost";
		PortScanner ps = new PortScanner();
//		ps.scan(host);
//		ps.scan1();
//		ps.scan2();
		ps.scan3();
	}
	
	public void scan(String host){
		Socket socket = null;
		for(int i=79;i<1024;i++){
			try {
				socket = new Socket(host,4000);
				System.out.println("There is a server on port "+i);
			} catch (IOException e) {
				System.out.println("Conn't connect to port "+i);
			}finally{
				try{
					if(socket != null){
						socket.close();
						System.out.println("socket has been closed");
					}else{
						System.out.println("socket is null");
					}
				}catch(Exception e){}
			}
		}
	}
	
	public void scan1(){
		Socket socket = new Socket();
		SocketAddress sa = new InetSocketAddress("localhost", 4000);
		try {
			socket.connect(sa, 0);
			System.out.println(socket.getLocalPort());
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void scan2(){
		try {
			InetAddress ia = InetAddress.getLocalHost();
			InetAddress ia2 = InetAddress.getByName("119.75.218.71");
			System.out.println(ia);
			System.out.println(ia2);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Socket socket = new Socket();
		SocketAddress sa = new InetSocketAddress("localhost", 8000);
		try {
			socket.connect(sa, 60000);
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void scan3() throws UnknownHostException{
		InetAddress ia = InetAddress.getByName("127.0.0.1");
		System.out.println(ia);
		
	}
}