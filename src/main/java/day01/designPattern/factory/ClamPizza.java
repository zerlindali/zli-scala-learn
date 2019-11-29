package day01.designPattern.factory;

/**
 * @author ZerlindaLi create at 2019/8/15 16:47
 * @version 1.0.0
 * @description ClamPizza 蛤蜊披萨
 */
public class ClamPizza extends Pizza {

    PizzaIngredientFactory ingredientFactory;

    public ClamPizza(PizzaIngredientFactory ingredientFactory) {
        // 蛤蜊披萨也需要原料工厂
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
        System.out.println("Preparing " + name);
        // 要做出蛤蜊披萨，prepare()方法就必须从本地工厂中取得正确的原料。
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        // 如果是纽约工厂，就会使用新鲜的蛤蜊，如果是芝加哥工厂，就是冷冻的蛤蜊
        clam = ingredientFactory.createClam();
    }
}
