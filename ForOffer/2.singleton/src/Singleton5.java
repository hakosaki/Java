/*
* 静态类内部加载
* 线程安全
* 调用getInstance才加载
* */
public class Singleton5 {
    private static class SingletonHolder{
        private static final Singleton5 instance = new Singleton5();
    }
    private Singleton5(){

    }
    public static Singleton5 getInstance(){
        return SingletonHolder.instance;
    }
}
