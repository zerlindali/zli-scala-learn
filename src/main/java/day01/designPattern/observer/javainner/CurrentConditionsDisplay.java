package day01.designPattern.observer.javainner;

import day01.designPattern.observer.DisplayElement;

import java.util.Observable;
import java.util.Observer;

/**
 * @author ZerlindaLi create at 2019/7/23 15:01
 * @version 1.0.0
 * @description CurrentConditionsDisplay
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temp;
    private float humidity;

    private Observable obs;

    public CurrentConditionsDisplay(Observable obs){
        this.obs = obs;
        obs.addObserver(this); // 注册观察者
    }

    @Override
    public void display() {
        System.out.println("Current Condition : " + temp + " F degresss and " + humidity + "% humidity.");
    }

    @Override
    public void update(Observable o, Object arg) {

        if(obs instanceof  WeatherData){
            this.temp = ((WeatherData) obs).getTemp();
            this.humidity = ((WeatherData) obs).getHumidity();
            display();
        }
    }
}
