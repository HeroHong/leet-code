package com.altman;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ji.yuhong
 * @date 2024/7/2 11:50
 */
public class N0761 {
    public String makeLargestSpecial(String s) {
        if (s.length() == 0) return s;
        List<String> list = new ArrayList<>();

        char[] charArray = s.toCharArray();

        for (int i = 0, j = 0, k = 0; i < charArray.length; i++) {
            k += charArray[i] == '1' ? 1 : -1;
            if (k == 0) {
                list.add("1" + makeLargestSpecial(s.substring(j + 1, i)) + "0");
                j = i + 1;
            }
        }
        return list.stream()
            .sorted((a, b) -> (b + a)
                .compareTo((a + b)))
            .collect(Collectors.joining());
    }
}
