package day01.designPattern.observer;

/**
 * @author ZerlindaLi create at 2019/7/22 17:41
 * @version 1.0.0
 * @description Subject
 */
public interface Subject {
    /**
     * 注册观察者
     */
    public void registerObserver(Observer o);

    /**
     * 删除观察者
     */
    public void removeObserver(Observer o);

    /**
     * 通知观察者
     */
    public void notifyObservers();
}
