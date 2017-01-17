public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[mid + 1] && nums[mid] < nums[mid - 1]){
                return nums[mid];
            } else if (nums[mid] > nums[0]){
                start = mid;
            } else {
                end = mid;
            }
        } 
        if (nums[start] < nums[end]){
            return nums[0];
        } else {
            return nums[nums.length - 1];
        }
        
    }
}