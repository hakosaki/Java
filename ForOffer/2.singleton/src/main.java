public class main {
//   枚举不能在local，不能在main内
    enum Singleton6{
        instance;
        public void getInstance(){

        }
    }
    public static void main(String[] args){
        Singleton1 single1 = Singleton1.getInstance();
        Singleton2 single2 = Singleton2.getInstance();
        Singleton3 single3 = Singleton3.getInstance();
        Singleton4 single4 = Singleton4.getInstance();
        Singleton5 single5 = Singleton5.getInstance();
        /*
        * 枚举
        * 类似饿汉
        * 简单 自由序列化
        * */
        Singleton6.instance.getInstance();
    }
}