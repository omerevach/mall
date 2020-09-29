package com.hit.server.service;

import java.io.IOException;

import com.hit.algorithm.*;
import com.hit.server.dao.ShopDaoFileImpl;
import com.hit.server.dm.Shop;

public class MallContoller{
	MallService service;
	ShopDaoFileImpl mallDao;

	public MallContoller() throws IOException {
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
