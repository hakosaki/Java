import java.util.Scanner;

public class Main {
    /**
     * 给一个整数，依次加整数除以10，eg 509 sum=509+50+5=564
     * 给一个sum，反求出原始整数
     *
     * 二分查找
     * */
    public int div10Sum(int n){
        if(n<1 || n>Math.pow(10,18))
            return -1;
        int tmp = n;
        int sum = n;
        while(tmp>0){
            tmp = tmp/10;
            sum+=tmp;
        }
        return sum;
    }

    private long getSum(long num){
        long res = 0;
        while(num!=0){
            res += num;
            num = num/10;
        }
        return res;
    }
    public long sumBinarySearch(long target){
        long start = 0;
        long end = (long)Math.pow(10,18);
        while(start<=end){
            long mid = (start+end)>>1;
            long tmp = getSum(mid);
            if(tmp>target)
                end = mid-1;
            else if(tmp<target)
                start = mid+1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args){
        Main m = new Main();
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.println(m.sumBinarySearch(n));
    }
}
