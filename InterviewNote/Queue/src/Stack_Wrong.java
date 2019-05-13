public class Stack_Wrong<E> {
    public MyQueue<E> q1 = new MyQueue<>();
    public MyQueue<E> q2 = new MyQueue<>();
//    private LinkedBlockingQueue<E> q1 = new LinkedBlockingQueue<>();
//    private LinkedBlockingQueue<E> q2 = new LinkedBlockingQueue<>();
    /**
     * isEmpty
     * */
    public boolean isEmpty(){
        return q1.isEmpty()&&q2.isEmpty();
    }
    /**
     * push
     * */
    public void push(E data){
        if(!q2.isEmpty()){
            q2.push(data);
        }else{
            q1.push(data);
        }
    }
    /**
     * peek
     * */
    /*
     * 错误在于循环内i++，同时size()也是自动递减的
     * 导致只计算了一半
     * */
    public E peek(){
        E data;
        if(!q1.isEmpty()){
            for(int i=0;i<q1.size()-1;){
//            while(q1.size()!=1){
//                System.out.println(q1.size());
                data = q1.pop();
//                System.out.println(q1.size());
//                System.out.println(data);
                q2.push(data);
            }
            data = q1.pop();
//            System.out.println(data);
            q2.push(data);
        }else if(!q2.isEmpty()){
            for(int i=0;i<q2.size()-1;){
//            while(q1.size()!=1){
                q1.push(q2.pop());
            }
            data = q2.pop();
            q1.push(data);
        }else{
            return null;
        }
        return data;
    }
    /**
     * pop
     * */
    public E pop(){
        E data;
        if(!q1.isEmpty()){
            int len =q1.size();
            for(int i=0;i<q1.size()-1;){
//            while(q1.size()!=1){
                q2.push(q1.pop());
            }
            data = q1.pop();
        }else if(!q2.isEmpty()){
            for(int i=0;i<q2.size()-1;){
//            while(q2.size()!=1){
                q1.push(q2.pop());
            }
            data = q2.pop();
        }else{
            return null;
        }
        return data;
    }
    /**
     * size
     * */
    public int size(){
        if(!q1.isEmpty()){
            return q1.size();
        }else if(!q2.isEmpty()){
            return q2.size();
        }else{
            return 0;
        }
    }

    public static void main(String[] args){
        Stack_Wrong<Integer> s = new Stack_Wrong<>();
        s.push(1);
        s.push(2);
//        s.push(3);
        s.push(4);
        System.out.println(s.q1.isEmpty());
        System.out.println(s.q2.isEmpty());
        System.out.println("栈顶元素： "+s.peek());
        System.out.println("栈顶元素： "+s.pop());
        System.out.println(s.q1.isEmpty());
        System.out.println(s.q2.isEmpty());
        System.out.println("栈顶元素： "+s.peek());
        System.out.println("栈顶元素： "+s.pop());
        System.out.println("栈顶元素： "+s.peek());
        System.out.println("栈顶元素： "+s.pop());
        System.out.println("栈顶元素： "+s.peek());
        System.out.println("栈顶元素： "+s.pop());
    }
}
