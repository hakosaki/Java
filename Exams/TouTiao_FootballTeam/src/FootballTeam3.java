import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
public class FootballTeam3 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String[] strs = new String[t];
        for (int i=0; i<t; ++i){
            strs[i] = br.readLine();
        }
        System.out.println(sumOf(strs));
    }

    public static String sumOf(String[] strs){
        StringBuilder result = new StringBuilder();
        for (int i=0; i<strs.length; ++i){
            String[] tem = strs[i].split(" ");
            long n = Long.parseLong(tem[0]);
            long k = Long.parseLong(tem[1]);
            long d1 = Long.parseLong(tem[2]);
            long d2 = Long.parseLong(tem[3]);
            if(n<1||n>Math.pow(10,12))
                return null;
            if(k<0||k>n)
                return null;
            if(d1<0||d1>k)
                return null;
            if(d2<0||d2>k)
                return null;

            long tmp,left;
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
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }
}