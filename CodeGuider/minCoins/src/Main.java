import java.lang.reflect.Array;
import java.util.*;

public class Main {
    /*
    * 暴力递归
    * */
    public static int minCoins(int[] arr,int aim){
        if(arr == null||arr.length==0||aim<0)
            return -1;
        return process(arr,0,aim);
    }
    public static int process(int[] arr, int i,int rest){
        if(i == arr.length){
            return rest == 0?0:-1;
        }
        int res = -1;
        //考虑面值arr[i]张数，余下交给其他面值
        for (int k = 0;k*arr[i]<=rest;k++){
            int next = process(arr,i+1,rest-k*arr[i]);
            if(next!=-1)//后续有效
                res = res == -1?next+k:Math.min(res,next+k);
        }
        return res;
    }

    /*
    * 给定数组arr,arr中所有值都为正数。每个值仅代表一种面值，有任意张，再给定一个整数aim代表要找的钱数，求组成aim最少货币数。
    *
    * arr长N，生成行数N，列数aim+1的dp
    * dp第一列表示找钱数0需要的最少张数，全设为0
    * dp第一行表示只能用arr[0]货币找某个钱的最少张数，eg arr[0] == 2;能找开钱数2,4,6,8，dp[0][2]=1,dp[0][4]=2,dp[0][6]=3,其余位置记为max
    * 余下位置从左到右，从上到下计算，不用当前货币dp[i][j] = dp[i-1][j],用一张dp[i][j] = dp[i-1][j-arr[i]] + 1,依次类推取张数最小
    * j-arr[i]<0即用一张就超了 dp[i][j] = dp[i-1][j]
    *
    * O(N*aim)
    * */
    public static int minCoins1(int[] arr,int aim){
        if(arr == null||arr.length == 0||aim < 0){
            return -1;
        }
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[n][aim + 1];
        for(int j = 1;j <= aim;j++){
            dp[0][j] = max;
            if(j - arr[0] >= 0 && dp[0][j-arr[0]]!= max){
                dp[0][j] = dp[0][j-arr[0]] + 1;
            }
        }
        int left = 0;
        for(int i = 1;i < n;i++){
            for(int j = 1;j <= aim;j++){
                left = max;
                if(j - arr[i] >= 0 && dp[i][j - arr[i]]!= max){
                    left = dp[i][j - arr[i]] + 1;
                }
                dp[i][j] = Math.min(left,dp[i-1][j]);
            }
        }
        System.out.println(Arrays.toString(dp[0]));
        System.out.println(Arrays.toString(dp[1]));
        System.out.println(Arrays.toString(dp[2]));
        System.out.println(Arrays.toString(dp[3]));
        return dp[n-1][aim] != max?dp[n-1][aim] : -1;
    }

    /*
    * 空间压缩 只用按行更新
    * */
    public static int minCoins2(int[] arr,int aim){
        if(arr == null||arr.length == 0||aim < 0){
            return -1;
        }
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[] dp = new int[aim + 1];
        for(int j = 1;j <= aim;j++) {
            dp[j] = max;
            if (j - arr[0] >= 0 && dp[j - arr[0]] != max) {
                dp[j] = dp[j - arr[0]] + 1;
            }
        }
        int left = 0;
        for(int i = 1;i < n;i++){
            for(int j = 1;j <= aim;j++){
                left = max;
                if(j - arr[i] >= 0 && dp[j - arr[i]] != max){
                    left = dp[j - arr[i]] + 1;
                }
                dp[j] = Math.min(left,dp[j]);
            }
        }
        System.out.println();
        System.out.println(Arrays.toString(dp));
        return dp[aim] != max ? dp[aim] : -1;
    }

    /*
    * 给定数组arr,arr中所有值都为正数。每个值仅代表一张，再给定一个整数aim代表要找的钱数，求组成aim最少货币数。
    *
    * arr长N，生成行数N，列数aim+1的dp
    * dp第一列表示找钱数0需要的最少张数，全设为0
    * dp第一行表示只能用arr[0]货币找某个钱的最少张数，eg arr[0] == 2;能找开钱数2，dp[0][2]=1,其余位置记为max
    * 余下位置从左到右，从上到下计算，不用当前货币dp[i][j] = dp[i-1][j],用一张dp[i][j] = dp[i-1][j-arr[i]] + 1,无其他情况
    * j-arr[i]<0即用一张都超了 dp[i][j] = dp[i-1][j]
    *
    *  O(N*aim)
    * */
    public static int minCoins3(int[] arr,int aim){
        if(arr == null||arr.length == 0||aim < 0){
            return -1;
        }
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[n][aim + 1];
//      区别1：只把张数为1的数组置为1
        for(int j = 1;j <= aim;j++){
            dp[0][j] = max;
            if(j - arr[0] == 0){
                dp[0][j] = 1;
            }
        }
        int left = 0;
        for(int i = 1;i < n;i++){
            for(int j = 1;j <= aim;j++){
                left = max;
//              区别2：不能从自身前面判断，而从上一组相应位置判断
                if(j - arr[i] >= 0 && dp[i-1][j - arr[i]]!= max){
                    left = dp[i-1][j - arr[i]] + 1;
                }
                dp[i][j] = Math.min(left,dp[i-1][j]);
            }
        }
        System.out.println(Arrays.toString(dp[0]));
        System.out.println(Arrays.toString(dp[1]));
        System.out.println(Arrays.toString(dp[2]));
        System.out.println(Arrays.toString(dp[3]));
        return dp[n-1][aim] != max?dp[n-1][aim] : -1;
    }
    /*
     * 空间压缩 只用按行更新
     * */
    public static int minCoins4(int[] arr,int aim){
        if(arr == null||arr.length==0||aim < 0)
            return -1;
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[] dp = new int[aim+1];
        for(int i=1;i<=aim;i++){
            dp[i] = max;
            if(dp[i]-arr[0]==0){
                dp[i] = 1;
            }
        }
        int left = 0;
        for(int i=0;i<n;i++){
//          区别1：需要从右边更新dp，因为左边保存上行数据，需要用到
            for(int j=aim;j>0;j--){
                left = max;
                if(j-arr[i] >=0 && dp[j-arr[i]]!=max){
                    left = dp[j-arr[i]]+1;
                }
                dp[j] = Math.min(left,dp[j]);
            }
        }
        for(int i=0;i<=aim-1;i++) {
            System.out.print(dp[i]+",");
        }
        System.out.print(dp[aim]);
        System.out.println();
        return dp[aim]!=max?dp[aim]:-1;
    }

    /*
    * 背包,算法不正确
    * */
    /*public static int minCoinsBag(ArrayList<Integer> arr, int aim){
        if(arr==null|arr.size()==0||aim<0)
            return -1;
        Stack<Integer> stack = new Stack<>();
        Collections.sort(arr,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int count = 0;
        int num = 0;
        int j = 0;
        while(j<arr.size()){
            if(count == aim){
                break;
            }else if(count > aim){
                int tmp = stack.pop();
                --num;
                count = count - arr.get(j);
                ++j;
                if(j==arr.size()){
                    if(stack.isEmpty()){
                        return -1;
                    }else{
                        while(stack.peek()==tmp){
                            stack.pop();
                            --num;
                            count = count - tmp;
                        }
                        tmp = stack.pop();
                        --num;
                        count = count - tmp;
                        for(int i=0;i<arr.size();i++){
                            if(arr.get(i)==tmp){
                                j = i+1;
                                break;
                            }
                        }
                    }
                }
            }else{
                stack.push(arr.get(j));
                count+= arr.get(j);
                System.out.println(count);
                ++num;
            }
        }
        return num;
    }*/

    public static void main(String[] args) {
        int[] arr = new int[]{10,3,1,5};
        int aim = 20;
//        int result = minCoins(arr,aim);
        int result1= minCoins3(arr,aim);
        int result2 = minCoins4(arr,aim);
//        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);
    }
}
