package cs61b;

public class binarysearch {
	public static int binarySearch(int[] nums, int target) {
        //write your code here
        if (nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end){
            int mid = (start + end) / 2;
            if (nums[mid] > target){
                end = mid - 1;
            } else if (nums[mid] < target){
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
	public static void main(String[] args){
		int[] nums = new int[]{1,2,2,2,4,5,6,6,6,7,8,};
		System.out.println(binarysearch.binarySearch(nums,2));
	
	}
	
}
