import sun.security.util.Length;
/*
 * duplication可以通过数组传参
 * 内存占用9000+k
 * */
public class Duplicate2 {
    public int[] duplication = new int[1];
    public int[] number;
    public int length;
    public Duplicate2(int[] number){
        this.number = number;
        this.length = number.length;
    }
    /*
     * 3.数组中重复的数字
     * 长为n，所有数字0~n-1，找出任一个重复数字
     * */
    //    Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < length; i++){
            sb.append(numbers[i] + "");
        }
        for(int j = 0; j < length; j++){
            if(sb.indexOf(numbers[j]+"") != sb.lastIndexOf(numbers[j]+"")){
                duplication[0] = numbers[j];
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] num1 = {1,3,5,4,1,2};
        int[] num2 = {1,0};
        int[] num3 = null;
        int[] num4 = {2};
        Duplicate1 m = new Duplicate1(num4);
        System.out.println(m.duplicate(m.number,m.length,m.duplication) );
        System.out.println(m.duplication[0]);
    }
}
