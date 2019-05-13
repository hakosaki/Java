import java.util.Scanner;
public class FootballTeam2 {
    public static void main(String[] args) {
        /*
         * 输入
         * */
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int t;
//      输入为空
        if(string.equals(""))
            return;
//      t不合法
        if(string.charAt(0)>'0'&&string.charAt(0)<='9') {
            t = Integer.parseInt(string);
        } else {
            return;
        }
        StringBuffer result = new StringBuffer();
        while(t>0){
            --t;
            long n = scanner.nextLong();
            long k = scanner.nextLong();
            long d1 = scanner.nextLong();
            long d2 = scanner.nextLong();
//          n,k,d1,d2不合法
            if(n<1||n>Math.pow(10,12))
                return;
            if(k<0||k>n)
                return;
            if(d1<0||d1>k)
                return;
            if(d2<0||d2>k)
                return;

            long tmp,left;
//          System.out.println(n);
//          System.out.println(k);
//          System.out.println(d1);
//          System.out.println(d2);
            tmp = k-d1-d1-d2;
            if(tmp >= 0 && tmp % 3 == 0){
                left = n-k-d1-d2-d2;
                if(left >= 0 && left % 3 ==0){
                    result.append("yes\n");
                    continue;
                }
            }
            tmp = k-d1-d1+d2;
            if(tmp >= 0 && tmp % 3 == 0){
                left = n-k-d1-d2;
                if(left >= 0 && left % 3 ==0){
                    result.append("yes\n");
                    continue;
                }
            }
            tmp = k+d1+d1+d2;
            if(tmp >= 0 && tmp % 3 == 0){
                left = n-k-d1-d1-d2;
                if(left >= 0 && left % 3 ==0){
                    result.append("yes\n");
                    continue;
                }
            }
            tmp = k+d1+d1-d2;
            if(tmp >= 0 && tmp % 3 == 0){
                if(d1 >= d2){
                    left = n-k-d1-d1+d2;
                } else {
                    left = n-k-d2-d2+d1;
                }
                if(left >= 0 && left % 3 ==0){
                    result.append("yes\n");
                    continue;
                }
            }
            result.append("no\n");
        }
        /*
         * 输出
         * */
        result.deleteCharAt(result.length()-1);
        System.out.print(result);
    }
}
