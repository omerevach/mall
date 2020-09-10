package com.hit.server.service;

import com.hit.server.dao.IShopDao;

import algorithm.AStarSearchAlgoImpl;
import algorithm.BFSSearchAlgoImpl;
import algorithm.ISearchAlgo;

public class MallService {
	
	private ISearchAlgo algosearch;
	private IShopDao datamanager;
	
	
	public MallService(ISearchAlgo algosearch, IShopDao datamanager) {
		this.algosearch = algosearch;
		this.datamanager = datamanager;
	}


	public ISearchAlgo getAlgosearch() {
		return algosearch;
	}


	public void setAlgosearch(ISearchAlgo algosearch) {
		this.algosearch = algosearch;
	}


	public IShopDao getDatamanager() {
		return datamanager;
	}


	public void setDatamanager(IShopDao datamanager) {
		this.datamanager = datamanager;
	}
	
	
	
}


