package day01.designPattern.factory;

/**
 * @author ZerlindaLi create at 2019/8/13 17:17
 * @version 1.0.0
 * @description PizzaTestDrive
 */
public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza = nyStore.createPizza("cheese");
        System.out.println("郑龙 ordered a " + pizza.getName() + "\n");
        pizza.prepare();
        pizza.prepare();


        Pizza pizza2 = chicagoStore.createPizza("cheese");
        System.out.println("程海锋 ordered a " + pizza2.getName() + "\n");
        pizza2.prepare();

    }
}
