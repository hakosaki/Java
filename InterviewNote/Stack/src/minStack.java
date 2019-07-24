public class minStack {
    MyStack<Integer> stack;
    MyStack<Integer> min;
    public minStack(){
        stack = new MyStack<>();
        min = new MyStack<>();
    }
    public void push(int data){
        stack.push(data);
        if(min.isEmpty()||min.peek()>=data)
            min.push(data);
    }
    public int pop(){
        if(!stack.isEmpty()){
            int topData = stack.pop();
            if(topData == min.peek())
                min.pop();
            return topData;
        }
        return -1;
    }
    public int min(){
        if(min.isEmpty())
            return Integer.MAX_VALUE;
        else
            return min.peek();
    }

    public static void main(String[] args){
        minStack stack = new minStack();
        stack.push(1);
        stack.push(1);
        stack.push(1);
        System.out.println(stack.stack.size);
        System.out.println(stack.min.size);
    }
}
