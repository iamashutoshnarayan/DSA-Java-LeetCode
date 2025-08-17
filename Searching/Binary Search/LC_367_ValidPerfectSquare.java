class Solution {
    // Topic : Math, Binary Search
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        int left = 2;
        int right = num / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sq = (long) mid * mid;
            if (sq == num) return true;
            else if (sq < num) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}