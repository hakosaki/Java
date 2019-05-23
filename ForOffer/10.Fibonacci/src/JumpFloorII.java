public class JumpFloorII {
    /**
     * 青蛙一次可以跳1~n级，青蛙跳上n级台阶有多少种跳法？
     * f(n)=2^(n=1)
     * */
    public int JumpFloorII(int target) {
        if(target<1)
            return 0;
        return (int)Math.pow(2,target-1);
    }
}
