package day01.designPattern.factory;

import java.util.ArrayList;

/**
 * @author ZerlindaLi create at 2019/8/13 15:00
 * @version 1.0.0
 * @description Pizza 工厂生产产品。对PizzaStore来说，产品就是Pizza.
 */
public abstract class Pizza {

    // 每个披萨都持有一组在准备时会用到的原料
    String name;

    Dough dough;

    Sauce sauce;

    Veggies veggies[];

    Cheese cheese;

    Pepperoni pepperoni;

    Clams clam;

    // 现在把prepare()方法声明成抽象。在这个方法中，我们需要收集披萨所需的原料，而这些原料当然是来自原料工厂了。
    abstract void prepare();

    void bake(){
        System.out.println("Bake for 25 minutes at 350");
    }
    void cut(){
        System.out.println("Cutting the pizza into diagonal slices");
    }
    void box(){
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        // 这里是打印披萨的代码
        return name;
    }
}
