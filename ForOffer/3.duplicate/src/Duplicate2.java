public class Duplicate2 {
    public int duplicate2(int[] numbers,int length){
        if(numbers==null||length<=0)
            return -1;
        int l = 1;
        int r = length-1;
        while(l<=r){
            int m = (l+r)>>1;
            int count = countRange(numbers,length,l,m);
            if(l==r){
                if(count>1)
                    return l;
                else
                    break;
            }
            if(count>(m-l+1))
                r = m;
            else
                l = m+1;
        }
        return -1;
    }

    private int countRange(int[] numbers,int length,int start,int end){
        int count = 0;
        for(int i=0;i<length;i++){
            if(numbers[i]>=start && numbers[i]<=end)
                count++;
        }
        return count;
    }

    public static void main(String[] args){
        Duplicate2 d = new Duplicate2();
        int[] arr = {2,3,5,4,3,2,6,7};
        System.out.println(d.duplicate2(arr,arr.length));
    }
}
