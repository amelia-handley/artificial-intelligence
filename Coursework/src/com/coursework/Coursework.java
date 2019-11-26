package com.coursework;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Coursework
{
    // array list to sort priority queue

    // Calculate Distance between Caves
    static double pythagoras(Cave firstCave, Cave lastCave) {
        double distanceOfX = firstCave.x - lastCave.x;
        double distanceOfY = firstCave.y - lastCave.y;

        double distance = Math.sqrt(((distanceOfY * distanceOfY) + (distanceOfX * distanceOfX)));
        return distance;
    }

    /*
    // Get the lowest distance for each cave connection within the toBeExplored arraylist
    private static Cave getLowDistanceCave(ArrayList<Cave> tobeExplored){
        Cave lowestDistanceNode = null;
        double lowestDistance = Integer.MAX_VALUE;
        for (Cave cave : tobeExplored)
        {
            for(Cave connection : cave.connections ) {
                //System.out.println("current cave: " + cave + " & curr connection: " + connection);
                double caveDistance = pythagoras(cave, connection);
                //System.out.println("dis = " + caveDistance);
                cave.edges.put(connection, caveDistance);
                //System.out.println(" connection: " + connection + " with dis: " + caveDistance + "added to cave: " + cave + " edges");
                if (caveDistance < lowestDistance) {
                    lowestDistance = caveDistance;
                    lowestDistanceNode = connection;
                }
            }
        }
        //System.out.println("----------------" + lowestDistanceNode);
        return lowestDistanceNode;
    } */

    /*
    // compares the distance with newly calculated one the current path with the new path
    private static void calculateShortest(Cave neighbourCave, double edgeWeight, Cave currentCave ){
        double currentDistance = currentCave.getDistance();
        if(currentDistance + edgeWeight < neighbourCave.getDistance()){
            neighbourCave.setDistance(currentDistance + edgeWeight);
            LinkedList<Cave> minimumPath = new LinkedList<Cave>(currentCave.getDistance());
            minimumPath.add(currentCave);
            neighbourCave.setShortestPath(minimumPath);
        }
    }*/


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
        for (int i = 1; i < cavesNumber * 2; i += 2) {
            // Create newCave
            Cave newCave = new Cave();
            // Find X Coordinate
            newCave.x = Integer.parseInt(values[i]);
            // Find Y Coordinate
            newCave.y = Integer.parseInt(values[i + 1]);//[2] element
            // Store the cave as a number
            newCave.caveNumber = counter;
            //Add cave
            allCaves.add(newCave);
            counter++; // increases cave number
        }
        //System.out.println(allCaves);

        //Create connection matrix
        int connection = cavesNumber * 2 + 1; // start the matrix after the number of caves and the coordinates
        int[][] connectionNodes = new int[cavesNumber][cavesNumber];
        for (int i = 0; i <= cavesNumber - 1; i++) {
            for (int j = 0; j <= cavesNumber - 1; j++) {
                //System.out.println("i = " + i + "j = " + j + " --------" + (values[(connection + j) + cavesNumber * i]));
                connectionNodes[i][j] = Integer.parseInt(values[(connection + j) + cavesNumber * i]);
            }
            //System.out.println(connectionNodes);
        }

        // Add connections between caves
        for (int i = 0; i <= cavesNumber - 1; i++) {
            for (int j = 0; j <= cavesNumber - 1; j++) {
                // if a 1 is found in the matrix, add the connections.
                if (connectionNodes[i][j] == 1) {
                    //int distance = pythagoras(allCaves.get(i), allCaves.get(j));
                    allCaves.get(j).addConnections(allCaves.get(i));
                }
            }
        }
        //print out caves

        for (int i = 0; i < cavesNumber - 1; i++) {
            System.out.println("Cave " + allCaves.get(i).caveNumber + " has neighbours: " + allCaves.get(i).connections);
        }

        // create array to store the cave route
        ArrayList<Cave> toBeExplored = new ArrayList<>(); // priority queue
        // array list to store the caves that have been explored
        ArrayList<Cave> exploredCaves = new ArrayList<>();

        //add all caves to priority queue
        Cave firstCave = allCaves.get(0); // set the first cave to the first element in the array
        Cave lastCave = allCaves.get(cavesNumber-1); ///cavesNumber-1
        toBeExplored.add(firstCave); // starting search for the route at the first cave
        firstCave.distance = 0;
        /*
        // While there are still caves to be explored
        while (toBeExplored.size() != 0) {
            Cave currentCave= getLowDistanceCave(toBeExplored);
            toBeExplored.remove(currentCave);
            for (Map.Entry <Cave, Double> neighbours : currentCave.edges.entrySet()){
                Cave neighbourCave = neighbours.getKey();
                double edgeWeight = neighbours.getValue();
                if(!exploredCaves.contains(neighbourCave)){
                    calculateShortest(neighbourCave, edgeWeight, currentCave);
                    System.out.println("------" + neighbourCave);
                    toBeExplored.add(neighbourCave);
                }
            }
            exploredCaves.add(currentCave);
        }
        System.out.println(exploredCaves);
        */
        Cave lowestDistanceNode;
        do {
            Cave visitedCave = toBeExplored.get(0);
            for (Cave connections : visitedCave.getConnections()) {
                //System.out.println(connections);
                // Make sure that it does not re-explore caves already been to
                if (!exploredCaves.contains(connections) && connections != visitedCave) {
                    if (!toBeExplored.contains(connections)) {
                        //System.out.println("current cave: " + cave + " & curr connection: " + connection);
                        double caveDistance = pythagoras(visitedCave, connections);
                        double distanceFromStart= pythagoras(firstCave, connections);
                        double distanceToConnection = caveDistance + distanceFromStart;
                        if (distanceToConnection < connections.getShortestPath()) {
                            lowestDistanceNode = connections;
                            toBeExplored.add(lowestDistanceNode);
                            System.out.println("lowest distance node: " + lowestDistanceNode);
                        }
                    }
                }
            }
            toBeExplored.remove(visitedCave);
            exploredCaves.add(visitedCave);
        } while (firstCave!=lastCave && toBeExplored.size() > 0);
        System.out.println("Caves explored" + exploredCaves);
        // print out cave path

        /**
        String completedRoute="";
        if(exploredCaves.contains(lastCave))
        {
            do{
               completedRoute =
            }while
        }
         **/

    }
}




