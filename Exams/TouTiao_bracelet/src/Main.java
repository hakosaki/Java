import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] para = br.readLine().split(" ");
        int n = Integer.parseInt(para[0]);
        int m = Integer.parseInt(para[1]);
        int c = Integer.parseInt(para[2]);
        HashMap<Integer,ArrayList<Integer>> color_map = new HashMap<>();
        for(int i=0; i<n; ++i){
            para = br.readLine().split(" ");
            int color_num = Integer.parseInt(para[0]);
            for(int j=1; j<=color_num; ++j){
                int tem = Integer.parseInt(para[j]);
                if(!color_map.containsKey(tem))
                    color_map.put(tem,new ArrayList<>());
                color_map.get(tem).add(i);
            }
        }
        int count = 0;
        for(int i=1; i<=c; ++i){
            if(!isVaild(i,n,m,color_map))
                ++count;
        }
        System.out.println(count);
    }

    public static boolean isVaild(int colorType, int n, int m, HashMap<Integer,ArrayList<Integer>> color_map){
        ArrayList<Integer> list = color_map.get(colorType);
        if(list.size()<=1) return true;
        list.add(list.get(0)+ n );
        for(int i=1; i<list.size(); ++i){
            if(list.get(i)-list.get(i-1)<m){
                list.remove(list.size()-1);
                return false;
            }
        }
        list.remove(list.size()-1);
        return true;
    }
}