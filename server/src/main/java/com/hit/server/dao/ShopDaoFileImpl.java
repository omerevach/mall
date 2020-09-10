package com.hit.server.dao;

import java.io.File; 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import com.hit.server.dm.*;



import algorithm.Graph;


public class ShopDaoFileImpl implements IShopDao {
	private FileInputStream input;
	private FileOutputStream output;
	private ObjectInputStream objectInputStream;
	private ObjectOutputStream objectOutputStream;
	
	public ShopDaoFileImpl() throws IOException {
		input  = new FileInputStream("/server/src/main/resources/datasource.txt‬");
		output = new FileOutputStream("/server/src/main/resources/datasource.txt‬");

		objectOutputStream= new ObjectOutputStream(new FileOutputStream("/server/src/main/resources/datasource.txt‬"));
		objectInputStream= new ObjectInputStream(new FileInputStream("/server/src/main/resources/datasource.txt‬"));
	}

	@Override
	public Graph<Shop> getGraph()  {
		try {
			Graph<Shop> graph = (Graph<Shop>) objectInputStream.readObject();
			return graph;
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public Shop getShopByName(String name) throws Exception {
		Shop res=null;
		List<Shop> result = new ArrayList<>();
		
		while (objectInputStream.available()>0) {
			   result.add((Shop)objectInputStream.readObject());
		}

		for(int i=0; i<result.size();i++) {
			if(result.get(i).getName().equals(name)) 
				res=result.get(i);
		}
		
		return res;
	}
	

	@Override
	public void updateShop(String name, Shop shop) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteShop(String name) {
		
		List<Shop> result = new ArrayList<>();
		
		try {
			while (objectInputStream.available()>0) {
				   result.add((Shop)objectInputStream.readObject());
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for(int i=0; i<result.size();i++) {
			if(result.get(i).getName().equals(name)) 
				break;
			else
			{
				try {
					objectOutputStream.writeObject(result.get(i));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

//	@Override
//	public void createShopConnection(Shop from, Shop to) throws Exception {
//		Graph<Shop> graph = getShopGraph();
//		graph.addConnection(from, to);
//		
//		createGraph(graph);
//	}

	@Override
	public void insertGraph(Graph<Shop> graph) throws Exception {
		cleanFile();
		objectOutputStream.writeObject(graph);
		objectOutputStream.flush();
	}
	
	@Override
	public void	insertShop(Shop shop) throws Exception {
		cleanFile();
		objectOutputStream.writeObject(shop);
		objectOutputStream.flush();
	}
	
	public void closeConnection() throws Exception {
		objectInputStream.close();
		objectOutputStream.close();
		input.close();
		output.close();
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

}
