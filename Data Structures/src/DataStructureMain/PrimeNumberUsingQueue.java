/********************************************************************************************************
 *
 * Purpose : Add the Prime Numbers that are Anagram in the Range of 0 - 1000 in a Queue using
 *          the Linked List and Print the Anagrams from the Queue. Note no Collection Library
 *          can be used.
 *
 * @author Krunal Lad
 * @Since 27-06-2021
 *
 *******************************************************************************************************/

package DataStructureMain;
import Implementations.QueueImplementationUsingLinkedList;

public class PrimeNumberUsingQueue {
    public static void main(String[] args) {
        int start = 0;
        int end = 1000;
        PrimeNumber2DArray p = new PrimeNumber2DArray();
        PrimeAnagramRange2DArray pa = new PrimeAnagramRange2DArray();
        QueueImplementationUsingLinkedList<Integer> queue = new QueueImplementationUsingLinkedList<Integer>();

        // putting values in array
        for (int i = start; i <= end; i++) {
            if (p.isPrime(i)) {
                for (int j = i + 1; j < end; j++){
                    if(p.isPrime(j)){
                        if(pa.isAnagram(String.valueOf(i),String.valueOf(j))){
                            queue.enqueue(i);
                            queue.enqueue(j);
                        }
                    }
                }
            }
        }

        int queueSize = queue.size();

        // printing values
        for(int i = 0; i < queueSize; i++){
            System.out.print(queue.get(i)+" ");
        }
    }
}
