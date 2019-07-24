public class countOne {
    /*
    * O(n)
    * */
    public static int countOne1(int n){
        int count = 0;
        while(n>0){
            if((n&1)==1)
                count++;
            n>>=1;
        }
        return count;
    }
    /*
    * 利用n&(n-1),每次结果少一位1，而且都是最后一位1
    * O(m),m为二进制中1的个数，m<=n
    * */
    public static int countOne2(int n){
        int count = 0;
        while(n>0){
            if(n!=0){
                n = n&(n-1);
                count++;
            }
        }
        return count;
    }
}
