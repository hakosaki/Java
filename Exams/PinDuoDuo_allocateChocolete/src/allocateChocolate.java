import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class allocateChocolate{
    /**
     * 牛客答案，更少空间
     * */
    public static void main(String args[]) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bf.readLine());
        String s[]=bf.readLine().split(" ");
        int h[]=new int[n];
        for(int i=0;i<n;i++ ){
            h[i]=Integer.parseInt(s[i]);
        }
        Arrays.sort(h);
        int m=Integer.parseInt(bf.readLine());
        String p[]=bf.readLine().split(" ");
        int w[]=new int[m];
        for(int i=0;i<m;i++){
            w[i]=Integer.parseInt(p[i]);
        }
        Arrays.sort(w);
        int result=0;
        int i=0,j=0;
        while(i<n && j<m){
            if(w[j]>=h[i]){
                result++;
                i++;
            }
            j++;
        }
        System.out.println(result);
    }
}