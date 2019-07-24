public class shellSort {
    /**
     * 希尔排序
     * 从数组一半开始，按步长划分数组，对每个数组进行插入排序
     * */
    public static void shellSort(int[] arr){
        if(arr==null||arr.length==0)
            return;
        for(int h=arr.length/2;h>0;h>>=1){
            for(int i=h;i<arr.length;i++){
                int temp = arr[i];
                int j=i;
                while(j>=h && arr[j-h]>temp){
                    arr[j] = arr[j-h];
                    j -= h;
                }
                arr[j] = temp;
            }
        }
    }
}
