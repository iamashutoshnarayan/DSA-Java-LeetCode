class Solution {
    // Topic : Array, Math, Greedy
    public int minCostToMoveChips(int[] position) {
        int oddCount = 0;
        int evenCount = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 0) evenCount++;
            else oddCount++;
        }
        return Math.min(oddCount, evenCount);
    }
}