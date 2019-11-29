package day01.designPattern.decorate;

/**
 * @author ZerlindaLi create at 2019/8/9 17:25
 * @version 1.0.0
 * @description 具体组件 奶茶 MilkTea 是一种饮料，所以让MilkTea扩展Beverage类
 */
public class MilkTea extends Beverage {

    public MilkTea () {
        description = "奶茶";
    }

    @Override
    public double cost() {
        return 1.98;
    }
}
