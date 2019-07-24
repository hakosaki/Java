import java.util.Arrays;

public class quickSort {
    public void quickSort(int[] arr){
        if(arr==null||arr.length==0)
            return;
        quickSort(arr,0,arr.length-1);
    }
    private void quickSort(int[] arr,int begin,int end){
        if(begin>end)
            return;
        int l = begin;
        int r = end;
        int tmp = arr[l];
        while(l<r){
            while(l<r && arr[r]>=tmp) {
                r--;
            }
            if(l<r)
                arr[l++] = arr[r];
            while(l<r && arr[l]<tmp){
                l++;
            }
            if(l<r)
                arr[r--] = arr[l];
        }
        arr[l] = tmp;
        quickSort(arr,begin,l-1);
        quickSort(arr,l+1,end);
    }
    public static void main(String[] args){
        quickSort q = new quickSort();
        int[] arr = {5,4,3,8,7,40,6};
        System.out.println(Arrays.toString(arr));
        q.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
