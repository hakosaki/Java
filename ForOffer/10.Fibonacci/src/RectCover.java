public class RectCover {
    public int RectCover(int target) {
        if(target<1)
            return 0;
        if(target==1||target==2)
            return target;
        int tmp;
        int res = 2;
        int pre = 1;
        for(int i=3;i<=target;i++){
            tmp = res;
            res += pre;
            pre = tmp;
        }
        return res;
    }
}
