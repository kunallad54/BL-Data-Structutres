/**
 * Purpose : Methods of File Operations
 *
 * @author Krunal Lad
 * @Since 26-06-2021
 */
package Implementations;
import java.io.*;

public class FileOperations {

    /**
     * Purpose : Read a file and return a string
     *
     * @param filePath is the path where file is located
     * @return string value which is read from file
     * @throws IOException checking exception for file operations
     */
    public static String readFile(String filePath) throws IOException {

        String str = "";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        str = bufferedReader.readLine();
        bufferedReader.close();
        return str;

    }

    /**
     * Purpose : Writes string into file
     *
     * @param filePath is the path where file is located
     * @param str string which needs to written in file
     * @return
     * @throws IOException checking for exceptions during file operations
     */
    public static String writeFile(String filePath,String str) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        bufferedWriter.write(str);
        bufferedWriter.close();
        return "\n File is written ...";

    }
}
