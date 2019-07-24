public class Queue<E> {
    /*
    * 链表实现
    * */
    private Node<E> head = null;
    private Node<E> tail = null;
    /**
     * 判空
     * */
    public boolean isEmpty(){
        return head == null;
    }
    /**
     * push
     * */
    public void push(E data){
        Node<E> newNode = new Node<>(data);
        if(isEmpty()){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
    }
    /**
     * pop
     * */
    public E pop(){
        if(isEmpty())
            return null;
        E data = head.data;
        head = head.next;
        return data;
    }
    /**
     * peek
     * */
    public E peek(){
        if(isEmpty())
            return null;
        E data = head.data;
        return data;
    }
    /**
     * size
     * */
    public int size(){
        Node<E> tmp = head;
        int size = 0;
        while(tmp!=null){
            size++;
            tmp = tmp.next;
        }
        return size;
    }

    public static void main(String[] args){
        Queue<Integer> q = new Queue<>();
        q.push(1);
        q.push(1);
        q.push(2);
        q.push(3);
        System.out.println("队列长： "+q.size());
        System.out.println("队首元素： "+q.pop());
        System.out.println("队首元素： "+q.pop());
        System.out.println("队首元素： "+q.peek());
        System.out.println("队首元素： "+q.pop());
        System.out.println("队空？ "+q.isEmpty());
        System.out.println("队首元素： "+q.pop());
        System.out.println("队空？ "+q.isEmpty());
        q.push(4);
        System.out.println("队空？ "+q.isEmpty());
    }
}
