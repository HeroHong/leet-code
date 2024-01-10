package com.altman;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author ji.yuhong
 * @date 2023/12/18 19:46
 */
public class N0042 {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        int[] height = {3, 2, 1, 2, 3};
//        int[] height = {4,2,0,3,2,5};
        N0042 x = new N0042();
        int trap = x.trap(height);
        System.out.println(trap);
    }

    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        int maxHeight = 0;
        for (int i : height) {
            maxHeight = Math.max(maxHeight, i);
        }
        int total = maxHeight * height.length,
                lTotal = 0,
                rTotal = 0,
                totalSum = Arrays.stream(height).sum();

       int lHeight = 0, rHeight = 0;
        for (int j : height) {
            lTotal += (lHeight = Math.max(lHeight, j));
        }
        for (int i = height.length - 1; i >= 0; i--) {
            rTotal += (rHeight = Math.max(rHeight, height[i]));
        }

        return lTotal + rTotal - total - totalSum;
    }

    public int trap3(int[] height) {

        Deque<Integer> stack = new ArrayDeque<>();

        int res = 0;
        for (int i = 0; i < height.length; i++) {

            while (!stack.isEmpty()
                    && height[i] > height[stack.peekLast()]) {
                int cus = stack.pollLast();
                if (stack.isEmpty()) {
                    continue;
                }
                int left = stack.peekLast(), right = i;
                int weight = right - left - 1,
                        h = Math.max(Math.min(height[left], height[right]) - height[cus], 0);
                res += weight * h;
            }
            stack.addLast(i);
        }
        return res;
    }

    public int trap2(int[] height) {
        int length;
        if (height == null
                || (length = height.length) <= 2) {
            return 0;
        }
        int[] cacheL = new int[length];
        cacheL[0] = height[0];

        for (int i = 1; i < length - 1; i++) {
            cacheL[i] = Math.max(cacheL[i - 1], height[i]);
        }
        int[] cacheR = new int[length];
        cacheR[length - 1] = height[length - 1];
        for (int i = length - 2; i > 0 ; i--) {
            cacheR[i] = Math.max(cacheR[i + 1], height[i]);
        }

        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int cur = height[i];

            int l = cacheL[i - 1];
            int r = cacheR[i + 1];
            if (l <= cur) {
                continue;
            }
            if (r <= cur) {
                continue;
            }
            res += Math.min(l, r) - cur;
        }
        return res;
    }

    public int trap1(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int result = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int cur = height[i];
            int l = height(height, 0, i - 1);
            if (l <= cur) {
                continue;
            }
            int r = height(height, i + 1, height.length - 1);
            if (r <= cur) {
                continue;
            }
            result += Math.min(l, r) - cur;
        }
        return result;
    }


    public int height(int[] height, int minIndex, int maxIndex) {
        int cIndex = minIndex;
        int r = 0;
        while (cIndex < height.length && cIndex <= maxIndex) {
            r = Math.max(r, height[cIndex]);
            cIndex++;
        }
        return r;
    }
}
