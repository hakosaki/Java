public class insertSort {
    /**
     * 插入排序
     * 双重循环，第一重遍历，第二重将比自己大的数后移
     * */
    public static void insertSort(int[] arr){
        if(arr==null||arr.length==0)
            return;
        for(int i=1;i<arr.length;i++){
            int tmp = arr[i];
            int j=i;
            while(j>=1 && arr[j-1]>tmp){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = tmp;
        }
    }
}
