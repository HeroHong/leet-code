package com.altman;

/**
 * @author ji.yuhong
 * @date 2024/7/4 17:27
 */
public class N1217 {

    public static void main(String[] args) {
        new N1217().minCostToMoveChips(new int[]{11});
    }
    public int minCostToMoveChips(int[] position) {
        if (position == null || position.length == 0) {
            return 0;
        }
        int dis = Integer.MAX_VALUE;
        for (int i = 0; i < position.length; i++) {
            dis = Math.min(dis, minCostToMoveChips(position, i));
        }
        return dis;
    }

    private int minCostToMoveChips(int[] position, int index) {
        int c = 0;
        for (int i = 0; i < position.length; i++) {
            c += (Math.abs(position[i] - position[index]) % 2) == 0 ? 0 : 1;
        }
        return c;
    }
}
