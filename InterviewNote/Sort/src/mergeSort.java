public class mergeSort {
    /**
     * 归并排序
     * 递归
     * 递归划分左，递归划分右，合并左右
     * 合并：左边赋给L[]，右边赋给R[]，依次取大数放arr[p++]，比较完把剩余放数组
     * */
    public static void mergeSort(int[] arr){
        if(arr==null||arr.length==0)
            return;
        sort(arr,0,arr.length-1);
    }

    private static void sort(int[] arr,int p,int r){
        if(p<r){
            int m =(p+r)/2;
            sort(arr,p,m);
            sort(arr,m+1,r);
            merge(arr,p,m,r);
        }
    }

    private static void merge(int[] arr,int p,int m,int r){
        int len1 = m-p+1;
        int len2 = r-m;
        int L[] = new int[len1];
        int R[] = new int[len2];
        int i,j,k;
        for(i=0,k=p;i<len1;i++,k++)
            L[i] = arr[k];
        for(j=0,k=m+1;j<len2;j++,k++)
            R[j] = arr[k];
        for(i=0,j=0,k=p;i<len1 && j<len2;k++){
            if(L[i]<R[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
        }
        if(i<len1){
            for(j=i;j<len1;j++,k++)
                arr[k] = L[j];
        }
        if(j<len2){
            for(i=j;i<len2;i++,k++)
                arr[k] = R[i];
        }
    }
}
