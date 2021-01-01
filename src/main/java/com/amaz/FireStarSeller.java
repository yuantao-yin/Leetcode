package com.amaz;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FireStarSeller {

    public static int fiveStarReviews2(int[][] productRatings, int ratingsThreshold) {
        int step = 0;
        double currentThreshold = 0;
        double sumRating = 0;
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double a1 = (double) (o1[0]+1) / (o1[1]+1) - (double) o1[0] / o1[1];
                double a2 = (double) (o2[0]+1) / (o2[1]+1) - (double) o2[0] / o2[1];
                int rst = (int) (a2 - a1);
                return rst;
            }
        });
        for(int i=0; i<productRatings.length; i++) {
            double percentRate = (double) (productRatings[i][0]) / (productRatings[i][1]);
            queue.add(productRatings[i]);
            sumRating += percentRate;
        }
//        while (!queue.isEmpty()) {
//            System.out.println(Arrays.toString(queue.poll()));
//        }
        double targetThreshold = (double) ratingsThreshold / 100 * productRatings.length;
        if (sumRating >= targetThreshold) {
            return 0;
        }
        while (!queue.isEmpty() && sumRating < targetThreshold) {
            int[] cur = queue.poll();
            if ((double) cur[0]/cur[1] == 1) {
                continue;
            } else {
                //int[] newProdRate = new int[]{cur[0]+1, cur[1]+1};
                sumRating = sumRating - (double) cur[0]/cur[1]
                    + (double) (cur[0]+1)/(cur[1]+1);
                step++;
                queue.add(new int[]{cur[0]+1, cur[1]+1});
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int[][] productRatings = new int[3][2];
        productRatings[0] = new int[]{4,4};
        productRatings[1] = new int[]{1,2};
        productRatings[2] = new int[]{3,6};
        //productRatings[3] = new int[]{1,7};

        //fiveStarReviews(productRatings, 75);
        int step = fiveStarReviews2(productRatings, 75);
        System.out.print(step);
    }
}
