package com.coursework;

import java.util.*;
import java.util.Comparator;

class Cave implements Comparator<Cave> {

    public int caveNumber;
    public double x;
    public double y;
    ArrayList<Cave> connections;
    public double distance;
    public double nearestNeighbour;
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
        this.nearestNeighbour = nearestNeighbour;
        distance = Double.MAX_VALUE;
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

    public void setShortestPath(double distanceToConnection) {
        this.shortestPath = shortestPath;
    }


    public double getDistance() {
        return distance;
    }
    public double getShortestNeighbour(){
        return nearestNeighbour;
    }

    public void  setShortestNeighbour(Cave visitedCave){
        this.nearestNeighbour = nearestNeighbour;
    }

    public void setDistance(){
        this.distance = distance;
    }

    public void addConnections(Cave other){
        this.connections.add(other);
    }

    public ArrayList<Cave> getConnections() {
        return connections;
    }

    public int compare(Cave a, Cave b) {
        return Double.compare(a.distance, b.distance);
    }
    @Override
    public String toString() {
        return (" " + caveNumber + " ");
    }
}

