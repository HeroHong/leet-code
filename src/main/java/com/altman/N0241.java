package com.altman;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ji.yuhong
 * @date 2024/7/2 19:33
 */
public class N0241 {

    char[] charArray;

    public List<Integer> diffWaysToCompute(String expression) {

        charArray = expression.toCharArray();

        return dfs(0, expression.length() - 1);
    }

    public static void main(String[] args) {
        List<Integer> integers = new N0241().diffWaysToCompute("2-1-1");
    }
    public List<Integer> dfs(int l, int r) {
        List<Integer> res = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if (charArray[i] >= '0' && charArray[i] <= '9') continue;
            List<Integer> left = dfs(l, i - 1), right = dfs(i + 1, r);
            for (Integer l1 : left) {
                for (Integer r1 : right) {
                    if (charArray[i] == '+')
                        res.add(l1 + r1);
                    else if (charArray[i] == '-')
                        res.add(l1 - r1);
                    else
                        res.add(l1 * r1);
                }
            }
        }
        if (res.isEmpty()) {
            int cur = 0;
            for (int i = l; i <= r; i++) cur = cur * 10 + charArray[i] - '0';
            res.add(cur);
        }
        return res;
    }
}