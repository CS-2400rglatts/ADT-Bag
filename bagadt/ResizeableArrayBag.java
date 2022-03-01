package com.bagadt;

import java.util.Arrays;

/**Implementation of BagInterface using resizable arrays
 * 
 * @author Frank M. Carrano, Timothy M. Henry
 * @author Rebecca Glatts, Yvonne Li, Jessica Ortega
 * */
public class ResizeableArrayBag<T> implements BagInterface<T> {

    private T[] bag;
    private static final int defaultCapacity = 30;
    private int numberOfEntries;
    private boolean initialized = false;
    private final static int maxCapacity = 10000;

    public ResizeableArrayBag() {
        this(defaultCapacity);
    } // end constructor

    public ResizeableArrayBag(int capacity) {
        numberOfEntries = 0;
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object[capacity];
        bag = tempBag;
        initialized = true;

    } // end constructor

    // Throws an exception if this object is not initialized.
    private void checkIntegrity() {
        if (!initialized)
            throw new SecurityException("ArrayBag object is corrupt.");
    } // end checkIntegrity

    /**
     * Counts the number of times a given entry appears in this bag.
     * 
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in this bag.
     */
    public int getFrequencyOf(T anEntry) {
        checkIntegrity();
        int counter = 0;

        for (int index = 0; index < numberOfEntries; index++) {
            if (anEntry.equals(bag[index])) {
                counter++;
            } // end if
        } // end for
        return counter;
    } // end getFrequencyOf

    /**
     * Sees whether this bag is empty.
     * 
     * @return True if this bag is empty, or false if not.
     */
    public boolean isEmpty() {
        return numberOfEntries == 0;
    } // end isEmpty

    /**
     * Gets the current number of entries in this bag.
     * 
     * @return The integer number of entries currently in this bag.
     */
    public int getCurrentSize() {
        return numberOfEntries;
    } // end getCurrentSize

    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries]; // unchecked cast
        for (int index = 0; index < numberOfEntries; index++) {
            result[index] = bag[index];
        } // end for
        return result;
    } // end toArray

    public boolean isFull() {
        return numberOfEntries == bag.length;
    } // end isFull

    /** Removes all entries from this bag. */
    public void clear() {
        while (!isEmpty())
            remove();
    } // end clear

    /**
     * Locates a given entry within the array bag.
     * Returns the index of the entry, if located, or -1 otherwise.
     * Precondition: checkIntegrity has been called.
     */
    private int getIndexOf(T anEntry) {
        int where = -1;
        boolean found = false;
        int index = 0;
        while (!found && (index < numberOfEntries)) {
            if (anEntry.equals(bag[index])) {
                found = true;
                where = index;
            } // end if
            index++;
        } // end while
          // Assertion: If where > -1, anEntry is in the array bag, and it
          // equals bag[where]; otherwise, anEntry is not in the array

        return where;
    } // end getIndexOf

    /**
     * Removes one unspecified entry from this bag, if possible.
     * 
     * @return Either the removed entry, if the removal
     *         was successful, or null.
     */
    public T remove() {
        checkIntegrity();
        T result = removeEntry(numberOfEntries - 1);
        return result;
    } // end remove

    /**
     * Removes and returns the entry at a given index within the array.
     * If no such entry exists, returns null.
     * Precondition: 0 <= givenIndex < numberOfEntries.
     * Precondition: checkInitialization has been called
     */
    public T removeEntry(int givenIndex) {
        T result = null;

        if (!isEmpty() && (givenIndex >= 0)) {
            result = bag[givenIndex]; // Entry to remove
            int lastIndex = numberOfEntries - 1;
            bag[givenIndex] = bag[lastIndex]; // Replace entry to remove with last entry
            bag[lastIndex] = null; // Remove reference to last entry
            numberOfEntries--;
        } // end if

        return result;
    } // end removeEntry

    /**
     * Removes one occurrence of a given entry from this bag.
     * 
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false if not.
     */
    public boolean removeEntry(T anEntry) {
        checkIntegrity();
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return anEntry.equals(result);
    } // end remove

    /**
     * Tests whether this bag contains a given entry.
     * 
     * @param anEntry The entry to locate.
     * @return True if this bag contains anEntry, or false otherwise.
     */
    public boolean contains(T anEntry) {
        checkIntegrity();
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i] == anEntry)
                return true;
        }
        return false;
    }

    /**
     * Returns true if this bag is full, or false if not.
     */
    private boolean isArrayFull() {
        return numberOfEntries >= bag.length;
    } // end isArrayFull

    /**
     * Adds a new entry to this bag.
     * 
     * @param newEntry The object to be added as a new entry.
     * @return True.
     */
    public boolean add(T anEntry) {
        checkIntegrity();
        boolean result = true;
        if (isFull()) {
            doubleCapacity();
        }
        bag[numberOfEntries] = anEntry;
        numberOfEntries++;
        return true;

    } // end add

    /** Throws an exception if the client requests a capacity that is too large. */
    private void checkCapacity(int capacity) {
        if (capacity > maxCapacity)
            throw new IllegalStateException("Attempt to create a bag whose "
                    + "capacity exeeds allowed "
                    + "maximum of " + maxCapacity);
    }// end checkCapacity

    /**
     * Doubles the size of the array bag.
     * Precondition: checkIntegrity has been called.
     */
    private void doubleCapacity() {
        int newLength = 2 * bag.length;
        checkCapacity(newLength);
        bag = Arrays.copyOf(bag, newLength);
    }// end doubleCapacity

    /**
     * Combines all of the items in the current bag and the passed bag
     * 
     * @param bag2 The bag that is combined with the current bag
     * @return a ResizebleArrayBag that contains all of the entries in the current
     *         bag and the passed bag
     */
    public BagInterface<T> union(BagInterface<T> bag2) {
        checkIntegrity();
        
        //clones original bags so they aren't touched
        BagInterface<T> b1 = this;
        BagInterface<T> b2 = bag2;
        BagInterface<T> b3 = new ResizeableArrayBag<T>();

        T[] bg1 = this.toArray();
        T[] bg2 = b2.toArray();
        
        //if both are empty return an empty bag
        if (b1.isEmpty() && b2.isEmpty()) {
            return b3;
        } // end if
        //if b2 is empty return b3 that is just filled with bag1
        else if (b2.isEmpty()) {
            b3 = b1;
            return b3;
        } // end else if
        //if b1 is empty return b3 that is just filled with bag2
        else if (b1.isEmpty()) {
            b3 = b2;
            return b3;
        } // end else if
    
         //add each element in bg1 to bag 3
        for (T i : bg1) {
            b3.add(i);

        } // end for
        //add each element in bg2 to bag3
        for (T i : bg2) {
            b3.add(i);
        }
        return b3;
    }// end union

    /**
     * Puts items that occur in both bags into a third bag
     * 
     * @param bag2 The bag that is used to compare which items overlap
     * @return a ResizableArrayBag that contains items that occur in both bags
     */
    public BagInterface<T> intersection(BagInterface<T> bag2) {
        checkIntegrity();
        
        //clone bags
        BagInterface<T> b1 = this;
        BagInterface<T> b2 = bag2;
        BagInterface<T> b3 = new ResizeableArrayBag<T>();
        
        //if either are empty return bag 3 with nothing because nothing overlaps
        if (b1.isEmpty() || b2.isEmpty()) {
            return b3;
        }

        T[] bg1 = this.toArray();
        T[] bg2 = b2.toArray();
    
        //for each element in bg1, if b2 contains the element, add the element to b3 and remove it from b2
        for (T elem : bg1) {
            if (bag2.contains(elem)) {
                b3.add(elem);
                bag2.removeEntry(elem);

            } // end for
        } // end for
        return b3;
    }// end intersection

    /**
     * Subtracts objects that occur in bag2 from the current bag and
     * 
     * @param bag2 The bag that is used to subtract from the current bag
     * @return a ResizeableArrayBag that contains entries left over after
     *         subtraction
     */
    public BagInterface<T> difference(BagInterface<T> bag2) {
        checkIntegrity();
        
        //clone bags
        BagInterface<T> b1 = this;
        BagInterface<T> b2 = bag2;
        BagInterface<T> b3 = new ResizeableArrayBag<T>();
        
        //if b2 is empty return b1 because nothing will be subtracted from it
        if (b1.isEmpty()) {
            return b3;
        } // end if
        //return b3 with nothing if b1 is empty
        else if (b2.isEmpty()) {
            b3 = b1;
            return b3;
        } // end else if

        T[] bg1 = this.toArray();
        T[] bg2 = b2.toArray();
        
        //for each element in bg1, if b2 does not contain it, add it to b3, else remove it from b2 because it is no longer needed
        for (T elem : bg1) {
            if (!b2.contains(elem)) {
                b3.add(elem);
            } else {
                b2.removeEntry(elem);
            }
        } // end for
        return b3;

    } // end difference

} // end ResizeableArrayBag
