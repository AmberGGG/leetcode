public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        int n = A.length;
        boolean[]  result = new boolean[n];
        result[0] = true;
        for (int i = 1; i < n; i++){
            for (int j = i - 1;j >= 0;j--){
                if (result[j] && A[j] +  j >= i){
                    result[i] = true;
                    break;
                } 
            }
        }
        return result[n - 1];
        
    }
}
