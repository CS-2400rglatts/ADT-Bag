package com.bagadt;

import com.bagadt.BagInterface;
import com.bagadt.LinkedBag;
import com.bagadt.ResizeableArrayBag;
import java.util.Arrays;

/**
 *
 * @author Rebecca Glatts
 */

public class bagDriver {
    public static void main(String[] args) {
        BagInterface<String> linkedBag1 = new LinkedBag<>();
        BagInterface<String> linkedBag2 = new LinkedBag<>();

        linkedBag1.add("1");
        linkedBag1.add("2");
        linkedBag1.add("3");
        linkedBag1.add("4");

        linkedBag2.add("5");
        linkedBag2.add("6");
        linkedBag2.add("1");
        linkedBag2.add("2");

        System.out.println("\nLinkedBag\nUnion:");
        System.out.println(Arrays.toString(linkedBag1.union(linkedBag2).toArray()));
        // should have 5, 6, 1, 2, 1, 2, 3, 4

        System.out.println("Intersection:");
        System.out.println(Arrays.toString(linkedBag1.intersection(linkedBag2).toArray()));
        // should have 1, 2

        System.out.println("Difference:");
        System.out.println(Arrays.toString(linkedBag2.difference(linkedBag1).toArray()));
        // should have 6, 5

        BagInterface<String> resizeableBag1 = new ResizeableArrayBag<>();
        BagInterface<String> resizeableBag2 = new ResizeableArrayBag<>();

        resizeableBag1.add("1");
        resizeableBag1.add("2");
        resizeableBag1.add("3");
        resizeableBag1.add("4");

        resizeableBag2.add("5");
        resizeableBag2.add("6");
        resizeableBag2.add("1");
        resizeableBag2.add("2");

        System.out.println("\nResizableArrayBag\nUnion:");
        System.out.println(Arrays.toString(resizeableBag1.union(resizeableBag2).toArray()));
        // should have 1, 2, 3, 4, 5, 6, 1, 2
        System.out.println("Intersection:");
        System.out.println(Arrays.toString(resizeableBag1.intersection(resizeableBag2).toArray()));
        // should have 1, 2
        System.out.println("Difference:");
        System.out.println(Arrays.toString(resizeableBag2.difference(resizeableBag1).toArray()));
        // should have 5, 6
    }
}
