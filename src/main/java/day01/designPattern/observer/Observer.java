package day01.designPattern.observer;

/**
 * @author ZerlindaLi create at 2019/7/22 17:41
 * @version 1.0.0
 * @description Observer 观察者
 */
public interface Observer {
    /**
     * 当主题数据发生变化时，会把数据传递给观察者
     * 所有的观察者都必须实现此接口，以实现观察者的接口
     */
    public void update(float temp, float humidity, float pressure);
}
