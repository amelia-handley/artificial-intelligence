package com.coursework;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Coursework
{
    /*
    private static Cave getLowDistanceCave(ArrayList<Cave> tobeExplored){
        Cave lowestDistanceNode = null;
        double lowestDistance = Integer.MAX_VALUE;
        for (Cave cave : tobeExplored) // explore each of the caves in the array
        {
            for(Cave connection : cave.connections ) //explore each of the connections {
                System.out.println("current cave: " + cave + " & curr connection: " + connection);
                double caveDistance = pythagoras(cave, connection);
                System.out.println("dis = " + caveDistance);
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
    */

    // Calculate Distance between Caves
    static double euclidean(Cave firstCave, Cave lastCave) {
        double distanceOfX = firstCave.x - lastCave.x;
        double distanceOfY = firstCave.y - lastCave.y;

        double distance = Math.sqrt(((distanceOfY * distanceOfY) + (distanceOfX * distanceOfX)));
        return distance;
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
        int numberCaves = Integer.parseInt(values[0]);
        // create array list
        ArrayList<Cave> allCaves = new ArrayList<Cave>();
        // start for loop at 1, as the first element in the array is the number of caves
        int counter = 1; // count the number of caves
        for (int i = 1; i < numberCaves * 2; i += 2) {
            // Create newCave
            Cave newCave = new Cave();
            // Find X Coordinate
            newCave.x = Integer.parseInt(values[i]);
            // Find Y Coordinate
            newCave.y = Integer.parseInt(values[i + 1]);
            // Store the cave as a number
            newCave.caveNumber = counter;
            //Add cave
            allCaves.add(newCave);
            counter++; // increases cave number
        }
        //System.out.println(allCaves);

        //Create connection matrix
        int connection = numberCaves * 2 + 1; // start the matrix after the number of caves and the coordinates
        int[][] connectionCaves = new int[numberCaves][numberCaves];
        for (int i = 0; i <= numberCaves - 1; i++) {
            for (int j = 0; j <= numberCaves - 1; j++) {
                //System.out.println("i = " + i + "j = " + j + " --------" + (values[(connection + j) + numberCaves * i]));
                connectionCaves[i][j] = Integer.parseInt(values[(connection + j) + numberCaves * i]);
                //for location i,j in matrix table: convert to int values (sepereated read in file) position in string connection + j
                //where connection is number of caves *2+1 to get to correct position in values. And adding J to get to correct position in row
                //number of caves * i is where the row is being chosen, so that
            }
            //System.out.println(connectionCaves);
        }

        // Add connections between caves
        for (int i = 0; i <= numberCaves - 1; i++) {
            for (int j = 0; j <= numberCaves - 1; j++) {
                // if a 1 is found in the matrix, add the connections.
                if (connectionCaves[i][j] == 1) {
                    //double setDistance = pythagoras(allCaves.get(i), allCaves.get(j));
                    allCaves.get(j).addConnections(allCaves.get(i));
                }
            }
        }
        //print out caves

        for (int i = 0; i < numberCaves - 1; i++) {
            System.out.println("Cave " + allCaves.get(i).caveNumber + " has neighbours: " + allCaves.get(i).connections);
        }

        // create array to store the caves in the matrix (priority queue)
        ArrayList<Cave> toBeExplored = new ArrayList<>();
        // array list to store the caves that have been explored
        ArrayList<Cave> exploredCaves = new ArrayList<>();

        //add all caves to priority queue
        Cave firstCave = allCaves.get(0); // set the first cave to the first element in the array
        Cave lastCave = allCaves.get(numberCaves-1); ///numberCaves-1 (find last cave in array)
        toBeExplored.add(firstCave); // starting search for the route at the first cave
        Cave visitedCave; //declare visitedCave
        double lowestDistance = Integer.MAX_VALUE;
        Cave lowestDistanceNode;

        // while there are still caves to be explored
        while(toBeExplored.size() > 0)
        {
            visitedCave = toBeExplored.get(0); //start search at visitedCave
            // (cave currently searching)
            toBeExplored.remove(visitedCave); // remove the visited cave from the array list
            // so it is not visited again
            // Explore all connections in each cave
            for (Cave connections : visitedCave.getConnections()) {
                // Make sure that it does not re-explore caves already been to
                if (!exploredCaves.contains(connections) && connections != visitedCave) {
                    // if it finds a cave that it does not have connections to, add it
                    if (!toBeExplored.contains(connections)) {
                        toBeExplored.add(connections);
                    }
                    //Calculate the current cave distance to its connections
                    double caveDistance = euclidean(visitedCave, connections);
                    // Calculate distance from start
                    double distanceFromStart= euclidean(visitedCave, firstCave);
                    if ( caveDistance < distanceFromStart) {
                        lowestDistance = caveDistance;
                        lowestDistanceNode = connections;
                    }
                }
            }
            exploredCaves.add(visitedCave);
            // sort tobeexplored by distance
        }

        //add all caves to priority queue
        //while (lastcave != priorityQueue.get(0))
            // get parent cave (shortest length in priority queue)
            // remove parent cave from priorityqueue
            // get list of child nodes
                // for loop to go through list of child nodes and their connections
                // get child cave
                // calculate distance between parent and child
                // if calculated length of child cave is less than the saved path
                    // save length of child cave
                    // move to next connection
        //add parent cave to the exploredCave list
        //sort priority queue by its shortest length

        //ArrayList<Cave> route = new ArrayList<>();
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




