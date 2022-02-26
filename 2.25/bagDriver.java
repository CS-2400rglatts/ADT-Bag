import java.util.Arrays;
public class bagDriver {
    public static void main(String[] args) {
        BagInterface < String > bag1 = new LinkedBag < >();
        BagInterface < String > bag2 = new LinkedBag < >();

        bag1.add("3");
        bag1.add("4");
        bag1.add("5");
        bag2.add("4");
        bag2.add("1");
        bag2.add("3");
        System.out.println(Arrays.toString(bag1.union(bag2).toArray()));
        System.out.println(Arrays.toString(bag1.intersection(bag2).toArray()));
        System.out.println(Arrays.toString(bag1.difference(bag2).toArray()));


    }
}