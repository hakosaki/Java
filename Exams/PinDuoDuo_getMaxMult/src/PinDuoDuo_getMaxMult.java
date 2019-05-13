import java.util.Scanner;

public class PinDuoDuo_getMaxMult {
    /**
     * 给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，要求时间复杂度：O(n)，空间复杂度：O(1)
     * 输入 3
     * 4 1 2
     * 输出
     * 8
     *
     * 注意long的返回值，输入值
     * */
    public static long getMaxMult(long[] arr) {
        if(arr==null||arr.length<=2)
            return Long.MIN_VALUE;
        long max1 = arr[0];
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;
        long min1 = arr[0];
        long min2 = Long.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = arr[i];
            } else if (arr[i] > max2) {
                max3 = max2;
                max2 = arr[i];
            } else if (arr[i] > max3) {
                max3 = arr[i];
            }

            if(arr[i] < min1){
                min2 = min1;
                min1 = arr[i];
            } else if (arr[i] < min2) {
                min2 = arr[i];
            }
        }
        return Math.max(max1*max2*max3,max1*min1*min2);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int tmp = scanner.nextInt();
        long arr[] = new long[tmp];
        for(int i=0;i<tmp;i++){
            arr[i] = scanner.nextLong();
        }
        System.out.println(getMaxMult(arr));
    }
}
