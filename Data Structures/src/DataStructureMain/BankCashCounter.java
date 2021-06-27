/**************************************************************************************************************
 *
 * Purpose : Simulate Banking Cash Counter
 *           a. Desc -> Create a Program which creates Banking Cash Counter where people
 *                      come in to deposit Cash and withdraw Cash. Have an input panel to add people
 *                      to Queue to either deposit or withdraw money and dequeue the people. Maintain
 *                      the Cash Balance.
 *           b. I/P -> Panel to add People to Queue to Deposit or Withdraw Money and dequeue
 *           c. Logic -> Write a Queue Class to enqueue and dequeue people to either deposit
 *                       or withdraw money and maintain the cash balance
 *           d. O/P -> True or False to Show Arithmetic Expression is balanced or not.
 *
 * @author Krunal Lad
 * @Since 27-06-2021
 *
 **************************************************************************************************************/

package DataStructureMain;

import java.util.Scanner;
import Implementations.QueueImplementationUsingLinkedList;

public class BankCashCounter {
    public static void main(String[] args) {

        System.out.println("Welcome to our Bank !!!");
        QueueImplementationUsingLinkedList<Integer> queue = new QueueImplementationUsingLinkedList<Integer>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnter the people count in queue : ");
        int peopleCount = scanner.nextInt();

        for (int i = 0; i < peopleCount; i++) {

            queue.enqueue(i);
            queue.bankService();
            queue.dequeue();

        }

        if (queue.isEmpty()) {
            System.out.println("Queue is Empty !!!");
        }

        System.out.println("\nBank Closing Balance is : " + queue.bankBalance);
        scanner.close();
    }
}
