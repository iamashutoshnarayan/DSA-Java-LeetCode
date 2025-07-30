class Solution {
    // Topics : Arrays, Strings
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int match = 0;
        int index = 0;

        if (ruleKey.equals("color")) {
            index = 1;
        } else if (ruleKey.equals("name")) {
            index = 2;
        }

        for (int item = 0; item < items.size(); item++) {
            if (items.get(item).get(index).equals(ruleValue)) {
                match++;
            }
        }
        return match;
    }
}