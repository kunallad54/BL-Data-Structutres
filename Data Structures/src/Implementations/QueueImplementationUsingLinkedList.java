/**
 * Purpose : This class is implemented to perform queue functionalities using Linked List
 *
 * @author Krunal Lad
 * @Since 27-06-2021
 *
 * @param <T> represents Generic Class
 */
package Implementations;
import java.util.List;
import java.util.Scanner;

public class QueueImplementationUsingLinkedList<T> {
    LinkedList<T> queue = new LinkedList<T>();

    int index = 0;
    public int bankBalance = 20000;
    Scanner scanner = new Scanner(System.in);
    int counter = 1;

    /**
     * Purpose: To get the size of queue
     *
     * @return size of queue
     */
    public int size(){
        return index;
    }

    /**
     * Purpose : Add data in queue
     * @param data taken from user
     */
    public void enqueue(T data){
        queue.add(data);
        index++;
    }

    /**
     * Purpose : To add all data inside queue
     *
     * @param list
     */
    public void enqueueAll(List<T> list){
        for(int i = 0; i < list.size(); i++){
            enqueue(list.get(i));
        }
    }

    /**
     * Purpose : Method to delete element in queue
     */
    public void dequeue(){
        index--;
        queue.deleteAt(index);
    }

    /**
     * Purpose : Prints all data inside queue
     */
    public void printQueue(){
        queue.printList();
    }

    /**
     * Purpose : Checks whether queue is empty  or not
     *
     * @return true if queue is empty else false
     */
    public boolean isEmpty(){
        return queue.isEmpty();
    }

    /**
     * Purpose : To get the last index of queue
     *
     * @return last index of queue
     */
    public T get(){
        return queue.get(index);
    }

    /**
     * Purpose : To get value at particular index
     *
     * @param ind taken from user
     * @return value at the index
     */
    public T get(int ind){
        return queue.get(ind);
    }

    /**
     * Purpose : Method for serving people who are in queue at bank
     */
    public void bankService(){
        System.out.println("Token number is : "+counter);

        int amount = 0;
        System.out.println("\nPress 1 to withdraw cash\nPress 2 to deposit cash");
        int choice = scanner.nextInt();

        switch (choice){
            case 1:
                System.out.println("Enter the amount to withdraw from account : ");
                amount = scanner.nextInt();
                bankBalance = bankBalance - amount;
                System.out.println("Thank You for using service");
                amount = 0;
                break;
            case 2:
                System.out.println("Enter the amount to deposit in account");
                amount = scanner.nextInt();
                bankBalance = bankBalance + amount;
                System.out.println("Thank You for using service");
                amount = 0;
                break;
            default:
                System.out.println("Enter Valid Option");
                break;
        }
        counter++;
    }

}
