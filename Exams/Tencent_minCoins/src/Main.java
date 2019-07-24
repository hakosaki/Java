import java.util.*;

public class Main {
    /*
     * 第一行给定m,n，之后n行表示硬币数量，求能满足1~m钱数的最少硬币数
     * 输入
     * 20 4
     * 1
     * 2
     * 5
     * 10
     * 输出
     * 5
     * */
    public static int minCoins1(ArrayList<Integer> arr,int aim){
        if(arr == null||arr.size() == 0||aim < 0){
            return -1;
        }
//      需要进行排序，优先添加大面值的硬币
        Collections.sort(arr);
//      经典动态规划矩阵
        int n = arr.size();
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[n][aim + 1];
        for(int j = 1;j <= aim;j++){
            dp[0][j] = max;
            if(j-arr.get(0) >= 0 && dp[0][j-arr.get(0)]!= max){
                dp[0][j] = dp[0][j-arr.get(0)] + 1;
            }
        }
        int left = 0;
        for(int i = 1;i < n;i++){
            for(int j = 1;j <= aim;j++){
                left = max;
                if(j - arr.get(i) >= 0 && dp[i][j - arr.get(i)]!= max){
                    left = dp[i][j -arr.get(i)] + 1;
                }
                dp[i][j] = Math.min(left,dp[i-1][j]);
            }
        }
       /* System.out.println(Arrays.toString(dp[0]));
        System.out.println(Arrays.toString(dp[1]));
        System.out.println(Arrays.toString(dp[2]));
        System.out.println(Arrays.toString(dp[3]));*/
//      return dp[n-1][aim] != max?dp[n-1][aim] : -1;
//      记录背包硬币数、硬币总额
        int sumCoins = 0;
        int numCoins = 0;
        for(int i = 0;i <= aim;i++){
            if(dp[n-1][i] == max) {
                return -1;
//          硬币总额满足当前现状就不加硬币
            }else if(sumCoins >= i) {
                continue;
            }else{
//          硬币总额不满足就添加合适的最大值硬币
                int coin = n-1;
                while(dp[coin][i] == dp[coin-1][i]){
                    coin--;
                    if(coin == 0)
                        break;
                }
                sumCoins += arr.get(coin);
                numCoins++;
//              System.out.print(numCoins + " ");
//              System.out.println(sumCoins);
            }
        }
        return  numCoins;
    }
    public static void main(String[] args) {
        /*
        * 输入
        * */
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        ArrayList<Integer> coins = new ArrayList();
        for(int i = 0;i < n;i++){
            coins.add(scanner.nextInt());
        }
        /*
        * 数据处理，调用输出函数
        * */
        /*
        * 输出
        * */
        int result = minCoins1(coins,m);
        System.out.println(result);
    }
}
