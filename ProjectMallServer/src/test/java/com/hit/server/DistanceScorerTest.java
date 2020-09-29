package com.hit.server;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.hit.server.dm.Shop;
import com.hit.server.enums.AreaEnum;
import com.hit.server.enums.FloorEnum;
import com.hit.server.utils.DistanceScorer;

public class DistanceScorerTest 
{
    
    @Test
    public void computeScoreTest1()
    {
    	
    	Shop shop1= new Shop("lee", FloorEnum.FLOOR_1, AreaEnum.AREA_A,5);
    	Shop shop2= new Shop("omer", FloorEnum.FLOOR_2, AreaEnum.AREA_C,10);
    	DistanceScorer scorer = new DistanceScorer();
        assertTrue("Wrong computation of the distance",scorer.computeScore(shop1,shop2)!=250.0);
    }
    
    @Test 
    public void computeScoreTest2() 
    {
    	
    	Shop shop1= new Shop("lee", FloorEnum.FLOOR_1, AreaEnum.AREA_B,5);
    	Shop shop2= new Shop("omer", FloorEnum.FLOOR_3, AreaEnum.AREA_C,10);
    	DistanceScorer scorer = new DistanceScorer();
        assertFalse("Wrong computation of the distance",scorer.computeScore(shop1,shop2)==250.0);
    }
    
}
