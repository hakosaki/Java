import java.util.Hashtable;
import java.util.Stack;

public class MyLinkedList<E> {
    Node<E> head = null;
    /**
    * 给链表插入数据
    * */
    public void addNode(E data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node tmp = head;
        while(tmp.next!=null){
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }
    /**
    * 删除数据指定下标数据
    * */
    public boolean deleteNode(int index){
        if(index < 0 || index > length()-1){
            return false;
        }
        if(index == 0){
            head = head.next;
            return true;
        }
        int i = 1;
        Node pre = head;
        Node cur = head.next;
        while(cur!=null){
            if(i==index){
                pre.next = cur.next;
                return true;
            }
            pre = pre.next;
            cur = cur.next;
            i++;
        }
        return true;
    }
    /**
    * 不知道头指针的情况下删除指定节点
    * */
    public boolean deleteNode(Node n){
        if(n==null||n.next==null)
            return false;
        Object tmp = n.data;
        n.data = n.next.data;
        n.next.data = tmp;
        n.next = n.next.next;
        return true;
    }
    /**
    * 链表长
    * */
    public int length(){
        int length = 0;
        Node tmp = head;
        while(tmp!=null){
            length++;
            tmp = tmp.next;
        }
        return length;
    }

    /**
     * 链表排序
     * 冒个泡
     */
    public Node orderList(){
        if(head == null)
            return null;
        int tmp;
        Node nextNode;
        Node currNode = head;
        while(currNode.next!=null){
            nextNode = currNode.next;
            while(nextNode!=null){
                if((int)currNode.data>(int)nextNode.data) {
                    tmp = (int)currNode.data;
                    currNode.data = nextNode.data;
                    nextNode.data = tmp;
                }
                nextNode = nextNode.next;
            }
            currNode = currNode.next;
        }
        return head;
    }
    /**
     * 打印链表
     * */
    public void printList(){
        Node curr = head;
        while(curr!=null){
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
    /**
     * 删除链表重复数据
     * HashTable
     * */
    public void deleteDuplicate1(){
        Hashtable<E,Integer> table = new Hashtable<>();
        Node<E> pre = null;
        Node<E> tmp = head;
        while(tmp!=null){
            if(table.containsKey(tmp.data)){
                pre.next = tmp.next;
            }else{
                table.put(tmp.data,1);
                pre = tmp;
            }
            tmp = tmp.next;
        }
    }
    /**
     *  删除链表重复数据
     *  双重循环遍历
     * */
    public void deleteDuplicate2(){
        Node curr = head;
        while(curr != null){
            Node tmp = curr;
            while(tmp.next!=null){
                if(curr.data == tmp.next.data){
                    tmp.next = tmp.next.next;
                }else{
                    tmp = tmp.next;
                }
            }
            curr = curr.next;
        }
    }
    /**
     * 找出单链的第k个倒数元素
     * */
    public Node findLastK(int k){
        if(head == null||length()==0||k<1||k>length())
            return null;
        Node first = head;
        Node second = head;
        for(int i=0;i<k-1;i++){
            first = first.next;
        }
        while(first!=null){
            first = first.next;
            second = second.next;
        }
        return second;
    }
    /**
     * 链表反转
     * 递归
     * */
    public Node reverseList1(){
        if(head.next == null||head == null)
            return head;
        head = reverseInteratively(head);
        return head;
    }
    private Node reverseInteratively(Node head){
        if(head.next == null)
            return head;
        Node reverseHead = reverseInteratively(head.next);
        head.next.next = head;
        head.next = null;
        return reverseHead;
    }
    /**
     * 链表反转
     * 非递归
     * */
    public Node reverseList2(){
        if(head.next == null||head == null)
            return head;
        head = reverseInteratively(head);
        return head;
    }
    private Node reverse(Node head){
        if(head.next == null||head == null)
            return head;
        Node reverseHead = null;
        Node next = null;
        Node curr = head;
        while(curr!=null){
            next = curr.next;
            curr.next = reverseHead;
            reverseHead = curr;
            curr = next;
        }
        return reverseHead;
    }
    /**
     * 反转输出
     * 递归
     * */
    public void reversePrint1(){
        if(head == null)
            return;
        reversePrintInteratively(head);
    }
    private Node reversePrintInteratively(Node head){
        if(head == null)
            return null;
        reversePrintInteratively(head.next);
        System.out.println(head.data);
        return head;
    }/**
     * 反转输出
     * Stack
     * */
    public void reversePrint2(){
        if(head == null)
            return;
        reversePrintStack(head);
    }
    private void reversePrintStack(Node head){
        if(head == null)
            return;
        Stack<E> stack = new Stack<>();
        Node<E> curr = head;
        while(curr!=null){
            stack.push(curr.data);
            curr = curr.next;
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
        return;
    }
    /**
    * 链表中间节点
    * */
    public Node searchMid(){
        Node first = head;
        Node second = head;
        while(first!=null && first.next!=null && first.next.next!=null){
            first = first.next.next;
            second = second.next;
        }
        return second;
    }
    /**
     * 检测一个链表是否有环
     * */
    public boolean isLoop(){
        Node fast = head;
        Node slow = head;
        if(fast == null)
            return false;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                return true;
        }
        return !(fast == null || slow == null);
    }
    /**
     * 找到环的入口
     * */
    public Node findLoopPort(){
        Node slow = head;
        Node fast = head;
        while(fast!=null || fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                break;
        }
        if(fast == null||fast.next == null)
            return null;
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    /**
     * 判断两个链表是否相交
     * */
    public boolean isIntersect(Node h1,Node h2){
        if(h1==null||h2==null)
            return false;
        Node tail1 = h1;
        while(tail1.next!=null){
            tail1 = tail1.next;
        }Node tail2 = h2;
        while(tail2.next!=null){
            tail2 = tail2.next;
        }
        return tail1 == tail2;
    }
    /**
     * 找到第一个相交的节点
     * */
    public Node getFirstMeetNode(Node h1,Node h2){
        if(h1 == null||h2 == null)
            return null;
        Node tail1 = h1;
        int len1 = 1;
        while(tail1.next!=null){
            tail1 = tail1.next;
            len1++;
        }
        Node tail2 = h2;
        int len2 = 1;
        while(tail2.next!=null){
            tail2 = tail2.next;
            len2++;
        }
        if(tail1!=tail2)
            return  null;
        tail1 = h1;
        tail2 = h2;
        if(len1>len2){
            int d = len1-len2;
            while(d!=0){
                tail1 = tail1.next;
                d--;
            }
        }else{
            int d = len2-len1;
            while(d!=0){
                tail2 = tail2.next;
                d--;
            }
        }
        while(tail1 != tail2){
            tail1 = tail1.next;
            tail2 = tail2.next;
        }
        return tail1;
    }
    public static void main(String[] args){
        MyLinkedList<Integer> list = new MyLinkedList();
        list.addNode(0);
        list.addNode(5);
        list.addNode(3);
        list.addNode(1);
        list.addNode(3);
        list.addNode(2);
        list.deleteNode(0);
        list.deleteDuplicate2();
        System.out.println("listLen = "+list.length());
        System.out.println("before order:");
        list.printList();
        list.orderList();
        System.out.println("after order:");
        list.printList();
        System.out.println("after reverse:");
        list.reverseList1();
        list.printList();
        System.out.println("after reverse:");
        list.reverseList2();
        list.printList();
        System.out.println("reverse print:");
        list.reversePrint1();
        System.out.println("reverse print:");
        list.reversePrint2();
        System.out.println("list's middle Node: = "+list.searchMid().data);
    }
}
