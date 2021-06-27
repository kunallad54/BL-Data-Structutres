/****************************************************************************************************************
 *
 * Purpose : Hashing Function to search a Number in a slot
 *           a. Desc -> Create a Slot of 10 to store Chain of Numbers that belong to each Slot to
 *              efficiently search a number from a given set of number
 *           b. I/P -> read a set of numbers from a file and take user input to search a number
 *           c. Logic -> Firstly store the numbers in the Slot. Since there are 10 Numbers divide
 *                      each number by 11 and the reminder put in the appropriate slot. Create a Chain
 *                      for each Slot to avoid Collision. If a number searched is found then pop it or else
 *                      push it. Use Map of Slot Numbers and Ordered LinkedList to solve the problem.
 *                      In the Figure Below, you can see number 77/11 reminder is 0 hence sits in the 0
 *                      slot while 26/11 remainder is 4 hence sits in slot 4
 *           d. O/P -> Save the numbers in a file
 *
 * @author Krunal Ladd
 * @Since 27-06-2021
 *
 ****************************************************************************************************************/

package DataStructureMain;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import Implementations.HashMap;
import Implementations.FileOperations;

public class HashSlot {
    static int[] array;

    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        String readMessage = "";
        String filePath = "C:\\Users\\Kunal\\IdeaProjects\\Data Structures\\src\\Files\\HashList";
        try {
            readMessage = FileOperations.readFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] str = readMessage.split(",");
        array = new int[str.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(str[i]);
        }
        System.out.println(Arrays.toString(array));
        System.out.println("Getting keys");
        for (int i = 0; i < array.length; i++) {
            hashMap.add(array[i], array[i]);
        }
        hashMap.show();
        System.out.println("\nEnter key to search: ");
        Scanner scanner = new Scanner(System.in);
        int key = scanner.nextInt();
        if (hashMap.get(key) != null) {
            hashMap.remove(key);
        } else {
            hashMap.add(key, key);
        }
        hashMap.show();
        scanner.close();

        try {
            FileOperations.writeFile(filePath, hashMap.returnListInString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
