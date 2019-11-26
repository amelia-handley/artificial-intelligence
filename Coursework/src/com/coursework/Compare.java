package com.coursework;

import java.util.Comparator;
class Compare implements Comparator<Cave> {

        public int compare(Cave a, Cave b)
        {
            return Double.compare(a.getShortestPath(), b.getShortestPath());
        }

}
