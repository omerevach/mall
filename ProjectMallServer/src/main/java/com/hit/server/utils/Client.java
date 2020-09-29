package com.hit.server.utils;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import com.google.gson.Gson;
import com.hit.algorithm.Graph;
import com.hit.server.dm.Shop;
import com.hit.server.enums.AreaEnum;
import com.hit.server.enums.FloorEnum;
import com.hit.server.server.Request;
import com.hit.server.server.Response;
import com.hit.server.server.Server;

public class Client implements Runnable {
	public PrintWriter writer;
	public Scanner reader;
	public Socket myServerSocket;
	public Server server;
	public Graph<Shop> theMall;
	public volatile boolean stop;
	
	public Client(InputStream in, PrintStream out) {
		writer=new PrintWriter(out);
		reader=new Scanner(in);
		stop=false;
		theMall=new Graph<Shop>();
	}


	public void addPropertyChangeListenre(Server server) {
		this.server=server;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void run() {
		try{
			Request request=new Request(theMall);
			Response response;
			Socket myServer = new Socket("localhost", server.port);
			System.out.println("Client is connected to server!");
			
			PrintWriter output=new PrintWriter(myServer.getOutputStream());
			Scanner input=new Scanner(myServer.getInputStream());

			while(!stop) {
			output.println(request);
			output.flush();
			
			response=new Response(input.nextLine());
			System.out.println(response);
//			String s = input.nextLine();
//			Graph<Shop> mall = gson.fromJson(s,Graph.class);
			
			
			output.close();
			input.close();
			myServer.close();
			}			

		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
