import java.util.Scanner;
public class getSubString {
/**
 * 找最长对称子串，动态规划
 * 输入algorithm 输出空
 * 输入rcursion 输出r
 * 输入redivide 输出edi
 *
 * 改自dp最长公共子串
 *
 * */
    private int[][] getdp(String s){
        if(s==null&&s.length()<=0)
            return null;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb1.append(s);
        sb2.append(s);
        sb2.reverse();
        int len = s.length();

        int[][] dp = new int[len][len];
        int i,j;
        for(i=0;i<len-1;i++)
            if(sb1.charAt(i)==sb2.charAt(0))
                dp[i][0] = 1;
        for(j=0;i<len-1;j++)
            if(sb1.charAt(0)==sb2.charAt(j))
                dp[0][j] = 1;
        for(i=1;i<len-1;i++){
            for(j=1;j+i<len-1;j++){
                if(sb1.charAt(i)==sb2.charAt(j))
                    dp[i][j] = dp[i-1][j-1]+1;
            }
        }
        return dp;
    }
    public String getSubString1(String s){
        if(s==null||s.equals(""))
            return null;
        int[][] dp = getdp(s);
        int end = 0;
        int max = 0;
        int len = s.length();
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(dp[i][j]>max){
                    end = i;
                    max = dp[i][j];
                }
            }
        }
        return s.substring(end-max+1,end+1);
    }
    /*
    * dp空间压缩
    * */
    public String getSubString2(String s){
        if(s==null||s.equals(""))
            return null;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb1.append(s);
        sb2.append(s);
        sb2.reverse();
        int row = 0;
        int col = s.length()-2;
        int end = 0;
        int max = 0;
        while(row<s.length()){
            int i = row;
            int j = col;
            int len = 0;
            while(i+j<s.length()-1){
                if(sb1.charAt(i)!=sb2.charAt(j))
                    len = 0;
                else
                    len++;
                if(len>max){
                    end = i;
                    max = len;
                }
                i++;
                j++;
            }
            if(col>0)
//                斜线开始位置列先向左移动
                col--;
            else
//                列移动到最左后，行向下移动
                row++;
        }
        return s.substring(end-max+1,end+1);
    }

    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
        getSubString g = new getSubString();
        String s1 = "abababababcbababababa";
        String s2 = "abcabababab";
        String s3 = "redivided";
        String s4 = "rir";
        System.out.println(g.getSubString2(s1));
        System.out.println(g.getSubString2(s2));
        System.out.println(g.getSubString2(s3));
        System.out.println(g.getSubString2(s4));
    }
}
