public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        int n = s.length();
        if (n == 0 || s == null){
            return true;
        }
        int max_word_len = 0;
        for (String word : dict) {
            max_word_len = Math.max(max_word_len, word.length());
        }

        boolean[] result = new boolean[s.length() + 1];
        result[0] = true;
        for (int i = 1; i < n + 1; i++){
            for (int j = i - 1; j >= 0;j--){
                if (i - j > max_word_len) break;
                if (result[j] == true && dict.contains(s.substring(j, i))){
                    result[i] = true;
                    break;
                }
            }
        }
        return result[n];
    }
}