import java.util.Scanner;
public class Main {
    /*
     * n 数列长度
     * k 数在1~k中
     * eg 1,7,7,2(n=4,k=7)
     * */
    /**
     * 数列长度n
     * 每个数在1~k中
     * 相邻两个数满足A<=B, A MOD B !=0
     *
     * dp[i][j]表示长度为i，以j结尾的个数，dp[i][j] = dp[i-1][1]+...dp[i-1][j]，即长度i-1数列合理加上j结尾也是合理
     * dp[i][j]还应加上特殊情况 如3 2，长i=2，以2结尾
     * 所以抽象为dp[i][j]= 上层合理数列总数sum-以j结尾不合理数列invalid
     *
     * invalid求法
     * p*j>j 且 p*j%j==0 不满足条件3
     * */
    static final int mod = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] state = new int[n+1][k+1];

        state[0][1] = 1;

        for(int i=1; i<=n; i++) {
            int sum = 0;
            for(int j=1; j<=k; j++) {
                sum = (sum + state[i-1][j]) % mod;
            }
            for(int j=1; j<=k; j++) {
                int invalid = 0;
                int p = 2;
                while(p*j <= k) {
                    invalid = (invalid + state[i-1][p*j]) % mod;
                    p++;
                }
                state[i][j] = (sum - invalid + mod) % mod;
            }
        }

        int sum = 0;
        for(int i=1; i<=k; i++) {
            sum = (sum + state[n][i]) % mod;
        }
        System.out.println(sum);
     /*   System.out.println(state[2][1]);
        System.out.println(state[2][2]);
        System.out.println(state[2][3]);*/

        scanner.close();
    }
}