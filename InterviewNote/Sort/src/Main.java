import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        int arr[] ={5,4,9,8,7,6,0,3,3,2};
        /*System.out.println("选择排序前： "+Arrays.toString(arr));
        selectSort.selectSort(arr);
        System.out.println("选择排序后： "+Arrays.toString(arr));*/

        /*System.out.println("插入排序前： "+Arrays.toString(arr));
        insertSort.insertSort(arr);
        System.out.println("插入排序后： "+Arrays.toString(arr));*/

        /*System.out.println("冒泡排序前： "+Arrays.toString(arr));
        bubbleSort.bubbleSort(arr);
        System.out.println("冒泡排序后： "+Arrays.toString(arr));*/

        /*System.out.println("归并排序前： "+Arrays.toString(arr));
        mergeSort.mergeSort(arr);
        System.out.println("归并排序后： "+Arrays.toString(arr));*/

        System.out.println("快速排序前： "+Arrays.toString(arr));
        quickSort.quickSort(arr);
        System.out.println("快速排序后： "+Arrays.toString(arr));

        /*System.out.println("希尔排序前： "+Arrays.toString(arr));
        shellSort.shellSort(arr);
        System.out.println("希尔排序后： "+Arrays.toString(arr));*/

        /*System.out.println("堆排序前： "+Arrays.toString(arr));
        heapSort.heapSort(arr);
        System.out.println("堆排序后： "+Arrays.toString(arr));*/

    }
}
