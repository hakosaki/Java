import java.lang.reflect.Array;
import java.util.Arrays;

public class ageSort {
    public void ageSort(int[] arr,int n){
        if(arr==null||n<=0)
            return;
        int age[] = new int[100];
        for(int i=0;i<n;i++){
            if(arr[i]<0||arr[i]>99)
                return;
            age[arr[i]]++;
        }
        int pos = 0;
        for(int i=0;i<100;i++){
            for(int j=0;j<age[i];j++){
                arr[pos++] = i;
            }
        }
    }
    public static void main(String[] args){
        ageSort a = new ageSort();
        int[] arr = {21,22,23,25,28,29,27,24,26};
        System.out.println(Arrays.toString(arr));
        a.ageSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
