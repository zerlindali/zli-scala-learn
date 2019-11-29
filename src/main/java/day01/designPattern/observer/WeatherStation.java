package day01.designPattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author ZerlindaLi create at 2019/7/22 19:10
 * @version 1.0.0
 * @description WeatherStation
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(35, 12L, 123);
        weatherData.setMeasurements(23, 123, 43);

    }
}
