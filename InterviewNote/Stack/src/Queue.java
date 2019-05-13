public class Queue<E> {
    /**
     * stack模拟queue
     * */
    private Stack<E> s1 = new Stack<E>();
    private Stack<E> s2 = new Stack<E>();
    /**
     * push
     * */
    public synchronized void push(E e){
        s1.push(e);
    }
    /**
     * peek
     * */
    public synchronized  E peek(){
        if(s2.isEmpty())
            while(!s1.isEmpty())
                s2.push(s1.pop());
        return s2.peek();
    }
    /**
     * pop
     * */
    public synchronized E pop(){
        if(s2.isEmpty())
            while(!s1.isEmpty())
                s2.push(s1.pop());
        return s2.pop();
    }
    /**
     * 判空
     * */
    public synchronized boolean isEmpty(){
        return s1.isEmpty()&&s2.isEmpty();
    }

    public static void main(String[] args){
        Queue<Integer> q = new Queue<>();
        q.push(1);
        q.push(1);
        q.push(2);
        q.push(3);
        System.out.println("队列首元素 "+q.pop());
        System.out.println("队列首元素 "+q.pop());
        System.out.println("队列首元素 "+q.peek());
    }
}
