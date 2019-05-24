import java.util.Arrays;

public class minHP {
    /**
     * 龙与地下城游戏，左上角出发，右或下，正数回血，负数减血，能走到右下角最低血量
     *
     * 初始dp[row][col]和dp[row][j]，dp = max（dp+1,1）
     * 其余dp等于下和右最小值
     *
     * 1.dp
     * 2.空间压缩
     * */
    public int minHP1(int[][] m){
        if(m==null||m[0]==null||m.length<=0||m[0].length<=0)
            return 1;
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row--][col--];
        dp[row][col] = m[row][col]>0?1:-m[row][col]+1;
        for(int j=col-1;j>=0;j--)
            dp[row][j] = Math.max(dp[row][j+1]-m[row][j],1);
        int right = 0;
        int down = 0;
        for(int i=row-1;i>=0;i--){
            dp[i][col] = Math.max(dp[i+1][col]-m[i][col],1);
            for(int j=col-1;j>=0;j--){
                right = Math.max(dp[i][j+1]-m[i][j],1);
                down = Math.max(dp[i+1][j]-m[i][j],1);
                dp[i][j] = Math.min(right,down);
            }
        }
        /*System.out.println(Arrays.toString(dp[0]));
        System.out.println(Arrays.toString(dp[1]));
        System.out.println(Arrays.toString(dp[2]));*/
        return dp[0][0];
    }
    public int minHP2(int[][] m){
        if(m==null||m[0]==null||m.length<=0||m[0].length<=0)
            return 1;
        int more = Math.max(m.length,m[0].length);
        int less = Math.max(m.length,m[0].length);
        boolean rowmore = more==m.length;
        int[] dp = new int[less];
        int tmp = m[m.length-1][m[0].length-1];
        dp[less-1] = tmp>0?1:-tmp+1;
        int row = 0;
        int col = 0;
        for(int j=less-2;j>=0;j--) {
            row = rowmore?more-1:j;
            col = rowmore?j:more-1;
            dp[j] = Math.max(dp[j + 1]-m[row][col], 1);
        }
        int chose1 = 0;
        int chose2 = 0;
        for(int i=more-2;i>=0;i--){
            row = rowmore?i:less-1;
            col = rowmore?less-1:i;
            dp[less-1] = Math.max(dp[less-1]-m[row][col],1);
            for(int j=less-2;j>=0;j--){
                row = rowmore?i:j;
                col = rowmore?j:i;
                chose1 = Math.max(dp[j]-m[row][col],1);
                chose2 = Math.max(dp[j+1]-m[row][col],1);
                dp[j] = Math.min(chose1,chose2);
            }
        }
        return dp[0];
    }
    public static void main(String[] args){
        minHP m = new minHP();
        int[][] map = {{-2,-3,3},{-5,-10,1},{0,30,-5}};
        System.out.println(m.minHP1(map));
        System.out.println(m.minHP2(map));
    }
}
