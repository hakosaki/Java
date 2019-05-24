import java.util.*;
//二阶魔方
public class Main {
    /**
     * 魔方一面优美度上四个乘积，魔方总优美度为6面优美度和
     * 在操作不超过5次情况，求能达到的最大优美度
     *
     * 弃疗
     * */
    static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[24];
        for (int i = 0; i < 24; i++) {
            arr[i] = sc.nextInt();
        }
        dfs(0, arr);
        System.out.println(maxSum);
    }

    // 上面顺时针旋转一次
    public static void upshunlevel(int[] arr) {
        int tmp1 = arr[0];
        int tmp2 = arr[1];
        arr[0] = arr[10];
        arr[1] = arr[4];
        arr[4] = arr[18];
        arr[10] = arr[19];
        arr[18] = arr[15];
        arr[19] = arr[9];
        arr[15] = tmp2;
        arr[9] = tmp1;
        int tmp3 = arr[23];
        arr[23] = arr[22];
        arr[22] = arr[20];
        arr[20] = arr[21];
        arr[21] = tmp3;
    }

    // 上面逆时针旋转一次
    public static void upnilevel(int[] arr) {
        upshunlevel(arr);
        upshunlevel(arr);
        upshunlevel(arr);
    }

    // 左面顺时针旋转一次
    public static void leftshunlevel(int[] arr) {
        int tmp1 = arr[0];
        int tmp2 = arr[2];
        arr[0] = arr[6];
        arr[2] = arr[12];
        arr[6] = arr[16];
        arr[12] = arr[18];
        arr[16] = arr[20];
        arr[18] = arr[22];
        arr[20] = tmp1;
        arr[22] = tmp2;
        int tmp3 = arr[10];
        arr[10] = arr[4];
        arr[4] = arr[5];
        arr[5] = arr[11];
        arr[11] = tmp3;
    }

    // 左面逆时针旋转一次
    public static void leftnilevel(int[] arr) {
        leftshunlevel(arr);
        leftshunlevel(arr);
        leftshunlevel(arr);
    }

    // 后面顺时针旋转一次
    public static void backshunlevel(int[] arr) {
        int tmp1 = arr[22];
        int tmp2 = arr[23];
        arr[22] = arr[5];
        arr[23] = arr[4];
        arr[4] = arr[6];
        arr[5] = arr[7];
        arr[6] = arr[8];
        arr[7] = arr[9];
        arr[8] = tmp2;
        arr[9] = tmp1;
        int tmp3 = arr[1];
        arr[1] = arr[0];
        arr[0] = arr[2];
        arr[2] = arr[3];
        arr[3] = tmp3;
    }

    // 后面逆时针旋转一次
    public static void backnilevel(int[] arr) {
        backshunlevel(arr);
        backshunlevel(arr);
        backshunlevel(arr);
    }

    public static void getSum(int[] arr) {
        int sum = 0;
        sum += arr[0] * arr[1] * arr[2] * arr[3];
        sum += arr[4] * arr[5] * arr[10] * arr[11];
        sum += arr[6] * arr[7] * arr[12] * arr[13];
        sum += arr[8] * arr[9] * arr[14] * arr[15];
        sum += arr[16] * arr[17] * arr[18] * arr[19];
        sum += arr[20] * arr[21] * arr[22] * arr[23];
        if (maxSum < sum) {
            maxSum = sum;
        }
    }

    public static void dfs(int deep, int[] arr) {
        getSum(arr);
        if (deep == 5) {
            return;
        }
        upshunlevel(arr);
        dfs(deep + 1, arr);
        upnilevel(arr); // 先返回到上一层中
        upnilevel(arr);
        dfs(deep + 1, arr);
        upshunlevel(arr);
        leftshunlevel(arr);
        dfs(deep + 1, arr);
        leftnilevel(arr);
        leftnilevel(arr);
        dfs(deep + 1, arr);
        leftshunlevel(arr);
        backshunlevel(arr);
        dfs(deep + 1, arr);
        backnilevel(arr);
        backnilevel(arr);
        dfs(deep + 1, arr);
        backshunlevel(arr);
    }
}