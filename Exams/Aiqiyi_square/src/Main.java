import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /**
     * 4个整数，可以加一减一，得到正方形的最少改动
     * 输入
     * 4 1 5 4
     * 输出
     * 4
     * */
    public int square(int[] arr){
        if(arr.length==0||arr==null)
            return -1;
        Arrays.sort(arr);
        int n = arr.length;
        int m = (0+n)>>1;
        int count = 0;
        for(int i=0;i<n;i++){
            count+=Math.abs(arr[m]-arr[i]);
        }
    return count;
    }
    public static void main(String[] args){
        Main m = new Main();
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int[] arr = new int[s.length];
        for(int i=0;i<arr.length;i++)
            arr[i] = Integer.parseInt(s[i]);
        System.out.println(m.square(arr));
    }
}
