public class findOnce {
    /**
     * 找出数组中只出现一次的数字
     * 1.只对其他数出现偶数次有用
     *
     * 2.奇偶都能用
     * */
    public int findOnce1(int[] arr){
        if(arr==null||arr.length==0)
            return Integer.MIN_VALUE;
        int res = arr[0];
        for(int i=1;i<arr.length;i++){
//            异或所有数组，偶数对异或为0
            res ^= arr[i];
        }
        return res;
    }

    public int findOnce2(int[] arr,int times) {
        int[] bitCount = new int[32];
//        计算数组对应二进制数上各位置1出现次数
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 32; j++) {
                bitCount[j] += ((arr[i] >> j) & 1);
            }
        }
        int appearOne = 0;
//        若某位上不能被整除，目标该位上是1
        for(int i = 0;i<32;i++){
            if(bitCount[i]%times != 0)
                appearOne +=(1<<i);
        }
        return appearOne;
    }
}
