package com.oneday.nioSocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class Handler {
	private int  bufferSzie=1024;
	private String localCharset="UTF-8";
	public Handler(){}
	public Handler(int bufferSzie){
		this(bufferSzie,null);
	}
	public Handler(String localCharset) {
		this(-1,localCharset);
	}
	public Handler(int bufferSzie, String localCharset) {
		if(bufferSzie>0){
			this.bufferSzie=bufferSzie;
		}
		if(localCharset!=null){
			this.localCharset=localCharset;
		}
	}
	
	public void handlerAccept(SelectionKey key) throws IOException{
		SocketChannel sc=((ServerSocketChannel) key.channel()).accept();
		sc.configureBlocking(false);
		sc.register(key.selector(),SelectionKey.OP_READ,ByteBuffer.allocate(bufferSzie));
	}
	
	public void handlerRead(SelectionKey key) throws IOException{
		//获取channel
		SocketChannel sc=(SocketChannel) key.channel();
		//获取buffer并重置
		ByteBuffer buffer=(ByteBuffer) key.attachment();
		buffer.clear();
		//没有读取到内容则关闭
		if(sc.read(buffer)==-1){
			sc.close();
		}else{
			//将buffer转换为读状态
			buffer.flip();
			//将buffer中接收的值按localCharset格式编码后保存到receivedString
			String  receivedString=Charset.forName(localCharset).newDecoder()
					.decode(buffer).toString();
			System.out.println("received from client:"+receivedString);
			//返回数据给客户端
			String sendString="received data: "+receivedString;
			buffer=ByteBuffer.wrap(sendString.getBytes(localCharset));
			sc.write(buffer);
			//关闭Socket
			sc.close();
			
		}
		
	}
}
