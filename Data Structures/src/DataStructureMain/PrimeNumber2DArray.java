/**********************************************************************************************************
 *
 * Purpose : Take a range of 0 - 1000 Numbers and find the Prime numbers in that range. Store
 *           the prime numbers in a 2D Array, the first dimension represents the range 0-100,
 *           100-200, and so on. While the second dimension represents the prime numbers in
 *           that range
 *
 * @author Krunal Lad
 * @Since 27-06-2021\
 *
 ***********************************************************************************************************/

package DataStructureMain;
public class PrimeNumber2DArray {
    public static void main(String[] args) {
        PrimeNumber2DArray p = new PrimeNumber2DArray();

        int start = 0;
        int end = 100;

        int[][] primeNumber = new int[10][];
        int j1 = 0, j2 = 0;

        // declaring array
        for (int i = 0; i < 10; i++) {

            for (int j = start; j <= end; j++) {

                if (p.isPrime(j))
                    j1++;

            }

            primeNumber[i] = new int[j1];
            start = end + 1;
            end += 100;
            j1 = 0;

        }

        start = 0;
        end = 100;

        // putting values inside the array
        for (int i = 0; i < 10; i++) {

            for (int j = start; j <= end; j++) {

                if (p.isPrime(j)) {
                    primeNumber[i][j2] = j;
                    j2++;
                }
            }

            start = end + 1;
            end += 100;
            j2 = 0;

        }

        // printing the array
        for (int i = 0; i < primeNumber.length; i++) {
            for (int j = 0; j < primeNumber[i].length; j++) {
                System.out.print(primeNumber[i][j]+" ");
            }
            System.out.println();
        }

    }

    /**
     * Purpose : To check whether number is prime or not
     *
     * @param number taken from user
     * @return true if prime else false
     */
    public boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        } else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0)
                    return false;
            }
        }
        return true;
    }
}
