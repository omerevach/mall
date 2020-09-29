package com.hit.server.dao;
 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.hit.server.dm.*;
import com.hit.algorithm.*;

@SuppressWarnings("unused")
public class ShopDaoFileImpl implements IShopDao {

	private FileInputStream input;
	private FileOutputStream output;
	
	private ObjectInputStream objectInputStream;
	private ObjectOutputStream objectOutputStream;
	
	private String filepath;
	
	public ShopDaoFileImpl(String pathFile) throws IOException { 
		filepath=pathFile;
	}
	// --------------- Graph edit ------------------- // 
	
	@SuppressWarnings("unchecked")
	@Override
	public Graph<Shop> getGraph()  {
		try {
			objectInputStream = new ObjectInputStream(new FileInputStream("out.txt"));
//			objectInputStream = new ObjectInputStream(new FileInputStream(filepath));
			//FileInputStream in = new FileInputStream(filepath);
			//objectInputStream = new ObjectInputStream(in);
			Graph<Shop> graph = (Graph<Shop>) objectInputStream.readObject();
			objectInputStream.close();
			return graph;
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public void insertGraph(Graph<Shop> graph) throws Exception {
		FileOutputStream out = new FileOutputStream(filepath);
		objectOutputStream = new ObjectOutputStream(out);
		objectOutputStream.writeObject(graph);
		objectOutputStream.close();
	}
	
	@Override
	public void updateShop(String name,int deals) throws Exception {
		Graph<Shop> graph = getGraph();
		Shop shop = graph.getNode(name);
		shop.setDeals(deals);
		output = new FileOutputStream(filepath);
		objectOutputStream = new ObjectOutputStream(output);
		objectOutputStream.writeObject(graph);
		objectOutputStream.close();
	}
	
	public void deleteGraph() throws IOException {
		objectOutputStream.reset();
		objectOutputStream.close();
	}

	
	// --------------- Shop data ------------------- // 
	
	@Override
	public Shop getShopByName(String name) throws Exception {
		Graph<Shop> graph = getGraph();
		Shop shop = graph.getNode(name);
		return shop;
		
	}
	
	@Override
	public void	insertConnection(Shop shopFrom,Shop shopTo) throws Exception {
		Graph<Shop> graph = getGraph();
		graph.addConnection(shopFrom, shopTo);
		output = new FileOutputStream(filepath);
		objectOutputStream = new ObjectOutputStream(output);
		objectOutputStream.writeObject(graph);
		objectOutputStream.close();
	}

}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	@Override
//	public List<Shop> getAllShops() {
//		FileInputStream inputStream;
//		try {
//			inputStream = new FileInputStream("‪/server/resources/datasource.txt‬");
//			ObjectInputStream objectInputStream =new ObjectInputStream(inputStream);
//			ArrayList<Shop> shops =new ArrayList();
//			shops=(ArrayList<Shop>) objectInputStream.readObject();
//			objectInputStream.close();
//			inputStream.close();
//			return shops;
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//		
//		
//	}

//	@Override
//	public Shop getShopByName(String name) {
//		ArrayList<Shop> shops =new ArrayList();
//		shops=(ArrayList<Shop>) this.getAllShops();
//		for (Shop shop: shops) {
//			if(shop.getName().equals(name))
//				return shop;
//		}
//		return null;
				
//	}
//
//	@Override
//	public void createShop(Shop shop) {
//		ArrayList<Shop> shops =new ArrayList();
//		shops=(ArrayList<Shop>) this.getAllShops();
//		shops.add(shop);
//		FileOutputStream fileOutputStream;
//		try {
//			fileOutputStream = new FileOutputStream("‪/server/resources/datasource.txt‬");
//			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//			objectOutputStream.writeObject(shops);
//			objectOutputStream.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//
//
//	}

//	@Override
//	public void updateShop(String name, Shop shop) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void deleteShop(String name) {
//		ArrayList<Shop> shops =new ArrayList();
//		shops=(ArrayList<Shop>) this.getAllShops();
//		for (int i = 0; i < shops.size(); i++) {
//			if(shops.get(i).getName().equals(name))
//				shops.remove(i);
//		}
//		FileOutputStream fileOutputStream;
//		try {
//			fileOutputStream = new FileOutputStream("‪/server/resources/datasource.txt‬");
//			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//			objectOutputStream.writeObject(shops);
//			objectOutputStream.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		
//	}


