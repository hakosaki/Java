public class balloonGrade {
    /**
     * 给一排有分数气球，打爆一个分数为L*I*R，求分数最高
     *
     * 1.暴力递归
     * l==r，只有一个气球直接打爆，arr[l-1]*arr[l]*arr[r+1]
     * 用help，help[0]=help[n+1]=1，防止边界溢出
     * 三种情况：
     * 最后打爆l,arr[l-1]*arr[l]*arr[r+1]+process(arr,l+1,r)
     * 最后打爆r,arr[l-1]*arr[r]*arr[r+1]+process(arr,l.r-1)
     * 中间最后打爆，遍历中间每个，arr[l-1]*arr[i]+arr[r+1]+process(arr,l,i-1)+process(arr,i+1,r);
     *
     * 2.dp O(n^3)
     * help赋值
     * 初始化l==r,即dp[i][i]
     * 双重循环 l=n-1;l>=1;l--
     *          r=l+1;r<=n;r++
     * 三种情况：
     * 最后打爆l,help[l-1]*help[l]*help[r+1]+dp[l+1][r]
     * 最后打爆r,help[l-1]*help[r]*help[r+1]+dp[l][r-1]
     * 中间最后打爆，遍历中间每个，help[l-1]*help[i]+help[r+1]+dp[l][i-1]+dp[i+1][r]
     * */
    /*
    * 递归
    * */
    public int maxGrade1(int[] arr){
        if(arr==null||arr.length==0)
            return 0;
        if(arr.length==1)
            return arr[0];
        int len = arr.length;
        int[] help = new int[len+2];
        help[0] = 1;
        help[len+1] = 1;
        for(int i=0;i<len;i++)
            help[i+1] = arr[i];
        return process(help,1,len);
    }
    private int process(int[] arr,int l,int r){
        if(l==r)
            return arr[l-1]*arr[l]*arr[r+1];
        int max = Math.max(
                arr[l-1]*arr[l]*arr[r+1]+process(arr,l+1,r),
                arr[l-1]*arr[r]*arr[r+1]+process(arr,l,r-1)
        );
        for(int i=l+1;i<r;i++){
            max = Math.max(
                    max,
                    arr[l-1]*arr[i]*arr[r+1]+process(arr,l,i-1)+process(arr,i+1,r)
            );
        }
        return max;
    }
    /*
    * 书上dp
    * */
    public int maxGrade2(int[] arr){
        if(arr==null||arr.length==0)
            return 0;
        if(arr.length==1)
            return arr[0];
        int len = arr.length;
        int[] help = new int[len+2];
        help[0] = 1;
        help[len+1] = 1;
        int i;
        for(i=0;i<len;i++)
            help[i+1] = arr[i];
        int dp[][] = new int[len+2][len+2];
        //因为递归返回条件r==l，所以dp[i][i]为动态初始条件
        for(i=1;i<=len;i++)
            dp[i][i] = help[i-1]*help[i]*help[i+1];
        for(int l=len;l>=1;l--){
            for(int r=l+1;r<=len;r++){
                int lmax = help[l-1]*help[l]*help[r+1]+dp[l+1][r];
                int rmax = help[l-1]*help[r]*help[r+1]+dp[l][r-1];
                dp[l][r] = Math.max(lmax,rmax);
                for(i=l+1;i<len;i++)
                    dp[l][r] = Math.max(
                            dp[l][r],
                            help[l-1]*help[i]*help[r+1]+dp[l][i-1]+dp[i+1][r]
                    );
            }
        }
        return dp[1][len];
    }
    /*
    * dp双重循环第一层可改为l=n-1
    * */
    public int maxGrade3(int[] arr){
        if(arr==null||arr.length==0)
            return 0;
        if(arr.length==1)
            return arr[0];
        int len = arr.length;
        int[] help = new int[len+2];
        help[0] = 1;
        help[len+1] = 1;
        int i;
        for(i=0;i<len;i++)
            help[i+1] = arr[i];
        int dp[][] = new int[len+2][len+2];
        //因为递归返回条件r==l，所以dp[i][i]为动态初始条件
        for(i=1;i<=len;i++)
            dp[i][i] = help[i-1]*help[i]*help[i+1];
        for(int l=len-1;l>=1;l--){
            for(int r=l+1;r<=len;r++){
                int lmax = help[l-1]*help[l]*help[r+1]+dp[l+1][r];
                int rmax = help[l-1]*help[r]*help[r+1]+dp[l][r-1];
                dp[l][r] = Math.max(lmax,rmax);
                for(i=l+1;i<len;i++)
                    dp[l][r] = Math.max(
                            dp[l][r],
                            help[l-1]*help[i]*help[r+1]+dp[l][i-1]+dp[i+1][r]
                    );
            }
        }
        return dp[1][len];
    }
    public static void main(String[] args){
        balloonGrade b = new balloonGrade();
        int[] arr = {3,2,5};
        System.out.println(b.maxGrade1(arr));
        System.out.println(b.maxGrade2(arr));
        System.out.println(b.maxGrade3(arr));
    }
}
