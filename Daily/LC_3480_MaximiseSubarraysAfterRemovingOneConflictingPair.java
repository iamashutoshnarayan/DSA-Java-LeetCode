class Solution {
    // Topic : Array, Segment Tree, Enumeration, Prefix Sum
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        List<Integer>[] conflicts = new List[n + 1];
        for (int i = 1; i <= n; i++) conflicts[i] = new ArrayList<>();
        for (int[] pair : conflictingPairs) {
            int a  = pair[0], b = pair[1];
            int L = Math.min(a, b), R = Math.max(a, b);
            conflicts[R].add(L);
        }

        long totalValid = 0;
        long[] gain = new long[n + 1];
        int maxLeft = 0, secondMaxLeft = 0;

        for (int r = 1; r <= n; r++) {
            for (int L : conflicts[r]) {
                if (L > maxLeft) {
                    secondMaxLeft = maxLeft;
                    maxLeft = L;
                } else if (L > secondMaxLeft) {
                    secondMaxLeft = L;
                }
            }
            totalValid += (r - maxLeft);
            gain[maxLeft] += (maxLeft - secondMaxLeft);
        }

        long maxGain = 0;
        for (long g : gain) maxGain = Math.max(g, maxGain);

        return totalValid + maxGain;
    }
}