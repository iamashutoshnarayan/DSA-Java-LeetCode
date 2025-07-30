class Solution {
    // Topic : Array, Bit Manipulation, Brainteaser
    public int longestSubarray(int[] nums) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        int maxLen = 0, currLen = 0;
        for (int num : nums) {
            if (num == maxVal) {
                currLen++;
                maxLen = Math.max(maxLen, currLen);
            } else {
                currLen = 0;
            }
        }
        return maxLen;
    }
}