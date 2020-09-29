package com.hit.server.server;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import com.google.gson.stream.JsonToken;
import com.hit.server.dm.Shop;

import com.hit.server.service.MallContoller;
import com.hit.algorithm.*;

public class HandleRequest<S> {
	Socket client;
	MallContoller controller;
	Scanner reader;
	PrintWriter writer;
	
	public HandleRequest(Socket client,MallContoller controller) throws IOException {
		this.client=client;
		this.controller=controller;
		this.reader = new Scanner(new InputStreamReader(client.getInputStream()));
		this.writer = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
	}
	
	public void handleClient() throws Exception {
		Request request=new Request(reader.toString());
		Response response = null;
		
		try {
			String name=null;
			String strValue=null;
			long numValue = 0;
			
		    while(request.jsonReader.hasNext()){
		        JsonToken nextToken = request.jsonReader.peek();
		        System.out.println(nextToken);

		        if(JsonToken.BEGIN_OBJECT.equals(nextToken)){

		        	request.jsonReader.beginObject();

		        } else if(JsonToken.NAME.equals(nextToken)){

		            name  =  request.jsonReader.nextName();
		            System.out.println(name);
		            
		        } else if(JsonToken.STRING.equals(nextToken)){

		        	strValue =  request.jsonReader.nextString();
		            System.out.println(strValue);

		        } else if(JsonToken.NUMBER.equals(nextToken)){

		        	numValue =  request.jsonReader.nextLong();
		            System.out.println(numValue);
		        }
		        
		    }
		    
		    switch (name) {
				case "GET": {
					response = new Response(controller.getGraph());
				}
				case "INSERT": {
					controller.insertGraph(new Graph<Shop>());
					response = new Response("Graph Inserted Successfuly!");
				}
				case "UPDATE": {
					controller.updateGraph(strValue,(int) numValue);
					response = new Response("Graph Updated Successfuly!");
				}
				case "DELETE": {
					controller.deleteGraph();
					response = new Response("Graph Deleted Successfuly!");
				}
		    }
		    writer.println(response);
		    writer.flush();

		} catch (IOException e) {
		    e.printStackTrace();
		}
		
	}

}
