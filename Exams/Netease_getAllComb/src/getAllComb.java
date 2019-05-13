import java.util.HashMap;
import java.util.Scanner;

public class getAllComb {
    /**
     * 彩色砖块。每种颜色由一个大写字母表示。字符串s,s中每个字符代表砖块的颜色。
     * 小易想把他所有的砖块排成一行。如果最多存在一对不同颜色的相邻砖块,那么这行砖块就很漂亮的。
     * 请你帮助小易计算有多少种方式将他所有砖块排成漂亮的一行。
     * (如果两种方式所对应的砖块颜色序列是相同的,那么认为这两种方式是一样的。)
     * 输入 ABAB
     * 输出 2（AABB BBAA）
     *
     * 最多存在一对不同颜色，若砖块两种以上肯定不漂亮，输出0
     * 若两种，输出2
     * 若一种，输出1
     *
     * 贼tm智障的一题
     * */
    public int getAllComb(String s){
        if(s==null||s.equals(""))
            return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                continue;
            }
            else
                map.put(s.charAt(i),1);
        }
        int res = map.size();

        if(res<=2&&res>0)
            return res;
        else
            return 0;
    }

    public static void main(String[] args){
        getAllComb g = new getAllComb();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(g.getAllComb(s));
    }
}
