package model;

import com.hit.algorithm.Graph;
import com.hit.server.dm.Shop;

public class Model {
	public Graph<Shop> theMall;
	
	public Model() {
		theMall=new Graph<Shop>();
	}
}
