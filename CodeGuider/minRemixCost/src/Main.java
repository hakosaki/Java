import java.util.Arrays;

public class Main {
    /**
     * 最小编辑代价，将s1编辑成s2的最小代价，ic插入，dc删除，rc替换
     *
     * 1.dp
     * dp[0][0]=0，表示空子串s1编辑成空子串s2的代价为0
     * 第一列dp[i][0]，s1删除成空子串代价，dc*i
     * 第一行dp[0][j]，空子串插入成s2代价，j*ic
     * 其余来源四个：
     * s1先删除当前，再编辑成s2，dp[i][j] = dp[i-1][j]+dc
     * s1先编辑成s2，再插入当前，dp[i][j] = dp[i][j-1]+ic
     * s1[i-1]==s2[j-1]，dp[i][j] = dp[i-1][j-1]
     * s1[i-1]!=s2[j-1]，dp[i][j] = dp[i-1][j-1]+rc
     *
     * 2.空间压缩
     * 长行，短列
     * s1短需要交换ic、dc
     * pre记录斜线上数据、tmp记录没更新前dp
     * */
    public int minRemixCost1(String s1,String s2,int ic,int dc,int rc){
        if(s1==null||s2==null)
            return 0;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int n = c1.length;
        int m = c2.length;
        int dp[][] = new int[n+1][m+1];
        for(int i=1;i<=n;i++)
            dp[i][0] = dc*i;
        for(int j=1;j<=m;j++)
            dp[0][j] = ic*j;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(c1[i-1]==c2[j-1])
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = dp[i-1][j-1]+rc;
                dp[i][j] = Math.min(dp[i][j],dc+dp[i-1][j]);
                dp[i][j] = Math.min(dp[i][j],dp[i][j-1]+ic);
            }
        }
        System.out.println(Arrays.toString(dp[0]));
        System.out.println(Arrays.toString(dp[1]));
        System.out.println(Arrays.toString(dp[2]));
        System.out.println(Arrays.toString(dp[3]));
        System.out.println(Arrays.toString(dp[4]));
        System.out.println(Arrays.toString(dp[5]));
        System.out.println(Arrays.toString(dp[6]));
        System.out.println(Arrays.toString(dp[7]));
        return dp[n][m];
    }
    public int minRemixCost2(String s1,String s2,int ic,int dc,int rc){
        if(s1==null||s2==null)
            return 0;
        int n = s1.length();
        int m = s2.length();
        char[] longs = n>m?s1.toCharArray():s2.toCharArray();
        char[] shorts = n>m?s2.toCharArray():s1.toCharArray();
        if(n<m){
            int tmp = ic;
            ic = dc;
            dc = tmp;
            tmp = n;
            n = m;
            m = tmp;
        }
        int dp[] = new int[m+1];
        for(int j=1;j<=m;j++)
            dp[j] = ic*j;
        for(int i=1;i<=n;i++){
            int pre = dp[0];
            dp[0] = dc*i;
            for(int j=1;j<=m;j++){
                /**
                 * 需要保存dp[j]没更新前的数据
                 * */
                int tmp = dp[j];
                if(longs[i-1]==shorts[j-1])
                    dp[j] = pre;
                else
                    dp[j] = pre + rc;
                dp[j] = Math.min(dp[j],tmp+dc);
                dp[j] = Math.min(dp[j],dp[j-1]+ic);
                /**
                 * 更新斜上方数据pre
                 * */
                pre = tmp;
            }
        }
        return dp[m];
    }

    public static void main(String[] args){
        Main m = new Main();
        String s1 = "ab12cd3";
        String s2 = "abcdf";
        String a2 = "ab12cd3";
        String a1 = "abcdf";
        int ic=5,dc=3,rc=2;
        System.out.println(m.minRemixCost1(a1,a2,ic,dc,rc));
        System.out.println(m.minRemixCost2(a1,a2,ic,dc,rc));
    }
}
