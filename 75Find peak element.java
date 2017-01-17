package cs61b;
/*
@Copyright:LintCode
@Author:   Jieyao Gao
@Problem:  http://www.lintcode.com/en/problem/find-peak-element/
@Language: Java
@Datetime: 17-01-17 4:44 pm
*/
class Findpeakelement{
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]){
                return mid;
            } else if (A[mid] < A[mid - 1]){
                end = mid;
            } else {
                start = mid;
            }
        }
        return -1;
    }
}
