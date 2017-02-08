package cs61b;

public class Solution {
	    /**
	     * @param A, B: Two string.
	     * @return: the length of the longest common substring.
	     */
	    public static int longestCommonSubstring(String A, String B) {
	        int m = A.length();
	        int n = B.length();
	        int[][] result = new int[m + 1][n + 1];
	        result[0][0] = 0;
	        for (int i = 1; i <= m; i++){
	            result[i][0] = 0;
	        }
	        for (int j = 1; j<= n;j++){
	            result[0][j] = 0;
	        }
	        for (int i = 1; i <= m; i++){
	            for (int j = 1; j<= n;j++){
	                if (A.charAt(i - 1) == B.charAt(j - 1)){
	                    result[i][j] = result[i - 1][j - 1] + 1;
	                    //continue;
	                } else {
	                    result[i][j] = 0;
	                }
	            }
	        } 
	        int max = 0;
	        for (int i = 0; i <= m; i++){
	            for (int j = 0; j<= n;j++){
	            max = max < result[i][j] ? result[i][j] : max;
	            }
	        }
	        return max;
	    }
	
	public static void main(String[] args) {
		String A = "www.lintcode.com code";
		String B = "www.ninechapter.com code";
		System.out.println(longestCommonSubstring(A, B));

	}

}
