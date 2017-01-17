package cs61b;
public class Compare_two_anagrams {
	public boolean anagram(String s, String t) {
	       //important step:如果两个字符串长度不相等，一定不是anagram
	        if (s.length() != t.length()){
	            return false;
	        }
	        //考虑空字符串的情况，如果两个都是，不过循环直接return true
	        if (s.length() == 0 || t.length() == 0){
	            return false;
	        }
	        int[] count = new int[256];
	        for (int i = 0; i < s.length(); i++){
	            count[s.charAt(i) - 'A']++;
	            count[t.charAt(i) - 'A']--;
	        }
	        //如果两个字符串频率相等，那么一定为0
	        for (int i = 0; i < 256; i++){
	            if (count[i] != 0){
	                return false;
	            }
	        }
	        return true;
	    }

}
