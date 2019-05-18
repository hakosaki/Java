import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    /**
     * 给一行整数数列，把每个整数按递增排，求最大数
     * 输入
     * 3
     * 9638 8210 331
     * 输出
     * 3689
     * */
    public int getMaxNum(LinkedList<int[]> list){
        if(list==null||list.size()==0)
            return Integer.MIN_VALUE;
        int n = list.size();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int[] tmp = list.pop();
            Arrays.sort(tmp);
            int res = 0;
            for(int j=0;j<tmp.length;j++)
                res = res*10+tmp[j];
            if(res>max)
                max = res;
        }
        return max;
    }
    public static void main(String[] args){
        Main m = new Main();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] s = scanner.nextLine().split(" ");
        LinkedList<int[]> list = new LinkedList<>();
        for(int i=0;i<n;i++){
            char[] tmp = s[i].toCharArray();
            int[] arr = new int[tmp.length];
            for(int j=0;j<tmp.length;j++)
                arr[j] = tmp[j]-'0';
            list.add(arr);
        }
        System.out.println(m.getMaxNum(list));
    }
}
