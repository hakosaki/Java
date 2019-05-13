public class selectSort {
    /**
     * 选择排序
     * 双重循环，第一重遍历，第二重比较并记录最小数、下标
     * 若最小数不为第一重遍历到的数就替换
     * */
    public static void selectSort(int[] arr){
        if(arr==null||arr.length==0)
            return;
        for(int i=0;i<arr.length;i++){
            int temp = arr[i];
            int index = i;
            for(int j=i+1;j<arr.length;j++){
                if(temp>arr[j]) {
                    temp = arr[j];
                    index = j;
                }
            }
            if(index!=i){
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
