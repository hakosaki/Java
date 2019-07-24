public class getMaxSubArray {
    /**
     * 数组有正有负，求连续子数组的和的最大值
     *
     * 1.暴力
     * 第一遍i sub头，第二遍j sub尾，第三遍k将i到j加起来
     * O(n^3)
     *
     * 2.暴力优化
     * 第一遍i sub头，第二遍j sub尾，边循环边加
     * O(n^2)
     *
     * 3.dp
     * All[i] = max{arr[i],End[i],All[i-1]},i最大子数组：1.只含i，2以i结尾，3不含i
     *
     * 4.dp优化
     * 空间压缩all end
     * */
    public int maxSubArray1(int[] arr){
        if(arr==null||arr.length==0)
            return Integer.MIN_VALUE;
        int len = arr.length;
        int sum ;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                sum = 0;
                for(int k=i;k<=j;k++){
                    sum += arr[k];
                }
                if(sum>max)
                    max = sum;
            }
        }
        return max;
    }

    public int maxSubArray2(int[] arr){
        if(arr==null||arr.length==0)
            return Integer.MIN_VALUE;
        int len = arr.length;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            int sum = 0;
            for(int j=i;j<len;j++){
                sum += arr[j];
                if(sum>max)
                    max = sum;
            }
        }
        return max;
    }

    public int maxSubArray3(int[] arr){
        if(arr==null||arr.length==0)
            return Integer.MIN_VALUE;
        int len = arr.length;
        int all[] = new int[len];
        int end[] = new int[len];
        all[0] = end[0] = arr[0];
        for(int i=1;i<len;i++){
            end[i] = Math.max(arr[i],end[i-1]+arr[i]);
            all[i] = Math.max(end[i],all[i-1]);
        }
        return all[len-1];
    }

    public int maxSubArray4(int[] arr){
        if(arr==null||arr.length==0)
            return Integer.MIN_VALUE;
        int len = arr.length;
        int all = arr[0];
        int end = arr[0];
        for(int i=1;i<len;i++){
            end = Math.max(end+arr[i],arr[i]);
            all = Math.max(all,end);
        }
        return all;
    }
    /**
     * 确定最大子数组位置
     * end[i] = Math.max(arr[i],end[i-1]+arr[i])，当end[i-1]<0，end[i]=arr[i]
     * */
    public int maxSubArray(int[] arr,int begin[],int end[]){
        if(arr==null||arr.length==0)
            return Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0;
        for(int i=0;i<arr.length;i++){
            if(sum<0){
                sum = arr[i];
                start = i;
            }else
                sum += arr[i];
            if(sum>max){
                max = sum;
                begin[0] = start;
                end[0] = i;
            }
        }
        return max;
    }
    public static void main(String[] args){
        getMaxSubArray m = new getMaxSubArray();
        int[] arr = {-1,-1,-1,-1,1};
        int[] arr1 = {1,-2,4,8,-4,7,-1,5};
        int[] arr2 = null;
        System.out.println(m.maxSubArray1(arr));
        System.out.println(m.maxSubArray1(arr1));
        System.out.println(m.maxSubArray1(arr2));

        System.out.println(m.maxSubArray2(arr));
        System.out.println(m.maxSubArray2(arr1));
        System.out.println(m.maxSubArray2(arr2));

        System.out.println(m.maxSubArray3(arr));
        System.out.println(m.maxSubArray3(arr1));
        System.out.println(m.maxSubArray3(arr2));

        System.out.println(m.maxSubArray4(arr));
        System.out.println(m.maxSubArray4(arr1));
        System.out.println(m.maxSubArray4(arr2));

        int begin[] = {0};
        int end[] = {0};
        System.out.println(m.maxSubArray(arr,begin,end));
        System.out.println(begin[0]+" "+end[0]);
        begin[0] = 0;
        end[0] = 0;
        System.out.println(m.maxSubArray(arr1,begin,end));
        System.out.println(begin[0]+" "+end[0]);
        begin[0] = 0;
        end[0] = 0;
        System.out.println(m.maxSubArray(arr2,begin,end));
        System.out.println(begin[0]+" "+end[0]);
    }
}
