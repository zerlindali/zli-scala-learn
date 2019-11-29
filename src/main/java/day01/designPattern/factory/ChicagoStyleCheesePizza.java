package day01.designPattern.factory;

/**
 * @author ZerlindaLi create at 2019/8/13 17:11
 * @version 1.0.0
 * @description ChicagoStyleCheesePizza 具体的产品
 */
public class ChicagoStyleCheesePizza extends Pizza{
    public ChicagoStyleCheesePizza() {
        // 芝加哥披萨使用小番茄作为酱料，并使用厚饼
/*        name = "Chicago Style Deep Dish Cheese Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";

        // 芝加哥风味的深盘比披萨使用许多mozzarella意大利百干酪！
        toppings.add("Shredded Mozzarella Cheese");*/
    }

    @Override
    void prepare() {

    }

    void cut() {
        // 这个芝加哥风味披萨覆盖了cut()方法，将披萨切成正方形
        System.out.println("Cutting the pizza into square slices");
    }
}
