package day01.designPattern.decorate;

/**
 * @author ZerlindaLi create at 2019/8/8 17:25
 * @version 1.0.0
 * @description 具体组件 浓咖啡Expresso是一种饮料,所以让Expresso扩展Beverage类
 */
public class Espresso extends Beverage {

    /**
     * 设置饮料的描述，description继承自Beverage
     */
    public Espresso(){
        description = "Espresso";
    }

    /**
     * 计算Espresso的价格，现在不需要管调料的价格，直接把Espresso的价格1.99返回
     * @return
     */
    public double cost() {
        return 1.99;
    }
}
