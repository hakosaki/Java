import java.sql.Array;
import java.util.Arrays;

public class Main {
    /*
     * 斐波那契数列
     * O(2^n)
     * */
    public int f1(int n){
        if(n < 1)
            return 0;
        if(n == 1||n == 2)
            return 1;
        return f1(n-1) + f1(n-2);
    }
    /*
     * O(n)
     * */
    public int f2(int n){
        if(n < 1)
            return 0;
        if(n == 1||n == 2)
            return 1;
        int res = 1;
        int pre = 1;
        int tmp = 0;
        for(int i=3;i<=n;i++){
            tmp = res;
            res = res + pre;
            pre = tmp;
        }
        return res;
    }
    /*
     * O(logN)
     * 转换为求二阶递推矩阵
     * 75=1001011   10^75=10^64*10^8*10^2*10  10-10^2-10^4…… 再把相应值累乘
     * 矩阵乘法同理
     * */
//  矩阵乘法
    public int[][] muliMatrix(int[][] m1,int[][] m2){
        int[][] res= new int[m1.length][m2[0].length];
        for(int i = 0;i < m1.length;i++){
            for(int j = 0;j < m2[0].length;j++){
                for(int k = 0;k < m2.length;k++){
                    res[i][j] += m1[i][k]*m2[k][j];
                }
            }
        }
        return res;
    }
    //  矩阵m的p次方
    public int[][] matrixPower(int[][] m,int p){
        int[][] res = new int[m.length][m[0].length];
//      先把res设为单位矩阵，相当于整数中1
        for(int i=0;i < res.length;i++){
            res[i][i] = 1;
        }
        int[][] tmp = m;
        for(;p!=0;p>>=1){
            if((p&1)!=0){
                res = muliMatrix(res,tmp);
            }
            tmp = muliMatrix(tmp,tmp);
        }
        return res;
    }
    //  矩阵乘法求斐波那契
    public int f3(int n){
        if(n < 1)
            return 0;
        if(n == 1||n == 2)
            return 1;
        int[][] base = {{1,1},{1,0}};
        int[][] res = matrixPower(base,n-2);
        return res[0][0] + res[1][0];
    }

    /*
     * 求台阶问题
     * O(2^n)
     * */
    public int s1(int n){
        if(n < 1)
            return 0;
        if(n == 1||n == 2)
            return n;
        return s1(n-1) + s1(n-2);
    }
    /*
     * O(n)
     * */
    public int s2(int n){
        if(n < 1)
            return 0;
        if(n == 1||n == 2)
            return n;
        int res = 2;
        int pre = 1;
        int tmp = 0;
        for(int i=3;i<=n;i++){
            tmp = res;
            res = res + pre;
            pre = tmp;
        }
        return res;
    }
    /*
     * (2,1) * base^(n-2) 不再是(1,1) * base^(n-2)
     * O(logN)
     * */
    public int s3(int n){
        if(n < 1)
            return 0;
        if(n == 1||n == 2)
            return n;
        int[][] base = {{1,1},{1,0}};
        int[][] res = matrixPower(base,n-2);
        return 2*res[0][0] + res[1][0];
    }

    /*
     * 母牛每年生1头小母牛，假设不会死。第一年有1只，第二年母牛开始生小母牛，每只小母牛3年后成熟又可以生小母牛。给定N，求N年后牛数量。
     * C(n)=C(n-1)+C(n-3)  c(1)==1,c(2)==2,c(3)==3
     * O(2^n)
     * */
    public int c1(int n){
        if(n < 1)
            return 0;
        if(n == 1||n == 2||n == 3)
            return n;
        return c1(n-1) + c1(n-3);
    }
    /*
     * O(n)
     * */
    public int c2(int n){
        if(n < 1)
            return 0;
        if(n == 1||n == 2||n ==3)
            return n;
        int res = 3;
        int pre = 2;
        int prepre = 1;
        int tmp = 0;
        for(int i=4;i<=n;i++){
            tmp = res;
            res = res + prepre;
            prepre = pre;
            pre = tmp;
        }
        return res;
    }
    /*
     * O(logN)
     * */
    public int c3(int n){
        if(n < 1)
            return 0;
        if(n == 1||n == 2||n ==3)
            return n;
        int[][] base = {{1,1,0},{0,0,1},{1,0,0}};
        int[][] res = matrixPower(base,n-3);
        return 3*res[0][0] + 2*res[1][0] +res[2][0];
//        return 3*res[0][0] + res[2][0];
    }
    public static void main(String[] args) {
        Main main = new Main();
        int test = 10;
        int[][] m = {{1,2}};
        int[][] n = {{1,1,1},{1,1,1}};
//        main.muliMatrix(m,n);
        System.out.println(main.c1(test));
        System.out.println(main.c2(test));
        System.out.println(main.c3(test));
    }

}
