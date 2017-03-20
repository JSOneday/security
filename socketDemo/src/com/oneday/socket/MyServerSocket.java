package com.oneday.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerSocket {
	public static void startServer(String sms) throws IOException{
		//创建一个ServerSocket监听8080端口
		ServerSocket server=new ServerSocket(8080);
		//等待请求
		Socket socket=server.accept();
		//接收请求后 使用socket进行通信，创建BufferedReader用于读取数据
		BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String line=br.readLine();
		System.out.println("recevied from client:"+line);
		//创建PrintWriter 用于发送数据
		PrintWriter pw=new  PrintWriter(socket.getOutputStream());
		pw.println("server send data:" +sms);
		pw.flush();
		//关闭资源
		pw.close();
		br.close();
		socket.close();
		server.close();
	}
}
