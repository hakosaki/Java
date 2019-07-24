import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TouTiao_StringConv2 {
  /*  8 1
    aabbaaaa
            输出4
    应该是5
            该答案没考虑上述字符串*/

    public static void main(String[] args) throws IOException {
        /*
        * 输入
        * */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int n = Integer.valueOf(s[0]);
        int m = Integer.valueOf(s[1]);
        String ab = reader.readLine();
        /*
        * 处理
        * */
        int left = 0;
        int right = 0;
        int max = 0;
        int o = m;
        while(right<n && left<n){
            if(ab.charAt(right) == 'a'){
                right++;
                if(right==n && max < right - left)
                    max = right - left;
            }else{
                if(o>0){
                    o--;
                    right++;
                }
                else {
                    if(max < right - left)
                        max = right - left;
                    while(left< n && ab.charAt(left) == 'a'){
                        left++;
                    }
                    while(left< n && ab.charAt(left) == 'b'){
                        left++;
                        if(o < m){
                            o++;
                        }
                    }
                    if(left>right)
                        right = left;
                }
            }
        }
        left = 0;
        right = 0;
        o = m;
        while(right < n&left< n){
            if(ab.charAt(right) == 'b'){
                right++;
                if(right == n&max < right - left) max = right - left;
            }else{
                if(o>0){o--;right++;}
                else {
                    if(max < right - left) max = right - left;
                    while(left< n && ab.charAt(left) == 'b'){
                        left++;
                    }
                    while(left < n&& ab.charAt(left) == 'a'){
                        left++;
                        if(o < m){
                            o++;
                        }
                    }
                    if(left>right) right = left;
                }
            }
        }
        System.out.print(max);
    }
}
