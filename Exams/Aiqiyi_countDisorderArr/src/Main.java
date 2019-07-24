import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /**
     * 求arr多少组递增序列
     * 输入
     * 5
     * 1 3 5 6 7
     * 输出
     * 3（1,3,567）
     * */
    public int countDisorderArr(int[] arr){
        if(arr==null||arr.length==0)
            return 0;
        Arrays.sort(arr);
        int n = arr.length;
        int count = 0;
        for(int i=1;i<n;i++){
            if(arr[i]!=arr[i-1]+1)
                count++;
        }
        return count+1;
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
        System.out.println(m.countDisorderArr(arr));
    }
}
