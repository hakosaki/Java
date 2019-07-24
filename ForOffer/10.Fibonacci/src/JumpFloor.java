public class JumpFloor {
    public int JumpFloor(int target){
        if(target<1)
            return 0;
        if(target==1||target==2)
            return target;
        int tmp;
        int pre = 1;
        int res = 2;
        for(int i=3;i<=target;i++){
            tmp = res;
            res += pre;
            pre = tmp;
        }
        return res;
    }
}
