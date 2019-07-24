import java.util.Stack;

public class twoStackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    /**
     * isEmpty
     * */
    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }
    /**
     * push
     * */
    public void push(int node){
        stack1.push(node);
    }
    public int pop(){
        if(isEmpty())
            return -1;
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return  stack2.pop();
    }
}
