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
        int counter = 1; // count the number of caves
        for(int i=1; i<cavesNumber*2; i+=2)
        {
            // Create newCave
            Cave newCave = new Cave();
            // Find X Coordinate
            newCave.x = Integer.parseInt(values[i]);
            // Find Y Coordinate
            newCave.y = Integer.parseInt(values[i+1]);//[2] element
            // Store the cave as a number
            newCave.caveNumber = counter;
            //Add cave
            allCaves.add(newCave);
            counter++; // increases cave number
        }
        //System.out.println(allCaves);

        //loop through connections
        // for loop to drop down every 7?
            //when connection == 1 add to arraylist
            //when i gets over 7 increase counter to move to the next arraylist position

        //Create connection matrix
        int connection=cavesNumber*2+1; // start the matrix after the number of caves and the coordinates
        int[][]connectionNodes = new int[cavesNumber][cavesNumber];
        for (int i=0; i<=cavesNumber-1; i++) {
            for (int j = 0; j <= cavesNumber-1; j++) {
                //System.out.println("i = " + i + "j = " + j + " --------" + (values[(connection + j) + cavesNumber * i]));
                connectionNodes[i][j] = Integer.parseInt(values[(connection + j) + cavesNumber*i]);
            }
            //System.out.println(connectionNodes);
        }

        // Add connections between the caves
        /**
        for(int i=connection; i<=cavesNumber-1; i++)
        {
            ArrayList<Cave> connectCave = new ArrayList<Cave>();
            for(int j=0; j<cavesNumber; j++)
            {
                Cave connectionMade = new Cave();
                if(values[i] == "1"){
                    connectionMade.connections = connectionNodes;
                }
                connectCave.add(connectionMade);
            }
        }
         **/
        for(int i=0; i<=cavesNumber-1; i++){
            for(int j=0; j<=cavesNumber-1; j++){
                if(connectionNodes[i][j] == 1) {
                    allCaves.get(j).connections.add(allCaves.get(i));
                }
            }
        }

        for(int i=0; i< cavesNumber-1; i++){
            System.out.println(" Cave: " + allCaves.get(i).caveNumber + " has neighbours: " + allCaves.get(i).connections);
        }
    }
}




