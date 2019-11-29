package day01.designPattern.singleton;

/**
 * @author ZerlindaLi create at 2019/8/29 11:35
 * @version 1.0.0
 * @description Singleton
 */
public class Singleton {
    // 在静态初始化器（static initializer）中创建单件。这段代码保证了线程安全（thread state）
    // volatile关键词确保：当uniqueInstance变量被初始化Singleton实例时，
    // 多个线程正确地处理uniqueInstance变量
    private volatile static Singleton uniqueInstance;

    private Singleton(){}

    public static Singleton getInstance() {
        if(uniqueInstance == null){
            // 检查实例，如果不存在，就进入同步区块
            synchronized (Singleton.class){
                // 注意，只有第一次才彻底执行这里的代码
                if(uniqueInstance == null) {
                    // 进入区块后，再检查一次。如果仍是null,才创建实例
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
