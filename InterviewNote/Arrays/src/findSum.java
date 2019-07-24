import java.util.Arrays;

public class findSum {
    /**
     * 找数组中两两相加等于20的组合种数
     * 1.暴力
     *
     * 2.排序后遍历
     * */
    public void findSum1(int[] arr,int sum){
        if(arr==null||arr.length==0)
            return;
        int len = arr.length;
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++) {
                if(arr[i] + arr[j] == sum)
                    System.out.println(arr[i]+","+arr[j]);
            }
        }
    }

    public void findSum2(int[] arr,int sum){
        Arrays.sort(arr);
        int l = 0;
        int r = arr.length-1;
        while(l<r){
            if(arr[l]+arr[r]==sum){
                System.out.println(arr[l]+","+arr[r]);
                l++;
                r--;
            }else if(arr[l]+arr[r]>sum){
                r--;
            }else{
                l++;
            }
        }
    }

    public static void main(String[] args){
        findSum f = new findSum();
        int[] arr = {1,7,17,2,6,3,14};
        f.findSum1(arr,20);
        System.out.println();
        f.findSum2(arr,20);
    }
}
