import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class br {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = br.read()-'0';
        br.readLine();
        String s1 = br.readLine();
        String s2 = br.readLine();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(len);
    }
}
