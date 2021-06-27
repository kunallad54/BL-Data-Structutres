/**
 * Purpose : : Linked List class to implement linked list functionalities
 *
 * @param <T> generic type class
 *
 * @author Krunal Lad
 * @Since 26-06-2021
 */
package Implementations;
import java.util.List;

public class LinkedList<T> {
    Node<T> head;
    public Object deleteAt;
    int size = 0;

    /**
     * Purpose : To insert data in linked list
     *
     * @param data taken from user
     */
    public void add(T data) {
        Node<T> newNode = new Node<T>();
        newNode.data = data;

        if (head == null)
            head = newNode;
        else {

            Node<T> currentNode = head;

            while (currentNode.next != null) {

                currentNode = currentNode.next;

            }

            currentNode.next = newNode;
            size++;

        }
    }

    /**
     * Purpose : Add data at the start of list
     *
     * @param data taken from user
     */
    public void addAtStart(T data) {
        Node<T> newNode = new Node<T>();
        newNode.data = data;

        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * Purpose : Adding data at particular index in linked list
     *
     * @param index taken from user
     * @param data  taken from user
     */
    public void addAt(int index, T data) {
        Node<T> newNode = new Node<T>();
        newNode.data = data;

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> currentNode = head;
            Node<T> previousNode = null;

            for (int i = 0; i < index; i++) {
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
            previousNode.next = newNode;
            newNode.next = currentNode;
        }
        size++;
    }

    /**
     * Purpose : Getting data at particular index
     *
     * @param index taken from user
     * @return data at particular index if
     */
    public T get(int index) {
        if (index == 0) {
            return head.data;
        } else {
            Node<T> currentNode = head;
            for (int i = 0; i < index; i++) {
                if (currentNode.next != null) {
                    currentNode = currentNode.next;
                } else {
                    return null;
                }
            }
            return currentNode.data;
        }
    }

    /**
     * Purpose : To delete node at start of linked list
     */
    public void deleteAtStart() {
        head = head.next;
        size--;
    }

    /**
     * Purpose : Delete data at particular index specified by user in linked list
     *
     * @param index taken from user
     */
    public void deleteAt(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            Node<T> currentNode = head;
            Node<T> previousNode = null;
            for (int i = 0; i < index; i++) {
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
            previousNode.next = currentNode.next;
            currentNode = null;
        }
        size--;
    }

    /**
     * Purpose : Deletes the last node of the linked list
     */
    public void deleteAtEnd() {
        if (!isEmpty()) {
            Node<T> currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            size--;
        } else {
            System.out.println("List is empty");
        }

    }

    /**
     * Purpose : To search data if present in linked list then delete it
     * if not present in list then add in list
     *
     * @param data taken from user
     * @param size taken from user
     * @return updated size of list
     */
    public int searchNode(T data, int size) {
        boolean isFound = false;
        int counter = -1;
        Node<T> currentNode = head;
        while (currentNode.next != null) {
            counter++;
            if (currentNode.data.equals(data)) {
                isFound = true;
                break;
            }
            currentNode = currentNode.next;
        }
        if (isFound) {
            System.out.println("\nData Found and deleting ...");
            deleteAt(counter);
            size--;
        } else if (currentNode.data.equals(data)) {
            System.out.println("\nData found at last node and deleting....");
            size--;
        } else {
            System.out.println("Data not found and therefore inserting...");
            add(data);
            size++;
        }
        return size;
    }

    /**
     * Purpose : Method for sorting the integer list
     *
     * @param size
     * @param <T>
     */
    public <T extends Comparable<T>> void sortList(int size) {

        Node<T> currentNode = (Node<T>) head;
        Node<T> nextNode = currentNode.next;

        for (int i = 0; i < size - 1; i++) {

            for (int j = 0; j < size - 1 - i ; j++) {

                if (currentNode.data.compareTo(nextNode.data) > 0) {
                    T tempNode = currentNode.data;
                    currentNode.data = nextNode.data;
                    nextNode.data = tempNode;
                }

                nextNode = nextNode.next;

            }
            currentNode = currentNode.next;
            nextNode = currentNode.next;
        }
    }

    /**
     * Purpose : To display data inside the linked list
     */
    public String printList() {
        String str = "";
        Node<T> currentNode = head;

        if(head == null)
            return "Empty List";
        else {
            while (currentNode.next != null) {
                str += currentNode.data + ",";
                currentNode = currentNode.next;
            }
            str += currentNode.data;
            //System.out.println(str);
        }
        return str;
    }

    /**
     *  Purpose : Updates the list again to write in a file
     * @return updated linked list
     */
    public String returnList() {

        String str = "";
        Node<T> currentNode = head;

        while (currentNode.next != null) {

            str += currentNode.data + " ";
            currentNode = currentNode.next;

        }

        str = str + currentNode.data;
        return str;

    }

    /**
     * Purpose : Checks whether list is empty or not
     *
     * @return true if it is empty else false
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Purpose : To get the size of linked list
     *
     * @return size of list
     */
    public int getSize() {
        return size;
    }

    /**
     * Purpose : Method to all data in linked list
     *
     * @param list data is provided in form of list
     */
    public void addALl(List<T> list){
        for(int i = 0; i < list.size(); i++){
            add(list.get(i));
        }
    }
}
