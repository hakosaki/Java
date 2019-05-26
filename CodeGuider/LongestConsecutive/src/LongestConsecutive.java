import java.util.HashMap;

public class LongestConsecutive {
    /**
     * 数组最长连续序列
     *
     * 输入 100 4 200 1 3 2
     * 输出 4（1 2 3 4）
     *
     * hashmap
     * 没出现过arr[i],则放入arr[i],1
     * max = Math.max(max，merge（左））
     * max = Math.max(max，merge（右））
     *  通过记录的len找到当前序列最左，通过记录的len找到当前序列最右，用新长度更新最左、最右
     * */
    public int LongestConsecutive(int[] arr){
        if(arr==null||arr.length==0)
            return 0;
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 1;
        for(int i=0;i<n;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],1);
                if(map.containsKey(arr[i]-1)){
                    max = Math.max(max,merge(map,arr[i]-1,arr[i]));
                }
                if(map.containsKey(arr[i]+1)){
                    max = Math.max(max,merge(map,arr[i],arr[i]+1));
                }
            }
        }
        return max;
    }
    private int merge(HashMap<Integer,Integer> map,int less,int more){
        int left = less - map.get(less) + 1;
        int right = more + map.get(more) - 1;
        int len = right - left + 1;
        map.put(left,len);
        map.put(right,len);
        return len;
    }
    public static void main(String[] args){
        LongestConsecutive l = new LongestConsecutive();
        int[] arr = {100,4,200,1,3,2};
        System.out.println(l.LongestConsecutive(arr));
    }
}
