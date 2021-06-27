/**
 * Purpose : To perform hashmap functionalities
 *
 * @author Krunal Lad
 * @Since 27-06-2021
 *
 */

package Implementations;
import java.util.ArrayList;

public class HashMap<K, V> {

    // it contains the chain
    public ArrayList<HashNode<K, V>> arrayList;

    //capacity of arrayList
    public int arrayCapacity;

    //size of arrayList
    public int size;

    /**
     * Purpose : Creating Constructor
     */
    public HashMap() {
        arrayList = new ArrayList<>();
        arrayCapacity = 10;
        size = 0;

        for (int i = 0; i < arrayCapacity; i++) {
            arrayList.add(null);
        }
    }

    /**
     * Purpose : Getting the size of array list
     *
     * @return size of the array list
     */
    public int getSize() {
        return size;
    }

    /**
     * Purpose : To check whether array list is empty or not
     *
     * @return true if empty else false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Purpose : For getting hashed upon key
     *
     * @param key is passed to get hash index code
     * @return hash code index
     */
    public int hashFunction(K key) {
        int index = (int) key;
        return index % 11;
    }

    /**
     * Purpose : Method for returning Key Value
     *
     * @param key input from user
     * @return key value
     */
    public V get(K key) {

        //Find head of a chain for given key
        int hashIndex = hashFunction(key);

        HashNode<K, V> head = arrayList.get(hashIndex);

        // search key in chain
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        // if key not found
        return null;
    }

    public void add(K key, V value) {
        int hashIndex = hashFunction(key);
        //get head of chain
        HashNode<K, V> head = new HashNode<K, V>(key, value);
        //check if key is already present
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        // Insert key in chain
        size++;
        head = arrayList.get(hashIndex);

        HashNode<K, V> newNode = new HashNode<K, V>(key, value);
        newNode.next = head;
        arrayList.set(hashIndex, newNode);
        // If load factor goes beyond threshold, then
        // double hash table size
        if ((1.0 * size) / arrayCapacity >= 0.7) {
            ArrayList<HashNode<K, V>> temp = arrayList;
            arrayList = new ArrayList<>();
            arrayCapacity = 2 * arrayCapacity;
            size = 0;
            for (int i = 0; i < arrayCapacity; i++)
                arrayList.add(null);

            for (HashNode<K, V> headNode : temp) {
                while (headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }

    // method for removing node from chain

    /**
     * Purpose: method for removing the key from array list
     *
     * @param key key is passed from user
     * @return returns the value of key which is deleted
     */
    public V remove(K key) {
        // Apply hash function to find index for given key
        int hashIndex = hashFunction(key);

        // Get head of chain
        HashNode<K, V> head = arrayList.get(hashIndex);

        // Search for key in its chain
        HashNode<K, V> prev = null;
        while (head != null) {
            // If Key found
            if (head.key.equals(key))
                break;

            // Else keep moving in chain
            prev = head;
            head = head.next;
        }

        // If key was not there
        if (head == null)
            return null;

        // Reduce size
        size--;

        // Remove key
        if (prev != null)
            prev.next = head.next;
        else
            arrayList.set(hashIndex, head.next);

        return head.value;
    }

    /**
     * Purpose: this method will show all the array list which contains the data
     */
    public void show() {
        // System.out.println(chainArray.get(3));
        for (int i = 0; i < arrayList.size(); i++) {
            try {
                if (!(arrayList.get(i) == null)) {
                    System.out.println("\narray index : " + i);
                    HashNode<K, V> head = arrayList.get(i);
                    while (head != null) {
                        System.out.print(head.value + " ");
                        head = head.next;
                    }

                }
            } catch (Exception e) {
                System.err.println(e);
            }

        }

        // Get head of chain

    }

    /**
     * Purpose: getting the array list and pass in string to main program
     *
     * @return returns the list in string
     */
    public String returnListInString() {
        String str = "";
        // System.out.println(chainArray.get(3));
        for (int i = 0; i < arrayList.size(); i++) {
            try {
                if (!(arrayList.get(i) == null)) {
                    str += "\narray index : " + i;
                    HashNode<K, V> head = arrayList.get(i);
                    while (head != null) {
                        str += head.value + " ";
                        head = head.next;
                    }

                }
            } catch (Exception e) {
                System.err.println(e);
            }

        }
        return str;

    }

}
