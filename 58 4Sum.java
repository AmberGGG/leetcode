public class Solution {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (numbers == null || numbers.length == 0){
            return result;
        }
        int n = numbers.length;
        Arrays.sort(numbers);
        for (int i = 0; i < n - 3; i++){
            int target1 = target - numbers[i];
            if (i > 0 && numbers[i] == numbers[i - 1]){
                continue;
            }
            for (int j = i + 1; j < n - 2;){
                int k = j + 1;
                int p = n - 1;
                int target2 = target1 - numbers[j];
                while (k < p){
                    if (numbers[k] + numbers[p] == target2){
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(numbers[i]);
                        list.add(numbers[j]);
                        list.add(numbers[k]);
                        list.add(numbers[p]);
                        result.add(list);
                        k++;
                        while(k < n - 1 && (numbers[k] == numbers[k - 1])){
                            k++;
                        }
                        p--;
                        while(p >= 0 && (numbers[p] == numbers[p + 1])){
                            p--;
                        }
                    } else if (numbers[k] + numbers[p] < target2) {
                        k++;
                    } else {
                        p--;
                    }
                }
                j++;
                while (j < n - 2 &&  (numbers[j] == numbers[j - 1])){
                    j++;
                }
            }
        }
        return result;
    }
}