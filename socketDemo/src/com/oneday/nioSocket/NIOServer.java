package com.oneday.nioSocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

public class NIOServer {
	public static void startNioSocket() throws IOException{
		//创建ServerSocketChannel,监听8080端口
		ServerSocketChannel socketChannel=ServerSocketChannel.open();
		socketChannel.bind(new InetSocketAddress(8080));
		//设置为非阻塞模式 !!注意阻塞模式不可以使用Selector
		socketChannel.configureBlocking(false);
		
		//为socketChannel注册选择器
		Selector selector=Selector.open();
		/* SelectionKey.OP_ACCEPT 请求操作
		 * SelectionKey.OP_CONNECT 连接操作
		 * SelectionKey.OP_READ  读操作
		 * SelectionKey.OP_WRITE 写操作
		 * */
		socketChannel.register(selector,SelectionKey.OP_ACCEPT);
		
		//创建处理器
		Handler handler=new Handler(1024);
		while(true){
			//等待请求,每次等待阻塞3s，超过3s后线程继续向下运行，如果传入0或者不传参数将一直阻塞
			if(selector.select(3000)==0){
				System.out.println("等待请求超时。。。。。。");
				continue;
			}
			System.out.println("处理请求。。。。。");
			//获取待处理的SelectionKey
			Iterator<SelectionKey> keyIter=selector.selectedKeys().iterator();
			while(keyIter.hasNext()){
				SelectionKey key=keyIter.next();
				try {
					//接收到连接请求时
					if(key.isAcceptable()){
						handler.handlerRead(key);
					}
					//读数据
					if(key.isReadable()){
						handler.handlerRead(key);
					}
				} catch (Exception e) {
					keyIter.remove();
					continue;
				}
				keyIter.remove(); 
			}
		}
	}
}
