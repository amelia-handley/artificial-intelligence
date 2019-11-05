// code from https://www.caveofprogramming.com/java/java-file-reading-and-writing-files-in-java.html
import java.io.*;

public class readtest
{
    public static void main(String[] args) 
    {
    // name of file
    String readFile = "caverns files/input1.cav";

    //reference one line at a time
    String line = null;
    
    // Read File using filereader
    try {
        // FileReader reads text files in the default encoding.
        FileReader fileReader = 
        new FileReader(readFile);

        // Always wrap FileReader in BufferedReader.
        BufferedReader bufferedReader = 
            new BufferedReader(fileReader);

        // while there is still text
        while((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
    }   
        // Always close files.
        bufferedReader.close();         
    }
    catch(FileNotFoundException ex) {
        System.out.println("Not able to read file'" + readFile + "'");                
    }
    catch(IOException ex) {
        System.out.println("Error  '" + readFile + "'");
        }
    }
    
}


