package day01.designPattern.decorate;

/**
 * @author ZerlindaLi create at 2019/8/8 17:23
 * @version 1.0.0
 * @description 抽象装饰者 调料装饰者CondimentDecorator
 */
public abstract class CondimentDecorator extends Beverage {
    public abstract  String getDescription();
}
