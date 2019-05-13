public class isPower {
    /*
    * O(logn)
    * */
    public static boolean isPower1(int n){
        if(n<1)
            return false;
        int i = 1;
        while(i<=n){
            if(i==n)
                return true;
            i<<=1;
        }
        return false;
    }

    public static boolean isPower2(int n){
        /*
        * 2的n次方的数和自身减一的数与，结果为0
        * O(1)
        * */
        if(n<1) return false;
        int m = n&(n-1);
        return m==0;
    }
}
