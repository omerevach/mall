package com.hit.server.server;

import java.io.StringReader;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class Request{
	public JsonReader jsonReader;
	public Gson json;
	
	public Request(String req) {
		jsonReader = new JsonReader(new StringReader(req));
	}
	
	public Request(Object req) {
		json=new Gson();
		json.toJson(req);
	}
}
