package com.hit.server.dm;

import java.io.Serializable; 

import com.hit.server.enums.AreaEnum;
import com.hit.server.enums.FloorEnum;
import com.hit.algorithm.*;


@SuppressWarnings("serial")
public class Shop implements Serializable, GraphNode,Scorer<GraphNode>{
	private String name;
	private FloorEnum floor;
	private AreaEnum area;
	private int deals;
	

	public Shop(String name, FloorEnum floor, AreaEnum area,int deals) {
		super();
		this.name=name;
		this.floor = floor;
		this.area = area;
		this.deals=deals;
	}

	public String getName() {
		return this.name;
	}

	public FloorEnum getFloor() {
		return floor;
	}

	public void setFloor(FloorEnum floor) {
		this.floor = floor;
	}

	public AreaEnum getArea() {
		return area;
	}

	public void setArea(AreaEnum area) {
		this.area = area;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getDeals() {
		return deals;
	}

	public void setDeals(int deals) {
		this.deals = deals;
	}

	@Override
	public double computeScore(GraphNode arg0, GraphNode arg1) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
