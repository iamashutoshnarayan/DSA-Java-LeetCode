class Solution {
    // Topics : Array, Hash Table, Sliding Window
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> window = new HashSet<>();
        int left = 0;
        int curr_score = 0;
        int max_score = 0;
        for(int right = 0; right < nums.length; right++) {
            while(window.contains(nums[right])) {
                window.remove(nums[left]);
                curr_score -= nums[left];
                left++;
            }
            window.add(nums[right]);
            curr_score += nums[right];
            max_score = Math.max(curr_score, max_score);
        }
        return max_score;
    }
}