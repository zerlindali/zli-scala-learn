package day01.designPattern.decorate;

/**
 * @author ZerlindaLi create at 2019/8/9 17:38
 * @version 1.0.0
 * @description PearlMilkTea
 */
public class PearlMilkTea {
    public static void main(String[] args) {
        // 创建一个奶茶
        Beverage beverage = new MilkTea();

        // 给奶茶加上珍珠
        beverage = new Pearl(beverage);

        // 给奶茶加上椰果
        beverage = new Coco(beverage);

        System.out.println(beverage.getDescription() + " $"+beverage.cost());
    }
}
