public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; ){
            int target = 0 - nums[i];
            int j = i + 1;
            int k = n - 1;
            while (j < k){
                if (nums[j] + nums[k] == target){
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    j++;
                    while (j < n && nums[j] == nums[j - 1]){
                        j++;
                    }
                    k--;
                    while (k >= 0 && nums[k] == nums[k + 1]){
                        k--;
                    }
                } else if (nums[j] + nums[k] < target){
                    j++;
                } else {
                    k--;
                }
            }
            i++;
            while (i < n && nums[i] == nums[i - 1]){
                i++;
            }
        }
        return result;
    }   
    
}