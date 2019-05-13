import java.util.Arrays;

public class mergeSortArray {
    /**
     * 两个有序子数组的合并
     * */
    public void mergeSortArray(int[] arr,int mid){
        if(arr==null||arr.length<=0||mid<0)
            return;
        for(int i=0;i<mid;i++){
            if(arr[mid]<arr[i]){
                int tmp = arr[i];
                arr[i] = arr[mid];
                arr[mid] = tmp;
                findRightMidPlace(arr,mid);
            }
        }
    }

    private void findRightMidPlace(int[] arr,int mid){
        for(int i=mid;i<arr.length-1;i++){
            if(arr[i+1]<arr[i]){
                int tmp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = tmp;
            }
        }
    }
    public static void main(String[] args) {
        mergeSortArray m = new mergeSortArray();
        int[] arr1 = {1, 5, 6, 7, 9};
        int[] arr2 = {2, 4, 8, 10, 13, 14};
        int[] arr = Arrays.copyOf(arr1, arr1.length + arr2.length);
        System.arraycopy(arr2, 0, arr, arr1.length, arr2.length);
        System.out.println(Arrays.toString(arr));
        m.mergeSortArray(arr,arr1.length);
        System.out.println(Arrays.toString(arr));
    }
}
