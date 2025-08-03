class Solution {
    // Topic : Array, Binary Search, Sliding Window, Prefix Sum
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int ans = 0, cur = 0;
        int n = fruits.length;
        int l = 0;

        final java.util.function.BiFunction<Integer, Integer, Integer> steps = (lp, rp) -> {
            if (rp <= startPos) 
                return startPos - lp;
            else if (lp >= startPos)
                return rp - startPos;
            else
                return Math.min(startPos - lp + (rp - lp),
                                (rp - startPos) * 2 + (startPos - lp));
        };

        for (int r = 0; r < n; ++r) {
            cur += fruits[r][1];
            while (l <= r && steps.apply(fruits[l][0], fruits[r][0]) > k) {
                cur -= fruits[l][1];
                l++;
            }
            ans = Math.max(ans, cur);
        }

        return ans;
    }
}