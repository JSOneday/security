package com.oneday.test;

import java.io.IOException;
import java.net.UnknownHostException;

import com.oneday.nioSocket.NIOServer;
import com.oneday.socket.MyClient;

public class NIOServerTest {
	public static void main(String[] args) throws InterruptedException {
		Thread t1=new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					new NIOServer().startNioSocket();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
//		Thread t2=new Thread(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					MyClient.runClient("什么");
//				} catch (UnknownHostException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		});
		t1.start();
		Thread.sleep(1000);
//		t2.start();
	}
}
