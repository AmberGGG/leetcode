package cs61b;
import java.io.*;
import java.util.*;
public class Solution {
	public static int binarySearch(int[] nums, int target){
		if (nums == null || nums.length == 0){
			return -1;
		}
		int start = 0;
		int end =nums.length - 1;
		while (start + 1 < end){
			int mid = (start + end)/2;
			if (nums[mid] > target){
				end = mid - 1;
			} else if (nums[mid] < target){
				start = mid + 1;
			} else{
				start = mid;
			}
		}
		if (nums[end] == target){
			return end;
		}
		if (nums[start] == target){
			return start;
		}
		return -1;
	}
	public static void main(String[] args){
		int[] nums = new int[]{1,2,3,3,4,6,6,6,8,9};
		System.out.println(binarySearch(nums, 6));
		
	}

}
