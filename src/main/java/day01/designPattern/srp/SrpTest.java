package day01.designPattern.srp;

/**
 * @description 单一职责原则适用的范围有接口、方法、类。
 * 按大家的说法，接口和方法必须保证单一职责，类就不必保证，只要符合业务就行。
 * @author ZerlindaLi create at 2019/6/11 16:13
 * @version 1.0.0
 * @description Shopping
 */
public class SrpTest{
    public static void main(String[] args) {

    }
}
interface Shopping {
    void doShopping();
}

interface PourGarbage {
    void doPourGarbage();
}

interface WashingUp{
    void doWashingUp();
}

class XiaoMing implements PourGarbage {

    @Override
    public void doPourGarbage() {
        System.out.println(("pourGarbage..."));
    }
}

class XiaoHong implements Shopping, WashingUp {

    @Override
    public void doShopping() {
        System.out.println(("Shopping..."));
    }

    @Override
    public void doWashingUp() {
        System.out.println(("doWashingUp..."));
    }
}
