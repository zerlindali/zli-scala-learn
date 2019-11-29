package day01.designPattern.factory;

/**
 * @author ZerlindaLi create at 2019/8/15 15:15
 * @version 1.0.0
 * @description PizzaIngredientFactory
 * 开始先为工厂定义一个接口，这个接口负责创建所有的原料
 */
public interface PizzaIngredientFactory {
    public Dough createDough();

    public Sauce createSauce();

    public Cheese createCheese();

    public Veggies[] createVeggies();

    public Pepperoni createPepperoni();

    public Clams createClam();
}
