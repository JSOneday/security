package com.oneday.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient {
	public static void runClient(String clientData) throws UnknownHostException, IOException{
		//创建一个Socket 跟本机的8080端口连接
		Socket socket=new Socket("localhost",8080);
		//使用Scocket 创建PrintWriter和BufferedReader进行数据读写
		PrintWriter pw=new PrintWriter(socket.getOutputStream());
		BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//发送数据
		pw.println("Client send msg："+clientData);
		pw.flush();
		String line=br.readLine();
		System.out.println("received from server:"+line);
		pw.close();
		br.close();
		socket.close();
	}
}
