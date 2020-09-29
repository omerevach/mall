package com.hit.server.utils;

import com.hit.server.server.*;

public class Driver {

	public static void main(String[] args) {
		Server server = new Server(40000);
		Client client = new Client(System.in,System.out);
		
		client.addPropertyChangeListenre(server);
		new Thread(client).start();
	}
}
