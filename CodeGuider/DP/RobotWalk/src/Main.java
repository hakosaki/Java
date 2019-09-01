public class Main {
    /**
     * 一行N个位置，1~N，N一定大于等于2，M为初始位置，机器人可往左走可往右走，
     * 在1只能往右走到2，在N只能往左走到N-1，必须走K步，走到目的地P，返回走的方法总数
     * 输入
     * N 5 位置数
     * M 2 当前位置
     * K 3 剩余步数
     * P 3 终点
     * 输出
     * 3
     *
     * 1.暴力递归
     *
     * 2.DP
     *
     * 3.DP空间压缩
     * leftup记录左上角值，
     * */
    /*
     * 1~N 位置
     * cur 当前位置
     * rest 剩余步数
     * p 目标位置
     * */
    private int walk(int n, int cur, int rest, int p) {
        if(rest == 0)
            return cur == p ? 1 : 0;
        if(cur == 1)
            return walk(n,2,rest-1,p);
        if(cur == n)
            return walk(n,n,rest-1,p);
        return walk(n,cur-1,rest-1,p)+walk(n,cur+1,rest-1,p);
    }
    public int ways1(int n,int m,int k,int p){
        if(n<2||m<1||m>n||k<1||p<1||p>n)
            return 0;
        return walk(n,m,k,p);
    }
    public int ways2(int n,int m,int k,int p){
        /* N  位置数
        *  M  当前位置
        *  K  剩余步数
        *  P  终点
        */
        if(n<2||m<1||m>n||k<1||p<1||p>n)
            return 0;
        int[][] dp = new int[k+1][n+1];
        dp[0][p] = 1;
        for(int i=1;i<=k;i++){
            for(int j=1;j<=n;j++){
                if(j==1)
                    dp[i][j] = dp[i-1][2];
                else if(j==n)
                    dp[i][j] = dp[i-1][n-1];
                else
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
            }
        }
        return dp[k][m];
    }
    public int ways3(int n,int m,int k,int p){
        if(n<2||m<1||m>n||k<1||p<1||p>n)
            return 0;
        int[] dp = new int[n+1];
        dp[p] = 1;
        for(int i=1;i<=k;i++){
            int leftup = dp[1];
            for(int j=1;j<=n;j++){
                int tmp = dp[j];
                if(j==1)
                    dp[j]=dp[2];
                else if(j==n)
                    dp[j]=leftup;
                else
                    dp[j]=dp[j+1]+leftup;
                leftup=tmp;
            }
        }
        return dp[m];
    }
    public static void main(String[] args){
        Main m = new Main();
        int[] arr = {5,2,3,3};
        System.out.println(m.ways1(arr[0],arr[1],arr[2],arr[3]));
        System.out.println(m.ways2(arr[0],arr[1],arr[2],arr[3]));
        System.out.println(m.ways3(arr[0],arr[1],arr[2],arr[3]));
    }
}
