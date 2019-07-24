import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /*
     * 二分查找优化
     * */
    public int chaos(int[] arr){
        if(arr==null||arr.length==0)
            return 0;
        Arrays.sort(arr);
        int len = arr.length;
        int max = arr[len-1];
        int min = arr[0];
        int minPos = 1;
        int maxPos = len-2;
        int diff = max - min;
        while(minPos<maxPos){
            diff += max - arr[minPos];
            diff += arr[maxPos] - min;
            min = arr[minPos++];
            max = arr[maxPos--];
        }
        diff += Math.max(arr[maxPos]-min,max-arr[minPos]);
        return diff;
    }
    public static void main(String[] args){
        Main m = new Main();
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        scanner.nextLine();
        String[] s = scanner.nextLine().split(" ");
        int arr[] = new int[len];
        for(int i=0;i<len;i++)
            arr[i] = Integer.parseInt(s[i]);
        System.out.println(m.chaos(arr));
    }
}
