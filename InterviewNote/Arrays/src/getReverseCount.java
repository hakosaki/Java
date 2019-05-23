import java.lang.reflect.Array;
import java.util.Arrays;

public class getReverseCount {
    /**
     * 数组中反序对个数
     *
     * 1.暴力
     *
     * 2.分治归并
     * */
    public int reverseCount1(int[] arr){
        if(arr==null||arr.length<=1)
            return 0;
        int len = arr.length;
        int count=0;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(arr[i]>arr[j])
                    count++;
            }
        }
        return count;
    }

    public int  reverseCount2(int[] arr){
        if(arr==null||arr.length<=1)
            return 0;
        int reverseCount[] = {0};
        int[] copy = new int[arr.length];
        mergeSort(arr,copy,0,arr.length-1,reverseCount);
//        System.out.println(Arrays.toString(copy));
        return reverseCount[0];
    }
    private void mergeSort(int[] arr,int[] copy,int begin,int end,int[] count){
        if(begin<end){
            int mid = (begin+end)>>1;
            mergeSort(arr,copy,begin,mid,count);
            mergeSort(arr,copy,mid+1,end,count);
            merge(arr,copy,begin,mid,end,count);
        }
    }
    private void merge(int[] arr,int[] copy,int begin,int mid,int end,int[] count){
        int i = begin;
        int j = mid+1;
        int k = begin;
        while(i<=mid && j<=end){
            if(arr[i]>arr[j]){
                copy[k++] = arr[j++];
                count[0] += mid-i+1;
            }else{
                copy[k++] = arr[i++];
            }
        }
        while(i<=mid){
            copy[k++] = arr[i++];
        }
        while(j<=end){
            copy[k++] = arr[j++];
        }
        for(i=begin;i<k;i++)
            arr[i] = copy[i];
    }

    public static void main(String[] args){
        getReverseCount r = new getReverseCount();
        int[] arr = {7,2,2,13,5,5,2};
        System.out.println(r.reverseCount1(arr));
        System.out.println(r.reverseCount2(arr));
    }
}
