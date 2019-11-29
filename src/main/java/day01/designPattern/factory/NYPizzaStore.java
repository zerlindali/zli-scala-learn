package day01.designPattern.factory;

/**
 * @author ZerlindaLi create at 2019/8/13 16:04
 * @version 1.0.0
 * @description NYPizzaStore 能够产生产品的类成为具体创建者
 */
public class NYPizzaStore extends PizzaStore{
    /**
     * 此方法正是工厂方法，用来制造产品。
     * 因为每个加盟店都有自己的PizzaStore子类，所以可以用实现createPizza()创建自己风味的披萨
     * @param item
     * @return
     */
    protected Pizza createPizza(String item) {
        Pizza pizza = null;

        // 纽约店会用到纽约披萨原料工厂，由该原料工厂负责生产所有纽约风味披萨所需的原料。
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

        if(item.equals("cheese")) {
            // 把工厂传递给每一个披萨，以便披萨能从工厂中取得原料。
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("New York Style Cheese Pizza");
        } else if (item.equals("veggie")) {
            // 确定你了解了披萨和工厂之间的关系是如何运作的
            pizza = new VeggiePizza(ingredientFactory);
            pizza.setName("New York Style Veggie Pizza");
        } else if (item.equals("clam")) {
            // 对于每一种披萨，我们实例化一个新的披萨，并传进该种披萨所需的工厂，以便披萨取得他的原料
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("New York Style Clam Pizza");
        } else if (item.equals("pepperoni")) {
            pizza = new PepperoniPizza(ingredientFactory);
            pizza.setName("New York Style Pepperoni Pizza");
        }
        return pizza;
    }
}


