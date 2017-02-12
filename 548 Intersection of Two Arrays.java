public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> results = new ArrayList<Integer>();
        for (int i = 0; i < nums1.length; i++){
            if (!map.containsKey(nums1[i])){
                map.put(nums1[i], 1);
            }
        }
        for (int j = 0; j < nums2.length; j++){
            if (map.containsKey(nums2[j]) && map.get(nums2[j]) == 1){
                results.add(nums2[j]);
                map.put(nums2[j], 0);
            }
        }
        int[] result = new int[results.size()];
        for (int k = 0; k < results.size(); k++){
            result[k] = results.get(k);
        }
        return result;
    }
}