package com.bagadt;
import com.bagadt.BagInterface;
import com.bagadt.LinkedBag;
import com.bagadt.ResizeableArrayBag;
import java.util.Arrays;

import javax.sound.sampled.SourceDataLine;

/**
 *
 * @author Rebecca
 */
public class bagDriver {
    public static void main(String[] args) {
        BagInterface < String > linkedBag1 = new LinkedBag<>();
        BagInterface < String > linkedBag2 = new LinkedBag<>();

        linkedBag1.add("1");
        linkedBag1.add("2");
        linkedBag1.add("3");
        linkedBag1.add("3");
        linkedBag1.add("4");

        linkedBag2.add("3");
        linkedBag2.add("4");
        linkedBag2.add("4");
        linkedBag2.add("5");
        
        System.out.println("LinkedBag\nUnion:");
        System.out.println(Arrays.toString(linkedBag1.union(linkedBag2).toArray()));
        //should have 1, 2, 3, 3, 4, 3, 4, 4, 5
        System.out.println("Intersection:");
        System.out.println(Arrays.toString(linkedBag1.intersection(linkedBag2).toArray()));
        //should have 3, 4
        System.out.println("Difference bag1 - bag2:");
        System.out.println(Arrays.toString(linkedBag1.difference(linkedBag2).toArray()));
        //should have 1, 2, 3
        System.out.println("Difference bag2 - bag1:");
        System.out.println(Arrays.toString(linkedBag2.difference(linkedBag1).toArray()));
        //should have 4, 5

        BagInterface < String > resizeableBag1 = new ResizeableArrayBag<>();
        BagInterface < String > resizeableBag2 = new ResizeableArrayBag<>();

        resizeableBag1.add("1"); 
        resizeableBag1.add("2");
        resizeableBag1.add("3");
        resizeableBag1.add("3");
        resizeableBag1.add("4");

        resizeableBag2.add("3");
        resizeableBag2.add("4");
        resizeableBag2.add("4");
        resizeableBag2.add("5");

        System.out.println("ResizableArrayBag\nUnion:");
        System.out.println(Arrays.toString(linkedBag1.union(linkedBag2).toArray()));
        //should have 1, 2, 3, 3, 4, 3, 4, 4, 5
        System.out.println("Intersection:");
        System.out.println(Arrays.toString(linkedBag1.intersection(linkedBag2).toArray()));
        //should have 3, 4
        System.out.println("Difference bag1 - bag2:");
        System.out.println(Arrays.toString(linkedBag1.difference(linkedBag2).toArray()));
        //should have 1, 2, 3
        System.out.println("Difference bag2 - bag1:");
        System.out.println(Arrays.toString(linkedBag2.difference(linkedBag1).toArray()));
        //should have 4, 5
    }   
}

