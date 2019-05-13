import java.util.ArrayList;

public class getIntersection {
    /**
     * 两个有序数组的交集
     * */
    public ArrayList<Integer> getIntersection(int[] arr1,int[] arr2){
        if(arr1==null||arr1.length<=0||arr2==null||arr2.length<=0)
            return null;
        ArrayList<Integer> res = new ArrayList<>();
        int len1 = arr1.length;
        int len2 = arr2.length;
        int i=0;
        int j=0;
        while(i<len1 && j <len2){
            if(arr1[i]==arr2[j]){
                res.add(arr1[i]);
                i++;
                j++;
            }else if(arr1[i]>arr2[j]){
                j++;
            }else{
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args){
        getIntersection g = new getIntersection();
        int[] arr1 = {0,1,2,3,4};
        int[] arr2 = {1,3,5,7,9};
        System.out.println(g.getIntersection(arr1,arr2).toString());
    }
}
