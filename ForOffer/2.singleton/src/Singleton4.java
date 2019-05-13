/*
* 饿汉模式
* 直接在运行这个类的同时就loading
* */
public class Singleton4 {
    private static Singleton4 instance = new Singleton4();
    private Singleton4(){

    }
    public static Singleton4 getInstance(){
        return instance;
    }
}
