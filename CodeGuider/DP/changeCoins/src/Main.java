import java.util.*;

public class Main {
    /*
    * 给定数组arr，arr中均为正数且不重复，每个值代表一种货币，任意张，求找aim有多少种方法
    *
    * 暴力递归、记忆搜索、动态规划之间的关系，出现大量暴力递归的题目都有相似优化轨迹
    * 暴力递归：
    * 用0-N张5，让其余货币组成余下aim-5*N
    *
    *  时间复杂度跟arr面值有关，最差O(aim^N)
    * */
    public static int changeCoins1(int[] arr,int aim){
        if(arr==null||arr.length==0||aim<0)
            return 0;
        return Interation1(arr,0,aim);
    }
    public static int Interation1(int[] arr,int index,int aim){
        int res = 0;
//      System.out.println(index+" "+aim+" "+res);
        if(index == arr.length){
            res = aim ==0 ? 1:0;
        }else{
            for(int i=0;arr[index]*i<=aim;i++){
                res += Interation1(arr,index+1,aim-arr[index]*i);
            }
        }
        return res;
    }
    /*
    * 记忆搜索：暴力递归初步优化
    * 重复计算大量发生，用map记录计算结果
    * 0张5+1张10,2张5+0张10
    * p(index,aim) map[i][j]表示p(i,j)是否计算过
    *
    * O(N*aim^2)
    * */
    public static int changeCoins2(int[] arr, int aim){
        if(arr==null||arr.length==0||aim<0)
            return 0;
        int[][] map = new int[arr.length+1][aim+1];
        return Interation2(arr,0,aim,map);
    }
    public static int Interation2(int[] arr,int index,int aim,int[][] map){
        int res = 0;
        if(index == arr.length){
               /* System.out.println(Arrays.toString(map[0]));
                System.out.println(Arrays.toString(map[1]));
                System.out.println(Arrays.toString(map[2]));
                System.out.println(Arrays.toString(map[3]));
                System.out.println(Arrays.toString(map[4]));
                System.out.println();*/
            res = aim==0?1:0;
        }else{
            int mapValue = 0;
            for(int i=0;arr[index]*i<=aim;i++){
//              读取p(index)(aim)
                mapValue = map[index+1][aim-arr[index]*i];
                if(mapValue!=0){
//                  p(index)(aim)计算过，-1无解不加，有解，该解累加
                    res += mapValue == -1?0:mapValue;
                }else{
//                  p(index)(aim)未计算过，计算，并累加解
                    res += Interation2(arr,index+1,aim-arr[index]*i,map);
                }
            }
        }
        map[index][aim] = res==0?-1:res;
        return res;
    }

    /*
    * 动态规划：生成功N行、aim+1列矩阵dp，dp[i][j]含义是在使用arr[0...i]货币情况下，组成j钱数的方法多少种
    * 第一列表示钱0方法，1种
    * 第一行只使用arr[0]情况下，组成钱方法数，eg：arr[0]==5，组成0,5,10,15……，令dp[0][k*arr[0]]=1
    * 其他位置dp[i][j]是以下值的累加：1、不用arr[i],dp[i-1][j] 2、用一张,dp[i-1][j-arr[i]] 3、……
    * dp[N-1][aim]就是结果
    *
    * O(N*aim^2)
    *
    * arr = [20000,10000,1000],aim=2000000000 动态规划数组过大，而记忆搜索可以不考虑面值小于1000的值
    * */
    public static int changeCoins3(int[] arr,int aim){
        if(arr==null||arr.length==0||aim<0)
            return 0;
        int[][] dp = new int[arr.length][aim+1];
        for(int i=0;i<arr.length;i++){
            dp[i][0] = 1;
        }
        for(int i=1;arr[0]*i<=aim;i++){
            dp[0][arr[0]*i] = 1;
        }
        int num = 0;
        for(int i=1;i<arr.length;i++){
            for(int j=1;j<=aim;j++){
                num = 0;
                for(int k=0;j-arr[i]*k>=0;k++){
                    num += dp[i-1][j-arr[i]*k];
                }
                dp[i][j] = num;
            }
        }
        System.out.println(Arrays.toString(dp[0]));
        System.out.println(Arrays.toString(dp[1]));
        System.out.println(Arrays.toString(dp[2]));
        System.out.println(Arrays.toString(dp[3]));
        return dp[arr.length-1][aim];
    }
    /*
    * dp优化：完全不用arr[i]情况等于dp[i-1][j]
    * 用1张~k张arr[i]情况等于dp[i-1][j-arr[i]]+...+dp[i-1][j-k*arr[i]]=dp[i][j-arr[i]]
    * 累加情况前面已经算过，可以省略三重循环
    * */
    public static int changeCoins4(int[] arr,int aim){
        if(arr==null||arr.length==0||aim<0)
            return 0;
        int len = arr.length;
        int[][] dp = new int[len][aim+1];
        int i,j;
        for(i=0;i<len;i++)
            dp[i][0] = 1;
        for(j=0;j*arr[0]<=aim;j++)
            dp[0][j*arr[0]] = 1;
        for(i=1;i<len;i++){
            for(j=1;j<=aim;j++){
                dp[i][j] += dp[i-1][j];
                dp[i][j] += j-arr[i]>=0?dp[i][j-arr[i]]:0;
            }
        }
        return dp[len-1][aim];
    }
    /*
    * dp空间压缩
    * */
    public static int changeCoins5(int[] arr,int aim){
        if(arr==null||arr.length==0||aim<0)
            return 0;
        int len = arr.length;
        int[] dp = new int[aim+1];
        int i,j;
        for (j=0;j*arr[0]<=aim;j++)
            dp[j*arr[0]] = 1;
        for(i=1;i<len;i++){
            for(j=1;j<=aim;j++){
                dp[j] += j-arr[i]>=0?dp[j-arr[i]]:0;
            }
        }
        return dp[aim];
    }
    public static void main(String[] args) {
        /*
        * 输入
        * */
        /*Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int aim = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }*/
        /*
        * 数据处理
        * */
        int[] arr = new int[]{1,5,10,15};
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(25);
        list.add(1);
        list.add(10);
        int aim = 15;
//      int result1 = changeCoins1(arr,aim);
//      int result2 = changeCoins2(arr,aim);
        int result3 = changeCoins3(arr,aim);
        int result4 = changeCoins4(arr,aim);
        int result5 = changeCoins5(arr,aim);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
    }
}
