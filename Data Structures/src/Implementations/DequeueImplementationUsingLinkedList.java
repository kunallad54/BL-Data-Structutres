/**
 * Purpose : To perform dequeue operations
 *
 * @author Krunal Lad
 * @Since 27-06-2021
 */
package Implementations;
public class DequeueImplementationUsingLinkedList<T> {
    LinkedList<T> dequeue = new LinkedList<T>();
    int size = 0;

    /**
     * Purpose : To insert data from front
     *
     * @param data taken from user
     */
    public void insertAtFront(T data){
        dequeue.addAtStart(data);
        size++;
    }

    /**
     * Purpose : Insert data at rear
     *
     * @param data taken from user
     */
    public void insertAtRear(T data){
        dequeue.add(data);
        size++;
    }

    /**
     * Purpose : Deleting data from front
     */
    public void deleteFromFront(){
        dequeue.deleteAtStart();
        size--;
    }

    /**
     * Purpose : Delete data from rear
     */
    public void deleteFromRear(){
        dequeue.deleteAtEnd();
        size--;
    }

    /**
     * Purpose : To get front element
     *
     * @return  the value at front
     */
    public T getFront(){
        return dequeue.get(--size);
    }

    /**
     * Purpose : To get the element at rear end
     *
     * @return value at end
     */
    public T getRear(){
        return dequeue.get(size-1);
    }
}
