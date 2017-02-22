package cs61b;
import java.util.*;
public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public static int threeSumClosest(int[] numbers, int target) {
        int n = numbers.length;
        if (numbers == null || n < 3){
            return 0;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < n; i++){
        System.out.print(numbers[i]+ " ");
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++){
            int j = i + 1;
            int k = n - 1;
            while(j < k){
                int temp = numbers[i] + numbers[j] + numbers[k];
                if (temp == target){
                    return temp;
                }
                if (Math.abs(temp - target) <= Math.abs(result - target)){
                    result = temp;
                } 
                if (temp > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
		int[] numbers = {1,2,33,23,2423,33,23,1,7,6,8787,5,33,2,3,-23,-54,-67,100,400,-407,-500,-35,-8,0,0,7,6,0,1,2,-56,-89,24,2};
		System.out.println(threeSumClosest(numbers, 148));
	}

}