import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    /**
     * 从DNA序列s中找出最短没有出现在DNA序列s中的DNA片段的长度
     * s = AGGTCTA
     * 序列中不包含"AA",所以输出2
     * */
    /**
     * 自己代码通过80%，原因序列2不止AA,CC,GG,TT,还有AC,AG,AT......
     * */
    public int getDNA1(String s){
        if(s==null||s.length()==0)
            return 1;
        int[] count = new int[4];
        int len = s.length();
//        A C G T
       switch(s.charAt(0)){
           case 'A':
               count[0]++;break;
           case 'C':
               count[1]++;break;
           case 'G':
               count[2]++;break;
           case 'T':
               count[3]++;break;
           default:
               return 0;
       }
       int tmp=1;
        for(int i=1;i<len;i++){
            if(s.charAt(i)==s.charAt(i-1)){
                tmp++;
            }else{
                tmp=1;
            }
            switch(s.charAt(i)){
                case 'A':
                    count[0]=Math.max(count[0],tmp);break;
                case 'C':
                    count[1]=Math.max(count[1],tmp);break;
                case 'G':
                    count[2]=Math.max(count[2],tmp);break;
                case 'T':
                    count[3]=Math.max(count[3],tmp);break;
                default:
                    return 0;
            }
        }
        Arrays.sort(count);
        return count[0]+1;
    }
    /**
     * 把s按长度i把子串都放进set，若set数量小于4的i次方，说明长度为i的子串不全
     * */
    public int getDNA(String s){
        if(s==null||s.length()==0)
            return 1;
        int len = s.length();
        for(int i=1;i<=len;i++){
            HashSet<String> set = new HashSet<>();
            for(int j=0;j<len-i;j++)
                set.add(s.substring(j,j+i));
            if(set.size()<Math.pow(4,i)){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Main m = new Main();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(m.getDNA(s));
    }
}
