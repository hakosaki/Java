public class Fibonacci {
    public int Fibonacci1(int n) {
        if(n<1)
            return 0;
        if(n==2||n==1)
            return 1;
        return Fibonacci1(n-1)+Fibonacci1(n-2);
    }
    public int Fibonacci2(int n){
        if(n<1)
            return 0;
        if(n==2||n==1)
            return 1;
        int tmp = 0;
        int pre = 1;
        int res = 1;
        for(int i=3;i<=n;i++){
            tmp = res;
            res += pre;
            pre = tmp;
        }
        return res;
    }
    public int Fibonacci3(int n) {
        if(n==2||n==1)
            return 1;
        int[][] base = {{1,1},{1,0}};
        int[][] res = matrixPower(base,n-2);
        return res[0][0]+res[1][0];
    }
    private int[][] matrixPower(int[][] base,int k){
        int n = base.length;
        int[][] res = new int[n][n];
        for(int i=0;i<n;i++)
            res[i][i] = 1;
        int[][] tmp = base;
        for(;k!=0;k>>=1){
            if((k&1)!=0){
                res = multiMatrix(res,tmp);
            }
            tmp = multiMatrix(tmp,tmp);
        }
        return res;
    }
    private int[][] multiMatrix(int[][] n,int[][] m){
        int row = n.length;
        int col = m[0].length;
        int[][] res = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                for(int k=0;k<m.length;k++){
                    res[i][j] += n[i][k]*m[k][j];
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        Fibonacci f = new Fibonacci();
        int n = 3;
        System.out.println(f.Fibonacci1(n));
        System.out.println(f.Fibonacci2(n));
        System.out.println(f.Fibonacci3(n));
    }
}
