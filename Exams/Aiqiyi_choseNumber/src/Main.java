import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /**
     * n个数，每个数选1~x[i]一个数，不能重复，最大选数方案
     * */
    public long choseNum(int n,int[] arr){
        if(arr==null||n<1||n>50)
            return -1;
        Arrays.sort(arr);
        long res = 1;
        for(int i=0;i<n;i++){
            res = (res * (arr[i]-i))%1000000007;
        }
        return res;
    }
    public static void main(String[] args){
        Main m = new Main();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] s = scanner.nextLine().split(" ");
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(s[i]);
        System.out.println(m.choseNum(n,arr));
    }
}
