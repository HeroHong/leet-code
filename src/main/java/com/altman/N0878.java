package com.xinheyun.openapi.manufacture.workorder.api;

/**
 * @author ji.yuhong
 * @date 2024/5/16 15:55
 */
public class N0878 {

    int n, a, b, c;

    public int nthMagicalNumber(int _n, int _a, int _b) {
        n = _n;
        a = _a;
        b = _b;
        c = lcm(a, b);

        long l = 0, r = (long) 1e18;

        while (l < r) {

            long mid = (l + r) >> 1;
            if (r(mid) >= n) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return (int) (r % (1e9 + 7));
    }

    private long r(long mid) {

        return mid / a + mid / b - mid / c;
    }


    /**
     * 最小公倍数
     */
    public int lcm(int a, int b) {

        return a * b / gcd(a, b);
    }

    /**
     * 最大公约数
     */
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
