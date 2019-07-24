public class getMinABS {
    /**
     * 在一个升序数组，找到绝对值最小的数
     * 全正，arr[0],全负，arr[n-1]，有正有负取中间比较
     *
     * 二分查找优化
     * */
    public int getMinABS(int[] arr){
        if(arr==null||arr.length<1)
            return Integer.MIN_VALUE;
        int len = arr.length;
        if(arr[0]>0)
            return arr[0];
        if(arr[len-1]<0)
            return arr[len-1];
        int low = 0;
        int high = len-1;
        while(low<=high){
            int mid = ((high + low)>>1);
            if(arr[mid] == 0)
                return 0;
            else if(arr[mid]>0){
                if(arr[mid-1] == 0)
                    return 0;
                else if(arr[mid-1]<0){
                    if(Math.abs(arr[mid-1])>Math.abs(arr[mid]))
                        return arr[mid];
                    else
                        return arr[mid-1];
                }
                else
                    high = mid;
            }
            else{
                if(arr[mid+1]==0)
                    return 0;
                else if(arr[mid+1]>0) {
                    if(Math.abs(arr[mid+1])>Math.abs(arr[mid]))
                        return arr[mid];
                    else
                        return arr[mid+1];
                }
                else
                    low = mid + 1;
            }
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args){
        getMinABS g = new getMinABS();
        int[] arr1 = {-10,-5,-2,7,15,50};
        int[] arr2 = {2,4,6,8,27};
        int[] arr3 = {-13,-9,-7,-3};
        System.out.println(g.getMinABS(arr1));
        System.out.println(g.getMinABS(arr2));
        System.out.println(g.getMinABS(arr3));
    }
}
