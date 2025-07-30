class Solution {
    // Topic : Array, Backtracking, Bit Manipulation, Enumeration
    int count = 0;
    int maxOr = 0;

    public int countMaxOrSubsets(int[] nums) {
        for (int num : nums) {
            maxOr |= num;
        }

        dfs(nums, 0, 0);
        return count;
    }

    void dfs(int[] nums, int index, int currOr) {
        if (index == nums.length) {
            if (currOr == maxOr) count++;
            return;
        }

        dfs(nums, index + 1, currOr | nums[index]);

        dfs(nums, index + 1, currOr);
    }
}