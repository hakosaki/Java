public class Stack<E> {
    private MyQueue<E> q1 = new MyQueue<>();
    private MyQueue<E> q2 = new MyQueue<>();
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
        q1.push(data);
    }
    /**
     * peek
     * */
    public E peek(){
        if(q1.size()==1){
            return q1.pop();
        }else {
            while (q1.size() != 1) {
                q2.push(q1.pop());
            }
            E data = q1.peek();
            q2.push(q1.pop());
            while (!q2.isEmpty()) {
                q1.push(q2.pop());
            }
            return data;
        }
    }
    /**
     * pop
     * */
    public E pop(){
        if(q1.size()==1){
            return q1.pop();
        }else {
            while (q1.size() != 1) {
                q2.push(q1.pop());
            }
            E data = q1.pop();
            while (!q2.isEmpty()) {
                q1.push(q2.pop());
            }
            return data;
        }
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
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
//        s.push(4);
        System.out.println("栈顶元素： "+s.peek());
        System.out.println("栈顶元素： "+s.pop());
        System.out.println("栈顶元素： "+s.peek());
        System.out.println("栈顶元素： "+s.pop());
    }
}
