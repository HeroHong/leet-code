package com.altman;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ji.yuhong
 * @date 2023/12/19 22:15
 */
public class N0871 {
    /**
     * input:100
     * 1
     * [[10,100]]
     * <p>
     * <p>
     * 100
     * 10
     * [[10,60],[20,30],[30,30],[60,40]]
     * <p>
     * input:100
     * 50
     * [[50,50]]
     * 1000
     * 			299
     * 			[[14,123],[145,203],[344,26],[357,68],[390,35],[478,135],[685,108],[823,186],[934,217],[959,80]]
     */

    public static void main1(String[] args) {
        N0871 t = new N0871();
//        int[][] stations = {{10, 100}};
//        int[][] stations = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};

        int[][] stations = {{14,123},{145,203},{344,26},{357,68},{390,35},{478,135},{685,108},{823,186},{934,217},{959,80}};

        System.out.println(t.minRefuelStops(1000, 299, stations));
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target) {
            return 0;
        } else if (stations.length == 0) {
            return -1;
        }
        //至少需要加油一次
        int cursor = 0,
                fuel = startFuel,
                position = 0;

        PriorityQueue<Integer> passFuel = new PriorityQueue<>(Comparator.reverseOrder());

        //能否到当前位置
        for (int[] station : stations) {
            int currentPosition = station[0],
                    distance = currentPosition - position;

            position = currentPosition;

            int residueFuel = fuel - distance;
            if (residueFuel < 0) {
                Integer m;
                while (residueFuel < 0
                        && (m = passFuel.poll()) != null) {

                    residueFuel = m + residueFuel;
                    cursor = cursor + 1;
                }
                if (residueFuel < 0) {
                    return -1;
                }
            }
            fuel = residueFuel;
            passFuel.add(station[1]);
        }
        int distance = target - position;
        if (distance > 0) {
            int residueFuel = fuel - distance;
            if (residueFuel >= 0) {
                return cursor;
            }
            Integer m;
            while (residueFuel < 0
                    && (m = passFuel.poll()) != null) {

                residueFuel = m + residueFuel;
                cursor = cursor + 1;
            }
            if (residueFuel < 0) {
                return -1;
            }
        }
        return cursor;
    }
}
