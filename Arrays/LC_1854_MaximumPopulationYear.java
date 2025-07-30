class Solution {
    // Topic : Array, Prefix Sum
    public int maximumPopulation(int[][] logs) {
        int[] yearChange = new int[101];
        for (int[] log : logs) {
            int birth = log[0];
            int death = log[1];
            yearChange[birth - 1950] += 1;
            yearChange[death - 1950] -= 1;
        }
        int maxPop = 0;
        int maxYear = 1950;
        int currPop = 0;

        for (int i = 0; i < yearChange.length; i++) {
            currPop += yearChange[i];
            if (currPop > maxPop) {
                maxPop = currPop;
                maxYear = 1950 + i;
            }
        }
        return maxYear;
    }
}