package com.coursework;

import java.util.*;


class Cave {

    public int caveNumber;
    public double x;
    public double y;
    ArrayList<Cave> connections;
    public double distance;
    public Cave nearestNeighbour;
    //public double shortestPath;

    public Cave() {
        // Cave number
        this.caveNumber = caveNumber;
        // x coordinate
        this.x = x;
        // y coordinate
        this.y = y;
        // connection to other caves
        this.connections = new ArrayList<>(); // i
        // distance to other caves (connected to) - set to max value as we do not know distance yet
        distance = Double.MAX_VALUE;
        // cave that current cave is closest to
        this.nearestNeighbour = nearestNeighbour;
        // store shortest path (arraylist?)
        //shortestPath = Double.MAX_VALUE;
    }

    // getters and setters
    // add connections between caves from the current cave
    public void addConnections(Cave current){
        this.connections.add(current);
    }

    // get connections from the array list
    public ArrayList<Cave> getConnections() {
        return connections;
    }

    @Override
    public String toString() {
        return (" " + caveNumber);
    }
}

