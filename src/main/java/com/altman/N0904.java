package com.altman;

/**
 * @author ji.yuhong
 * @date 2024/1/3 18:54
 */
public class N0904 {

    public static void main(String[] args) {
        N0904 t = new N0904();
        int[] fruits = {1, 2, 1, 2, 2, 2, 3, 3, 3, 3};
        int i = t.totalFruit(fruits);
        System.out.println(i);
    }

    public int totalFruit(int[] fruits) {

        int result = 0;
        boolean isOk = false;

        for (int i = 0; i < fruits.length; i++) {
            int range = 1;
            int a = fruits[i],
                    b = -1;
            for (int j = i + 1; j < fruits.length; j++) {
                int c = fruits[j];
                boolean bIsEmpty = false;
                if (a == c
                        || (bIsEmpty = (b == -1))
                        || b == c) {

                    if (bIsEmpty) {
                        b = c;
                    }
                    range++;
                    if (j == fruits.length - 1) {
                        isOk = true;
                    }
                } else {
                    int f = fruits[--j];
                    while ((--j) > 0 && fruits[j] == f) {
                    }
                    i = j;
                    break;
                }
            }
            if (range > result) {
                result = range;
            }
            if (isOk) {
                break;
            }
        }
        return result;
    }
}
