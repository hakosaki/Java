public class findDuplication {
    /**
     * 数组a[N]中有1~N-1的元素，只有一个元素重复一次
     * 1.数学求和法
     * 因为1~N-1连续，只有一个重复,对1~N-1项求和，减去1~N-1和
     *
     * 2.异或法
     *
     * 3.取反法
     *
     * 0~n-1中重复数字，可以有多个重复多次
     *
     * 1~n中重复数字
     * 二分查找，分的是1~n，不是arr[1]~arr[n]
     * */
    public int findDup1(int[] arr){
        if(arr==null||arr.length==0)
            return Integer.MIN_VALUE;
        int t1 = 0;
        int t2 = 0;
        for(int i=0;i<arr.length-1;i++){
            t1 += arr[i];
            t2 += (i+1);
        }
        t1 += arr[arr.length-1];
        return t1-t2;
    }

    public int findDup2(int[] arr){
        if(arr==null||arr.length==0)
            return Integer.MIN_VALUE;
        int res = 0;
        for(int i=0;i<arr.length;i++){
            res ^= arr[i];
        }
        for(int i=1;i<arr.length;i++){
            res ^= i;
        }
        return res;
    }

    public int findDup3(int[] arr){
        if(arr==null||arr.length==0)
            return Integer.MIN_VALUE;
        int len = arr.length;
        int res = Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            if(arr[i]>0)
                arr[arr[i]] = -arr[arr[i]];
            else
                arr[-arr[i]] = -arr[-arr[i]];
        }
        for(int i=1;i<len;i++){
            if(arr[i]>0)
                res = i;
            else
                arr[i] = -arr[i];
        }
        return res;
    }

    public int findDup4(int[] arr){
        if(arr==null||arr.length==0)
            return Integer.MIN_VALUE;
        int i = 0;
        int res = Integer.MIN_VALUE;
        for(i=0;i<arr.length;i++)
            if(arr[i]<0)
                return Integer.MIN_VALUE;
        for(i=0;i<arr.length;i++){
            while(arr[i]!=i){
                if(arr[i]==arr[arr[i]]){
                    res = arr[i];
                    return res;
                }
                int tmp = arr[i];
                arr[i] = arr[tmp];
                arr[tmp] = tmp;
            }
        }
        return res;
    }

    public int findDup5(int[] arr){
        if(arr == null || arr.length <= 0)
            return Integer.MIN_VALUE;

        int len = arr.length;
        for(int i = 0; i < len; i++){
            if(arr[i] > len - 1 || arr[i] < 1)
                return Integer.MIN_VALUE;
        }
        int low = 1;
        int high = len - 1;
        while (high >= low) {                                         //此处应该是rear >= front
            int mid = ((high - low)>>1) + low;
            int count = countRange(arr,low,mid);
            if(high == low){                                          //忘记判断rear == front了
                if(count > 1)
                    return low;                                       //返回的是front, 不是numbers[front]
                else
                    break;
            }
            if(count > (mid - low + 1)){                          //count > middle XXXX
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return Integer.MIN_VALUE;
    }

    private int countRange(int[] arr, int low, int mid){
        int len = arr.length;
        int temp = 0;
        for(int i = 0; i < len; i++){
            if(arr[i] >= low && arr[i] <= mid){
                ++temp;
            }
        }
        return temp;
    }
    public static void main(String[] args){
        findDuplication f = new findDuplication();
        int[] arr={1,2,1,3,4};
        System.out.println(f.findDup1(arr));
        System.out.println(f.findDup2(arr));
        System.out.println(f.findDup3(arr));
        System.out.println(f.findDup4(arr));
        System.out.println(f.findDup5(arr));
    }
}
