package com.hit.server;

import com.hit.server.dao.ShopDaoFileImpl;
import com.hit.server.dm.Shop;
import com.hit.server.enums.AreaEnum;
import com.hit.server.enums.FloorEnum;

import algorithm.Graph;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        try {
			ShopDaoFileImpl shopDao = new ShopDaoFileImpl();
			Graph<Shop> graph = new Graph<Shop>();
			graph.addConnection(new Shop("Zara", FloorEnum.FLOOR_1, AreaEnum.AREA_A), new Shop("Castro", FloorEnum.FLOOR_1, AreaEnum.AREA_A));
			shopDao.createGraph(new Graph<Shop>());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
    }
}
