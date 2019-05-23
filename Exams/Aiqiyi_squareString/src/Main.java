import java.util.Scanner;

public class Main {
    /**
     * 输入字符串，输出最长平方串字符数
     * 输入
     * frankfrut
     * 输出
     * 4（frfr）
     *
     * 遍历s，将s分两段
     * 对两段子字符串进行最长公共子序列dp
     * 返回dp[m-1]最大值乘以2
     * */
    /*
    * 64ms
    * 10576k
    * */
    public int squareString(String s){
        if(s==null||s.equals(""))
            return 0;
        int n = s.length();
        int res = 0;
        for(int i=1;i<n;i++){
            String s1 = s.substring(0,i);
            String s2 = s.substring(i);
            res = Math.max(res,lcse(s1,s2));
        }
        return res;
    }
    private int lcse(String s1,String s2){
        int n = s1.length();
        int m = s2.length();
        char[] longs = n>m?s1.toCharArray():s2.toCharArray();
        char[] shorts = n>m?s2.toCharArray():s1.toCharArray();
        if(n<m){
            int tmp = n;
            n = m;
            m = tmp;
        }
        int[] dp = new int[m];
        dp[0] = longs[0]==shorts[0]?1:0;
        for(int j=1;j<m;j++)
            dp[j] = Math.max(dp[j-1],shorts[j]==longs[0]?1:0);
        for(int i=1;i<n;i++){
            int tmp = dp[0];
            dp[0] = Math.max(dp[0],shorts[0]==longs[i]?1:0);
            for(int j=1;j<m;j++){
                int cur = dp[j];
                dp[j] = Math.max(dp[j],dp[j-1]);
                if(longs[i]==shorts[j])
                    dp[j] = Math.max(dp[j],tmp+1);
                tmp = cur;
            }
        }
//        System.out.println(dp[m-1]);
        return dp[m-1]*2;
    }
    public static void main(String[] args){
        Main m = new Main();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(m.squareString(s));
    }
}
