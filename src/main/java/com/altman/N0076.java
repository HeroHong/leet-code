package com.altman;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ji.yuhong
 * @date 2024/1/10 11:48
 */
public class N0076 {
    public static void main(String[] args) {
        int a = 0;
        while (aaaaa(a++)) {
            System.out.println("111111");
        }
//        N0076 t = new N0076();
//        String s = t.minWindow("ADOBECODEBANC", "ABC");
//        System.out.println(s);
    }

    public static boolean aaaaa(int a) {
        return a < 3;
    }

    /**
     * a    97
     * z    122
     * A    65
     * Z    90
     */

    public String minWindow2(String s, String t) {
        int[] sArrays = new int[60], tArrays = new int[60];
        int r = 0;

        for (char c : t.toCharArray()) {
            if (++tArrays[index(c)] == 1) {
                r++;
            }
        }

        String res = "";
        for (int i = 0, j = 0; i < s.length(); i++) {
            int index = index(s.charAt(i));
            //这里只能是1
            if (++sArrays[index] == tArrays[index]) {
                r--;
            }
            while (j < i) {
                int indexJ = index(s.charAt(j));
                if (sArrays[indexJ] > tArrays[indexJ]
                        && --sArrays[indexJ] > 0) {
                    j++;
                } else {
                    break;
                }
            }
            if (r == 0 && (res.length() == 0 || res.length() > (i - j + 1))) {
                res = s.substring(j, i + 1);
            }
        }
        return res;
    }

    private int index(char c) {
        return c - 'A';
    }


    public String minWindow(String s, String t) {

        int[] a1 = new int[60],
                a2 = new int[60];

        for (char c : s.toCharArray()) {
            ++a1[index(c)];
        }

        for (int i = 0; i < s.length(); i++) {


        }
        return "";
    }

    public String minWindow1(String s, String t) {

        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> target = new HashMap<>(t.length());
        Map<Character, Integer> source = new HashMap<>(s.length());

        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            source.put(character, source.getOrDefault(character, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            Character character = t.charAt(i);
            int count = target.getOrDefault(character, 0) + 1;
            target.put(character, count);

            if (source.getOrDefault(character, 0) < count) {
                return "";
            }
        }
        int start = 0, end = s.length() - 1;
        while (start <= end) {
            Character startChar = s.charAt(start);
            Character endChar = s.charAt(end);

            boolean startMove = false, endMove = false;

            Integer startCount, endCount;
            if ((startCount = target.get(startChar)) == null) {
                start++;
                startMove = true;
            } else {
                if (source.get(startChar) > startCount) {
                    start++;
                    startMove = true;
                    source.put(startChar, source.get(startChar) - 1);
                }
            }

            if ((endCount = target.get(endChar)) == null) {
                end--;
                endMove = true;
            } else {
                if (source.get(endChar) > endCount) {
                    end--;
                    endMove = true;
                    source.put(endChar, source.get(endChar) - 1);
                }
            }
            if (!startMove && !endMove) {
                break;
            }
        }
        return s.substring(start, end + 1);
    }
}
