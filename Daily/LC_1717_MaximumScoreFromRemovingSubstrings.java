class Solution {
    // Topic : String, Stack, Greedy
    public int maximumGain(String s, int x, int y) {
        if (x >= y) {
            return removeAndScore(s, "ab", x, "ba", y);
        } else {
            return removeAndScore(s, "ba", y, "ab", x);
        }
    }

    private int removeAndScore(String s, String first, int firstVal, String second, int secondVal) {
        Result firstPass = removeSubstring(s, first, firstVal);
        Result secondPass = removeSubstring(firstPass.remaining, second, secondVal);
        return firstPass.score + secondPass.score;
    }

    class Result {
        String remaining;
        int score;

        Result(String remaining, int score) {
            this.remaining = remaining;
            this.score = score;
        }
    }

    private Result removeSubstring(String s, String target, int val) {
        StringBuilder stack = new StringBuilder();
        int score = 0;

        char firstChar = target.charAt(0);
        char secondChar = target.charAt(1);

        for(char c : s.toCharArray()) {
            if (stack.length() > 0 && stack.charAt(stack.length() - 1) == firstChar && c == secondChar) {
                stack.deleteCharAt(stack.length() - 1);
                score += val;
            } else {
                stack.append(c);
            }
        }
        return new Result(stack.toString(), score);
    }
}