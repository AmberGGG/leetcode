package cs61b;
import java.io.*;
import java.util.*;
public class Woodcut {
	public static int woodCut(int[] L, int k) {
        if (L == null || L.length == 0){
            return 0;
        }
        Arrays.sort(L);
        int start = 0;
        int end = L[L.length - 1];
        //if (L.length <= 2) {}
        while (start + 1 < end){
            int l = start + (end - start) / 2;
            int sum = 0;
            for (int i = 0;i < L.length;i++){
                sum = sum + L[i] / l;
            }
            if (sum >= k){
                start = l;
            } else {
                end = l;
            }
        }
        return start;
    }
	 public static void main(String[] args) {
		 int[] L=new int[]{4, 6, 5};
	     System.out.println(Woodcut.woodCut(L, 7));

		}

}
