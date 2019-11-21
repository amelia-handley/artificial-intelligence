package com.coursework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Cave {
    public int caveNumber;
    public int x;
    public int y;
    ArrayList<Cave> connections;
    Map<Cave, Double> edges;
    public double distance;

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
        this.distance = distance;
        this.edges = new HashMap<>();
    }

    @Override
    public String toString() {
        return String.format(caveNumber + "(" + x + "," + y + ")" );
    }
}

