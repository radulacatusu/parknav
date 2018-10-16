package com.mine.parknav;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Parknav {
    public static void main(String[] args) {

        int cameraRange = 10;
        int[] parkingSpaces = {1, 15, 30, 40, 50};
        //int[] parkingSpaces = {2, 4, 5, 6, 7, 9, 11, 12};
        System.out.println(findMinimumNumberOfCameras(cameraRange, parkingSpaces));
    }

    static int findMinimumNumberOfCameras(int cameraRange, int[] parkingSpaces) {
        int[] difference = new int[parkingSpaces.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < parkingSpaces.length - 1; i++) {
            map.put(parkingSpaces[i], parkingSpaces[i + 1] - parkingSpaces[i]);
            difference[i] = parkingSpaces[i + 1] - parkingSpaces[i];
        }

        map.forEach((key,value) -> {
            System.out.println("ParkingSpace: " + key + " Difference to next parking space: " + value);
        });

        ArrayList sums = new ArrayList();
        int sum = 0;
        for (int i = 0; i < difference.length - 1; i++) {
            if(sum + difference[i] < cameraRange) {
                sum = sum + difference[i];
            } else {
                sums.add(i);
                System.out.println(i);
                sum = 0;
            }
        }

        System.out.println("---------------");

/*        for (int i = 0; i < sums.size() - 1; i++) {
            System.out.println(sums.indexOf(i));
        }*/
        return difference.length;
    }

}
