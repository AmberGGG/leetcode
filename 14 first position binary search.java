package cs61b;

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
                end = mid;
            }
        }
        if (nums[start] == target){
            return start;
        }
        if (nums[end] == target){
            return end;
        }
        return -1;
    }
}
