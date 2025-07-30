class Solution {
    // Topic : Array, Hash Table, Greedy
    public int maxSum(int[] nums) {
        Set<Integer> subArr = new HashSet<>();
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] > 0 && !subArr.contains(nums[i])) {
                subArr.add(nums[i]);
                sum += nums[i];
            }
        }
        return max <= 0 ? max : sum;
    }
}