package cs61b;

public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    public static int minCut(String s) {
        int n = s.length();
        int[] result = new int[n + 1];
        result[0] = 0;
        for (int i = 1;i <= n;i++){
            result[i] = i - 1;
        }
        for (int i = 1; i <= n; i++){
            for (int j = i - 1; j >= 0; j--){
                if(ispdm(s.substring(0, i)) == true){
                    result[i] = 0;
                    break;
                }
                if (ispdm(s.substring(j, i)) == true && result[j] + 1 < result[i]){
                    result[i] = result[j] + 1;
                }
            }
            System.out.println(result[i]);
        }
        return result[n];
        
        
    }
    public static boolean ispdm(String s){
        boolean result;
        int n = s.length();
        result = true;
        for (int i = 0; i < n / 2; i++){
            if (s.charAt(i) != s.charAt(n - 1 - i)){
                result = false;
                break;
            } 
        }
        return result;
    }
    public static void main(String[] args) {
		String s = "dde";
		System.out.println(minCut(s));

	}
}