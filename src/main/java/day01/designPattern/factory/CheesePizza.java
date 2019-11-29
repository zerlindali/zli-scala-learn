package day01.designPattern.factory;

/**
 * @author ZerlindaLi create at 2019/8/15 16:29
 * @version 1.0.0
 * @description CheesePizza
 */
public class CheesePizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;

    /**
     * 要制作披萨，需要工厂提供原料。所以每个披萨类都需要从构造器参数中得到一个工厂，并把这个工厂存储在一个实例变量中
     * @param ingredientFactory
     */
    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }


    @Override
    void prepare() {


    }
}
