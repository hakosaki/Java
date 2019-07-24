import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /**
     * 将一个数列排序，求最小移动数字
     * 输入
     * 3
     * 3 2 1
     * 输出
     * 2（移动1、3）
     * */
    public int getMinSortStep(int[] arr){
        if(arr==null||arr.length==0)
            return 0;
        int len = arr.length;
        /*
        * 注意，数组pre=arr或同步改变pre和res
        * */
        int[] pre = new int[len];
        for(int i=0;i<len;i++)
            pre[i] = arr[i];
        Arrays.sort(pre);
        int count = 0;
        for(int i=0;i<len;i++)
            if(pre[i]!=arr[i])
                count++;
        return count;
    }
    public static void main(String[] args){
        Main m = new Main();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] arr = new int[n];
        String[] s = scanner.nextLine().split(" ");
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(s[i]);
        System.out.println(m.getMinSortStep(arr));
    }
}
