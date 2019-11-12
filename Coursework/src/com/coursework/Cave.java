package com.coursework;

class Cave {
    public int x;
    public int y;

    public Cave() {
        // x coordinate
        this.x = x;
        // y coordinate
        this.y = y;
        // connection to other caves
        // distance to other caves (connected to)
        // cave that current cave is closest to
    }

    public int getXCoord() {
        return x;
    }

    public void setXCoord() {
        this.x = x;
    }

    public int getYCoord() {
        return this.y;
    }

    public void setYCoord() {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("X=" + x + ", Y=" + y);
    }
}
// total number of caves
