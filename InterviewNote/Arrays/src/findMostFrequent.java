import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class findMostFrequent {
    /**
     * 找数组重复最多的数字
     * HashMap+Iterator
     * */
    public int findMostFrequent(int[] arr){
        if(arr==null||arr.length==0)
            return Integer.MAX_VALUE;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i]))
                map.put(arr[i],map.get(arr[i])+1);
            else
                map.put(arr[i],1);
        }
        int most = 0;
        int result = 0;
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry = (Map.Entry)iter.next();
            int key = (int)entry.getKey();
            int value = (int)entry.getValue();
            if(value>most){
                result = key;
                most = value;
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] arr={1,5,4,3,4,4,5,4,5,5,6,6,6,6,6};
        findMostFrequent m = new findMostFrequent();
        System.out.println(m.findMostFrequent(arr) );
    }
}
