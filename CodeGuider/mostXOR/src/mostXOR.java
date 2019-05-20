import java.util.HashMap;

public class mostXOR {
    /**
     * 子数组异或和为0的最多划分（每个都是0）
     *
     * 举例看输出
     *
     * HashMap< 异或和,位置 >
     * map.put(0,-1)
     * map.put(arr[0],0)
     * */
    public int mosrXor(int[] arr){
        if(arr==null||arr.length==0)
            return 0;
        int eor = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int[] dp = new int[arr.length];
        dp[0] = arr[0]==0?1:0;
        map.put(arr[0],0);
        for(int i=1;i<arr.length;i++){
            eor ^= arr[i];
            if(map.containsKey(eor)){
                int pos = map.get(eor);
                dp[i] = pos==-1?1:(dp[pos]+1);
            }
            dp[i] = Math.max(dp[i],dp[i-1]);
            map.put(eor,i);
        }
        return dp[dp.length-1];
    }
    public static void main(String[] args){
        mostXOR m = new mostXOR();
        int[] arr1 = {6,3,2,1};                 //1(3 2 1)
        int[] arr2 = {3,2,1,9,0,7,0,2,1,3};     //4(3 2 1)(0)(0)(2 1 3)
        int[] arr3 = {6,3,2,1,3,2,1};           //2(3 2 1)(3 2 1)
        int[] arr4 = {6,3,2,1,6};               //1(3 2 1)
        int[] arr5 = {6,3,2,1,6,6};             //2(3 2 1)(6 6)
        System.out.println(m.mosrXor(arr1));
        System.out.println(m.mosrXor(arr2));
        System.out.println(m.mosrXor(arr3));
        System.out.println(m.mosrXor(arr4));
        System.out.println(m.mosrXor(arr5));
    }
}
