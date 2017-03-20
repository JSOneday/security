package com.oneday.test;

import java.io.IOException;
import com.oneday.socket.MyClient;
import com.oneday.socket.MyServerSocket;

public class SocketServerTest {
	public static void main(String[] args) {
		Thread t1=new Thread(new Runnable() {
			public void run() {
				try {
					MyServerSocket.startServer("Hello Customer!");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Thread t2=new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					MyClient.runClient("Hello server！");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
	}
}
