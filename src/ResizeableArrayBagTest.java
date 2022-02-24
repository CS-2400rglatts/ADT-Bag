import java.util.Arrays;

public class ResizeableArrayBagTest
{
    public static void main(String[] args)
    {
        BagInterface < String > bag1 = new ResizeableArrayBag < >();
        BagInterface < String > bag2 = new ResizeableArrayBag < >();

        bag1.add("1");
        bag1.add("2");
        bag1.add("3");
        bag1.add("3");
        bag2.add("1");
        bag2.add("3");
        bag2.add("5");
        bag2.add("7");

        System.out.println("Union: ");
        System.out.println(Arrays.toString(bag1.union(bag2).toArray()));
        System.out.println("Intersection: ");
        System.out.println(Arrays.toString(bag1.intersection(bag2).toArray()));
        System.out.println("Difference: ");
        System.out.println(Arrays.toString(bag1.difference(bag2).toArray()));}
}