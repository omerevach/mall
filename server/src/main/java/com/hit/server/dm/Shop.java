package com.hit.server.dm;

import java.io.Serializable;

import com.hit.server.enums.AreaEnum;
import com.hit.server.enums.FloorEnum;

import algorithm.GraphNode;


public class Shop implements Serializable, GraphNode {
	private String name;
	private FloorEnum floor;
	private AreaEnum area;

	public Shop(String name, FloorEnum floor, AreaEnum area) {
		super();
		this.name=name;
		this.floor = floor;
		this.area = area;
		
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
	
	

}
