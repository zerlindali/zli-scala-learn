package day01.designPattern.decorate;

/**
 * @author ZerlindaLi create at 2019/8/9 17:33
 * @version 1.0.0
 * @description Pearl 珍珠 是一个装饰者，所以让它扩展自CondimentDecorator
 */
public class Pearl extends CondimentDecorator {
    Beverage beverage;

    public Pearl(Beverage beverage){
        this.beverage = beverage;
    }


    @Override
    public String getDescription() {
        return beverage.getDescription() + ", 珍珠";
    }

    @Override
    public double cost() {
        return .05 + beverage.cost();
    }
}
