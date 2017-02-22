public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    int n = nums.length;
	    if (nums == null || n == 0){
	        return 0;
	    } 
	    int m = 0;
	    for (int i = 0; i < n; i++){
	        if (nums[i] < k){
	            int temp =  nums[i];
	            nums[i] = nums[m];
	            nums[m] = temp;
	            m++;
	        }
	    }
	    return m;
    }
}