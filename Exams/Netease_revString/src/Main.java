import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    /**
     * 小易有一个长度为n的整数序列,a_1,...,a_n。然后考虑在一个空序列b上进行n次以下操作:
     * 1、将a_i放入b序列的末尾
     * 2、逆置b序列
     * 小易需要你计算输出操作n次之后的b序列。
     *
     * 输入2
     * 123 456
     * 输出
     * 456 123
     * */
    /*
    * 时间复杂太大
    * */
    public void revString1(String[] s){
        if(s==null||s.length<=0)
            return;
        int len = s.length;
        LinkedList<String> list = new LinkedList<>();
        for(int i=0;i<len;i++){
            list.add(s[i]);
            Collections.reverse(list);
        }
        for(int i=0;i<len-1;i++) {
            System.out.print(list.pop()+ " ");
        }
        System.out.print(list.pop());
    }
    /*
    * 找规律
    * */
    //规律题
    //n = 1,b = 1    n = 1直接输出
    //n = 2,b = 2,1
    //n = 3,b = 3,1,2
    //n = 4,b = 4,2,1,3
    //n = 5,b = 5,3,1,2,4
    //n = 6,b = 6,4,2,1,3,5
    //由上述可推，当n 为奇数时，
    //先从后向前输出奇数位置的数字，再从前向后输出偶数位置的数字
    //当n 为偶数时
    //先从后向前输出偶数位置的数字，再从前向后输出奇数位置的数字
    public void revString2(String[] s){
        if(s==null||s.length<=0)
            return;
        StringBuilder sb = new StringBuilder();
        int len = s.length;
        for(int i=len-1;i>=0;i-=2){
            sb.append(s[i]).append(" ");
        }
        for(int i=((len&1)==1?1:0);i<len-1;i+=2) {
            sb.append(s[i]).append(" ");
        }
        System.out.println(sb.substring(0,sb.length()-1));
    }
    public static void main(String[] args){
        Main m = new Main();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] s = new String[n];
        scanner.nextLine();
        for(int i=0;i<n;i++)
            s[i] = scanner.next();
//        String[] s = {"12","34"};
        m.revString2(s);
    }
}
