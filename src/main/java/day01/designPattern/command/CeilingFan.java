package day01.designPattern.command;

/**
 * @author ZerlindaLi create at 2019/9/2 17:35
 * @version 1.0.0
 * @description CeilingFan
 */
public class CeilingFan {

    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    String location;
    int speed;

    String name;

    public CeilingFan(){}

    public CeilingFan(String location){
        this.location = location;
        speed = OFF;
    }

    public void high() {
        speed = HIGH;
        // 设置高转速
    }

    public void medium() {
        speed = MEDIUM;
        // 设置中转速
    }

    public void low() {
        speed = LOW;
    }

    public void off() {
        speed = OFF;
    }

    public void on(){
        System.out.println("打开风扇");
    }

    public int getSpeed() {
        return speed;
    }
}
