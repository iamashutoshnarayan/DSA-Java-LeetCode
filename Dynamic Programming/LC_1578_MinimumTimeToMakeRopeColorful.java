class Solution {
    public int minCost(String colors, int[] neededTime) {
        int totalCost = 0;
        int prevMaxTime = neededTime[0];
        
        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                totalCost += Math.min(prevMaxTime, neededTime[i]);
                prevMaxTime = Math.max(prevMaxTime, neededTime[i]);
            } else {
                prevMaxTime = neededTime[i];
            }
        }
        return totalCost;
    }
}
