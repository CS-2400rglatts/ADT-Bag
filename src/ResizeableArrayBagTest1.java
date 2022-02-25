import java.beans.Transient;

import org.junit.Test;

import bagadt.BagInterface;


public class ResizeableArrayBagTest {
    /**
     * Sets data for the two resizeableArrayBag's to be tested
     */
   
    
    /** Tests method union() with duplicants in each bag in the class ResizeableArrayBag 
     * 
    */
    @Test
    public void testUnionDupes() {
        ResizeableArrayBag<String> bag1;
        bag1.add("1");
        bag1.add("2");
        bag1.add("3");
        bag1.add("3");
        
        ResizeableArrayBag<String> bag2;
        bag1.add("1");
        bag1.add("3");
        bag1.add("5");
        bag1.add("7");
        
        
        BagInterface<String> everything = bag1.union(bag2);
        
        ResizeableArrayBag<String> bag3;
        bag3.add("1");
        bag3.add("2");
        bag3.add("3");
        bag3.add("3");
        bag3.add("1");
        bag3.add("3");
        bag3.add("5");
        bag3.add("7");
        


        
        assertTrue("union method did not work", everything == bag3 );    
    }