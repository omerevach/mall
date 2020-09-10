package com.hit.server.dm;

import java.util.List;

import com.hit.server.enums.AreaEnum;
import com.hit.server.enums.FloorEnum;

import algorithm.AStarSearchAlgoImpl;
import algorithm.BFSSearchAlgoImpl;
import algorithm.Graph;

public class Main {

	public static void main(String[] args) {
		Graph<Shop> mall =new Graph<Shop>();
//		graph.addConnection(new Shop("hello world", FloorEnum.FLOOR_1, AreaEnum.AREA_A) , new Shop("zleae", FloorEnum.FLOOR_1, AreaEnum.AREA_A));
		Shop shop= new Shop("zleae", FloorEnum.FLOOR_1, AreaEnum.AREA_A);
		Shop shop2= new Shop("zleae2", FloorEnum.FLOOR_2, AreaEnum.AREA_C);
		Shop shop3= new Shop("sun", FloorEnum.FLOOR_2, AreaEnum.AREA_C);
		Shop shop4= new Shop("omer", FloorEnum.FLOOR_2, AreaEnum.AREA_A);
		mall.addConnection(shop,shop2);
		mall.addConnection(shop3, shop2);
		mall.addConnection(shop2, shop4);
		BFSSearchAlgoImpl<Shop> bfs=new BFSSearchAlgoImpl<>(mall);
		List<Shop> solB = bfs.findRoute(shop, shop4);
		System.out.println("BFS SUCCSSESS");
		
		AStarSearchAlgoImpl<Shop> astr=new AStarSearchAlgoImpl<Shop>(mall) ;
		List<Shop> solA = astr.findRoute(shop, shop4);
		System.out.println("Astar SUCCSSESS");
		
	}
}



//		graph.addConnection(new Shop("omer", FloorEnum.FLOOR_1, AreaEnum.AREA_A), new Shop("lee", FloorEnum.FLOOR_2, AreaEnum.AREA_B));
		
		
//		AStarSearchAlgoImpl<GraphNode> stam = new AStarSearchAlgoImpl<GraphNode>(graph,,);
//		System.out.println(stam);
	    
//	    List<Shop> list=new ArrayList<Shop>();
//		BFSSearchAlgoImpl<GraphNode> stam2 = new BFSSearchAlgoImpl(graph);
//		stam2.findRoute(shop, shop2);
		
		

		
//		FileReader in = null;
//		FileWriter out = null;
//		try {
//			out=new FileWriter("resources/omer.txt");
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try {
//			out.write(graph);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try {
//			out.close();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
		
		
		
		
//		FileOutputStream fileOutputStream;
//		try {
//			fileOutputStream = new FileOutputStream("omer.txt");
//			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//			objectOutputStream.writeObject(graph);
//			objectOutputStream.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		ShopDaoFileImpl daoFileImpl = new ShopDaoFileImpl();
//		graph=daoFileImpl.getShopGraph();
//		System.out.println("test");
//	}
//
//	private static AStarSearchAlgoImpl<GraphNode> AStarSearchAlgoImpl(Graph<Shop> graph, , ) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
	//}
		


//Shop shop1= new Shop("lee", FloorEnum.FLOOR_1, AreaEnum.AREA_A);
//Shop shop2= new Shop("omer", FloorEnum.FLOOR_2, AreaEnum.AREA_C);
//AStarSearchAlgoImp<T> asaf = new AStarSearchAlgoImp<T>()

















