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
        mergeSort(arr,0,arr.length-1,reverseCount);
        return reverseCount[0];
    }
    private void mergeSort(int[] arr,int begin,int end,int[] count){
        if(begin<end){
            int mid = (begin+end)>>1;
            mergeSort(arr,begin,mid,count);
            mergeSort(arr,mid+1,end,count);
            merge(arr,begin,mid,end,count);
        }
    }
    private void merge(int[] arr,int begin,int mid,int end,int[] count){
        int len1 = mid-begin+1;
        int len2 = end-mid;
        int i,j,k;
        int[] l = new int[len1];
        int[] r = new int[len2];
        for(i=0,k=begin;i<len1;i++,k++)
            l[i] = arr[k];
        for(j=0,k=mid+1;j<len2;j++,k++)
            r[j] = arr[k];
        for(i=0,j=0,k=begin;i<len1&&j<len2;k++){
            if(l[i]<=r[j])
                arr[k] = l[i++];
            else{
                count[0]+= mid-i+1;
                arr[k] = r[j++];
            }
        }
        if(i<len1)
            for(j=i;j<len1;j++,k++)
                arr[k] = l[j];
        if(j<len2)
            for(i=j;i<len2;i++,k++)
                arr[k] = r[i];
    }

    public static void main(String[] args){
        getReverseCount r = new getReverseCount();
        int[] arr = {1,5,3,3,6};
        System.out.println(r.reverseCount1(arr));
        System.out.println(r.reverseCount2(arr));
    }
}
