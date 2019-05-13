import sun.security.util.Length;
/*
* duplication输出有错 没能够正常传送duplication
* */
public class Duplicate {
    public int duplication;
    public int[] number;
    public int length;
    public Duplicate(int[] number){
        this.number = number;
        this.length = number.length;
    }
    /*
    * 3.数组中重复的数字
    * 长为n，所有数字0~n-1，找出任一个重复数字
    * */
     boolean duplicate(int[] number,int length,int duplication ){
//       判断空数组！！！！！！！！！！！！！（忘记判空）
        if(number == null||length <= 1){
            return  false;
        }
        for(int i = 0; i < length; i++){
//      要判断比较的不是自己！！！！！！！！（忘记加while）
            while(number[i] != i) {
                if (number[i] == number[number[i]]) {
                    duplication = number[i];
//                    System.out.println(duplication);
                    return true;
                } else if (number[i] > length || number[i] < 0) {
                    System.out.println("测试用例超出范围！");
                    return false;
                } else {
//      number[i]现在可以用temp代替！！！！
                    /*
                    * int temp = number[i];
                    * number[i] = number[number[i]];
                    * number[number[i]] = temp
                    * */
                    int temp = number[i];
                    number[i] = number[temp];
                    number[temp] = temp;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] num1 = {1,3,5,4,1,2};
        int[] num2 = {1,0};
        int[] num3 = null;
        int[] num4 = {2};
        Duplicate m = new Duplicate(num1);
        System.out.println(m.duplicate(m.number,m.length,m.duplication) );
        System.out.println(m.duplication);
    }
}
