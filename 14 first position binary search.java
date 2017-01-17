public class Solution{
    public static int binarysearch(int[] nums, int target){
        if (nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target){
                end = mid;
            } else (nums[mid] < target) {
                start = mid;
            }
        }
        if (nums[end] == target){
            return end;
        }
        return -1;
    }
}