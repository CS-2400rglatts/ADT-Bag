package com.example;
/**
 *
 * @author Rebecca Glatts
 * Tests union, intersection, and difference methods within ResizeableArrayBag
 */


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import com.bagadt.BagInterface;
import com.bagadt.LinkedBag;
import com.bagadt.ResizeableArrayBag;


public class ResizeableArrayBagTest {
    
    /** Tests method union with duplicants in each bag in the class ResizeableArrayBag 
     * 
    */
    @Test
    public void testUnionDupesResizeable() {
        BagInterface < String > bag1 = new ResizeableArrayBag < >();
        BagInterface < String > bag2 = new ResizeableArrayBag < >();
        BagInterface < String > bag3 = new ResizeableArrayBag < >();
    
        bag1.add("1");
        bag1.add("2");
        bag1.add("3");
    
        bag2.add("1");
        bag2.add("3");
        bag2.add("5");
        bag2.add("7");
        
        BagInterface<String> everything = bag1.union(bag2);
    
        bag3.add("1");
        bag3.add("2");
        bag3.add("3");
       
        bag3.add("1");
        bag3.add("3");
        bag3.add("5");
        bag3.add("7");
        
        Object[] array1 = new Object[8];
        array1 = everything.toArray();
        Object[] array2 = new Object[8];
        array2 = bag3.toArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        assertTrue(Arrays.equals(array1, array2));   
    }

    /**
     * Tests whether union works with no duplicants in either bag in ResizeableArrayBag
     */
    @Test
    public void testResizeableUnionNoDupes() {
        BagInterface < String > bag1 = new ResizeableArrayBag < >();
        BagInterface < String > bag2 = new ResizeableArrayBag < >();
        BagInterface < String > expected = new ResizeableArrayBag < >();
    
        bag1.add("1");
        bag1.add("2");
        bag1.add("3");
        bag1.add("4");
        
        bag2.add("5");
        bag2.add("6");
        bag2.add("7");
        bag2.add("8");

        expected.add("1");
        expected.add("2");
        expected.add("3");
        expected.add("4");
        expected.add("5");
        expected.add("6");
        expected.add("7");
        expected.add("8");
      
        BagInterface<String> everything = bag1.union(bag2);
        Object[] array1 = new Object[8];
        array1 = everything.toArray();
        Object[] array2 = new Object[8];
        array2 = expected.toArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        assertTrue(Arrays.equals(array1, array2));  
    }
       
    /**
     * Tests whether union works correctly if one of the bags is empty in ResizeableArrayBag
     */
    @Test
    public void testResizeableUnionEmptyBag() {
        BagInterface < String > bag1 = new ResizeableArrayBag < >();
        BagInterface < String > bag2 = new ResizeableArrayBag < >();
        BagInterface < String > expected = new ResizeableArrayBag < >();
        
        
        bag1.add("1");
        bag1.add("2");
        bag1.add("3");
        bag1.add("3");
        
        BagInterface<String> everything = bag1.union(bag2);
    
        expected.add("1");
        expected.add("2");
        expected.add("3");
        expected.add("3");
    
    
        Object[] array1 = new Object[8];
        array1 = everything.toArray();
        Object[] array2 = new Object[8];
        array2 = expected.toArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        assertTrue(Arrays.equals(array1, array2));   
    }
    /**
     * Tests whether union works with both bags empty
     */
    @Test
    public void testResizeableUnionBothEmpty() {
        BagInterface < String > bag1 = new ResizeableArrayBag < >();
        BagInterface < String > bag2 = new ResizeableArrayBag < >();
        BagInterface<String> everything = bag1.union(bag2);

        assertNull(everything);
    }

    /**
     * Tests whether union works when the first bag is larger than the other
     */
    @Test
    public void testResizeableUnionBag1LargerBag2() {
        BagInterface < String > bag1 = new ResizeableArrayBag < >();
        BagInterface < String > bag2 = new ResizeableArrayBag < >();
        BagInterface < String > expected = new ResizeableArrayBag < >();
        
        
        bag1.add("1");
        bag1.add("2");
        bag1.add("1");

        bag2.add("5");
        bag2.add("7");
    
        expected.add("1");
        expected.add("2");
        expected.add("1");
        expected.add("5");
        expected.add("7");
    
        BagInterface<String> everything = bag1.union(bag2);
        Object[] array1 = new Object[8];
        array1 = everything.toArray();
        Object[] array2 = new Object[8];
        array2 = expected.toArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        assertTrue(Arrays.equals(array1, array2));      
    }

    /**
     * Tests whether union works when the second bag is larger than the first in ResizeableArrayBag
     */
    @Test
    public void testUnionBag2LargerBag1ablResizee() {
        BagInterface < String > bag1 = new ResizeableArrayBag < >();
        BagInterface < String > bag2 = new ResizeableArrayBag < >();
        BagInterface < String > expected = new ResizeableArrayBag < >();
       
        
        bag2.add("1");
        bag2.add("2");
        bag2.add("3");
        
        bag1.add("1");

        expected.add("1");
        expected.add("2");
        expected.add("3");
        expected.add("1");

        BagInterface<String> everything = bag1.union(bag2);
        Object[] array1 = new Object[8];
        array1 = everything.toArray();
        Object[] array2 = new Object[8];
        array2 = expected.toArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        assertTrue(Arrays.equals(array1, array2));   
    }
     /**
     * Tests whether union works when the second bag is a LinkedBag in ResizeableArrayBag
     */
    @Test
    public void testResizeableUnionWithLinkedBag() {
        BagInterface < String > bag1 = new ResizeableArrayBag < >();
        BagInterface < String > bag2 = new LinkedBag < >();
        BagInterface < String > expected = new ResizeableArrayBag < >();
        
        
        bag2.add("1");
        bag2.add("2");
        bag2.add("3");
        
        bag1.add("1");
        bag2.add("4");

        expected.add("1");
        expected.add("2");
        expected.add("3");
        expected.add("1");
        expected.add("4");

        BagInterface<String> everything = bag1.union(bag2);
        Object[] array1 = new Object[8];
        array1 = everything.toArray();
        Object[] array2 = new Object[8];
        array2 = expected.toArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        assertTrue(Arrays.equals(array1, array2));   
    }

    /**
     * Tests whether intersection works when there are duplicates in the bags in ResizeableArrayBag
     */
    @Test
    public void testResizeableIntersectionDupes() {
        BagInterface < String > bag1 = new ResizeableArrayBag < >();
        BagInterface < String > bag2 = new ResizeableArrayBag < >();
        BagInterface < String > expected = new ResizeableArrayBag < >();
        
        bag1.add("1");
        bag1.add("5");
        bag2.add("1");
        bag2.add("2");
        bag2.add("3");
        bag2.add("4");

        expected.add("1");
        expected.add("5");
        expected.add("1");
        expected.add("2");
        expected.add("3");
        expected.add("4");
        BagInterface<String> commonItems = bag1.intersection(bag2);
        Object[] array1 = new Object[8];
        array1 = commonItems.toArray();
        Object[] array2 = new Object[8];
        array2 = expected.toArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        assertTrue(Arrays.equals(array1, array2));   
    }

    /**
     * Tests whether intersection works when there are no duplicates in the bags in ResizeableArrayBag
     */
    @Test
    public void testResizeableIntersectionNoDupes() {
        BagInterface < String > bag1 = new ResizeableArrayBag < >();
        BagInterface < String > bag2 = new ResizeableArrayBag < >();
        BagInterface < String > expected = new ResizeableArrayBag < >();
        
        bag1.add("1");
        bag1.add("5");
        bag2.add("2");
        bag2.add("3");
        bag2.add("4");

        expected.add("1");
        expected.add("5");
        expected.add("2");
        expected.add("3");
        expected.add("4");

        BagInterface<String> commonItems = bag1.intersection(bag2);
        
        Object[] array1 = new Object[8];
        array1 = commonItems.toArray();
        Object[] array2 = new Object[8];
        array2 = expected.toArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        assertTrue(Arrays.equals(array1, array2));   
    }

    /**
     * Tests whether intersection works when there is an empty bag in ResizeableArrayBag
     */
    @Test
    public void testResizeableIntersectionEmptyBag() {
        BagInterface < String > bag1 = new ResizeableArrayBag < >();
        BagInterface < String > bag2 = new ResizeableArrayBag < >();
        BagInterface < String > expected = new ResizeableArrayBag < >();
        
        bag1.add("1");
        bag1.add("5");
        expected.add("1");
        expected.add("5");
        
        BagInterface<String> commonItems = bag1.intersection(bag2);
        Object[] array1 = new Object[8];
        array1 = commonItems.toArray();
        Object[] array2 = new Object[8];
        array2 = expected.toArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        assertTrue(Arrays.equals(array1, array2));   
    }

    

     /**
     * Tests whether intersection works when both bags are empty in ResizeableArrayBag
     */
    @Test
    public void testResizeableIntersectionBothEmpty() {
        BagInterface < String > bag1 = new ResizeableArrayBag < >();
        BagInterface < String > bag2 = new ResizeableArrayBag < >();
        BagInterface < String > expected = new ResizeableArrayBag < >();
        BagInterface<String> commonItems = bag1.intersection(bag2);
        
        
        Object[] array1 = new Object[8];
        array1 = commonItems.toArray();
        Object[] array2 = new Object[8];
        array2 = expected.toArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        assertTrue(Arrays.equals(array1, array2));   
    }

     /**
     * Tests whether intersection works when bag1 is larger than bag2 in ResizeableArrayBag
     */
    @Test
    public void testResizeableIntersectionBag1Larger() {
        BagInterface < String > bag1 = new ResizeableArrayBag < >();
        BagInterface < String > bag2 = new ResizeableArrayBag < >();
        BagInterface < String > expected = new ResizeableArrayBag < >();
        
        bag1.add("1");
        bag1.add("5");
        bag2.add("1");
        expected.add("1");
        expected.add("5");
        expected.add("1");
        BagInterface<String> commonItems = bag1.intersection(bag2);
        
        Object[] array1 = new Object[8];
        array1 = commonItems.toArray();
        Object[] array2 = new Object[8];
        array2 = expected.toArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        assertTrue(Arrays.equals(array1, array2));   
    }

      /**
     * Tests whether intersection works when bag2 is larger than bag1 in ResizeableArrayBag
     */
    @Test
    public void testResizeableIntersectionBag2Larger() {
        BagInterface < String > bag1 = new ResizeableArrayBag < >();
        BagInterface < String > bag2 = new ResizeableArrayBag < >();
        BagInterface < String > expected = new ResizeableArrayBag < >();
        
        bag1.add("1");
        bag1.add("5");
        bag2.add("1");
        BagInterface<String> commonItems = bag1.intersection(bag2);
        Object[] array1 = new Object[8];
        array1 = commonItems.toArray();
        Object[] array2 = new Object[8];
        array2 = expected.toArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        assertTrue(Arrays.equals(array1, array2));   
    }

     /**
     * Tests whether intersection works when the second bag is a LinkedBag in ResizeableArrayBag
     */
    @Test
    public void testResizeableIntersectionWithLinkedBag() {
        BagInterface < String > bag1 = new ResizeableArrayBag < >();
        BagInterface < String > bag2 = new LinkedBag < >();
        BagInterface < String > expected = new ResizeableArrayBag < >();
        
        
        bag2.add("1");
        bag2.add("2");
        bag2.add("3");
        bag2.add("4");
        
        bag1.add("1");
        bag1.add("4");

        expected.add("1");
        expected.add("2");
        expected.add("3");
        expected.add("4");
        expected.add("1");
        expected.add("4");
        
        BagInterface<String> commonItems = bag1.intersection(bag2);
        Object[] array1 = new Object[8];
        array1 = commonItems.toArray();
        Object[] array2 = new Object[8];
        array2 = expected.toArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        assertTrue(Arrays.equals(array1, array2));   
    }

     /**
     * Tests whether difference works when there are duplicants in the bags in ResizeableArrayBag
     */
    @Test
    public void testResizeableDifferenceDupes() {
        BagInterface < String > bag1 = new ResizeableArrayBag < >();
        BagInterface < String > bag2 = new ResizeableArrayBag < >();
        BagInterface < String > expected1 = new ResizeableArrayBag < >();
        BagInterface < String > expected2 = new ResizeableArrayBag < >();
          
        bag1.add("1");
        bag1.add("2");
        bag1.add("3");
        bag1.add("4");
        
        bag2.add("1");
        bag2.add("4");
        bag2.add("5");

        expected1.add("2");
        expected1.add("3");

        expected2.add("5");
   
        BagInterface<String> leftOver1 = bag1.difference(bag2);
        BagInterface<String> leftOver2 = bag2.difference(bag1);

    
        Object[] array1 = new Object[8];
        array1 = leftOver1.toArray();
        Object[] array2 = new Object[8];
        array2 = expected1.toArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        assertTrue(Arrays.equals(array1, array2));
        array1 = leftOver2.toArray();
        array2 = expected2.toArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        assertTrue(Arrays.equals(array1, array2));
    }

     /**
     * Tests whether difference works when there are no duplicants in the bags in ResizeableArrayBag
     */
    @Test
    public void testResizeableDifferenceNoDupes() {
        BagInterface < String > bag1 = new ResizeableArrayBag < >();
        BagInterface < String > bag2 = new ResizeableArrayBag < >();
        BagInterface < String > expected1 = new ResizeableArrayBag < >();
        BagInterface < String > expected2 = new ResizeableArrayBag < >();
          
        bag1.add("1");
        bag1.add("2");
        bag1.add("3");
        bag1.add("4");
        
        bag2.add("5");
        bag2.add("6");
        bag2.add("7");
        
        expected1.add("1");
        expected1.add("2");
        expected1.add("3");
        expected1.add("4");

        expected2.add("5");
        expected2.add("6");
        expected2.add("7");

        BagInterface<String> leftOver1 = bag1.difference(bag2);
        BagInterface<String> leftOver2 = bag2.difference(bag1);

    
        Object[] array1 = new Object[8];
        array1 = leftOver1.toArray();
        Object[] array2 = new Object[8];
        array2 = expected1.toArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        assertTrue(Arrays.equals(array1, array2));
        array1 = leftOver2.toArray();
        array2 = expected2.toArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        assertTrue(Arrays.equals(array1, array2));
    }

     /**
     * Tests whether difference works when bag1 is larger than bag2 in ResizeableArrayBag
     */
    @Test
    public void testResizeableDifferenceBag1Larger() {
        BagInterface < String > bag1 = new ResizeableArrayBag < >();
        BagInterface < String > bag2 = new ResizeableArrayBag < >();
        BagInterface < String > expected1 = new ResizeableArrayBag < >();
        BagInterface < String > expected2 = new ResizeableArrayBag < >();
          
        bag1.add("1");
        bag1.add("2");
        bag1.add("3");
        bag1.add("4");
        
        bag2.add("5");
        bag2.add("6");
        bag2.add("7");
        
        expected1.add("1");
        expected1.add("2");
        expected1.add("3");
        expected1.add("4");

        expected2.add("5");
        expected2.add("6");
        expected2.add("7");

        BagInterface<String> leftOver1 = bag1.difference(bag2);
        BagInterface<String> leftOver2 = bag2.difference(bag1);

    
        Object[] array1 = new Object[8];
        array1 = leftOver1.toArray();
        Object[] array2 = new Object[8];
        array2 = expected1.toArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        assertTrue(Arrays.equals(array1, array2));
        array1 = leftOver2.toArray();
        array2 = expected2.toArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        assertTrue(Arrays.equals(array1, array2)); 
    }
     /**
     * Tests whether difference works when bag2 is larger than bag1 in ResizeableArrayBag
     */
    @Test
    public void testResizeableDifferenceBag2Larger() {
        BagInterface < String > bag1 = new ResizeableArrayBag < >();
        BagInterface < String > bag2 = new ResizeableArrayBag < >();
        BagInterface < String > expected1 = new ResizeableArrayBag < >();
        BagInterface < String > expected2 = new ResizeableArrayBag < >();
          
        bag1.add("1");
        bag1.add("2");
        
        bag2.add("5");
        bag2.add("6");
        bag2.add("7");
        
        expected1.add("1");
        expected1.add("2");

        expected2.add("5");
        expected2.add("6");
        expected2.add("7");

        BagInterface<String> leftOver1 = bag1.difference(bag2);
        BagInterface<String> leftOver2 = bag2.difference(bag1);

    
        Object[] array1 = new Object[8];
        array1 = leftOver1.toArray();
        Object[] array2 = new Object[8];
        array2 = expected1.toArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        assertTrue(Arrays.equals(array1, array2));
        array1 = leftOver2.toArray();
        array2 = expected2.toArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        assertTrue(Arrays.equals(array1, array2));
    }

     /**
     * Tests whether difference works when bag2 is a LinkedBag
     */
    @Test
    public void testResizeableDifferenceWithLinkedBag() {
        BagInterface < String > bag1 = new ResizeableArrayBag < >();
        BagInterface < String > bag2 = new LinkedBag < >();
        BagInterface < String > expected1 = new ResizeableArrayBag < >();
        BagInterface < String > expected2 = new ResizeableArrayBag < >();
          
        bag1.add("1");
        bag1.add("2");
        
        bag2.add("5");
        bag2.add("6");
        bag2.add("7");
        
        expected1.add("1");
        expected1.add("2");

        expected2.add("5");
        expected2.add("6");
        expected2.add("7");

        BagInterface<String> leftOver1 = bag1.difference(bag2);
        BagInterface<String> leftOver2 = bag2.difference(bag1);

    
        Object[] array1 = new Object[8];
        array1 = leftOver1.toArray();
        Object[] array2 = new Object[8];
        array2 = expected1.toArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        assertTrue(Arrays.equals(array1, array2));
        array1 = leftOver2.toArray();
        array2 = expected2.toArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        assertTrue(Arrays.equals(array1, array2));    
    }

     /**
     * Tests whether difference works when bag2 is empty in ResizeableArrayBag
     */
    @Test
    public void testResizeableDifferenceEmptyBag() {
        BagInterface < String > bag1 = new ResizeableArrayBag < >();
        BagInterface < String > bag2 = new ResizeableArrayBag < >();
        BagInterface < String > expected1 = new ResizeableArrayBag < >();
        BagInterface < String > expected2 = new ResizeableArrayBag < >();
          
        bag1.add("1");
        bag1.add("3");
        bag1.add("6");
    
        expected1.add("1");
        expected1.add("3");
        expected1.add("6");

        BagInterface<String> leftOver1 = bag1.difference(bag2);
        BagInterface<String> leftOver2 = bag2.difference(bag1);

         Object[] array1 = new Object[8];
        array1 = leftOver1.toArray();
        Object[] array2 = new Object[8];
        array2 = expected1.toArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        assertTrue(Arrays.equals(array1, array2));
        array1 = leftOver2.toArray();
        array2 = expected2.toArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        assertTrue(Arrays.equals(array1, array2));   
    }

      /**
     * Tests whether difference works when both bags are empty in ResizeableArrayBag
     */
    @Test
    public void testResizeableDifferenceBothEmpty() {
        BagInterface < String > bag1 = new ResizeableArrayBag < >();
        BagInterface < String > bag2 = new ResizeableArrayBag < >();
        BagInterface < String > expected1 = new ResizeableArrayBag < >();
        BagInterface < String > expected2 = new ResizeableArrayBag < >();
    
        BagInterface<String> leftOver1 = bag1.difference(bag2);
        BagInterface<String> leftOver2 = bag2.difference(bag1);

        Object[] array1 = new Object[8];
        array1 = leftOver1.toArray();
        Object[] array2 = new Object[8];
        array2 = expected1.toArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        assertTrue(Arrays.equals(array1, array2));
        array1 = leftOver2.toArray();
        array2 = expected2.toArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        assertTrue(Arrays.equals(array1, array2));  
    }
}