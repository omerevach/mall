package com.hit.server.dao;

import com.hit.server.dm.Shop;

import com.hit.algorithm.*;

public interface IShopDao {

	Graph<Shop> getGraph() throws Exception;

	void insertGraph(Graph<Shop> graph) throws Exception;
	
	void updateShop(String name, int deals) throws Exception;

	void deleteGraph() throws Exception;
	
	Shop getShopByName(String name) throws Exception;

	void insertConnection(Shop shopFrom,Shop shopTo) throws Exception;
	

}
