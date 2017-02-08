package cs61b;
public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
	public static int numDistinct(String S, String T) {
        int m = S.length();
        int n = T.length();
        int[][] result = new int[m + 1][n + 1];
        //Initialization
        result[0][0] = 1;
        for (int i = 1; i <= n; i++){
            result[0][i] = 0;
        }
        for (int j = 1; j <= m; j++){
            result[j][0] = 1;
        }
        // Recurrance
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (S.charAt(i - 1) == T.charAt(j - 1)){
                    result[i][j] = result[i - 1][j] + result[i - 1][j - 1];
                } else {
                    result[i][j] = result[i - 1][j];
                }
                System.out.println(result[i][j]);
            }
        }
        return result[m][n];
    }
	public static void main(String[] args) {
		String S = "ddd";
		String T ="dd";
		System.out.println(numDistinct(S,T));
	}
}