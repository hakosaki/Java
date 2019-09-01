public class LongestCommonSubstring {
    /**
     * 最长公共子串
     *
     * 与最长公共子序列区别：
     * 子序列不要求连续，dp[i][j]来源可以为dp[i-1][j]或dp[i][j-1]或dp[i-1][j-1]+1
     * 子串要求连续，dp[i][j]来源只可以为dp[i-1][j-1]+1
     *
     * 1.dp
     * 初始化行相等置为1，初始化列相等置为1
     * dp[i][j] = dp[i-1][j-1]+1
     *
     * lcst1
     * 找最大dp记录max，pos，substring(pos-max+1,pos+1)即为所求
     *
     * 2.dp空间压缩
     * dp按斜线递增，row=0，col=c2.length-1
     * 每一斜线 i++,j++ 记录最大值
     *
     * col>0则向左，否则说明到0列向下
     * */
    private int[][] getdp(char[] c1,char[] c2){
        int row = c1.length;
        int col = c2.length;
        int[][] dp = new int[row][col];
        for(int i=0;i<row;i++)
            if(c1[i]==c2[0])
                dp[i][0] = 1;
        for(int j=1;j<col;j++)
            if(c1[0]==c2[j])
                dp[0][j] = 1;
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(c1[i]==c2[j])
                    dp[i][j] = dp[i-1][j-1]+1;
            }
        }
        return dp;
    }
    public String lcst1(String s1,String s2){
        if(s1==null||s1.length()==0||s2==null||s2.length()==0)
            return null;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int n = c1.length;
        int m = c2.length;
        int[][] dp = getdp(c1,c2);
        int max = Integer.MIN_VALUE;
        int pos = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(dp[i][j]>max){
                    max = dp[i][j];
                    pos = i;
                }
            }
        }
        return s1.substring(pos-max+1,pos+1);
    }

    public String lcst2(String s1,String s2){
        if(s1==null||s1.length()==0||s2==null||s2.length()==0)
            return null;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int row = 0;
        int col = c2.length-1;
        int max = Integer.MIN_VALUE;
        int pos = Integer.MIN_VALUE;
        while(row<c1.length){
            int i = row;
            int j = col;
            int len = 0;
            while(i<c1.length && j<c2.length){
                if(c1[i]!=c2[j])
                    len = 0;
                else
                    len++;

                if(len>max){
                    max = len;
                    pos = i;
                }
                i++;
                j++;
            }
            if(col>0)
                col--;
            else
                row++;
        }
        return s1.substring(pos-max+1,pos+1);
    }
    public static void main(String[] args){
        LongestCommonSubstring l = new LongestCommonSubstring();
        String s1 = "1AB2345CD";
        String s2 = "12345EF";
        System.out.println(l.lcst1(s1,s2));
        System.out.println(l.lcst2(s1,s2));
    }
}
