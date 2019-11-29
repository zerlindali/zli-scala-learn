package day01.designPattern.factory;

/**
 * @author ZerlindaLi create at 2019/8/15 15:49
 * @version 1.0.0
 * @description ChicagoPizzaIngredientFactory
 */
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new TickCrusDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies [] = {new BlackOlives(), new Spinach(), new EggPlant(), new Mozzarella()};
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperonl();
    }

    @Override
    public Clams createClam() {
        return new FrozenClams();
    }
}
