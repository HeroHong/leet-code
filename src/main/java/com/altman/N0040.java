package com.altman;

import java.util.Arrays;

/**
 * @author ji.yuhong
 * @date 2023/12/19 22:21
 */
public class N0040 {

    public static void main(String[] args) {
//        int[] cards = {1, 2, 8, 9};
//        int[] cards = {3, 3, 1};
//        int[] cards = {7, 4, 1};
        int[] cards = {7, 6, 4, 6};
        int cnt = 1;

        N0040 n0040 = new N0040();
        int i = n0040.maxmiumScore(cards, cnt);
        System.out.println(i);
    }

    public int maxmiumScore(int[] cards, int cnt) {

        Arrays.sort(cards);

        int[] su = new int[cnt];
        int oddCunt = 0,
                //奇数
                minOdd = Integer.MAX_VALUE,
                //偶数
                minEven = Integer.MAX_VALUE;
        boolean hasEven = false;
        for (int i = cards.length - 1; i > cards.length - cnt - 1; i--) {
            int card;
            su[cards.length - i - 1] = (card = cards[i]);
            if (card % 2 == 1) {
                oddCunt++;
                minOdd = Math.min(minOdd, card);
            } else {
                minEven = Math.min(minEven, card);
                hasEven = true;
            }
        }
        if (oddCunt % 2 == 1) {
            if (cards.length == cnt) {
                return 0;
            }
            int fOdd = 0, fEven = 0;
            boolean lHasOdd = false, lHasEven = false;
            for (int i = cards.length - cnt - 1; i >= 0; i--) {
                int card = cards[i];
                if (card % 2 == 1) {
                    if (!lHasOdd) {
                        fOdd = card;
                    }
                    lHasOdd = true;
                } else {
                    if (!lHasEven) {
                        fEven = card;
                    }
                    lHasEven = true;
                }
                if (lHasOdd && lHasEven) {
                    break;
                }
            }
            int r = Arrays.stream(su).sum();
//            if (!lHasOdd) {
//                return r - minOdd + fEven;
//            } else if (!lHasEven) {
//                if (!hasEven) {
//                    return 0;
//                }
//                return r - minEven + fOdd;
//            }
            if (!hasEven) {
                //里面都是奇数
                if (!lHasEven) {
                    return 0;
                }
                return r - minOdd + fEven;
            }
            //已包含偶数
            if (!lHasEven) {
                //后面没有偶数，只能把里面的偶数去掉换一个最大的奇数
                if (!lHasOdd) {
                    return 0;
                }
                return r - minEven + fOdd;
            } else {
                //后面有偶数
                if (minOdd + fOdd > minEven + fEven) {
                    //取dddd奇数
                    return r - minEven + fOdd;
                } else {
                    //取偶数
                    return r - minOdd + fEven;
                }
            }

        }
        return Arrays.stream(su).sum();
    }
}
