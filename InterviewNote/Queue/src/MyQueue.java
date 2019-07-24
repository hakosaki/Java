import java.util.LinkedList;
/*
* 数组实现
* */
public class MyQueue<E> {
    private LinkedList<E> list = new LinkedList<>();
    private int size = 0;
    public synchronized void push(E data){
        list.add(data);
        size++;
    }
    public synchronized E peek(){
        return list.peek();
    }
    public synchronized E pop(){
        if(!list.isEmpty()){
            size--;
            return list.removeFirst();
        }
        return null;
    }
    public synchronized boolean isEmpty(){
        return list.isEmpty();
    }
    public synchronized int size(){
        return size;
    }
    public static void main(String[] args){
        MyQueue<Integer> s = new MyQueue<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println("栈长度 "+s.size());
        System.out.println("栈顶元素： "+s.pop());
        System.out.println("栈顶元素： "+s.pop());
        System.out.println("栈顶元素： "+s.peek());
        System.out.println("栈顶元素： "+s.pop());
        System.out.println("栈空？ "+s.isEmpty());
        System.out.println("栈顶元素： "+s.pop());
        System.out.println("栈空？ "+s.isEmpty());
    }
}
