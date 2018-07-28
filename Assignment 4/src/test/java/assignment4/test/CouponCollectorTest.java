package assignment4.test;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import assignment4.BdayProblem;
import org.junit.Test;

import assignment4.CouponCollector;

import static org.junit.Assert.*;

/**
 *
 * @author aMaha
 */
public class CouponCollectorTest {
    @Test public void testHashTable0() {
         CouponCollector<String, Integer> hashTable = new CouponCollector<String, Integer>(2);
        assertEquals(0,hashTable.size());
       
    }
    @Test public void testHashTable1() {
         CouponCollector<String, Integer> hashTable = new CouponCollector<String, Integer>(2);
        hashTable.put("Hello0",1);
        hashTable.put("Hello1",2);
        assertEquals(2,hashTable.size());
        assertNotNull(hashTable.get("Hello0"));
        assertNotNull(hashTable.get("Hello1"));

    }
}
