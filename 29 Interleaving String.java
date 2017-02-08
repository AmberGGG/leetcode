public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        int x = s1 == null ? 0 : s1.length();
        int y = s2 == null ? 0 : s2.length();
        int z = s3 == null ? 0 : s3.length();
        if (z != x + y){
            return false;
        }
        boolean result;
        int j = 0;
        int k = 0;
        for (int i = 0; i < z; i++){
            result = false;
            if (j < x && s1.charAt(j) == s3.charAt(i) &&
                k < y && s2.charAt(k) == s3.charAt(i)) {
                // s1[1+i1:], s2[i2:], s3[1+i3:]
                boolean case1 = isInterleave(s1.substring(1 + j), s2.substring(k), s3.substring(1 + i));
                // s1[i1:], s2[1+i2:], s3[1+i3:]
                boolean case2 = isInterleave(s1.substring(j), s2.substring(1 + k), s3.substring(1 + i));
                // return instantly
                return case1 || case2;
            }
            if (j < x && s3.charAt(i) == s1.charAt(j)){
                result = true;
                j++;
                continue;
            }
            if (k < y && s3.charAt(i) == s2.charAt(k)){
                result = true;
                k++;
                continue;
            }
            if (!result){
                return false;
            }
        }
        return true;
    }
}