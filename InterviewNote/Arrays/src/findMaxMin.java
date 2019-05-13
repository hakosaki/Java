public class findMaxMin {
    /**
     * 求数组最大、最小数
     *
     * 1.问题分解法，分别求最大、最小即可
     * 遍历2次，比较2n
     *
     * 2.取单元素法，维持两个变量max，min，每次取一个数分别与max、min比较
     * 遍历1次，比较2n
     *
     * 3.取双元素法，维持两个变量max，min，每次取两个数大与max比较、小与min比较
     * 遍历1次，比较1.5n
     *
     * 4.数组元素移位法，将数组相邻两个数分在一组，每次比较两个数，大放左边，小放右边，分别扫描大组、小组
     * 遍历2次，比较1.5n~2n，改变数组结构
     *
     * 5.分治法，数组分两半，分别找出两边最大、最小，取两边最大、最小
     * 递归，比较1.5n
     * */
    int max;
    int min;
    public void findMaxMin(int arr[]){
        if(arr==null||arr.length==0)
            return;
        max = arr[0];
        min = arr[0];
        int i;
        for(i=1;i<arr.length-1;i+=2){
            if(arr[i]>arr[i+1]){
                if(arr[i]>max)
                    max = arr[i];
                if(arr[i+1]<min)
                    min = arr[i+1];
            }
            if(arr[i]<arr[i+1]){
                if(arr[i+1]>max)
                    max = arr[i+1];
                if(arr[i]<min)
                    min = arr[i];
            }
        }
        if(i==arr.length-1){
            if(arr[i]>max)
                max = arr[i];
            if(arr[i]<min)
                min = arr[i];
        }
    }

    public static void main(String[] args){
        int[] arr = {1,2,3};
        findMaxMin main = new findMaxMin();
        main.findMaxMin(arr);
        System.out.println(main.max);
        System.out.println(main.min);
    }
}
