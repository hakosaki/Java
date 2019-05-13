public class findSecondMax {
    /**
     * 求数组第二大数
     *
     * 1.排序后找
     * O(nlogn)
     *
     * 2.两变量分别存数组最大、第二大，遍历一遍即可
     * O(n)
     * */
    public int SecondMax(int[] arr) {
        if(arr==null||arr.length==0)
            return Integer.MIN_VALUE;
        int max = arr[0];
        int sec = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                sec = max;
                max = arr[i];
            } else if (arr[i] > sec)
                sec = arr[i];
        }
        return sec;
    }
    public static void main(String[] args){
        findSecondMax s = new findSecondMax();
        int[] arr = {7,3,19,40,4,7,1};
        System.out.println(s.SecondMax(arr));
    }
}
