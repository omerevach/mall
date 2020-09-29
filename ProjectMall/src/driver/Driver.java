package driver;

import com.hit.server.server.Server;
import com.hit.server.utils.Client;

public class Driver {
	public static void main(String[] args) {
		Client client = new Client(System.in,System.out);
		Server server = new Server(34567);
		
		client.addPropertyChangeListenre(server);
		new Thread(client).start();
	}
}

