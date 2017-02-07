package cs61b;
import java.util.*;
import java.io.*;
public class Solution {
	public static int minimumTotal(int[][] triangle) {
        if (triangle.length == 0 || triangle == null){
            return -1;
        }
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = triangle.length - 1;i >= 0; i--){
        	if (i == triangle.length - 1){
        		for (int j = 0; j < triangle[i].length; j++){
        			hm.put(j, triangle[i][j]);
        		}
        	} else {
        		for (int j = 0; j < triangle[i].length; j++){
        			int left = triangle[i][j] + hm.get(j);
        			int right = triangle[i][j] + hm.get(j + 1);
        			if (left < right) {
        				hm.put(j, left);
        			} else {
        				hm.put(j, right);
        			}
        		}
        	}
        }
        return hm.get(0);
     }
	public static void main(String[] args) {
		int[][] triangle = {{2},{3,4},{6,5,7},{4,1,8,3}};
		int result= minimumTotal(triangle);
		System.out.println(result);
	}

}
