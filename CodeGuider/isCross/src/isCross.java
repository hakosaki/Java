public class isCross {
    /**
     * 字符串交错组成
     *
     * 给s1,s2,aim，aim包含s1，s2所有字符且顺序与s1,s2不变
     * 输入+输出
     * s1 = "AB"
     * s2 = "12"
     * aim = "AB12" true
     * aim = "AB23" false
     *
     * 1.dp
     * dp[0][0]=true
     * 第一行，仅用s2能否交错组成aim
     * 第一列，仅用s1能否交错组成aim
     * 其他，当前aim等于s1，且dp[i-1][j]也true，当前aim等于s2，且dp[i][j-1]也true
     *
     * 2.空间压缩
     * dp[0] = dp[0] && longs[i-1]==caim[i-1]
     * 若不是true还要置为false
     * */
    public boolean isCross1(String s1,String s2,String aim){
        if(s1==null||s2==null||aim==null)
            return false;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] caim = aim.toCharArray();
        int n = c1.length;
        int m = c2.length;
        if(aim.length()!=m+n)
            return false;
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for(int i=1;i<=n;i++) {
            if (c1[i - 1] != caim[i - 1])
                break;
            dp[i][0] = true;
        }
        for(int j=1;j<=m;j++) {
            if (c2[j - 1] != caim[j - 1])
                break;
            dp[0][j] = true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if((c1[i-1]==caim[i+j-1] && dp[i-1][j]) || (c2[j-1]==caim[i+j-1] && dp[i][j-1]))
                    dp[i][j] = true;
            }
        }
        return dp[n][m];
    }
    public boolean isCross2(String s1,String s2,String aim){
        if(s1==null||s2==null||aim==null)
            return false;
        char[] caim = aim.toCharArray();
        int n = s1.length();
        int m = s2.length();
        if(aim.length()!=m+n)
            return false;
        char[] longs = n>m?s1.toCharArray():s2.toCharArray();
        char[] shorts = n>m?s2.toCharArray():s1.toCharArray();
        if(n<m){
            int tmp = n;
            n = m;
            m = tmp;
        }
        boolean dp[] = new boolean[m+1];
        dp[0] = true;
        for(int j=1;j<=m;j++){
            if(shorts[j-1]!=caim[j-1])
                break;
            dp[j] = true;
        }
        for(int i=1;i<=n;i++){
            /**
             * dp[0] 需要当前字符等，且上一个字符也相等
             * */
            dp[0] = dp[0] && longs[i-1]==caim[i-1];
            for(int j=1;j<=m;j++){
                if((longs[i-1]==caim[i+j-1] && dp[j]) || (shorts[j-1]==caim[i+j-1] && dp[j-1]))
                    dp[j] = true;
                /**
                 * 需要把不符合的dp置为false
                 * */
                else
                    dp[j] = false;
            }
        }
        return dp[m];
    }
    public static void main(String[] args){
        isCross i = new isCross();
        String s1 = "AB";
        String s2 = "12";
        String aim1 = "AB12";
        String aim2 = "A1B2";
        String aim3 = "A12B";
        String aim4 = "AB23";
        System.out.println(i.isCross1(s1,s2,aim1));
        System.out.println(i.isCross1(s1,s2,aim2));
        System.out.println(i.isCross1(s1,s2,aim3));
        System.out.println(i.isCross1(s1,s2,aim4));

        System.out.println(i.isCross2(s1,s2,aim1));
        System.out.println(i.isCross2(s1,s2,aim2));
        System.out.println(i.isCross2(s1,s2,aim3));
        System.out.println(i.isCross2(s1,s2,aim4));
    }
}
