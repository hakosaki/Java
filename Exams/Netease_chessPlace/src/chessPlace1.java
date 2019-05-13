import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class chessPlace1{
    /**
     * n个棋子，x,y坐标，移动棋子求棋盘上一个格子至少有1~n个棋子的移动最少步数
     * 输入
     * 4
     * 1 2 4 9
     * 1 1 1 1
     * 输出
     * 0 1 3 10
     *
     * 输入
     * 5
     * 8 1 9 9 7
     * 7 7 7 7 10
     * 输出
     * 0 0 1 6 13
     * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String[] str = br.readLine().split(" ");
        String[] str2 = br.readLine().split(" ");
        int len = str.length;
        int[] xs = new int[len];
        int[] ys = new int[len];
        int[] distance = new int[len];
        int[] result = new int[len];
        for(int i = 0;i < len;i++){
            xs[i] = Integer.parseInt(str[i]);
            ys[i] = Integer.parseInt(str2[i]);
            result[i] = Integer.MAX_VALUE;
        }

        for(int i = 0;i<len;i++){
            for(int j = 0;j<len;j++){
                for(int k = 0;k<len;k++){
                    distance[k] = Math.abs(xs[k] - xs[i]) + Math.abs(ys[k] - ys[j]);
                }
                Arrays.sort(distance);
                int temp = 0;
                for(int m = 0;m<len;m++){
                    temp += distance[m];
                    result[m] = Math.min(result[m], temp);
                }
            }
        }
        for(int i = 0;i<len-1;i++)
            System.out.print(result[i]+" ");
        System.out.print(result[len-1]);
    }
}