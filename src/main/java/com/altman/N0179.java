package com.altman;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author ji.yuhong
 * @date 2023/12/23 17:56
 */
public class N0179 {

    public static void main(String[] args) {

        N0179 n = new N0179();
//        int[] arrays = {9, 123, 12, 3};
//        int[] arrays = {3, 30, 34, 5, 9};
//        int[] arrays = {432, 43243};
        int[] arrays = {0, 0};
        System.out.println(n.largestNumber(arrays));
    }

    public String largestNumber(int[] nums) {

        String r = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .sorted((a, b) -> (b + a).compareTo(a + b))
                .collect(Collectors.joining());

        int index = 0;
        while (index < r.length() - 1 && r.charAt(index) == '0') {
            index++;
        }
        return r.substring(index);
    }

//    public int compare(String a, String b) {
//        for (int i = 0;
//             i < Math.min(a.length(), b.length()); i++) {
//            int r = b.charAt(i) - a.charAt(i);
//            if (r != 0) {
//                return r;
//            }
//        }
//        return a.length() - b.length();
//    }

//    public String largestNumber(int[] nums) {
//
//        List<String> list = Arrays.stream(nums)
//                .mapToObj(String::valueOf).sorted(this::compare).collect(Collectors.toList());
//
//        if (nums.length == 1) {
//            return String.valueOf(nums[0]);
//        }
//        StringBuilder res = new StringBuilder();
//
//        while (list.size() > 0) {
//
//
//
//            String pending = list.get(0);
//            int removeIndex = 0;
//
//            if (list.size() > 1) {
//                String next = list.get(1);
//                String next = null;
//
//
//                for (int i = 1; i < list.size(); i++) {
//                    String current = list.get(i);
//                    if (current.startsWith(pending)) {
//                        if (next == null) {
//                            if () {
//
//                            }
//                        }
//                    }
//                }
//
//                while (next.startsWith(pending)) {
//                    next = next.substring(pending.length());
//                }
//                if (compare(pending, next) > 0) {
//                    res.append(list.remove(1));
//                    continue;
//                }
//            }
//            res.append(list.remove(0));
//        }
//        return res.toString();
//    }
}
