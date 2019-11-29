package day01.designPattern.decorate;

/**
 * @author ZerlindaLi create at 2019/8/8 17:45
 * @version 1.0.0
 * @description StarbuzzCoffee
 */
public class StarbuzzCoffee {
    public static void main(String[] args) {
        // 具体组件Espresso
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        // 具体组件HouseBlend,用Mocha装饰
        Beverage beverage2 = new HouseBlend();
        beverage2 = new Mocha(beverage2);

        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
    }
}
