public class Stack<E> {
    Node<E> top = null;
    /**
     * 判空
     * */
    public boolean isEmpty(){
        return top == null;
    }
    /**
     * push
     * */
    public void push(E data){
        Node<E> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
    }
    /**
     * pop
     * */
    public E pop(){
        if(isEmpty())
            return null;
        E data = top.data;
        top = top.next;
        return data;
    }
    /**
     * peek
     * */
    public E peek(){
        if (isEmpty())
            return null;
        return top.data;
    }
}
