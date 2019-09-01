public class Main {
    /*
     * 给定矩阵m，从左上角开始每次只能向右或向下，最后到达右下角位置，路径上所有数字累加就是路径和，返回所有路径最小路径和
     *   1 3 5 9
     *   8 1 3 4
     *   5 0 6 1
     *   8 8 4 0
     *   1,3,1,0,6,1,0是最小路径和，返回12
     * */
    /*
     * (0,j)位置最小路径即0-j的累加
     * (i,0)位置最小路径即0-i的累加
     * (i,j)位置最小路径即上左取最小
     * O(m*n)的时空
     * */
    public int minPathSum1(int[][] m){
        if(m == null || m.length == 0||m[0] == null||m[0].length == 0){
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        for(int i = 1;i < row;i++){
            dp[i][0] = dp[i-1][0] + m[i][0];
        }
        for(int j = 1;j < col;j++){
            dp[0][j] = dp[0][j-1] + m[0][j];
        }
        for(int i = 1;i < row;i++){
            for(int j = 1;j < col;j++) {
               dp[i][j] = Math.min(dp[i - 1][j],dp[i][j - 1]) + m[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }
    /*
    * arr=[1,4,9,18]第一行最小路径
    * 将arr更新为第二行最小路径
    * arr[0]=arr[0]+m[1][0];
    * arr[1]=min{arr[0],arr[1]}+m[1][1];
    * O(min{M,N})空间复杂
    * */
    public int minPathSum2(int[][] m){
        if(m == null||m.length == 0||m[0] == null||m[0].length == 0){
            return 0;
        }
        int more = Math.max(m.length,m[0].length);//行、列大的为more
        int less = Math.min(m.length,m[0].length);//行、列小的为less
        boolean rowmore = more == m.length;//行数是不是大于等于列数
        int[] arr = new int[less];
        arr[0] = m[0][0];
        for(int i = 1;i < less;i++){
            arr[i] = arr[i - 1] + (rowmore ? m[0][i]:m[i][0]);
        }
        for(int i = 1;i < more;i++){
            arr[0] = arr[0] + (rowmore ? m[i][0]:m[0][i]);
            for(int j = 1;j < less; j++){
                arr[j] = Math.min(arr[j-1],arr[j]) + (rowmore ? m[i][j] : m[j][i]);
            }
        }
        return arr[less-1];
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
