import java.util.Scanner;

public class Main {
    /**
     * n个棋子，x,y坐标，移动棋子求棋盘上一个格子至少有1~n个棋子的移动最少步数
     * 输入
     * 4
     * 1 2 4 9
     * 1 1 1 1
     * 输出
     * 0 1 3 10
     *
     * 输入
     * 5
     * 8 1 9 9 7
     * 7 7 7 7 10
     * 输出
     * 0 0 1 6 13
     * 理解错误，输出的是前i个棋子最优解
     * 不是全棋子的i个最优解
     * */
    public static int[] chessPlace(int[][] arr){
        if(arr==null||arr.length==0||arr[0].length==0)
            return null;
        int i;
        int len = arr[0].length;
        int x = 0;
        int y = 0;
        for(i=0;i<len;i++){
            if(arr[0][i]>x)
                x = arr[0][i];
            if(arr[1][i]>y)
                y = arr[1][i];
        }
        int[][] dp = new int[x][y];
        int j,k;
        int min;
        int[] res = new int[len];
        for(i=0;i<len;i++){
            min = Integer.MAX_VALUE;
            for(j=0;j<x;j++){
                for (k=0;k<y;k++){
                    dp[j][k] += Math.abs(arr[0][i]-1-j)+Math.abs(arr[1][i]-1-k);
                    if(min>dp[j][k])
                        min = dp[j][k];
                }
            }
            res[i] = min;
        }
        return res;
    }
    public static void main(String[] args){
//        int[][] arr = {{1,2,4,9},{1,1,1,1}};
//        int[] res = chessPlace(arr);
//        System.out.println(Arrays.toString(res));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] s1 = scanner.nextLine().split(" ");
        String[] s2 = scanner.nextLine().split(" ");
        int[][] arr = new int[2][n];
        for(int i = 0;i<n;i++){
            arr[0][i] = Integer.parseInt(s1[i]);
            arr[1][i] = Integer.parseInt(s2[i]);
        }
        int[] res = chessPlace(arr);
        if(res.length==0)
            return;
        else{
            System.out.print(res[0]);
            for(int i=1;i<res.length;i++)
                System.out.print(" "+res[i]);
        }
    }
}
