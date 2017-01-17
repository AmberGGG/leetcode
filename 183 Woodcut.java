public class Solution{
    public static int woodcut(int[] L, int k){
        if (L == null || L.length == 0){
            return 0;
        }
        int start = 0;
        int end = L[L.length - 1];
        boolean result;
        while (start + 1 < end){
            int l = start + (end - start) / 2;
            result = condition(L, k, l);
            if (result == true){
                start = l;
            } else {
                end = l;
            }
            return start;
            
        }
    }
    public boolean condition(int[] L, int k, int l){
        int sum = 0;
        boolean result;
        for (i = 0; i < L.length; i++){
            sum = sum + L[i]/l;
        }
        if (sum >= k){
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}