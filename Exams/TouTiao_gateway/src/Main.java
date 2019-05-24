import java.util.Scanner;

public class Main {
    /**
     * N个房间每个房间有个向后的传送门
     * A. 如果访问过当前房间 i 偶数次，那么下一次移动到房间i+1；
     * B. 如果访问过当前房间 i 奇数次，那么移动到房间pi；
     *
     * 因为传送只会后退，前进的唯一方式是偶数次到达并+1，不能跳跃
     * 所以到达i门前面所有门都走过并且经过偶数次
     * dp[i]=dp[i-1]+第二次到达i-1 + 1
     * 第一次到达i-1门后再走一步会回到p[i-1]，此时p[i-1]门到达奇数次，其他所有门到达偶数次
     * 这和第一次到达p[i-1]门的情况完全相同，所以从p[i-1]门回到i-1门，需要dp[i-1]-dp[p[i-1]]
     * 所以dp[i] = dp[i-1] + dp[i-1] - dp[p[i-1]] + 1 + 1
     * dp[i] = 2 * dp[i-1] - dp[p[i-1]] + 2
     * */
    public long gateway(int n,int[] arr){
        if(arr==null||n<1||n>1000)
            return 0;
        int[] count = new int[n+2];
        int i = 1;
        long step = 0;
        count[1] = 1;
        while(i!=n+1){
            if((count[i]&1)==1){
                i = arr[i-1];
            }else{
                i = i+1;
            }
            count[i]++;
            step++;
            if(step>1000000007)
                step = step%1000000007;
        }
        return step;
    }
    public long getJumpNum(int n,int[] arr){
        if(arr==null||n<1||n>1000)
            return 0;
        int[] dp = new int[n+1];
        int mod = 1000000007;
        for(int i=1;i<=n;i++)
            dp[i] = (2 * dp[i-1] % mod - dp[arr[i-1]-1] + 2) % mod;
        return dp[n];
    }
    public static void main(String[] args){
        Main m = new Main();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String s[] = scanner.nextLine().split(" ");
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(s[i]);
        System.out.println(m.getJumpNum(n,arr));
    }
}
