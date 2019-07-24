import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    /**
     * n个用户，n个喜欢程度
     * q个查询
     * 每个查询 起点 终点 喜欢程度
     *
     * 查询给定范围内喜欢程度的数量
     * */
    public String preferenceCount(String[] like,String[] query){
        if(like==null||query==null)
            return null;
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<like.length;i++){
            int favor = Integer.parseInt(like[i]);
            if(!map.containsKey(favor))
                map.put(favor,new ArrayList<>());
            map.get(favor).add(i+1);
        }
        StringBuilder res = new StringBuilder();
        int q = query.length;
        for(int i=0;i<q;i++){
            String[] tmp = query[i].split(" ");
            int l = Integer.parseInt(tmp[0]);
            int r = Integer.parseInt(tmp[1]);
            int k = Integer.parseInt(tmp[2]);
            if(!map.containsKey(k)) {
                res.append("0\n");
                continue;
            }
            ArrayList list = map.get(k);
            int len = getSum(l,r,list);
            res.append(len);
            res.append("\n");
        }
        res.deleteCharAt(res.length()-1);
        return res.toString();
    }
    private int getSum(int low,int high,ArrayList<Integer> list){
        int l = 0;
        int r = list.size()-1;
        while(l<list.size() && list.get(l)<low){
            ++l;
        }
        while(r>=0 && list.get(r)>high){
            --r;
        }
        return r-l+1;
    }

    public static void main(String[] args) throws IOException {
        Main m = new Main();
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        int n = Integer.parseInt(br.readLine());
        String[] like = br.readLine().split(" ");
        int q = Integer.parseInt(br.readLine());
        String[] ques = new String[q];
        for (int i=0; i<q; ++i){
            ques[i] = br.readLine();
        }
        System.out.println(m.preferenceCount(like,ques));
        ir.close();
    }
}
