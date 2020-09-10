package com.hit.server.dao;

import com.hit.server.dm.Shop;

import algorithm.Graph;

public interface IShopDao {

	Graph<Shop> getGraph() throws Exception;

	Shop getShopByName(String name) throws Exception;

//	void createShopConnection(Shop from, Shop to) throws Exception;

	void insertGraph(Graph<Shop> graph) throws Exception;
	
	void insertShop(Shop shop) throws Exception;

	void updateShop(String name, Shop shop);

	void deleteShop(String name);

}
