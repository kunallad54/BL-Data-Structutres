/****************************************************************************************************************
 *
 * Purpose : UnOrdered List
 *           a. Desc -> Read the Text from a file, split it into words and arrange it as Linked List.
 *                      Take a user input to search a Word in the List. If the Word is not found then add it
 *                      to the list, and if it found then remove the word from the List. In the end save the
 *                      list into a file
 *           b. I/P -> Read from file the list of Words and take user input to search a Text
 *           c. Logic -> Create a Unordered Linked List. The Basic Building Block is the Node
 *                       Object. Each node object must hold at least two pieces of information. One ref to
 *                       the data field and second the ref to the next node object.
 *          d. O/P -> The List of Words to a File.
 *
 * @author Krunal Lad
 * @Since 25-06-2021
 *
 ****************************************************************************************************************/

package DataStructureMain;

import java.io.*;
import java.util.Scanner;

import Implementations.LinkedList;
import Implementations.FileOperations;

public class UnorderedList{

    public static void main(String[] args) throws FileNotFoundException {

        String filepath = "C:\\Users\\Kunal\\IdeaProjects\\Data Structures\\src\\Files\\UnorderedText";
        LinkedList<String> list = new LinkedList<String>();
        String[] stringArray = null;
        try {
            stringArray = FileOperations.readFile(filepath).split(",");
        } catch (IOException e) {
            e.printStackTrace();
        }
        int size = stringArray.length;

        // reading from file and storing in unordered linked list
        for(int i = 0; i < stringArray.length; i++){
            list.add(stringArray[i]);
        }
        System.out.println(list.printList());

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the word you want to search : ");
        String word = sc.next();

        size = list.searchNode(word,size);
        System.out.println(list.printList());

        System.out.println("\nSize of Linked List : "+size);
        try {
            FileOperations.writeFile(filepath,list.returnList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        sc.close();
    }

}
