package cs61b;
import java.io.*;
import java.util.*;
public class Solution {
	public static ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> result = new ArrayList<String>();
		if (strs.length < 2){
	        for (int i = 0; i  < strs.length; i++){
	        	result.add(strs[i]);
	        }
	        return result;
	    }
		boolean[] visit = new boolean[strs.length];
	    for (int i = 0; i < strs.length; i++){
	        boolean has_anagrams = false;
	        for (int j = i + 1; j < strs.length; j++){
	            if ((visit[j] == false) && (isanagram(strs[i], strs[j]) == true)){
	                result.add(strs[j]);
	                visit[j] = true;
	                has_anagrams = true;
	            }
	        }
	        if (has_anagrams == true){
	            result.add(strs[i]);
	        }
	    }
	    return result;
	    }
	    public static boolean isanagram(String s, String t) {
	        if (s.length() != t.length()){
	            return false;
	        }
	        if (s.length() == 0 || t.length() == 0){
	            return false;
	        }
	        int[] count = new int[256];
	        for (int i = 0; i < s.length(); i++){
	            count[s.charAt(i) - 'A']++;
	            count[t.charAt(i) - 'A']--;
	        }
	        for (int i = 0; i < 256; i++){
	            if (count[i] != 0){
	                return false;
	            }
	        }
	        return true;
	    }
		public static void main(String[] args){
			String[] strs= {"ba", "ab", "cd", "dc", "e"};
			System.out.println(anagrams(strs));
		
		}
}

