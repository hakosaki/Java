public class heapSort {
    /**
     * 堆排序
     * 1.构建堆 2.交换堆顶元素和最后一个元素
     * 第一个非叶子节点 len/2-1，从该点往上依次建立大顶堆
     * 交换根节点和最后一个元素，从根节点依次重建大顶堆
     * */
    public static void heapSort(int[] arr){
        int i;
        int len = arr.length;
        for(i=len/2-1;i>=0;i--){
            adjustMaxHeap(arr,i,len-1);
        }
        for(i=len-1;i>=0;i--){
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            adjustMaxHeap(arr,0,i-1);
        }
    }

    private static void adjustMaxHeap(int[] arr, int pos,int len){
        int tmp,child;
        for(tmp=arr[pos];pos*2+1<=len;pos=child){
            child = pos*2+1;
            if(child<len && arr[child]<arr[child+1])
                child++;
            if(arr[child]>tmp)
                arr[pos] = arr[child];
            else
                break;
        }
        arr[pos] = tmp;
    }
}
