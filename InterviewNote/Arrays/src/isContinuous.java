public class isContinuous {
    /**
     * 0~65535，除0外不会重复出现，判断数组是否连续
     * 5位的话，没有0，最大-最小==4，有0，最大-最小<4
     * */
    public boolean isContinuous(int[] arr){
        if(arr==null||arr.length<=0)
            return false;
        int len = arr.length;
        int min = -1;
        int max = -1;
//        不能使用arr[0]，因为arr[0]可能是0
        for(int i=0;i<len;i++){
            if(arr[i]!=0) {
                if (arr[i] < min||min==-1)
                    min = arr[i];
                if (arr[i] > max||max==-1)
                    max = arr[i];
            }
        }
        if(max-min>len-1)
            return false;
        else
            return true;
    }
    public static void main(String[] args){
        isContinuous i = new isContinuous();
        int arr[] = {0,7,0,3,6};
        System.out.println(i.isContinuous(arr));
    }
}
