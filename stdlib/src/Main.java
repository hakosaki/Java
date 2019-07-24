import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    /*
     * 中文字符正则表达式
     * */
    public void judgeChineseCharactor(String str){
        String regEx="[\u4e00-\u9fa5]";
        if(str.getBytes().length==str.length()){
            System.out.println("无汉字");
        }else{
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(str);
            while(m.find()){
                System.out.print(m.group(0)+"");
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
        /*
        * 比较器
        * */
        /*
        * private final class CompareName implements Comparator<Milan> {
        boolean is_Ascend;

        public CompareName(boolean b) {
            // TODO Auto-generated constructor stub
            is_Ascend = b;
        }

        @Override
        public int compare(Milan o1, Milan o2) {
            // TODO Auto-generated method stub
            if (is_Ascend)
                return o1.p_Name.compareTo(o2.p_Name);
            else
                return o2.p_Name.compareTo(o1.p_Name);
        }
    }

    private final class CompareId implements Comparator<Milan> {
        boolean is_Ascend;

        public CompareId(boolean b) {
            // TODO Auto-generated constructor stub
            is_Ascend = b;
        }
        * */
        Comparator compare = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };


        /*
        * 链表
        * */
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        list1.add(1);list1.add(2);list1.add(3);
//        System.out.println(list1);
        Collections.sort(list1,compare);
//        System.out.println(list1);


        /*
        * 顺序表
        * */
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(1);list2.add(2);list2.add(3);
        Collections.sort(list2,compare);

        Vector<Integer> list3 = new Vector<Integer>();
        list3.add(1);list3.add(2);list3.add(3);
        Collections.sort(list3,compare);


        /*
        * Hashtable
        * */
//      <Key,Value>
        Hashtable<Integer,Integer> table1 = new Hashtable<>();
        table1.put(1,1);
        if(table1.containsKey(1));


        /*
        * HashMap
        * */
        HashMap<Integer,Integer> table2 = new HashMap<>();
        table2.put(1,1);
        if(table2.containsKey(1));


        /*
        * Stack
        * */
        Stack<Integer> stack = new Stack<>();
        stack.push(1);stack.push(2);stack.push(3);
//      System.out.println(stack);
//      System.out.println(stack);


        /*
        * Queue
        * */
        BlockingQueue queue1 = new ArrayBlockingQueue<Integer>(10);    //指定容量
        BlockingQueue queue2 = new LinkedBlockingQueue<Integer>();              //上限MAX_VALUE
        BlockingQueue queue3 = new PriorityBlockingQueue<Integer>();            //带优先级


        /*
        * String.Split（）使用正则表达式，而StringTokenizer的只是使用逐字分裂的字符。
        * 如果不用正则表达式（StringTokenizer也不能使用正则表达式），StringTokenizer在截取字符串中的效率最高。
        * StringTokenizer
        * */
        String str = "100|66,55:200|567,90:102|43,54";
        StringTokenizer strToke = new StringTokenizer(str, ":,|");// 默认不打印分隔符
        // StringTokenizer strToke=new StringTokenizer(str,":,|",true);//打印分隔符
        // StringTokenizer strToke=new StringTokenizer(str,":,|",false);//不打印分隔符
        while(strToke.hasMoreTokens()){
            System.out.println(strToke.nextToken());
        }

        /*
        * Collections——List、Queue、Stack、Set、Map
        * */
//        排序
        Collections.sort(stack,compare);
//        对集合进行随机排序
        Collections.shuffle(stack);
//        反转
        Collections.reverse(stack);
//        二分查找、需要先升序
        Collections.binarySearch(stack,2);
//        查找子串在集合中首次出现的位置
        List<String> list4 = Arrays.asList("Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday".split(","));
        List<String> subList = Arrays.asList("Friday,Saturday".split(","));
        int index3 = Collections.indexOfSubList(list4, subList);
        System.out.println(index3);
        int index4 = Collections.lastIndexOfSubList(list4, subList);
        System.out.println(index4);
//        替换
        boolean flag = Collections.replaceAll(list4, "Sunday", "tttttt");
//        集合中的元素向后移动k位置，后面的元素出现在集合开始的位置
        Collections.rotate(list4, 3);
//        复制并覆盖相应索引位置的元素
        List<String> list5 = Arrays.asList("copy1,copy2,copy3".split(","));
        Collections.copy(list4, list5);//5复制到4中
//        为集合生成一个Enumeration
        List<String> list6 = Arrays.asList("I love my country!".split(" "));
        Enumeration<String> e = Collections.enumeration(list6);
//        最大最小值
        Collections.max(stack);
        Collections.min(stack);
//        数组转成集合List
        List<Integer> list = new ArrayList<Integer>();
        Integer[] arr={12,2,45,46,76,23,45,65};
        Collections.addAll(list,arr);

//        将现有的List集合转换为线程安全的
        list=Collections.synchronizedList(list);
        System.out.println(list);
//        将现有的Set集合转换为线程安全的
        Set<String> set=new HashSet<String>();
        set=Collections.synchronizedSet(set);
//        将现有的Map集合转换为线程安全的
        Map<String, Integer> map=new HashMap<String, Integer>();
        map=Collections.synchronizedMap(map);


        /*
        * 数组打印方法
        * */
        /*
        * 1 for循环
        * */
        /*
        * 2 foreach
        * */
//        for(int a:array)
//            System.out.println(a);
        /*
        * 3 Array类中的toString方法
        * */
        int[] array = {1,2,3,4,5};
        System.out.println(Arrays.toString(array));
//      输出：[1, 2, 3, 4, 5]

    }
}
