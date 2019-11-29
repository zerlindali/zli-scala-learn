package day01.designPattern.factory;

/**
 * @author ZerlindaLi create at 2019/8/15 17:00
 * @version 1.0.0
 * @description VeggiePizza
 */
public class VeggiePizza extends Pizza {

    PizzaIngredientFactory pizzaIngredientFactory;

    public VeggiePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }
    @Override
    void prepare() {
        System.out.println("Preparing " + name);
        // 神奇的事情发生在这里！
        // prepare()方法一步一步地创建芝士披萨，每当需要原料时，就更工厂要。
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
        cheese = pizzaIngredientFactory.createCheese();
    }
}
