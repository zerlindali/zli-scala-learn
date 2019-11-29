package day01.designPattern.decorate;

/**
 * @author ZerlindaLi create at 2019/8/9 17:36
 * @version 1.0.0
 * @description Coco 椰汁 是一个装饰者，所以让它扩展自CondimentDecorator
 */
public class Coco extends CondimentDecorator {
    Beverage beverage;

    public Coco (Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", 椰果";
    }

    @Override
    public double cost() {
        return 0.8 + beverage.cost();
    }
}
