package day01.designPattern.decorate;

/**
 * @author ZerlindaLi create at 2019/8/8 17:28
 * @version 1.0.0
 * @description 摩卡Mocha是一个装饰者，所以让它扩展自CondimentDecorator
 */
public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    /**
     * 返回自身价格0.20加上组件价格
     * @return
     */
    public double cost(){
        return .20 + beverage.cost();
    }
}
