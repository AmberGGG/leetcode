class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        if (nums == null){
            return 0;
        }
        return helper(nums, 0, nums.length - 1, k);
    }
    public int helper(int[] nums, int low, int up, int k){
        if (low >= up){
            return nums[up];
        }
        int m = low;
        for (int i = low + 1;i <= up; i++){
            if (nums[i] > nums[low]){
                m++;
                int temp = nums[i];
                nums[i] = nums[m];
                nums[m] = temp;
            }
        }
        int temp = nums[low];
        nums[low] = nums[m];
        nums[m] = temp;
        if (m + 1 == k){
            return nums[m];
        } else if (m  + 1 < k){
            return helper(nums, m + 1, up, k);
        } else {
            return helper(nums, low, m - 1, k);
        }
        
    }
};