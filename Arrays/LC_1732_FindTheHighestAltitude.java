class Solution {
    // Topics : Arrays, Prefix Sum
    public int largestAltitude(int[] gain) {
        int highest = 0, current = 0;
        for(int g : gain) {
            current += g;
            highest = Math.max(highest, current);
        }
        return highest;
    }
}