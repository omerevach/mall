package controller;

import java.io.IOException;

import com.hit.algorithm.*;
import com.hit.server.dao.*;
import com.hit.server.dm.*;
import com.hit.server.service.*;

public class Contoller{
	MallService service;
	ShopDaoFileImpl mallDao;

	public Contoller() throws IOException {
		service=new MallService(new AStarSearchAlgoImpl<>(new Graph<>()),new ShopDaoFileImpl("src/main/resources/datasource.txt"));
		mallDao=(ShopDaoFileImpl) service.getDatamanager();
	}
	
	public Graph<Shop> getGraph() {
		return mallDao.getGraph();
	}

	public void insertGraph(Graph<Shop> graph) throws Exception {
		mallDao.insertGraph(graph);
	}

	public void updateGraph(String name,int deals)  throws Exception{
		mallDao.updateShop(name, deals);
		
	}

	public void deleteGraph() throws IOException {
		mallDao.deleteGraph();
	}

}
