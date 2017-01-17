package cs61b;

public class sqrtx {
    public long sqrt(int x) {
        if (x < 0){
            return -1;
        }
        long start = 0;
        long end = x;
        while (start + 1 < end){
            long mid = (start + end) / 2;
            if (mid * mid > x){
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        if (end * end < x){
            return end;
        }
        if (x == 1){
            return x;
        } else {
            return start;
        }
    }
}
