import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_remix {
    /**
     * n个杂色手串，m个串珠至多出现一次，c种颜色
     * 以下n行，每行第一个数字为当前珠子颜色数字，后面为颜色
     * 输出多少种颜色不符合条件
     * */
    public int bracelet(int n,int m,int c,String[] s){
        if(n<1||n>10000||m<1||m>1000||c<1||c>50||s==null)
            return 0;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<c;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            String[] tmp = s[i].split(" ");
            int len = Integer.parseInt(tmp[0]);
            for(int j=1;j<=len;j++){
                int color = Integer.parseInt(tmp[j]);
                ArrayList<Integer> l = list.get(color-1);
                l.add(i);
            }
        }
        int res = 0;
        for(int i=0;i<c;i++){
            ArrayList<Integer> l = list.get(i);
//            System.out.println(l.toString());
            int len = l.size();
            if(len<=0)
                continue;
            if((l.get(0) + n - l.get(len-1))<m) {
                res++;
                continue;
            }
            for(int j=1;j<len;j++){
                if(l.get(j)-l.get(j-1)<m) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        Main_remix main = new Main_remix();
        /*int n = 5;
        int m = 2;
        int c = 3;
        String[] s = {"3 1 2 3","0","2 2 3","1 2","1 3"};*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        int c = Integer.parseInt(tmp[2]);
        String[] s = new String[n];
        for(int i=0;i<n;i++)
            s[i] = br.readLine();
        System.out.println(main.bracelet(n,m,c,s));
        br.close();
    }
}
