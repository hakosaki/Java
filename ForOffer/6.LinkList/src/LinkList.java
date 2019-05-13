import sun.plugin.javascript.navig.Link;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Stack;

public class LinkList {
    private ListNode head;
    private ListNode tail;
    /*
    * 链表末加节点
    * */
    public void add(Integer data){
        if(this.head == null){
            head = new ListNode(data);
            tail = head;
        } else {
           this.tail.next = new ListNode(data);
           this.tail = tail.next;
        }
    }
    /*
    *  删除一个节点
    *  O(n)时间复杂度
    * */
    /*public void remove(ListNode head, Object value){
        if(head == null)
            return;
        ListNode curr = head;
        if(head.val == value){
            head = head.next;
        } else {
            while(curr.next != null){
                if(curr.next.val == value){
                    curr.next = curr.next.next;
                } else {
                    curr = curr.next;
                }
            }
        }
        return;
    }*/
    /*
    * 删除一个节点，不过要确保pDelete在pListHead中
    * O(1)时间复杂度
    * 时间复杂度：[(n-1)XO(1)+O(n)]/n, 还是O(1)
    * */
   /* public ListNode deleteNode(ListNode pListHead, ListNode pDelete) {
        if(pListHead == null || pDelete == null)
            return pListHead;
        if(pListHead == pDelete){
            pListHead = pListHead.next;                             //链表只有一个节点， pListHead = null;
        } else if(pDelete.next == null){
            ListNode curr = pListHead;
            while(curr.next != pDelete){
                curr = curr.next;
            }
            curr.next = pDelete.next;                               //要删除的点是尾节点，curr.next = null;
        } else {                                                    //要删除的不是尾节点
            pDelete.val = pDelete.next.val;
            pDelete.next = pDelete.next.next;
        }
        return pListHead;
    }*/
    public ListNode deleteNode(ListNode pListHead, ListNode pDelete) {
        if(pListHead == null || pDelete == null)
            return pListHead;
        if(pListHead == pDelete){
            pListHead = null;
        } else if(pDelete.next == null){
            ListNode curr = pListHead;
            while(curr.next != pDelete){
                curr = curr.next;
            }
            curr.next = null;
        } else {
            ListNode next = pDelete.next;
            pDelete.val = next.val;
            pDelete.next = next.next;
        }
        return pListHead;
    }
    /*
     * 直接翻转链表
     */
    public ArrayList<Integer> reversePrint1(ListNode listNode){
        ArrayList<Integer> alist = new ArrayList<>();
        ListNode reverseHead = null;
        ListNode curr = listNode;
        ListNode temp = null;
        while(curr != null){
            temp = curr.next;
            curr.next = reverseHead;
            reverseHead = curr;
            curr = temp;
        }
        while(reverseHead != null){
            alist.add(reverseHead.val);
            reverseHead = reverseHead.next;
        }
        return alist;
    }
    /*
    * 栈翻转
    * */
/*    public void reversePrint2(Node head){
        if(head == null || head.next == null)                       //加判空出错，需改成若为空返回新表
            return;
        Stack<Node> stack = new Stack<Node>();
        Node curr = head;                                           //不需要
        while(curr != null){
            stack.push(curr);
            curr = curr.next;
        }
        while(!stack.empty()){
            System.out.println(stack.pop().data);                   //不要忘记加.data
        }
        return;
    }*/
    public ArrayList<Integer> reversePrint2(ListNode listNode) {
        Stack<Integer> stack = new Stack<Integer>();
        while(listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> alist = new  ArrayList<Integer>();
        while(!stack.empty()){
            alist.add(stack.pop());
        }
        return alist;
    }
    /*
    * Recursion递归翻转
    * */
   /* public  ArrayList<Integer> reversePrint3(ListNode listNode){
        ArrayList<Integer> alist = new ArrayList<>();
        if (listNode != null){
            if (listNode.next != null){
                reversePrint3(listNode.next);
            }
            alist.add(listNode.val);
        }
        return alist;
    }*/
    public ArrayList<Integer> reversePrint3(ListNode listNode) {
        ArrayList<Integer> alist = new ArrayList<>();
        if (listNode != null){
            if (listNode.next != null){
                alist = reversePrint3(listNode.next);               //不要忘记加alist =
            }
            alist.add(listNode.val);
        }
        return alist;
    }
    /*
    * 找到倒数k个节点
    * 注意代码鲁棒性
    * */
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k <= 0)                                  //鲁棒性，指针不空，k!=0 否则k-1溢出
            return null;
        ListNode pFirst = head;
        ListNode pSecond = head;
        for(int i=0;i <k-1;++i){
           if(pFirst.next != null){                                 //判断总节点是否少于k，小于k return null;
               pFirst = pFirst.next;
           } else {
               return  null;
           }
        }
        while(pFirst.next != null){
            pFirst = pFirst.next;
            pSecond = pSecond.next;
        }
        return  pSecond;
    }
    /*
    * 反转链表
    * 注意代码鲁棒性
    * */
    public ListNode ReverseList(ListNode head) {
        if(head == null)                                            //判空指针
            return null;
        ListNode temp = null;
        ListNode reverseHead = null;
        ListNode curr = head;
        if(curr.next == null)                                       //鲁棒性，考虑只有一个节点情况
            return head;
        while(curr != null){
            temp = curr.next;
            curr.next = reverseHead;
            reverseHead = curr;
            curr = temp;
        }
        return reverseHead;
    }
    /*
    * 合并两个排序链表
    * 非递归
    * */
    public ListNode Merge1(ListNode list1,ListNode list2) {
        if(list1 == null){                                          //判空
            return list2;
        } else if(list2 == null){
            return list1;
        }
        ListNode newHead = null;
        if(list1.val < list2.val){                                  //判头
            newHead = list1;
            list1 = list1.next;
        } else {
            newHead = list2;
            list2 = list2.next;
        }
        ListNode curr = newHead;
        while (list1 != null && list2 != null){                     //依次赋值
            if(list1.val < list2.val){
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if(list1 == null) {                                          //剩余副职
            curr.next = list2;
        }else if(list2 == null){
            curr.next = list1;
        }
        return newHead;
    }
    /*
     * 合并两个排序链表
     * 递归
     * */
    public ListNode Merge2(ListNode list1,ListNode list2) {
        if (list1 == null)
            return list2;
        else if (list2 == null)
            return list1;
        ListNode newHead = null;
        if (list1.val < list2.val) {
            newHead = list1;
            newHead.next = Merge2(list1.next, list2);
        } else {
            newHead = list2;
            newHead.next = Merge2(list1, list2.next);
        }
        return newHead;
    }
    /*
    * 两个链表的第一个公共节点
    * 双重遍历O（mn）
    * 用栈O(m+n)时间复杂，额外空间栈
    * */
/*
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null)
            return null;
        if(pHead1 == pHead2)                                        //判断两个链表是同一个
            return pHead1;
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (pHead1 != null){
            ListNode push = stack1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while(pHead2 != null){
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }
        ListNode common = null;
        while (stack1.peek()==stack2.peek()){                       //不知道为啥，可能是溢出了
            common = stack1.peek();
            stack1.pop();
            stack2.pop();
        }
        return  common;
    }
*/
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null)
            return null;
        if(pHead1 == pHead2)
            return pHead1;
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (pHead1 != null){
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while(pHead2 != null){
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }
        ListNode common = null;
        while (stack1.size() > 0 && stack2.size() > 0) {
            if(stack1.peek()==stack2.peek()) {
                common = stack1.peek();
                stack1.pop();
                stack2.pop();
            } else {
                break;
            }
        }
        return  common;
    }
    /*
    * 双指针
    * 时间复杂度O(m+n)，空间不需要辅助栈
    * */
    public int getListLength(ListNode head){
        ListNode curr = head;
        if(curr == null)
            return 0;
        int count = 0;
        while(curr != null){
            ++count;
            curr = curr.next;
        }
        return  count;
    }
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null)
            return null;
        int length1 = getListLength(pHead1);
        int length2 = getListLength(pHead2);
        int lengthDif = 0;
        ListNode longHead = null;
        ListNode shortHead = null;
        if(length1 > length2){
            longHead = pHead1;
            shortHead = pHead2;
            lengthDif = length1 - length2;
        } else {
            longHead = pHead2;
            shortHead = pHead1;
            lengthDif = length2 - length1;
        }
        for(int i=0;i<lengthDif;++i){
            longHead = longHead.next;
        }
        while(longHead != null && shortHead != null && longHead != shortHead){
            longHead = longHead.next;
            shortHead = shortHead.next;
        }
        return longHead;
    }
    public static void main(String[] args) {
        LinkList list1 = new LinkList();
        LinkList list2 = new LinkList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list2.add(6);
        list2.add(7);
        list2.add(8);
        ListNode commonNode =list1.FindFirstCommonNode1(list1.head,list2.head);
        System.out.println(commonNode);
    }
}
