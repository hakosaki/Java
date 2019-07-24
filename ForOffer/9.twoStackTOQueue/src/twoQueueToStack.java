import java.util.concurrent.LinkedBlockingQueue;

public class twoQueueToStack {
    LinkedBlockingQueue<Integer> q1 = new LinkedBlockingQueue();
    LinkedBlockingQueue<Integer> q2 = new LinkedBlockingQueue();
    public boolean isEmpty(){
        return q1.isEmpty()&&q2.isEmpty();
    }
    public void push(int data){
        if(!q2.isEmpty())
            q2.add(data);
        else
            q1.add(data);
    }
    public int pop(){
        if(isEmpty())
            return Integer.MIN_VALUE;
        if(!q1.isEmpty()){
            while(q1.size()>1){
                q2.add(q1.poll());
            }
            return q1.poll();
        }else{
            while(q2.size()>1){
                q1.add(q2.poll());
            }
            return q2.poll();
        }
    }

    public static void main(String[] args){
        twoQueueToStack t = new twoQueueToStack();
        t.push(1);
        t.push(2);
        t.push(3);
        t.push(4);
        t.push(5);
        System.out.println(t.pop());
        System.out.println(t.pop());
        System.out.println(t.pop());
        System.out.println(t.pop());
        System.out.println(t.pop());
        System.out.println(t.pop());
    }
}
