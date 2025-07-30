class Solution {
    // Topic : Array, Math
    public int[] plusOne(int[] digits) {
        List<Integer> result = new ArrayList<>();
        int i = digits.length - 1;
        int k = 1;
        while (i >= 0 || k > 0) {
            if (i >= 0) {
                k += digits[i];
                i--;
            }
            result.add(k % 10);
            k /= 10;
        }
        Collections.reverse(result);

        int[] res = new int[result.size()];
        for (int j = 0; j < result.size(); j++) {
            res[j] = result.get(j);
        }

        return res;
    }
}