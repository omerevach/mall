package com.hit.server.server;

import com.google.gson.Gson;

public class Response{
	public String json;

	public <Type> Response(Type tojson) {
		json = new Gson().toJson(tojson);
	}

}

