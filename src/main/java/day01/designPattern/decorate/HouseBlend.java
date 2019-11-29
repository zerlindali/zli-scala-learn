package day01.designPattern.decorate;

/**
 * @author ZerlindaLi create at 2019/8/8 17:27
 * @version 1.0.0
 * @description 具体组件 HouseBlend是另外一种饮料，做法和Espresso一样，只是把描述换成了House Blend Coffee, 并返回正确的价格 0.89
 */
public class HouseBlend extends Beverage {
    public HouseBlend(){
        description = "House Blend Coffee";
    }

    public double cost() {
        return .89;
    }
}
