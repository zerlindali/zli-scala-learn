package day01.designPattern.factory;

/**
 * @author ZerlindaLi create at 2019/8/12 16:49
 * @version 1.0.0
 * @description 抽象PizzaStore 创建者类
 * 这是抽象创建者类，它定义了一个抽象的工厂方法，让子类实现此方法制造产品
 * 创建者通常会包含依赖于抽象产品的代码，而这些抽象产品由子类制造。创建者不需要真的知道在制造哪种具体产品。
 */
public abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza;

        // createPizza()方法从工厂对象中移回PizzaStore
        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    // 现在把工厂对象移到这个方法中，现在是抽象的
    abstract Pizza createPizza(String  type);
}
