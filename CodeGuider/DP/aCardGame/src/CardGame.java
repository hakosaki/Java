public class CardGame {
    /**
     * 一条整型数组，A,B每次拿纸牌，只能拿最左或最右，求赢家分数
     * 输入 1 2 100 4
     * 输出 101(A 1 100)(B 4 2)
     *
     * 输入 1 100 2
     * 输出 100(A 2 1)(B 100)
     *
     * 1.暴力递归
     * 求先手、后手最大值
     * 先手f 递归求arr[i]+s(arr,i+1,j) arr[j]+s(arr,i,j-1)最大值
     * 后手s 递归求f(arr,i+1,j) f(arr,i,j-1)最小值
     *
     * 2.dp
     * f[][] s[][]
     * f[j][j] = arr[j]
     * f[i][j] = Math.max(arr[i]+s[i+1][j],arr[j]+s[i][j-1])
     * s[i][j] = Math.min(f[i+1][j],f[i][j-1])
     * */
    public int win1(int[] arr){
        if(arr==null||arr.length==0)
            return 0;
        int n = arr.length-1;
        return Math.max(f(arr,0,n),s(arr,0,n));
    }
    private int f(int[] arr,int i,int j){
        if(i==j)
            return arr[i];
        return Math.max(arr[i]+s(arr,i+1,j),arr[j]+s(arr,i,j-1));
    }
    private int s(int[] arr,int i,int j){
        if(i==j)
            return 0;
        return Math.min(f(arr,i+1,j),f(arr,i,j-1));
    }

    public int win2(int[] arr){
        if(arr==null||arr.length==0)
            return 0;
        int n = arr.length;
        int[][] f = new int[n][n];
        int[][] s = new int[n][n];
        for(int j=0;j<n;j++){
            f[j][j] = arr[j];
            for(int i=j-1;i>=0;i--){
                f[i][j] = Math.max(arr[i]+s[i+1][j],arr[j]+s[i][j-1]);
                s[i][j] = Math.min(f[i+1][j],f[i][j-1]);
            }
        }
        return Math.max(f[0][n-1],s[0][n-1]);
    }
    public static void main(String[] args){
        CardGame c = new CardGame();
        int[] arr1 = {1,2,100,4};
        int[] arr2 = {1,100,2};
        System.out.println(c.win1(arr1));
        System.out.println(c.win2(arr1));
        System.out.println(c.win1(arr2));
        System.out.println(c.win2(arr2));
    }
}
