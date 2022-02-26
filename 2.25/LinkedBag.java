
import java.util.Arrays;
public class LinkedBag<T> implements BagInterface<T> {

    private Node firstNode;
    private int numberOfEntries;
    private T element;
    private boolean initialized;



    public LinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
        initialized = true;

    }// end default constructor

    public boolean add(T newEntry) // OutOfMemoryError possible
    {
        // Add to beginning of chain:
        Node newNode = new Node(newEntry);
        newNode.next = firstNode; // Make new node reference rest of chain
        // (firstNode is null if chain is empty)
        firstNode = newNode; // New node is at beginning of chain
        numberOfEntries++;

        return true;
    }// end add

    public T remove() {
        T result = null;
        if (firstNode != null) {
            result = firstNode.getData();
            firstNode = firstNode.getNextNode(); // Remove first node from chain
            numberOfEntries--;
        } // end if

        return result;
    } // end remove

    // Locates a given entry within this bag.
    // Returns a reference to the node containing the // entry, if located, or null
    // otherwise.
    private Node getReferenceTo(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.getData()))
                found = true;
            else
                currentNode = currentNode.getNextNode();
        } // end while

        return currentNode;
    } // end getReferenceTo

    /**
     * Removes one occurrence of a given entry from this bag, if possible.
     *
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false otherwise.
     */
    public boolean remove(T anEntry) {
        boolean result = false;
        Node nodeN = getReferenceTo(anEntry);

        if (nodeN != null) {
            // Replace located entry with entry in first node
            nodeN.setData(firstNode.getData());
            // Remove first node
            firstNode = firstNode.getNextNode();
            numberOfEntries--;

            result = true;
        } // end if

        return result;
    } // end remove

    /** Sees whether this bag is empty
     * @return True if this bag is empty, false if not
     */
    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    }//end isEmpty

    /** Gets the number of entries currently in this bag
     * @return The integer number of entries in this bag
     */
    public int getCurrentSize()
    {
        return numberOfEntries;
    }//end getCurrentSize

    /** Removes all entries from this bag */
    public void clear()
    {
        while(!isEmpty())
            remove();
    }//end clear

    /** Counts the number of times a given entry appears in this bag.
     * @param anEntry The entry to be counted
     * @return The number of times anEntry appears in this bag. */
    public int getFrequencyOf(T anEntry)
    {
        int frequency = 0;
        int counter = 0;
        Node currentNode = firstNode;
        while ((counter < numberOfEntries) && (currentNode != null))
        {
            if (anEntry.equals(currentNode.getData()))
            {
                frequency++;
            }//end if

            counter++;
            currentNode = currentNode.getNextNode();
        }//end while

        return frequency;
    }//end getFrequencyOf

    private void checkIntegrity() {
        if (!initialized)
            throw new SecurityException("ArrayBag object is corrupt.");
    } // end checkIntegrity


    /** Retrieves all entries that are in this bag.
     * @return A newly allocated array of all the entries in the bag. */
    public T[] toArray()
    {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries]; //Unchecked cast

        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null))
        {
            result [index] = currentNode.getData();
            index++;
            currentNode = currentNode.getNextNode();
        }//end while
        return result;

    } //end toArray



    public BagInterface<T> union(BagInterface<T> bag2)
    {
        BagInterface<T> b1 = this;
        BagInterface<T> b2 = bag2;
        BagInterface<T> b3 = new LinkedBag<T>();

        T[] bg1 = this.toArray();
        T[] bg2 = b2.toArray();

        if (b1.isEmpty() && b2.isEmpty()) {
            return null;
        } //end if
        else if (b2.isEmpty()) {
            b3 = b1;
            return b3;
        } //end else if
        else if (b1.isEmpty()) {
            b3 = b2;
            return b3;
        } //end else if

        for (T i : bg1) {
            b3.add(i);

        } // end for
        for (T i : bg2) {
            b3.add(i);
        }
        return b3;

    }//end union

    private class Node // private inner class
    {

        private T data;
        private Node next;

        private Node(T dataPortion) {
            this(dataPortion, null);
        }// end constructor

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }// end constructor

        private T getData() {
            return data;
        }// end getData

        private void setData(T newData) {
            data = newData;
        }// end setData

        private Node getNextNode() {
            return next;
        }// end getNextNode()

        private void setNextNode(Node nextNode) {
            next = nextNode;
        }// end setNextNode

    }// end Node


    public BagInterface<T> intersection(BagInterface<T> bag2)
    {
        BagInterface<T> newBag = new LinkedBag<T>();
        int index = 0;
        Node currentNode = firstNode;

        while (index < this.numberOfEntries)
        {
            if (bag2.contains(currentNode.data))
                newBag.add(currentNode.data);
            index++;
            currentNode = currentNode.next;
        }
        return newBag;
    }


    /*
    public BagInterface<T> intersection(BagInterface<T> bag2)
    { //sanitize user input; account for null
        BagInterface<T> b1 = this;
        BagInterface<T> b2 = bag2;
        BagInterface<T> b3 = new LinkedBag<T>();

        T[] bg1 = this.toArray();
        T[] bg2 = b2.toArray();
        int count1;
        int count2;

        if (b1.isEmpty() && b2.isEmpty()) {
            return null;
        } //end if
        else if (b2.isEmpty()) {
            b3 = b1;
            return b3;
        } //end else if
        else if (b1.isEmpty()) {
            b3 = b2;
            return b3;
        } //end else if

        for (T i : bg1) {
            if (b2.contains(i)){
                count2 = b2.getFrequencyOf(i);
                count1 = b1.getFrequencyOf(i);
                if (count2 > count1) {
                    for (int j = 0; j < count1; j++) {
                        b3.add(i);
                    }
                } //end if
            } //end if
        } //end for
        return b3;
    }//end union

     */
    

public BagInterface<T> difference(BagInterface<T> bag2)
 {
  BagInterface<T> newBag = new LinkedBag<T>();
  int index = 0;
  Node currentNode = firstNode;

  while (index < this.numberOfEntries)
  {
   int thisFrequency = this.getFrequencyOf(currentNode.data);
   int anotherFrequency = bag2.getFrequencyOf(currentNode.data);
   if ((thisFrequency > anotherFrequency) && !newBag.contains(currentNode.data))
   {
    for (int i = thisFrequency - anotherFrequency; i > 0 ; i--)
    {
     newBag.add(currentNode.data);
    }
   }
   index++;
   currentNode = currentNode.next;

  }
  return newBag;
 }



    /*
    public BagInterface<T> difference(BagInterface<T> bag2)
    {
        BagInterface<T> b1 = this;
        BagInterface<T> b2 = bag2;
        BagInterface<T> b3 = new LinkedBag<T>();
        T[] bg1 = this.toArray();
        T[] bg2 = b2.toArray();
        int count1;
        int count2;

        if (b1.isEmpty() && b2.isEmpty()) {
            return null;
        } //end if
        else if (b2.isEmpty()) {
            b3 = b1;
            return b3;
        } //end else if
        else if (b1.isEmpty()) {
            b3 = b2;
            return b3;
        } //end else if

        for (T i : bg1) {
            for (T j : bg2) {
                if (i == j) {
                    break;
                } //end if
                else {
                    b3.add(i);
                } //end else
            } //end for
        } //end for
        return b3;
    }// end difference

     */

    @Override
    public boolean contains(T anEntry) {
        // TODO Auto-generated method stub
        return false;
    }



}// end LinkedBag