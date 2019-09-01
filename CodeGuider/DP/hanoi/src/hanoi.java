public class hanoi {
    /**
     * 1.简单汉诺塔，把所有圆盘移到右边，最优轨迹
     * 2.给数组arr，求arr是最优轨迹的第几步
     *
     * 1.对于i，i递归把1~i-1移到中间，i移到右边，再把1~i-1从中间移到右边
     * 2.递归，对于i，如果在中间则结束，在左边求1~i-1状态，在右边求1~i-1状态+左移到中所有（2^i-1）
     * 2.非递归，res = 0；在中间退出，在左边不计数求i-1，在右边res计数求i-1
     * */
    public void hanoi(int n){
        if(n>0)
            hanoi(n,"left","mid","right");
    }
    private void hanoi(int n,String from,String mid,String to){
        if(n == 1)
            System.out.println("move from "+from+" to "+to);
        else{
            hanoi(n-1,from,to,mid);
            hanoi(1,from,mid,to);
            hanoi(n-1,mid,from,to);
        }
    }

    public int step1(int[] arr){
        if(arr==null||arr.length==0)
            return -1;
        return step1(arr,arr.length-1,1,2,3);
    }
    private int step1(int[] arr,int i,int from,int mid,int to){
        if(i==-1)
            return 0;
        if(arr[i]!=from&&arr[i]!=to)
            return -1;
        if(arr[i]==from)
            return step1(arr,i-1,from,to,mid);
        else{
            int rest = step1(arr,i-1,mid,from,to);
            if(rest == -1)
                return -1;
            return (1<<i)+rest;
        }
    }

    public int step2(int[] arr){
        if(arr==null||arr.length==0)
            return -1;
        int from = 1;
        int mid = 2;
        int to = 3;
        int i = arr.length-1;
        int res = 0;
        int tmp = 0;
        while(i>=0){
            if(arr[i]!=from && arr[i]!=to)
                return  -1;
            if(arr[i]==from){
                tmp = to;
                to = mid;
            }else{
                res +=1<<i;
                tmp = from;
                from = mid;
            }
            mid = tmp;
            i--;
        }
        return res;
    }

    public static void main(String[] args){
        hanoi h = new hanoi();
        h.hanoi(5);
    }
}
