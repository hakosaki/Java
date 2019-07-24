/*
* 双重校验锁法
*
* */
public class Singleton3 {
    private static Singleton3 instance;
    private  Singleton3(){

    }
    public static Singleton3 getInstance(){
        if(instance == null){
            synchronized (this){
                if(instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
