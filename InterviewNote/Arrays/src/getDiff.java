public class getDiff {
    /**
     * 求数对之差的最大值
     * 一个数字只能减去他右边的数字
     *
     * 1.暴力
     *
     * 2.动态规划
     * */
    public int getDiff1(int arr[]){
        if(arr==null||arr.length<=1)
            return Integer.MIN_VALUE;
        int len = arr.length;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<len;i++) {
            for (int j = i; j < len; j++) {
                if (arr[i] - arr[j] > max)
                    max = arr[i] - arr[j];
            }
        }
        return max;
    }

    public int getDiff2(int arr[]){
        if(arr==null||arr.length<=1)
            return Integer.MIN_VALUE;
        int len = arr.length;
        int max = arr[0];
        int diff = Integer.MIN_VALUE;
        for(int i=1;i<len;i++){
            diff = Math.max(diff,max-arr[i]);
            if(arr[i]>max)
                max = arr[i];
        }
        return diff;
    }

    public static void main(String[] args){
        getDiff g = new getDiff();
        int[] arr = {1,4,17,3,2,9};
        System.out.println(g.getDiff1(arr));
        System.out.println(g.getDiff2(arr));
    }
}
