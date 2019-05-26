import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * 小写字母串，每次可以选两个相邻字母进行交换，至多m次交换后，求最长连续相同字母
     * 输入
     * abcbaa 2
     * 输出
     * 2
     *
     * 26个字母链表，整数链表放当前字母的位置，选每个字母最长的结果
     * 先计算两个字母间距离
     * 再计算多个字母间距离
     * */
    public int swapLetter(String s,int m){
        if(s==null||s.equals(""))
            return 0;
        int n = s.length();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<26;i++){
            list.add(new ArrayList<Integer>());
        }
        for(int i=0;i<n;i++){
            list.get(s.charAt(i)-'a').add(i);
        }
        int res = 0;
        for(int i=0;i<26;i++)
            res = Math.max(res,swapLetter(list.get(i),m));
        return res;
    }
    private int swapLetter(ArrayList<Integer> l,int m){
        if(l==null||l.size()<=0)
            return 0;
        int n = l.size();
        int[][] dp = new int[n][n];
        for(int i=0;i<n-1;i++)
            dp[i][i+1] = l.get(i+1)-l.get(i)-1;
        for(int len=2;len<n;len++){
            for(int i=0;i<n-len;i++){
                int j = i + len;
                dp[i][j] = dp[i+1][j-1] + l.get(j) - l.get(i) - (j - i);
            }
        }
        int res = 0;
        for(int i=0;i<l.size();i++){
            for(int j=i;j<l.size();j++){
                if(dp[i][j]<=m)
                    res = Math.max(res,j-i+1);
            }
        }
        return res;
    }
    public static void main(String[] args){
        Main m = new Main();
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(" ");
        String s = arr[0];
        int k = Integer.parseInt(arr[1]);
        System.out.println(m.swapLetter(s,k));
    }
}
