package cs61b;
class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
	    public static int maxSubArray(int[] nums) {
	        if (nums == null || nums.length == 0){
	            return 0;
	        }
	        int n = nums.length;
	        int[] result = new int[n + 1];
	        result[0] = 0;
	        result[1] = nums[0];
	        for (int i = 2; i <= n; i++){
	            if (result[i - 1] < 0){
	                result[i] = nums[i - 1];
	            } else {
	                result[i] = nums[i - 1] + result[i - 1];
	            }
	            System.out.println(result[i]);
	        }
	        int max = result[1];
	        for (int j = 1; j <= n; j++){
	            if (result[j] > max){
	                max = result[j];
	            }
	        }
	        return max;
	    }
	public static void main(String[] args) {
		int[] nums = {-2,2,-3,4,-1,2,1,-5,3};
		maxSubArray(nums);
	}
}
