package com.coursework;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Coursework
{
    // array list to sort priority queue

    static double pythagoras(Cave firstCave, Cave lastCave) {
        double distanceOfX = firstCave.x - lastCave.x;
        double distanceOfY = firstCave.y - lastCave.y;

        double distance = Math.sqrt(((distanceOfY * distanceOfY) + (distanceOfX * distanceOfX)));
        return distance;
    }

    private static Cave getLowDistanceCave(ArrayList<Cave> tobeExplored){
        Cave lowestDistanceNode = null;
        double lowestDistance = Integer.MAX_VALUE;
        for (Cave cave : tobeExplored)
        {
            for(Cave connection : cave.connections ) {
                System.out.println("current cave: " + cave + " & curr connection: " + connection);
                double caveDistance = pythagoras(cave, connection);
                System.out.println("dis = " + caveDistance);
                cave.edges.put(connection, caveDistance);
                System.out.println(" connection: " + connection + " with dis: " + caveDistance + "added to cave: " + cave + " edges");
                if (caveDistance < lowestDistance) {
                    lowestDistance = caveDistance;
                    lowestDistanceNode = connection;
                }
            }
        }
        System.out.println("----------------" + lowestDistanceNode);
        return lowestDistanceNode;
    }

    public static void calculateMin(Cave neighbourNode, double edgeWeigh, Cave currentNode ){
        double currentDistance = currentNode.distance;
        if(currentNode + edgeWeigh < neighbourNode.distance ){
            
        }

    }


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

        // Add connections between caves
        for(int i=0; i<=cavesNumber-1; i++){
            for(int j=0; j<=cavesNumber-1; j++){
                // if a 1 is found in the matrix, add the connections.
                if(connectionNodes[i][j] == 1) {
                    //int distance = pythagoras(allCaves.get(i), allCaves.get(j));
                    allCaves.get(j).connections.add(allCaves.get(i));
                }
            }
        }

        //print out caves
        for(int i=0; i< cavesNumber-1; i++){
            System.out.println("Cave " + allCaves.get(i).caveNumber + " has neighbours: " + allCaves.get(i).connections);
        }


        // finding lengths of paths

        // create array to store the cave route
        ArrayList<Cave> toBeExplored = new ArrayList<>(); // priority queue
        // array list to store the caves that have been explored
        ArrayList<Cave> exploredCaves = new ArrayList<>();


        //add all caves to priority queue
        Cave cavePath= allCaves.get(3); // set the first cave to the first element in the array
        //Cave lastCave = cavePath.get(cavesNumber-1);
        toBeExplored.add(cavePath);
        getLowDistanceCave(toBeExplored);
        //while (exploredCaves.size() != 0) {

            // get parent cave (shortest length in priority queue)

            // get list of child nodes
            // for loop to go through list of child nodes
            // get child cave
            // calculate distance between parent and child
            // if calculated length of child cave is less than the saved path
            // save length of child cave
            // increment
            //add parent cave to the exploredCave list
            //remove parent cave from priorityqueue
            //sort priority queue by its shortest length
        //}

           // ArrayList<Cave> route = new ArrayList<>();
        //find out the route
        // add final cave to the route arraylist .add
        // int x=visitedlist.length-1
        // for (i = end of exploredCave, i <= 0)
        // get recentCave = exploredCave(i)
        // get the nextCave(x)
        //if recentDistance - calculated distance = nextCave distance
        // add the nextCave to route list
        // i = x //x=nextCave
        //else
        // x-- // go to cave behind

        //output to file





    }
}




