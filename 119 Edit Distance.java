public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] result = new int[m + 1][n + 1];
        //Initialization
        for (int i = 1; i <= m; i++){
            result[i][0] = i;
        } 
        for (int i = 1; i <= n; i++){
            result[0][i] = i;
        } 
        // Recurrance
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    result[i][j] = result[i - 1][j - 1];
                } else {
                    result[i][j] = Math.min(Math.min(result[i - 1][j], result[i][j - 1]), result[i - 1][j - 1]) + 1;
                }
            }
        }
        return result[m][n];
    }
}