import java.util.Scanner;

public class Main {
    /**
     * 任意01串中找最长01交错子串
     * 输入
     * 111101111
     * 输出
     * 3（101）
     *
     * 简单dp
     * */
    public int getSub01String(String s){
        if(s==null||s.equals(""))
            return 0;
        int dp = 0;
        int max = 0;
        int pos = -1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)!=s.charAt(i-1)) {
                dp++;
                if(dp>max){
                    max = dp;
                    pos = i;
                }
            }else{
                dp = 0;
            }
        }
        return max+1;
    }
    public static void main(String[] args){
        Main m = new Main();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(m.getSub01String(s));
    }
}
