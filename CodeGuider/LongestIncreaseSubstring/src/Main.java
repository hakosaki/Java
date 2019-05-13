import java.util.Arrays;

public class Main {
/*
* 给定数组arr，返回arr的最长递增子序列
* arr=[2,1,5,3,6,4,8,9,7]，返回[1,3,4,8,9]
* */
    /*
     * 1.生成N的dp，dp[i]表示以arr[i]结尾，arr[0...i]中最长递增子序列
     * 2.第一个数arr[0]，dp[0]=1，从左到右依次计算出每个位置的数结尾情况，最长递增子序列长度
     * 3.以arr[i]结尾，那么arr[0...i-1]中所有比arr[i]小的数都可以作为倒数第二个数，选最长的做倒数第二个数
     * dp[i]=max{dp[j]+1(0<=j<i,arr[j]<arr[i])}
     * 4.若都不比dp[i]小，令dp[i]=1,说明以dp[i]结尾最长子序列只含dp[i]
     *
     * O(N^2)
     * */
    private int[] getdp1(int[] arr){
        int[] dp = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return dp;
    }
/*；
* 解释dp数组得到最长递增子序列
* arr[2,1,5,3,6,4,8,9,7]，dp[1,1,2,2,3,3,4,5,4]
* */
    /*
    * 1.遍历dp，找最大值及位置
    * 2.从最大值位置向左遍历，若arr[i]<arr[7]，又有arr[i]==arr[7]-1,说明arr[i]可做序列第二个数
    * 3.依次找，直到找到所有数
    * */
    private int[] generateLIS(int[] arr,int[] dp){
        int len = 0;
        int index = 0;
//        遍历查找最长序列长和下标
        for(int i=0;i<dp.length;i++){
            if(dp[i]>len){
                len = dp[i];
                index = i;
            }
        }
//        依次查找序列元素
        int[] lis = new int[len];
        lis[--len] = arr[index];
        for(int i=index;i>=0;i--){
            if(arr[i]<arr[index] && dp[i] == dp[index]-1){
                lis[--len] = arr[i];
                index = i;
            }
        }
        return lis;
    }
    public int[] lis1(int[] arr){
        if(arr == null||arr.length==0)
            return null;
        int[] dp = getdp1(arr);
        return generateLIS(arr,dp);
    }

    /*
    * 利用二分查找来优化dp数组的生成
    * ends[0...right]为有效区，有效位置上b，若有ends[b]==c，表示遍历到目前为止，所有b+1递增序列中，最小的结尾是c
    *
    * 遍历到arr[0]==2,ends[0]=2,dp[0]=1,ends[0]=2
    * 遍历到arr[1]==1,ends[0...0]=2,dp[1]=1,ends[0]=1;
    * 遍历到arr[2]==5,ends[0...0]=5,dp[2]=2,ends[0...1]=[1,5]
    * 遍历到arr[3]==3,ends[0...1]=[1,5],dp[3]=2,ends[0...1]=[1,3]
    *
    * O(NlogN)
    * */
    private int[] getdp2(int[] arr){
        int[] dp = new int[arr.length];
        int[] ends = new int[arr.length];
        ends[0] = arr[0];
        dp[0] = 1;
        int right = 0;

        int l = 0;
        int r = 0;
        int m = 0;

//        二分查找
        for(int i=1;i<arr.length;i++){
            l = 0;
            r = right;
            while(l <= r){
                m =(l + r)/2;
                if(arr[i] > ends[m]){
                    l = m + 1;
                }else{
                    r = m - 1;
                }
            }
            right = Math.max(right,l);
            ends[l] = arr[i];
            dp[i] = l + 1;
        }
        return dp;
    }

    public int[] lis2(int[] arr){
        if(arr == null||arr.length == 0){
            return null;
        }
        int[] dp = getdp2(arr);
        return generateLIS(arr,dp);
    }

    /*
     * 给定数组arr，返回arr的最长递减子序列
     * arr=[2,1,5,3,6,4,8,9,7]，返回[2,1]
     * */
    /*
     * 递减
     *
     * O(N^2)
     * */
    private int[] getdp3(int[] arr){
        int[] dp = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(arr[i]<arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return dp;
    }
    /*
     * 解释dp数组得到最长递减子序列
     * arr[2,1,5,3,6,4,8,9,7]，dp[1,2,1,2,1,2,1,1,2]
     * */
    /*
     * 1.遍历dp，找最大值及位置
     * 2.从最大值位置向左遍历，若arr[i]>arr[7]，又有arr[i]==arr[7]-1,说明arr[i]可做序列第二个数
     * 3.依次找，直到找到所有数
     * */
    private int[] generateLDS(int[] arr,int[] dp){
        int len = 0;
        int index = 0;
//        遍历查找最长序列长和下标
        for(int i=0;i<dp.length;i++){
            if(dp[i]>len){
                len = dp[i];
                index = i;
            }
        }
//        依次查找序列元素
        int[] lis = new int[len];
        lis[--len] = arr[index];
        for(int i=index;i>=0;i--){
            if(arr[i]>arr[index] && dp[i] == dp[index]-1){
                lis[--len] = arr[i];
                index = i;
            }
        }
        return lis;
    }
    public int[] lis3(int[] arr){
        if(arr == null||arr.length==0)
            return null;
        int[] dp = getdp3(arr);
        return generateLDS(arr,dp);
    }

    /*
     * 利用二分查找来优化dp数组的生成
     * ends[0...right]为有效区，有效位置上b，若有ends[b]==c，表示遍历到目前为止，所有b+1递增序列中，最小的结尾是c
     *
     * 遍历到arr[0]==2,ends[0]=2,dp[0]=1,ends[0]=2
     * 遍历到arr[1]==1,ends[0...0]=2,dp[1]=1,ends[0]=1;
     * 遍历到arr[2]==5,ends[0...0]=5,dp[2]=2,ends[0...1]=[1,5]
     * 遍历到arr[3]==3,ends[0...1]=[1,5],dp[3]=2,ends[0...1]=[1,3]
     *
     * O(NlogN)
     * */
    private int[] getdp4(int[] arr){
        int[] dp = new int[arr.length];
        int[] ends = new int[arr.length];
        ends[0] = arr[0];
        dp[0] = 1;
        int right = 0;

        int l = 0;
        int r = 0;
        int m = 0;

//        二分查找
        for(int i=1;i<arr.length;i++){
            l = 0;
            r = right;
            while(l <= r){
                m =(l + r)/2;
                if(arr[i] < ends[m]){
                    l = m + 1;
                }else{
                    r = m - 1;
                }
            }
            right = Math.max(right,l);
            ends[l] = arr[i];
            dp[i] = l + 1;
        }
        return dp;
    }

    public int[] lis4(int[] arr){
        if(arr == null||arr.length == 0){
            return null;
        }
        int[] dp = getdp4(arr);
        return generateLDS(arr,dp);
    }
    public static void main(String[] args) {
        Main main = new Main();
//        int[] arr = {2,1,5,3,6,4,8,9,7,10};
        int[] arr = {9,8,7,6,5,4,3};
        int[] result1 = main.lis1(arr);
        int[] result2 = main.lis2(arr);
        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
        int[] result3 = main.lis3(arr);
        int[] result4 = main.lis4(arr);
        System.out.println(Arrays.toString(result3));
        System.out.println(Arrays.toString(result4));
    }
}
