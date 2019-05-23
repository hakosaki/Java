import java.util.Stack;

public class linkedList {
    public Node head = null;
    public linkedList(){}
    /**
     * add
     * */
    public void add(int data){
        Node newNode = new Node(data);
        /*
        * if(head==null)记得返回！！！！
        * */
        if(head==null) {
            head = newNode;
            return;
        }
        Node tmp = head;
        while(tmp.next!=null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
        return;
    }
    /**
     * print
     * */
    public void print(){
        Node tmp = head;
        if(tmp==null)
            return;
        while(tmp!=null){
            System.out.print(tmp.data+" ");
            tmp = tmp.next;
        }
        System.out.println();
    }
    public void print(Node head){
        Node tmp = head;
        if(tmp==null)
            return;
        while(tmp!=null){
            System.out.print(tmp.data+" ");
            tmp = tmp.next;
        }
        System.out.println();
    }
    /**
     * delete the last Node
     * */
    public boolean deleteTail(){
        if(head==null)
            return false;
        /*
        * 判断只有头节点情况
        * */
        if(head.next==null){
            head = null;
            return true;
        }
        /*
        * 双指针
        * */
        Node pre = head;
        Node cur = head.next;
        while(cur.next!=null){
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null;
        return true;
    }
    /**
     * delete Node quickly
     * */
    public boolean deleteNode(Node head){
        if(head==null)
            return false;
        /*
         * 节点是尾节点情况
         * */
        if(head.next==null){
            return false;
        }
        /*
        * 快速删除，不能直接将头节点向后移动
        * */
       /* Node tmp = head;
        head = head.next;
        tmp = null;
        return true;*/
       int tmp = head.data;
       head.data = head.next.data;
       head.next.data = tmp;
       head.next = head.next.next;
       return true;
    }
    /**
     * delete data
     * */
    public boolean delete(int data){
        if(head==null)
            return false;
        /*
        * 判断要删除节点是头节点情况
        * */
        if(head.data == data){
            head = head.next;
            return true;
        }
        /*
        * 双指针找节点
        * */
        Node pre = head;
        Node cur = head.next;
        while(cur!=null){
            if(cur.data==data) {
                pre.next = cur.next;
                return true;
            }
            pre = pre.next;
            cur = cur.next;
        }
        return false;
    }
    /**
     * reverse print
     * */
    /*
    * recursion
    * */
    public void reversePrint1(){
        if(head==null)
            return;
        reversePrint1(head);
        System.out.println();
    }
    private void reversePrint1(Node head){
        if(head==null)
            return;
        reversePrint1(head.next);
        System.out.print(head.data+" ");
    }
    /*
    * stack
    * */
    public void reversePrint2(){
        if(head==null)
            return;
        Node cur = head;
        Stack<Integer> stack = new Stack<>();
        while(cur!=null){
            stack.push(cur.data);
            cur = cur.next;
        }
        while(stack.size()!=0){
            System.out.print(stack.pop()+" ");
        }
        System.out.println();
    }
    /**
     * reverse list
     * */
    /*
    * recursion
    * */
    public void reverseList1(){
        if(head==null||head.next==null)
            return;
        head = reverseList1(head);
    }
    private Node reverseList1(Node head){
        if(head.next==null)
            return head;
        Node reverseHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return reverseHead;
    }
    /*
    * not recursion
    * */
    public void reverseList2(){
        if(head==null||head.next==null)
            return;
        head = reverseList2(head);
    }
    private Node reverseList2(Node head){
        if(head==null||head.next==null)
            return head;
        Node reverseHead = null;
        Node cur = head;
        Node tmp = null;
        while(cur!=null){
            tmp = cur.next;
            cur.next = reverseHead;
            reverseHead = cur;
            cur = tmp;
        }
        return reverseHead;
    }
    public static void main(String[] args){
        linkedList l = new linkedList();
        int[] arr = {1,2,3,4,5,6,7,8};
        for(int i=0;i<arr.length;i++)
            l.add(arr[i]);
        l.print();
        l.deleteTail();
        l.print();
        l.delete(4);
        l.print();
        l.deleteNode(l.head.next.next);
        l.print();
        l.reversePrint1();
        l.reversePrint2();
        l.reverseList1();
        l.print();
        l.reverseList2();
        l.print();
    }
}
