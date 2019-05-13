public class bubbleSort {
    /**
     * 冒泡排序
     * 双重循环，第一重遍历（比正常遍历少一次），第二重将大的数字依次换到末尾
     * */
    public static void bubbleSort(int[] arr){
        if(arr==null||arr.length==0)
            return;
        for(int i=1;i<arr.length;i++){
            int tmp;
            for(int j=1;j<=arr.length-i;j++){
                if(arr[j-1]>arr[j]){
                    tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}
