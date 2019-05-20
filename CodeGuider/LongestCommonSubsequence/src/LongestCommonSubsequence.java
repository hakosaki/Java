public class LongestCommonSubsequence {
    /**
     * 最长公共子序列
     *
     * dp第一列，s1[i]==s2[0],dp[i][0]=1，且后续dp都为1
     * dp第一行，s1[0]==s2[j],dp[0][j]=1，且后续dp都为1
     * dp[i][j]三种来源，
     * 与dp[i-1][j]相同，与dp[i][j-1]相同，s1[i]==s2[j] dp[i-1][j-1]+1
     *
     * lcse
     * dp[i][j]==dp[i-1][j]，不选s1[i]上移
     * dp[i][j]==dp[i][j-1]，不选s2[j]左移
     * dp[i][j]>dp[i][j-1] && dp[i][j]>dp[i-1][j]，当前是公共字符放进res
     * */
    private int[][] getdp(char[] c1,char[] c2){
        int row = c1.length;
        int col = c2.length;
        int[][] dp = new int[row][col];
        dp[0][0] = c1[0]==c2[0]?1:0;
        for(int i=1;i<row;i++)
            dp[i][0] = Math.max(dp[i-1][0],c1[i]==c2[0]?1:0);
        for(int j=1;j<col;j++)
            dp[0][j] = Math.max(dp[0][j-1],c1[0]==c2[j]?1:0);
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                if(c1[i]==c2[j])
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-1]+1);
            }
        }
        return dp;
    }
    public String lcse(String s1,String s2){
        if(s1==null||s1.length()==0||s2==null||s2.length()==0)
            return null;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int n = c1.length-1;
        int m = c2.length-1;
        int[][] dp = getdp(c1,c2);
        char[] res = new char[dp[n][m]];
        int index = res.length-1;
        while(index>=0){
            if(n>0 && dp[n][m]==dp[n-1][m])
                n--;
            else if(m>0 && dp[n][m]==dp[n][m-1])
                m--;
            else{
                res[index--] = c1[n];
                n--;
                m--;
            }
        }
        return String.valueOf(res);
    }
    public static void main(String[] args){
        LongestCommonSubsequence l = new LongestCommonSubsequence();
        String s1 = "1A2C3D4B56";
        String s2 = "B1D23CA45B6A";
        System.out.println(l.lcse(s1,s2));
    }
}
