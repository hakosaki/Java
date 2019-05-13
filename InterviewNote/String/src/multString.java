import java.io.*;
public class multString{
    /**
     * 大整数乘法
     * */
    public String multString(String s1,String s2){
        if(s1==null||s2==null||s1.length()<=0||s2.length()<=0)
            return null;
        int len1 = s1.length();
        int len2 = s2.length();
        int[] num1 = new int[len1];
        int[] num2 = new int[len2];
        int[] res = new int[len1+len2];
        int i,j;
        for(i=0;i<len1;i++){
            num1[i] = s1.charAt(len1-1-i)-'0';
        }
        for(i=0;i<len2;i++){
            num2[i] = s2.charAt(len2-1-i)-'0';
        }
        for(i=0;i<len1;i++){
            for (j=0;j<len2;j++){
                res[i+j] += num1[i]*num2[j];
            }
        }
        for(i=1;i<len1+len2;i++){
            res[i] += res[i-1]/10;
            res[i-1] = res[i-1]%10;
        }
        StringBuilder sb = new StringBuilder();
        boolean start = false;
        for(i=len1+len2-1;i>=0;i--){
            if(!start && res[i]==0)
                continue;
            else
                start = true;
            sb.append(res[i]);
        }
        return sb.toString();
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        String[] string = s.split(" ");
        multString m = new multString();
        System.out.println(m.multString(string[0],string[1]));
    }
}