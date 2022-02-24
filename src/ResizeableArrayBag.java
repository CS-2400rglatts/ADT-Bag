import java.util.*; // to use the class Arrays, * avail to all files

public class ResizeableArrayBag<T> implements BagInterface<T>
{
    private T[] itemArray; // itemArray must not be final
    //if going to resize
    private static final int DEFAULT_CAPACITY = 4;
    private int myCapacity; //added a variable to track changing capacity
    private int numberOfItems;

    // Constructor; creates a bag with an empty Item array
    public ResizeableArrayBag()
    {
        this(DEFAULT_CAPACITY);
    }

    // Extra constructor; creates and initializes an empty Bag
    public ResizeableArrayBag(int capacity)
    {
        myCapacity = capacity;
        numberOfItems = 0;
        @SuppressWarnings("unchecked") // says don't pick on me for casting types
        T [] tempBag = (T []) new Object[capacity];
        // ( ) says doesn't look like an item type but it is
        itemArray = tempBag;

    }

    // Extra constructor; creates a bag by copy
    public ResizeableArrayBag(ResizeableArrayBag anotherBag)
    {
        @SuppressWarnings("unchecked")
        T [] tempBag = (T []) new Object[anotherBag.getCapacity()];
        myCapacity = anotherBag.getCapacity();
        itemArray = tempBag;

        numberOfItems = anotherBag.numberOfItems;
        for (int index = 0; index < anotherBag.numberOfItems; ++index)
        {
            @SuppressWarnings("unchecked")
            T movingItem = (T) anotherBag.itemArray[index];
            itemArray[index] = movingItem;
        }

    }

    // Return the number of Items being stored in the Bag
    public int getCurrentSize()
    {
        return numberOfItems;
    }

    // Return the capacity of the bag (the maximum Items it can store)
    public int getCapacity()
    {
        return myCapacity;

    }

    //Resizes the bag's capacity to newCapacity
    //if the new size is larger, copy all bag contents
    //else, do nothing
    public void resize(int newCapacity)
    {
        if (myCapacity > newCapacity)
        {
            return;
        }
        else
        {
            itemArray = Arrays.copyOf(itemArray, newCapacity);
            myCapacity = newCapacity;
        }
    }

    // Report whether the Bag is empty
    // Return true if the Bag is empty (storing no Items);
    // Return false if Items exist in the Bag
    public boolean isEmpty()
    {
        return numberOfItems == 0;
    }

    // Report whether the Bag is full
    // Return true if the Bag is filled to capacity
    // Return false if there is still room
    public boolean isFull()
    {
        if (myCapacity == numberOfItems)
        {
            return true;
        }
        return false;
    }

    // Give the Bag a new Item to store
    // If Bag is full, double size and add
    // Else, Bag must add this Item to its Item array and update its numberOfItems
    // If Bag is full after this, return true; else return false
    public boolean add(T newItem)
    {
        if (isFull())
        {
            resize(2 * myCapacity);
            itemArray[numberOfItems] = newItem;
            numberOfItems++;
            return true;
        }
        else
        {
            itemArray[numberOfItems] = newItem;
            numberOfItems++;
            if (isFull())
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    // Make the Bag act like an empty Bag again
    public void clear()
    {
        for (int index = 0; index < numberOfItems; index++)
            itemArray[index] = null;
        numberOfItems = 0;
    }

    // Check how many times an Item is in the Bag
    // return 0 if it's not there; otherwise,
    // return the number of times it occurs
    public boolean remove(T anItem)
    {
        int k = 0;
        while (k < numberOfItems)
        {
            if (itemArray[k].equals(anItem))
            {
                if (k < numberOfItems)
                {
                    itemArray[k] = itemArray[numberOfItems-1];
                    itemArray[numberOfItems-1] = null;
                    numberOfItems--;
                    return true;
                }
            }
            k++;
        }
        return false;
    }

    // Check if an Item is in the Bag
    // Return true if it is in the Bag, and false if not
    public boolean contains(T anItem)
    {
        if (isEmpty()) return false;
        else
        {
            int k = 0;
            while (k < numberOfItems)
            {
                if (itemArray[k] == anItem)
                    return true;
                k++;
            }
        }
        return false;
    }

    // Check how many times an Item is in the Bag
    // return 0 if it's not there; otherwise,
    // return the number of times it occurs
    public int getFrequencyOf(T anItem)
    {
        int counter = 0;
        for (int index = 0; index < numberOfItems; index++)
        {
            if (itemArray[index].equals(anItem))
            {
                counter++;
            }
        }
        return counter;
    }

    // Make an output vector of Items from the bag (for checking)
    public T[] toArray()
    {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfItems];
        for (int index = 0; index < numberOfItems; index++)
            result[index] = itemArray[index];
        return result;
    }

    @Override
    public BagInterface<T> union(BagInterface<T> otherBag) {
        BagInterface < T > result = new ResizeableArrayBag < >();
        T[] mine = this.toArray();
        for (T elem : mine) {
            result.add(elem);
        }
        T[] others = otherBag.toArray();
        for (T elem : others) {
            result.add(elem);
        }
        return result;
    }

    @Override
    public BagInterface<T> intersection(BagInterface<T> otherBag) {
        BagInterface < T > result = new ResizeableArrayBag < >();
        BagInterface < T > finalResult = new ResizeableArrayBag < >();
        T[] mine = this.toArray();
        for (T elem : mine) {
            result.add(elem);
        }
        T[] others = otherBag.toArray();
        for (T elem : others) {
            if(result.contains(elem)){
                finalResult.add(elem);
            }
        }
        return finalResult;
    }

    @Override
    public BagInterface<T> difference(BagInterface<T> otherBag) {
        BagInterface < T > result = new ResizeableArrayBag < >();
        T[] mine = this.toArray();
        for (T elem : mine) {
            result.add(elem);
        }
        T[] others = otherBag.toArray();
        for (T elem : others) {
            if(result.contains(elem)){
                result.remove(elem);
            }
        }
        return result;
    }

    @Override
    public T remove() {
        // TODO Auto-generated method stub
        return null;
    }

}