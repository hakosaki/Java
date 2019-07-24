import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /**
     * 递推公式，s个0,1，每次随机取两个，把其中1变成0，平均多少次操作后，s个数全变0
     *
     * k个1，
     * 00 C(s-k,2)/C(s,2)
     * 01 (s-k)*k/C(s,2)
     * 11 C(k,2)/C(s,2)
     *
     * f(k)=1+C(s-k,2)/C(s,2)f(k)+(s-k)k/C(s,2)f(k-1)+C(k,2)/C(s,2)f(k-2)
     * f(0)=0,f(1)=s/2
     * */
    public static void main(String[] args) throws IOException, IOException {
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bufr.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int s = m+n;
        double f0=0,f1 = s/2.0;
        for(int k=2;k<=m;k++) {
            double cur = s * (s - 1) / (1.0 * k * (2 * s - k - 1)) + 2 * (s - k) * 1.0 / (2 * s - k - 1) * f1 + (k - 1) * 1.0 / (2 * s - k - 1) * f0;
            f0=f1;
            f1=cur;
        }
        System.out.println(Math.round(f1*10)/10.0);

    }
}
