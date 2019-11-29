package day01.designPattern.factory;

/**
 * @author ZerlindaLi create at 2019/8/13 17:19
 * @version 1.0.0
 * @description ChicagoPizzaStore
 */
public class ChicagoPizzaStore extends PizzaStore{
    @Override
    Pizza createPizza(String item) {
        if(item.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        } else if (item.equals("veggie")) {
            return new ChicagoStyleVeggiePizza();
        } else if (item.equals("clam")) {
            return new ChicagoStyleClamPizza();
        } else if (item.equals("pepperoni")) {
            return new ChicagoStylePepperonlPizza();
        } else return null;
    }
}
