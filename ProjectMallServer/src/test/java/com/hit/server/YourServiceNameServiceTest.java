package com.hit.server;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hit.algorithm.Graph;
import com.hit.server.dao.ShopDaoFileImpl;
import com.hit.server.dm.Shop;

public class YourServiceNameServiceTest 
{
	 @Test
	    public void getShopByName() throws Exception
	    {	
		ShopDaoFileImpl shopDao = new ShopDaoFileImpl("src/main/resources/datasource.txt");
  	    Graph<Shop> graph =shopDao.getGraph();
	    assertEquals("Zara", shopDao.getShopByName("Zara").getName());
	    }
	 
	 @Test
	    public void updateShop() throws Exception
	    {	
		ShopDaoFileImpl shopDao = new ShopDaoFileImpl("src/main/resources/datasource.txt");
	    Graph<Shop> graph =shopDao.getGraph();
	    shopDao.updateShop("Zara", 20);
	    Shop shop = shopDao.getShopByName("Zara");
	    assertEquals(20,shop.getDeals());
	    }
	
  
}
