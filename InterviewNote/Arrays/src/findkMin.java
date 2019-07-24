import java.util.Arrays;

public class findkMin {
    /**
     * 找第k个最小的数
     *
     * 1.排序后遍历
     * 2.采用快速排序进行优化
     * */
    public int findkMin(int arr[],int k){
        if(arr==null||arr.length==0||k<0||arr.length<k)
            return Integer.MIN_VALUE;
        return quickSort(arr,k,0,arr.length-1);
    }

    private int quickSort(int[] arr,int k,int low,int high){
        if(low>high)
//            必须是>，不能是>=
            return Integer.MIN_VALUE;
        int l = low;
        int r = high;
        int index = arr[l];
        while(l<r){
            while (l<r && arr[r]>=index){
                r--;
            }
            if(l<r)
                arr[l++] = arr[r];
            while (l<r && arr[l]<index){
                l++;
            }
            if(l<r)
                arr[r--] = arr[l];
        }
        arr[l] = index;
        if(l+1==k)
            return index;
        else if(l+1>k)
            return quickSort(arr,k,low,l-1);
        else
            return quickSort(arr,k,l+1,high);
    }
    public static void main(String[] args){
        findkMin f = new findkMin();
        int[] arr = {1,5,2,6,8,0,6};
        System.out.println(f.findkMin(arr,4));
        System.out.println(Arrays.toString(arr));
    }
}
