
/***************************************************************************************************************
 *
 * Purpose : Ordered List
 *           a. Desc -> Read .a List of Numbers from a file and arrange it ascending Order in a
 *                      Linked List. Take user input for a number, if found then pop the number out of the
 *                      list else insert the number in appropriate position
 *           b. I/P -> Read from file the list of Numbers and take user input for a new number
 *           c. Logic -> Create a Ordered Linked List having Numbers in ascending order.
 *           d. O/P -> The List of Numbers to a File.
 *
 * @author Krunal Lad
 * @Since 26-06-2021
 *
 ***************************************************************************************************************/

package DataStructureMain;

import Implementations.LinkedList;
import Implementations.FileOperations;

import java.io.IOException;
import java.util.Scanner;

public class OrderedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        String filePath = "C:\\Users\\Kunal\\IdeaProjects\\Data Structures\\src\\Files\\Numbers";
        String[] stringArray = null;
        try {
            stringArray = FileOperations.readFile(filePath).split(",");
        } catch (IOException e) {
            e.printStackTrace();
        }
        int size = stringArray.length;
        int[] integerArray = new int[stringArray.length];
        for(int i = 0; i < stringArray.length; i++){
            integerArray[i] = Integer.parseInt(stringArray[i]);
            list.add(integerArray[i]);
        }
        System.out.println("List before Sorting : ");
        System.out.println(list.printList());

        System.out.println("Sorting...");
        list.sortList(size);
        System.out.println(list.printList());


        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter the number you want to search in list : ");
        int number = scanner.nextInt();
        size = list.searchNode(number,size);
        scanner.close();

        System.out.println("\nSorting...");
        list.sortList(size);

        String str = list.returnList();
        try {
            FileOperations.writeFile(filePath,str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(list.printList());
        System.out.println("Size of list is : "+size);
    }
}
