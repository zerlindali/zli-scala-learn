package day01.designPattern.observer.javainner;

/**
 * @author ZerlindaLi create at 2019/7/23 16:15
 * @version 1.0.0
 * @description WeatherStation
 */
public class WeatherStation {

    public static void main(String[] args) {
        // 创建可观察者
        WeatherData subject = new WeatherData();

        // 创建观察者
        CurrentConditionsDisplay observer = new CurrentConditionsDisplay(subject);

        // 可观察者数据发生变化时
        subject.setMeasurements(12,34,54);
        subject.setMeasurements(42,34,54);
        subject.setMeasurements(13,34,54);
        subject.setMeasurements(41,34,54);
    }
}
