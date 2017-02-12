class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        if (A == null && B == null){
            return null;
        }
        int m = A.length;
        int n = B.length;
        int[] result = new int[m + n];
        int j = 0;
        int k = 0;
        int i = 0;
        while (j < m && k < n){
            if (A[j] <= B[k]){
                result[i] = A[j];
                j++;
            } else {
                result[i] = B[k];
                k++;
            }
            i++;
        }
        if (j >= m){
            while (k < n){
                result[i] = B[k];
                k++;
                i++;
            }
        } else {
            while (j < m){
                result[i] = A[j];
                j++;
                i++;
            }
        }
        return result;
        
    }
}