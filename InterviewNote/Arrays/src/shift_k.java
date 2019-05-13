import java.util.Arrays;

public class shift_k {
    /**
     * 数组循环右移k
     * 逆序前，逆序后，逆序全部
     * O(n)
     * */
    public String shift_k(int[] arr,int k){
        if(arr==null||arr.length==0||k<1)
            return arr.toString();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            if(i<arr.length-k){
                sb1.append(arr[i]);
            }else{
                sb2.append(arr[i]);
            }
        }
        sb1.reverse();
        sb2.reverse();
        sb.append(sb1);
        sb.append(sb2);
        sb.reverse();
        return sb.toString();
    }
    public static void main(String[] args){
        shift_k s = new shift_k();
        int[] arr = {1,2,3,4,5,6,7,8};
        String sb = s.shift_k(arr,2);
        System.out.println(sb);
    }
}
