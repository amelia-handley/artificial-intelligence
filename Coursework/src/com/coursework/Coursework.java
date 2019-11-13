package com.coursework;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Coursework
{
    public static void main(String[] args) {
        List<String> inputFile;
        // Save the file for the cave route as a list
        String caveRoute;

        // path for file
        // need to allow user to input file
        Path path = FileSystems.getDefault().getPath("C:\\Users\\ameli\\Documents\\artificial-intelligence\\Coursework\\caverns files\\input1.cav");
        try {
            // Store the "path" file as a List<string>
            inputFile = Files.readAllLines(path);
            caveRoute = inputFile.get(0);
            //System.out.println(caveRoute);
        } catch (IOException ex) {
            System.out.println("Error cannot read file: '" + path + "'");
            return;
        }

        // get first element in inputContents array
        // split the document by ","
        String[] values = caveRoute.split(",");
        // Number of caves found in text file is found at element [0]
        int cavesNumber = Integer.parseInt(values[0]);
        // create array list
        ArrayList<Cave> allCaves = new ArrayList<Cave>();
        // start for loop at 1, as the first element in the array is the number of caves
        for(int i=1; i<cavesNumber*2; i+=2)
        {
            // Create newCave
            Cave newCave = new Cave();
            // Find X Coordinate
            newCave.x = Integer.parseInt(values[i]);
            // Find Y Coordinate
            newCave.y = Integer.parseInt(values[i+1]);//[2] element

            //Add cave
            allCaves.add(newCave);
        }
        System.out.println(allCaves);

        // Set the connection Matrix to null
        String[][] connectionMatrix = new String[cavesNumber][cavesNumber];
        for (int i=0; i<cavesNumber; i++){
            for (int j=0; i<=cavesNumber-2; j++) {
                connectionMatrix[i][j] = null;
            }
        }

        // Create matrix
        int connection = cavesNumber*2+1;
        int y;
        for(y=0; y<cavesNumber; y++);
        {
            for(int x=0; x<cavesNumber; x++)
            {
                connectionMatrix[x][y] = values[x + connection];
                connection++;
            }
        }

        for (int i=0; i<cavesNumber; i++){
            for (int j=0; i<cavesNumber; j++) {
                System.out.println(connectionMatrix + ",");
            }
        }



        /**
        // Create a 2D array to search through the matrix to determine connections
        int index =0; // acts as a counter
        int connection=cavesNumber*2+1; // start the matrix after the number of caves and the coordinates
        for (int i=connection; i<=values.length; i++) {
            for(int j=connection; j<=values.length; j++){
                connectionMatrix[i][j] =
            }
            //System.out.println(index);
            index++;
        }
        **/

        /*
        // Matrix
        int [][] matrix;
        int j =0;
        for(j<7)
        {
            for(int i=0; i<7; i++) {
                //add to array
                matrix[i*j];
            }
            j++;
        }




        int index =0; // acts as a counter
        String[][] connectionMatrix = new String[cavesNumber][cavesNumber];
        int connection=cavesNumber*2+1;
        //int counter =0;
        for (int i=connection; i<=values.length; i++) {
            for(int j=connection; j<=values.length; j++){
                int counter =0;
                if(connectionMatrix[i][j].equals("1")){
                    // add to connections
                }
            }
            System.out.println(index);
            index++;
        }
         /*
         int connection=cavesNumber*2+1; // skip the number of caves and the coordinates
        for (int i=connection; i<=input.length; i++) {
            ArrayList<Cave> links = new ArrayList<Cave>()
            if(input[i].equals("1")){
                input
                links.add(); // add connection to cave
            }

        int[] connectionMatrix = new int[cavesNumber];
        int connection=cavesNumber*2+1;
        for (int i=connection; i<=cavesNumber; i++) {
                int counter = 0;
                for(int )
                }

        */

    }
}




