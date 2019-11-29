package day01.designPattern.factory;

/**
 * @author ZerlindaLi create at 2019/8/15 15:30
 * @version 1.0.0
 * @description NYPizzaIngredientFactory
 * 这是纽约原料工厂的实现。这工厂专精于大蒜番茄酱料、Reggiano干酪、新鲜哈利···
 * 具体原料工厂必须实现PizzaIngredientFactory这个接口，纽约原料工厂也不例外
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        // 对于蔬菜，以一个蔬菜数组为返回值。在这里我们是直接把蔬菜写死。
        // 其实我们可以把它改写得更好一点，但是这对于学习工厂模式并没有帮助，所以还是保持这个简单的做法就好了。
        Veggies veggies [] = {new Garlic(), new Onion(), new Mushroom(), new RedPepper()};
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        // 这是切片的意式腊肠，纽约和芝加哥都会用到它。在下一页，在你自己实现芝加哥工厂时，别忘了使用它。
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam() {
        // 纽约靠海，所以有新鲜的蛤蜊。芝加哥就必须使用冷冻的蛤蜊
        return new FreshClams();
    }
}
