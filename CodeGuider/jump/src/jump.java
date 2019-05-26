public class jump {
    /**
     * 跳跃游戏，arr[i]表示能向前跳跃arr[i]步，求到末尾的最少步数
     *
     * cur>=i 说明能到i 什么也不做
     * cur<i jump不能到i，需要多跳一步， jump++,cur = next
     * 更新next,表示能够到达最远的位置 Math.max(next,arr[i]+i)
     * */
    public int jump(int[] arr){
        if(arr==null||arr.length==0)
            return 0;
        int jump = 0,cur = 0,next = 0;
        for(int i=0;i<arr.length;i++){
            if(cur<i){
                jump++;
                cur = next;
            }
            next = Math.max(next,i+arr[i]);
        }
        return jump;
    }
    public static void main(String[] args){
        jump j = new jump();
        int[] arr ={3,2,3,1,1,4};
        System.out.println(j.jump(arr));
    }
}
