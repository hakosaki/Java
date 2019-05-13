/*
* n+1数组里所有数字都在1~n，所以至少有一个重复的数字，但不能修改数组
* */
public class GetDuplication {
    int getDupication(final int[] numbers, int length){
        if(numbers == null || length <= 0){
            return -1;
        }
        for(int i = 0; i < length; i++){
            if(numbers[i] > length - 1 || numbers[i] < 1)
                return -2;
        }
        int front = 1;
        int rear = length - 1;
        while (rear >= front) {                                         //此处应该是rear >= front
            int middle = ((rear - front)>>1) + front;                   //
            //int middle = (rear - front)>>1 + front;                   // >> 优先级 低于 +
            //System.out.println(middle);
            int count = countRange(numbers, length, front, middle);
            //int count = countRange(numbers, length, front, middle);   // (numbers, rear, front, middle) XXXX
            if(rear == front){                                          //忘记判断rear == front了
                if(count > 1)
                    return front;                                       //返回的是front, 不是numbers[front]
                else
                    break;
            }
            if(count > (middle - front + 1)){                          //count > middle XXXX
                rear = middle;
            } else {
                front = middle + 1;
            }
        }
        return -3;
    }

    int countRange(final int[] numbers, int length, int front, int middle){
        if(numbers == null){
            return 0;
        }
        int temp = 0;
        for(int i = 0; i < length; i++){
            if(numbers[i] >= front && numbers[i] <= middle){
                ++temp;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] num1 = {1,3,5,4,1,2};
        int[] num2 = {1,0};
        int[] num3 = null;
        int[] num4 = {2};
        GetDuplication g = new GetDuplication();
        int m = g.getDupication(num2, num2.length);
        System.out.println(m);
    }
}
/*
* 若不申请 GetDuplication g = new GetDuplication();则函数getDupication没有初始化，无法调用final
*/