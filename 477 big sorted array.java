public class Solution{
    public static int findinsort(ArrayReader reader, target k){
        int index = 1;
        if (reader.get(index - 1) < target){
            index = 2 * index;
        }
        int start = index / 2 - 1;
        int end = index - 1;
        while (start < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target){
                end = mid;
            } else {
                start = mid;
            }
            if (nums[end] == target){
                return end;
            }
            return -1;
        }
    }