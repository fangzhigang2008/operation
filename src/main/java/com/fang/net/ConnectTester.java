package com.fang.net;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class ConnectTester {
	public static void main(String[] args) {
		String host = "localhost";
		int port = 25;
		if(args.length>1){
			host = args[0];
			port = Integer.parseInt(args[1]);
		}
		new ConnectTester().connect(host, port);
	}
	
	public void connect(String host,int port){
		SocketAddress remoteAddr = new InetSocketAddress(host,port);
		Socket socket = null;
		
		String result = "";
		
		try{
			long begin = System.currentTimeMillis();
			socket = new Socket();
			socket.connect(remoteAddr,1000);
			long end = System.currentTimeMillis();
			result = (end - begin)+"ms";
			socket.close();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(host+" "+port+" "+result);
		
	}
}