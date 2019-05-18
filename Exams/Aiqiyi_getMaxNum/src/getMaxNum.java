import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class getMaxNum {
    private static int getMaxNum(int n, String[] x) {
        int tmp,max = Integer.MIN_VALUE;
        StringBuilder st = new StringBuilder();
        for (int i=0;i<n;i++){
            char a[] = x[i].toCharArray();
            Arrays.sort(a);
            for (int j=0;j<a.length;j++){
                st.append(a[j]);
            }
            tmp = Integer.parseInt(st.toString());
            if (tmp>max){
                max = tmp;
            }
            st.setLength(0);
        }
        return max;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2[] = br.readLine().split(" ");
        int n = Integer.parseInt(s1);
        System.out.println(getMaxNum(n,s2));
    }
}
