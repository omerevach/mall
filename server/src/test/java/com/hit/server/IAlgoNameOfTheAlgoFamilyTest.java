package com.hit.server;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.hit.server.dm.Shop;
import com.hit.server.enums.AreaEnum;
import com.hit.server.enums.FloorEnum;
import com.hit.server.utils.DistanceScorer;

import algorithm.BFSSearchAlgoImpl;
import algorithm.Graph;

public class IAlgoNameOfTheAlgoFamilyTest {

	  @Test 
	    public void BFSTest() 
	    {
		    Graph<Shop> mall =new Graph<Shop>();
			Shop shop= new Shop("zleae", FloorEnum.FLOOR_1, AreaEnum.AREA_A);
			Shop shop2= new Shop("zleae2", FloorEnum.FLOOR_2, AreaEnum.AREA_C);
			Shop shop3= new Shop("sun", FloorEnum.FLOOR_2, AreaEnum.AREA_C);
			Shop shop4= new Shop("omer", FloorEnum.FLOOR_2, AreaEnum.AREA_A);
			mall.addConnection(shop,shop2);
			mall.addConnection(shop3, shop2);
			mall.addConnection(shop2, shop4);
			mall.addConnection(shop4, shop);
			BFSSearchAlgoImpl<Shop> bfs=new BFSSearchAlgoImpl<>(mall);
			List<Shop> temp=bfs.findRoute(shop, shop4);

			assertFalse("Wrong path",!temp.get(0).equals(shop2));
			
	    }

	  @Test 
	    public void BFSTest2() 
	    {
		    Graph<Shop> mall =new Graph<Shop>();
			Shop shop= new Shop("zleae", FloorEnum.FLOOR_1, AreaEnum.AREA_A);
			Shop shop2= new Shop("zleae2", FloorEnum.FLOOR_2, AreaEnum.AREA_C);
			Shop shop3= new Shop("sun", FloorEnum.FLOOR_2, AreaEnum.AREA_C);
			Shop shop4= new Shop("omer", FloorEnum.FLOOR_2, AreaEnum.AREA_A);
			mall.addConnection(shop,shop2);
			mall.addConnection(shop3, shop2);
			mall.addConnection(shop2, shop4);
			mall.addConnection(shop4, shop);
			BFSSearchAlgoImpl<Shop> bfs=new BFSSearchAlgoImpl<>(mall);
			List<Shop> temp=bfs.findRoute(shop, shop4);

			assertTrue("True path",temp.get(1).equals(shop));
}
}
