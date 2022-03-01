package com.example;



import org.junit.Test;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import com.bagadt.BagInterface;
import com.bagadt.LinkedBag;
import com.bagadt.ResizeableArrayBag;

/**Tests union, intersection, and difference methods within LinkedBag
 *
 * @author Rebecca Glatts
 * 
 */
public class LinkedBagTest {
    
    /** Tests method union() with duplicants in each bag in the class LinkedBag 
     * 
    */
    @Test
    public void testUnionDupes() {
        BagInterface < String > bag1 = new LinkedBag < >();
        BagInterface < String > bag2 = new LinkedBag < >();
        BagInterface < String > bag3 = new LinkedBag < >();
    
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
     * Tests whether union works with no duplicants in either bag
     */
    @Test
    public void testUnionNoDupes() {
        BagInterface < String > bag1 = new LinkedBag < >();
        BagInterface < String > bag2 = new LinkedBag < >();
        BagInterface < String > expected = new LinkedBag < >();
        

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
     * Tests whether union works correctly if one of the bags is empty
     */
    @Test
    public void testUnionEmptyBag() {
        BagInterface < String > bag1 = new LinkedBag < >();
        BagInterface < String > bag2 = new LinkedBag < >();
        BagInterface < String > expected = new LinkedBag < >();
        
        
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
    public void testUnionBothEmpty() {
        BagInterface < String > bag1 = new LinkedBag < >();
        BagInterface < String > bag2 = new LinkedBag < >();
        BagInterface < String > expected = new LinkedBag < >();
        BagInterface<String> everything = bag1.union(bag2);

        assertNull(everything);
    }

    /**
     * Tests whether union works when the first bag is larger than the other
     */
    @Test
    public void testUnionBag1LargerBag2() {
        BagInterface < String > bag1 = new LinkedBag < >();
        BagInterface < String > bag2 = new LinkedBag < >();
        BagInterface < String > expected = new LinkedBag < >();
        
        
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
     * Tests whether union works when the second bag is larger than the first
     */
    @Test
    public void testUnionBag2LargerBag1() {
        BagInterface < String > bag1 = new LinkedBag < >();
        BagInterface < String > bag2 = new LinkedBag < >();
        BagInterface < String > expected = new LinkedBag < >();
       
        
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
     * Tests whether union works when the second bag is a ResizeableArrayBag
     */
    @Test
    public void testUnionWithResizeableArrayBag() {
        BagInterface < String > bag1 = new LinkedBag < >();
        BagInterface < String > bag2 = new ResizeableArrayBag < >();
        BagInterface < String > expected = new LinkedBag < >();
        
        
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
     * Tests whether intersection works when there are duplicates in the bags
     */
    @Test
    public void testIntersectionDupes() {
        BagInterface < String > bag1 = new LinkedBag < >();
        BagInterface < String > bag2 = new LinkedBag < >();
        BagInterface < String > expected = new LinkedBag < >();
        
        bag1.add("1");
        bag1.add("5");
        bag2.add("1");
        bag2.add("5");

        expected.add("1");
        expected.add("5");


        BagInterface<String> commonItems = bag1.intersection(bag2);
        Object[] array1 = new Object[4];
        array1 = commonItems.toArray();
        Object[] array2 = new Object[4];
        array2 = expected.toArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        assertTrue(Arrays.equals(array1, array2));   
    }

    /**
     * Tests whether intersection works when there are no duplicates in the bags
     */
    @Test
    public void testIntersectionNoDupes() {
        BagInterface < String > bag1 = new LinkedBag < >();
        BagInterface < String > bag2 = new LinkedBag < >();
        BagInterface < String > expected = new LinkedBag < >();
        
        bag1.add("1");
        bag1.add("5");
        bag2.add("2");
        bag2.add("3");
    

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
     * Tests whether intersection works when there is an empty bag
     */
    @Test
    public void testIntersectionEmptyBag() {
        BagInterface < String > bag1 = new LinkedBag < >();
        BagInterface < String > bag2 = new LinkedBag < >();
        BagInterface < String > expected = new LinkedBag < >();
        
        bag1.add("1");
        bag1.add("5");
        
        
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
     * Tests whether intersection works when both bags are empty
     */
    @Test
    public void testIntersectionBothEmpty() {
        BagInterface < String > bag1 = new LinkedBag < >();
        BagInterface < String > bag2 = new LinkedBag < >();
        BagInterface < String > expected = new LinkedBag < >();
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
     * Tests whether intersection works when bag1 is larger than bag2
     */
    @Test
    public void testIntersectionBag1Larger() {
        BagInterface < String > bag1 = new LinkedBag < >();
        BagInterface < String > bag2 = new LinkedBag < >();
        BagInterface < String > expected = new LinkedBag < >();
        
        bag1.add("1");
        bag1.add("5");
        bag2.add("1");
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
     * Tests whether intersection works when bag2 is larger than bag1
     */
    @Test
    public void testIntersectionBag2Larger() {
        BagInterface < String > bag1 = new LinkedBag < >();
        BagInterface < String > bag2 = new LinkedBag < >();
        BagInterface < String > expected = new LinkedBag < >();
        
        bag1.add("1");
        bag1.add("5");
        bag2.add("1");
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
     * Tests whether intersection works when the second bag is a ResizeableArrayBag
     */
    @Test
    public void testIntersectionWithResizeableArrayBag() {
        BagInterface < String > bag1 = new LinkedBag < >();
        BagInterface < String > bag2 = new ResizeableArrayBag < >();
        BagInterface < String > expected = new LinkedBag < >();
        
        
        bag2.add("1");
        bag2.add("2");
        bag2.add("3");
        bag2.add("4");
        
        bag1.add("1");
        bag1.add("4");

        expected.add("1");
        expected.add("2");
        expected.add("4");
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
     * Tests whether difference works when there are duplicants in the bags
     */
    @Test
    public void testDifferenceDupes() {
        BagInterface < String > bag1 = new LinkedBag < >();
        BagInterface < String > bag2 = new LinkedBag < >();
        BagInterface < String > expected1 = new LinkedBag < >();
        BagInterface < String > expected2 = new LinkedBag < >();
          
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
     * Tests whether difference works when there are no duplicants in the bags
     */
    @Test
    public void testDifferenceNoDupes() {
        BagInterface < String > bag1 = new LinkedBag < >();
        BagInterface < String > bag2 = new LinkedBag < >();
        BagInterface < String > expected1 = new LinkedBag < >();
        BagInterface < String > expected2 = new LinkedBag < >();
          
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
     * Tests whether difference works when bag1 is larger than bag2
     */
    @Test
    public void testDifferenceBag1Larger() {
        BagInterface < String > bag1 = new LinkedBag < >();
        BagInterface < String > bag2 = new LinkedBag < >();
        BagInterface < String > expected1 = new LinkedBag < >();
        BagInterface < String > expected2 = new LinkedBag < >();
          
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
     * Tests whether difference works when bag2 is larger than bag1
     */
    @Test
    public void testDifferenceBag2Larger() {
        BagInterface < String > bag1 = new LinkedBag < >();
        BagInterface < String > bag2 = new LinkedBag < >();
        BagInterface < String > expected1 = new LinkedBag < >();
        BagInterface < String > expected2 = new LinkedBag < >();
          
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
     * Tests whether difference works when bag2 is a linked bag
     */
    @Test
    public void testDifferenceWithLinkedBag() {
        BagInterface < String > bag1 = new LinkedBag < >();
        BagInterface < String > bag2 = new ResizeableArrayBag < >();
        BagInterface < String > expected1 = new LinkedBag < >();
        BagInterface < String > expected2 = new LinkedBag < >();
          
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
     * Tests whether difference works when bag2 is empty
     */
    @Test
    public void testDifferenceEmptyBag() {
        BagInterface < String > bag1 = new LinkedBag < >();
        BagInterface < String > bag2 = new LinkedBag < >();
        BagInterface < String > expected1 = new LinkedBag < >();
        BagInterface < String > expected2 = new LinkedBag < >();
          
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
     * Tests whether difference works when both bags are empty
     */
    @Test
    public void testDifferenceBothEmpty() {
        BagInterface < String > bag1 = new LinkedBag < >();
        BagInterface < String > bag2 = new LinkedBag < >();
        BagInterface < String > expected1 = new LinkedBag < >();
        BagInterface < String > expected2 = new LinkedBag < >();
    
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

