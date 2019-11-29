package day01.designPattern.observer.javainner;

import java.util.Observable;

/**
 * @author ZerlindaLi create at 2019/7/23 14:57
 * @version 1.0.0
 * @description WeatherData 可观察者
 */
public class WeatherData extends Observable {

    private float temp;
    private float humidity;
    private float pressure;

    public float getTemp(){
        return this.temp;
    }

    public float getHumidity(){
        return this.humidity;
    }

    public float getPressure(){
        return pressure;
    }


    public void setMeasurements(float temp, float humidity, float pressure){
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public void measurementsChanged(){

        setChanged(); // 需手动将changed标为true， 才会通知观察者
        notifyObservers(); // 通知观察者之后，changed会变为false
    }
}
