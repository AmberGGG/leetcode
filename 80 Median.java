public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        if (nums == null){
            return -1;
        }
        return helper(nums, 0, nums.length - 1, (nums.length + 1) / 2);
    }
    public int helper(int[] nums, int low, int up, int size){
        int m = low;
        if (low >= up){
            return nums[up];
        }
        for (int i = low + 1; i <= up; i++){
            if (nums[i] < nums[low]){
                m++;
                int temp = nums[m];
                nums[m] = nums[i];
                nums[i] = temp;
            }
        }
        int temp = nums[m];
        nums[m] = nums[low];
        nums[low] = temp;
        if (m - low + 1 == size){
            return nums[m];
        } else if (m - low + 1 > size){
            return helper(nums, low, m - 1, size);
        } else {
            return helper(nums, m + 1, up, size - (m - low + 1));
        }
    }
}
