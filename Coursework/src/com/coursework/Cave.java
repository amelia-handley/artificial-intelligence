package com.coursework;

import java.util.*;

class Cave {
    public int caveNumber;
    public double x;
    public double y;
    ArrayList<Cave> connections;
    Map<Cave, Double> edges;
    public double distance;
    public Cave nearestNeighbour;
    public double shortestPath;

    public Cave() {
        // Cave number
        this.caveNumber = caveNumber;
        // x coordinate
        this.x = x;
        // y coordinate
        this.y = y;
        // connection to other caves
        this.connections = new ArrayList<>(); // i
        // distance to other caves (connected to)
        // cave that current cave is closest to
        distance = Double.MAX_VALUE;
        this.edges = new HashMap<>();
        nearestNeighbour = null;
        shortestPath = Double.MAX_VALUE;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getCaveNumber() {
        return caveNumber;
    }

    public double getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath() {
        this.shortestPath = shortestPath;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(){
        this.distance = distance;
    }
    @Override
    public String toString() {
        return "caveNumber + '(' + x + y + ')' ";
    }
}

