# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):

    def nthMagicalNumber(self, n: int, a: int, b: int) -> int:
        def gcd(a, b):
            return a if b == 0 else gcd(b, a % b)

        def check(x):
            return x // a + x // b - x // c

        c = a * b // gcd(a, b)
        l, r = 0, 1e18
        while l < r:
            mid = (l + r) // 2
            if check(mid) >= n:
                r = mid
            else:
                l = mid + 1
        return int(r % 1000000007)

# leetcode submit region end(Prohibit modification and deletion)
