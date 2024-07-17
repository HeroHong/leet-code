package com.altman;

/**
 * @author ji.yuhong
 * @date 2024/7/17 20:22
 */
public class N0390 {

    public int lastRemaining(int n) {
        return n == 1 ? 1 : 2 * (n / 2 + 1 - lastRemaining(n / 2));
    }
}
