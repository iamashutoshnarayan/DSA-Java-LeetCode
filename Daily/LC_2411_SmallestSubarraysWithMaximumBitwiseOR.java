class Solution {
    // Topic : Array, Binary Search, Bit Manipulation, Sliding Window
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int[] lastSeen = new int[32];

        for (int i = n - 1; i >= 0; i--) {
            for (int b = 0; b < 32; b++) {
                if ((nums[i] & (1 << b)) != 0) {
                    lastSeen[b] = i;
                }
            }

            int maxIndex = i;
            for (int b = 0; b < 32; b++) {
                maxIndex = Math.max(maxIndex, lastSeen[b]);
            }

            answer[i] = maxIndex - i + 1;
        }

        return answer;
    }
}