package cs61b;
import java.io.*;
import java.util.*;
public class bigsortedarray{
	public static int bsa(ArrayReader reader, int target){
        if (reader == null){
        	return -1;
        } 
		int index = 1;
        if (reader.get(index - 1) < target){
        	index = index * 2;
        }
        int start = (index / 2) - 1;
        int end = index - 1;
        while (start + 1 < end){
        	int mid = start + (end - start) / 2;
        	if (reader.get(mid) > target){
                end = mid - 1;
        	} else if (reader.get(mid) < target) {
        		start = mid + 1;
        	} else {
        		end = mid;
        	}
        }
        if (reader.get(start) == target){
        	return start;
        }
        if (reader.get(end) == target){
        	return end;
        }
        return -1;   
	}
}
