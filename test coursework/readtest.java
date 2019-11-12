// code from https://www.caveofprogramming.com/java/java-file-reading-and-writing-files-in-java.html
import java.io.*;

public class readtest
{
    public static void main(String[] args) 
    {
    // name of file
    String readFile = "caverns files/input1.cav";
    String contents;

    //reference one line at a time
    String line = null;
    
    // Read File using filereader
    try {
        // FileReader reads text files in the default encoding.
        FileReader fileReader = new FileReader(readFile);

        // Always wrap FileReader in BufferedReader.
        BufferedReader bufferedReader = new BufferedReader(fileReader);
    }
        // Always close files.
        bufferedReader.close();
    }
    catch(IOException ex) {
        System.out.println("Error  '" + readFile + "'");
        }
    }

    //Store .cav file as a 1D array and split all numbers by ","
    String[] values.split(",");
    //find how many caves there are in the document - at position [0] of the array

}


