package day01.designPattern.command;

/**
 * @author ZerlindaLi create at 2019/8/29 17:43
 * @version 1.0.0
 * @description Light
 */
public class Light {

    String name;

    public Light(){}

    public Light(String name) {
        this.name = name;
    }
    public void on(){
        System.out.println(name+"灯开了...");
    }

    public void off(){
        System.out.println(name+"灯灭了---");
    }
}
