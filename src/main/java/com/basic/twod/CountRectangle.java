package com.basic.twod;


import java.util.Arrays;

/**
 *    leftup  (1,4)----(7,4) rightup
 *             |         |
 *             |         |
 *    leftdown(1,1)----(7,1) rightdown
 */
public class CountRectangle {
    public static int getRectangleCount(int[][] coordinates) {
        if (coordinates.length < 1 || coordinates.length > 100)
            return -1;
        final int MIN_POINTS_TO_CREATE_RECTANGLE = 4;
        // can't make a rectangle with less than 4 points
        if (coordinates.length < MIN_POINTS_TO_CREATE_RECTANGLE)
            return 0;
        final Point[] points = new Point[coordinates.length];
        for (int i = 0; i < coordinates.length; i++) {
            if (coordinates[i].length > 2)
                return -1;
            points[i] = new Point(coordinates[i][0], coordinates[i][1]);
        }
        Arrays.sort(points);
        int rectangleCount = 0;
        for (int i = 0; i < points.length; i++) {
            Point leftDown = points[i];
            for (int j = i + 1; j < points.length; j++) {
                Point leftUp = points[j];
                if (leftDown.getX() == leftUp.getX()) {
                    for (int k = j + 1; k < points.length; k++) {
                        Point rightDown = points[k];
                        if (leftDown.getY() == rightDown.getY()) {
                            Point probableRightUp = new Point(rightDown.getX(), leftUp.getY());
                            if (probableRightUp.existsIn(points))
                                rectangleCount++;
                        }
                    }
                }
            }
        }
        return rectangleCount;
    }


    public static void main(String[] args) {
        int coordinates[][] = { {1,1}, {7,1}, {1,4}, {1,5}, {7,4}, {7,5} };
        int count = getRectangleCount(coordinates);
        System.out.println(count);
    }


}