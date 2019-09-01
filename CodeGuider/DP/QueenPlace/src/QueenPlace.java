public class QueenPlace {
    /**
     * N*N棋盘上放N个皇后，同行、同列、同斜不能放两个queen
     *
     * 1.暴力递归
     * 用record记录每行的列放置的位置
     * 递归求j列是否可以放置，若可以放置则累加结果res
     *
     * 2.dp
     * upperLim：n的二进制，不变量
     * colLim：已放置二进制
     * leftDiaLim：由于左斜线影响，当前行不能放的位置
     * rightDiaLim：由于右斜线影响，当前行不能放的位置
     * pos 可选位置
     * mostRight 可选位置最右边
     * */
    public int queenPlace1(int n){
        if(n<1)
            return 0;
        int[] record = new int[n];
        return queenPlace1(0,record,n);
    }
    private int queenPlace1(int i,int[] record,int n){
        if(i==n)
            return 1;
        int res = 0;
        for(int j=0;j<n;j++){
            if(isValid(record,i,j)){
                record[i] = j;
                res += queenPlace1(i+1,record,n);
            }
        }
        return res;
    }
    private boolean isValid(int[] record,int i,int j){
        for(int k=0;k<i;k++){
            if(j==record[k]||Math.abs(record[k]-j)==Math.abs(i-k))
                return false;
        }
        return true;
    }

    public int queenPlace2(int n){
        if(n<1)
            return 0;
        int upperLim = n==32?-1:(1<<n)-1;
        return queenPlace2(upperLim,0,0,0);
    }
    private int queenPlace2(int upperLim,int colLim,int leftDiaLim,int rightDiaLim){
        if(upperLim==colLim)
            return 1;
        int pos = 0;
        int mostRight = 0;
        pos = upperLim & (~(colLim | leftDiaLim | rightDiaLim));
        int res = 0;
        while (pos!=0){
            mostRight = pos & (~pos +1);
            pos -= mostRight;
            res += queenPlace2(upperLim,colLim|mostRight,(leftDiaLim|mostRight)<<1,(rightDiaLim|mostRight)>>>1);
        }
        return res;
    }
    public static void main(String[] args){
        QueenPlace q = new QueenPlace();
        int n1 = 8;
        int n2 = 1;
        int n3 = 2;
        System.out.println(q.queenPlace1(n1));
        System.out.println(q.queenPlace2(n1));
        System.out.println(q.queenPlace1(n2));
        System.out.println(q.queenPlace2(n2));
        System.out.println(q.queenPlace1(n3));
        System.out.println(q.queenPlace2(n3));
    }
}
