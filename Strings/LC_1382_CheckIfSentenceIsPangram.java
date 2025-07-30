class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] marking = new boolean[26];
        for(char ch : sentence.toCharArray()) {
            marking[ch - 'a'] = true;
        }
        for(int i = 0; i < 26; i++) {
            if (!marking[i]) {
                return false;
            }
        }
        return true;
    }
}