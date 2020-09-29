package com.hit.server.dm;

import java.util.List; 

import com.hit.server.enums.AreaEnum;
import com.hit.server.enums.FloorEnum;

import com.hit.algorithm.*;


public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Graph<Shop> mall =new Graph<Shop>();
		Shop shop= new Shop("zleae", FloorEnum.FLOOR_1, AreaEnum.AREA_A,5);
		Shop shop2= new Shop("zleae2", FloorEnum.FLOOR_2, AreaEnum.AREA_C,7);
		Shop shop3= new Shop("sun", FloorEnum.FLOOR_2, AreaEnum.AREA_C,0);
		Shop shop4= new Shop("omer", FloorEnum.FLOOR_2, AreaEnum.AREA_A,20);
		mall.addConnection(shop,shop2);
		mall.addConnection(shop3, shop2);
		mall.addConnection(shop2, shop4);
		
		BFSSearchAlgoImpl<Shop> bfs=new BFSSearchAlgoImpl<>(mall);
		List<Shop> solB = bfs.findRoute(shop, shop4);
		System.out.println("BFS SUCCSSESS");
		
		Scorer<Shop> targetShop=new Scorer<Shop>() { 
			@Override
			public double computeScore(Shop arg0, Shop arg1) {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		Scorer<Shop> nextShop=new Scorer<Shop>() { 
			@Override
			public double computeScore(Shop arg0, Shop arg1) {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		
		AStarSearchAlgoImpl<Shop> astr=new AStarSearchAlgoImpl<Shop>(mall,nextShop,targetShop) ;
		List<Shop> solA = astr.findRoute(shop, shop4);
		System.out.println("Astar SUCCSSESS");
		
	}
}








