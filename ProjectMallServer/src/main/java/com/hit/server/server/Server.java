package com.hit.server.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import com.hit.server.service.MallContoller;
import com.hit.server.utils.Client;

public class Server {

	public int port;
	public volatile boolean stop;
	public ServerSocket server;
	public HandleRequest<String> handleRequest;
	
	public Server(int port) {
		stop=false;
		this.port=port;
		new Thread(()->{try {run();} catch (Exception e) {e.printStackTrace();}}).start();
	}
	
	public void stop() {
		stop=true;
	}
	
	public  void run() throws Exception {
		server=new ServerSocket(port);		
		System.out.println("You are connected to the server!");
	
		while(!stop){
				try{
					Socket client=server.accept();
					new HandleRequest<String>(client, new MallContoller()).handleClient();
					client.close();
			} catch (IOException e) {e.printStackTrace();}
		}
		
		server.close();
	}
}
