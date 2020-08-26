package com.basic.twod;


public class Point implements Comparable<Point> {
    private int x;
    private int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean existsIn(Point[] graph) {
        for (Point p : graph) {
            if (p.x == this.x && p.y == this.y) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Point{" + "X=" + x + ", Y=" + y + '}';
    }

    @Override
    public int compareTo(Point p) {
        if(Integer.compare(this.getX(),p.getX()) == 0)
        {
            return Integer.compare(this.getY(), p.getY());
        }

        return Integer.compare(this.getX(),p.getX());
    }
}