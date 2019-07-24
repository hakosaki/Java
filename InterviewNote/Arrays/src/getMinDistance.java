public class getMinDistance {
    /**
     * 求数组两个元素的最小距离
     * */
    public int minDistance(int[] arr,int c1,int c2){
        if(arr==null||arr.length<=1)
            return Integer.MIN_VALUE;
        int pos1 = -1;
        int pos2 = -1;
        int dis = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==c1){
                pos1 = i;
                if(pos2>=0)
                    dis = Math.min(dis,pos1-pos2);

            }
            if(arr[i]==c2){
                pos2 = i;
                if(pos1>=0)
                    dis = Math.min(dis,pos2-pos1);
            }
        }
        return dis;
    }

    public static void main(String[] args){
        getMinDistance m = new getMinDistance();
        int[] arr = {4,5,6,4,7,4,6,4,7,8,5,6,4,3,10,8};
        System.out.println(m.minDistance(arr,10,5));
    }
}
