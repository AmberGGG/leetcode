public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if (numbers == null || numbers.length == 0){
            return result;
        }
        int n = numbers.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++){
            if (map.containsKey(numbers[i]) != false){
                result[0] = map.get(numbers[i]);
                result[1] = i + 1;
                return result; 
            }
            map.put(target - numbers[i], i + 1);
        }
        return result;
    }
}
