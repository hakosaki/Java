import java.util.Scanner;

public class countReverse {
    /**
     * 通过反转逆序对，减少冒泡排序交换次数，最少的冒泡交换次数
     *
     * 输入 n,k,int[] arr
     * n个数，反转k次
     * 3 2
     * 2 3 1
     *
     * 输出
     * 1（反转2 3 1两次后冒泡还要交换一次）
     *
     * dp[i][j],0~i数组通过反转能减少的逆序对数量
     * 1.不旋转当前char（i），dp[i-1][j]
     * 2.旋转当前，循环旋转以i结尾每一位，countReverseBefore(arr,t-1,i-1)-countReverseAfter(arr,t-1,i-1)+dp[t-1][j-1]
     *                                    t到i的逆序对 - 反转后逆序对，（即加i能减少逆序对）+ t以前能减少的逆序对数
     * */
    public int countReverse(int n,int k,int[] arr){
        if(n<2||n>50||k<1||k>50)
            return -1;
        if(arr==null)
            return 0;
        int[][] dp = new int[n+1][k+1];
        for(int i=2;i<=n;i++){
            for(int j=1;j<=k;j++){
                int tmp = Integer.MIN_VALUE;
                for(int t=i-1;t>=1;t--){
                    tmp = Math.max(countReverseBefore(arr,t-1,i-1)-countReverseAfter(arr,t-1,i-1)+dp[t-1][j-1],tmp);
                    dp[i][j] = Math.max(tmp,dp[i-1][j]);
                }
            }
        }
        return countReverseBefore(arr,0,n-1)-dp[n][k];
    }
/**
 * 111ms
 * 11120k
 * */
/*    private int countReverseBefore(int[] arr, int begin, int end) {
        int count = 0;
        for (int i = begin; i <= end; i++) {
            for (int j = i+1; j <= end; j++) {
                if (arr[j] < arr[i])
                    count++;
            }
        }
        return count;
    }

    private int countReverseAfter(int[] arr, int begin, int end) {
        int count = 0;
        for (int i = end; i >= begin; i--) {
            for (int j = i-1; j >=begin; j--) {
                if (arr[j] < arr[i]) count++;
            }
        }
        return count;
    }*/
/**
 * 230ms
 * 26072k
 * */
    private int countReverseBefore(int[] arr,int begin,int end){
        int count[] = {0};
        int n = end - begin + 1;
        int[] copy = new int[n];
        int[] tmp = new int[n];
        for(int i=0;i<n;i++){
            tmp[i] = arr[begin+i];
        }
        mergeSort(tmp,copy,0,n-1,count);
        return count[0];
    }
    private void mergeSort(int[] arr,int[] copy,int begin,int end,int[] count){
        if(begin<end){
            int mid = (begin+end)>>1;
            mergeSort(arr,copy,begin,mid,count);
            mergeSort(arr,copy,mid+1,end,count);
            mergeSort(arr,copy,begin,mid,end,count);
        }
    }
    private void mergeSort(int[] arr,int[] copy,int begin,int mid,int end,int[] count){
        int i=begin,j=mid+1,k=begin;
        while(i<=mid && j<=end){
            if(arr[i]>arr[j]){
                copy[k++] = arr[j++];
                count[0] += mid-i+1;
            }else{
                copy[k++] = arr[i++];
            }
        }
        while(i<=mid){
            copy[k++] = arr[i++];
        }
        while(j<=end){
            copy[k++] = arr[j++];
        }
        for(i=begin;i<k;i++)
            arr[i] = copy[i];
    }
    private int countReverseAfter(int[] arr,int begin,int end){
        int count[] = {0};
        int n = end-begin+1;
        int[] tmp = new int[n];
        int[] copy = new int[n];
        for(int i=0;i<n;i++){
            tmp[i] = arr[end-i];
        }
        mergeSort(tmp,copy,0,n-1,count);
        return count[0];
    }
    public static void main(String[] args){
        countReverse c = new countReverse();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        String[] s = scanner.nextLine().split(" ");
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(s[i]);
        /*int n = 7;
        int k = 2;
        int[] arr = {7,2,2,13,5,5,2};*/
        System.out.println(c.countReverse(n,k,arr));
    }
}
