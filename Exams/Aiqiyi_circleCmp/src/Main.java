import java.util.Scanner;

public class Main {
    /**
     * 整数a，重复次数k1，整数b，重复次数k2，比较两数大小
     * 输入 1010 3 101010 2
     * 输出 Equal
     * a>b输出Greater,  a<b输出Less
     * */
    public static String circleCmp(int a,int k1,int b,int k2){
        String sa = new String();
        String sb = new String();
        for(int i=0;i<k1;i++)
            sa =sa+a;
        while(sa.charAt(0)=='0')
            sa=sa.substring(1);
        for(int i=0;i<k2;i++)
            sb=sb+b;
        while(sb.charAt(0)=='0')
            sb=sb.substring(1);
        if(sa.length()>sb.length())
            return "Greater";
        else if(sa.length()<sb.length())
            return "Less";
        else{
            if(sa.equals(sb))
                return "Equal";
            int i = 0;
            while(i<sa.length()){
                if(sa.charAt(i)>sb.charAt(i))
                    return "Greater";
                else if(sa.charAt(i)<sb.charAt(i))
                    return "Less";
                else
                    i++;
            }
            return "Equal";
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int k1 = Integer.parseInt(s[1]);
        int b = Integer.parseInt(s[2]);
        int k2 = Integer.parseInt(s[3]);
        System.out.println(circleCmp(a,k1,b,k2));
    }
}
