public class quickSort {
    /**
     * 快速排序
     * 递归
     * 选取数组随机一个数赋给index，当右边比index小换到index左边，当左边比index大换到index右边
     * 循环完成所有数划分，再取数递归划分左右两边
     * */
    public static void quickSort(int[] arr){
        if(arr==null||arr.length==0)
            return;
        sort(arr,0,arr.length-1);
    }

    private static void sort(int[] arr,int p,int r){
        if(p>r)
            return;
        int i = p;
        int j = r;
        int index = arr[i];
        while(i<j){
            while(i<j && arr[j]>=index)
                j--;
            if(i<j)
                arr[i++] = arr[j];
            while(i<j && arr[i]<index)
                i++;
            if(i<j)
                arr[j--] = arr[i];
        }
        arr[i] = index;
        sort(arr,p,i-1);
        sort(arr,i+1,r);
    }
}
