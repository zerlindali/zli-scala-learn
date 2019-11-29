package day01.designPattern.decorate;

/**
 * @author ZerlindaLi create at 2019/8/8 17:21
 * @version 1.0.0
 * @description 抽象组件 Beverage
 */
public abstract class Beverage {
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract  double cost();
}
