/************************************************************************************************************
 *
 * Purpose : Palindrome-Checker
 *           a. Desc -> A palindrome is a string that reads the same forward and backward, for
 *                      example, radar, toot, and madam. We would like to construct an algorithm to
 *                      input a string of characters and check whether it is a palindrome.
 *           b. I/P -> Take a String as an Input
 *           c. Logic -> The solution to this problem will use a deque to store the characters of
 *                       the string. We will process the string from left to right and add each character to
 *                       the rear of the deque.
 *           d. O/P -> True or False to Show if the String is Palindrome or not.
 *
 * @author Krunal Lad
 * @Since 27-06-2021
 *
 ************************************************************************************************************/

package DataStructureMain;
import java.util.Scanner;
import Implementations.DequeueImplementationUsingLinkedList;

public class PalindromeChecker {
    public static void main(String[] args) {
        DequeueImplementationUsingLinkedList<Character> dequeue = new DequeueImplementationUsingLinkedList<Character>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the string : ");
        String str = scanner.next();
        String reverseFront = "";
        String reverseRear = "";

        // inserting element in dequeue
        for (int i = 0; i < str.length(); i++) {
            dequeue.insertAtFront(str.charAt(i));
        }

        // removing elements from rear and getting rear values
        for (int i = 0; i < str.length(); i++) {
            reverseRear += dequeue.getRear();
            dequeue.deleteFromRear();
        }

        // inserting element in dequeue again
        for (int i = 0; i < str.length(); i++) {
            dequeue.insertAtFront(str.charAt(i));
        }

        // removing elements from front and getting front values
        for (int i = 0; i < str.length(); i++) {
            reverseFront += dequeue.getFront();
            dequeue.deleteFromFront();
        }

        if(reverseRear.equals(reverseFront)){
            System.out.println("String is Palindrome");
        } else {
            System.out.println("String is not a Palindrome");
        }

    }
}
