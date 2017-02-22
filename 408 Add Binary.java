public class Solution {
    public String addBinary(String a, String b) {
        if ((a == null && b == null) || (a.length() == 0 && b.length() == 0)){
            return null;
        }
        if (a == null || a.length() == 0){
            return b;
        }
        if (b == null || b.length() == 0){
            return a;
        }
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int sum = 0;
        int carry = 0;
        while(i >= 0 || j >= 0) {
            sum = carry == 1 ? 1 : 0;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry == 1){
            sb.append(1);
        }
        return sb.reverse().toString();
        
    }
}