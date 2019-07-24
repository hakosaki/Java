public class power2N {
    /**
     * m乘以2的n次方
     */
    public static int power2N(int m,int n){
        for(int i=0;i<n;i++){
            m = m<<1;
        }
        return m;
    }
}
