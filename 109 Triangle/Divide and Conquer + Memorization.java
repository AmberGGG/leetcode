package cs61b;
import java.util.*;
import java.io.*;
public class Solution {
	public class Solution{
	    /**
	     * @param triangle: a list of lists of integers.
	     * @return: An integer, minimum path sum.
	     */
	    public static int minimumTotal(int[][] triangle) {
	        int n = triangle.length;
	        int[][] result = new int[n][n];
	        boolean[][] hasv = new boolean[n][n];
	        if (triangle == null || triangle.length == 0){
	            return -1;
	        }
	        daq(triangle, 0, 0, result, hasv);
	        return result[0][0];
	    }
	    public static int daq(int[][] triangle, int x, int y, int[][] result,boolean[][] hasv){
	        int n = triangle.length;
	        if (x == n){
	            return 0;
	        }
	        if (hasv[x][y] == true){
	            return result[x][y];
	        }
	        //daq
	        int left = daq(triangle, x + 1, y, result, hasv);
	        int right = daq(triangle, x + 1, y + 1,result, hasv);
	        hasv[x][y] = true;
	        result[x][y] = Math.min(left, right) + triangle[x][y];
	        return result[x][y];
	    }
	    
	}
	public static void main(String[] args) {
		int[][] triangle = {{2},{3,4},{6,5,7},{4,1,8,3}};
		int result= minimumTotal(triangle);
		System.out.println(result);
	}

}
