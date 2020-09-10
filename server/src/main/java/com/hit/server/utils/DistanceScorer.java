package com.hit.server.utils;

import com.hit.server.dm.Shop;

import algorithm.Scorer;


public class DistanceScorer implements Scorer<Shop> {
	
	 public DistanceScorer() {}

	@Override
	public double computeScore(Shop from, Shop to) {
		double sectionDistance = (to.getArea().ordinal() - from.getArea().ordinal()) * 100;
		double floorDistance = (to.getFloor().ordinal() - from.getFloor().ordinal()) * 50;
		return sectionDistance + floorDistance;
	}

}
