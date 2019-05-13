import java.util.Arrays;

public class MyStack<E> {
    private Object[] stack;
    public int size = 0;
    public MyStack(){
        stack = new Object[10];
    }
    /**
     * 判空
     * */
    public boolean isEmpty(){
        return size==0;
    }
    /**
     * peek
     * */
    public E peek(){
        if(isEmpty())
            return null;
        return (E)stack[size-1];
    }
    /**
     * pop
     * */
    public E pop(){
        E e = peek();
        if(!isEmpty()) {
            stack[size - 1] = null;
            size--;
        }
        return e;
    }
    /**
     * push
     * */
    public E push(E data){
        ensureCapacity(size+1);
        stack[size++] = data;
        return data;
    }
    /**
     * 判断数组是否已满，满则扩充数组空间
     * */
    private void ensureCapacity(int size){
        int len = stack.length;
        if(size > len){
            int newLen = 10;
            stack = Arrays.copyOf(stack,newLen);
        }
    }

    public static void main(String[] args){
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        System.out.println("栈中元素个数： "+stack.size);
        System.out.println("栈顶元素： "+stack.pop());
        System.out.println("栈顶元素： "+stack.pop());
    }
}
