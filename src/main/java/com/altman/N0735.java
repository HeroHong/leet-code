package com.altman;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ji.yuhong
 * @date 2023/12/28 17:47
 */
public class N0735 {

    public static void main(String[] args) {
        N0735 test = new N0735();
//        int[] arrays = {5,10,-5};
//        int[] arrays = {8,-8};
//        int[] arrays = {-2,-1,1,2};
        int[] arrays = {10, 2, -5};
        int[] ints = test.asteroidCollision(arrays);
        System.out.println(ints);
    }

    public int[] asteroidCollision(int[] asteroids) {

        Deque<Integer> stack = new ArrayDeque<>();

        for (int asteroid : asteroids) {
            Integer a = asteroid,
                    b;

            while (!stack.isEmpty()
                    && a != null) {
                b = stack.getLast();
                if (a < 0 && b > 0) {
                    int absA = Math.abs(a);
                    int absB = Math.abs(b);
                    if (absA > absB) {
                        stack.removeLast();
                    } else if (absA < absB) {
                        a = null;
                    } else {
                        a = null;
                        stack.removeLast();
                    }
                } else {
                    break;
                }
            }
            if (a != null) {
                stack.addLast(a);
            }
        }

        if (stack.isEmpty()) {
            return new int[]{};
        } else {
            return stack.stream().mapToInt(i -> i).toArray();
        }
    }
}
