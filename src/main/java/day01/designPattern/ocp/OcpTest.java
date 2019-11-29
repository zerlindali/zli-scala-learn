package day01.designPattern.ocp;

import java.math.BigDecimal;

/**
 * 开闭原则：当应用的需求改变时，在不修改软件实体的源代码或者二进制代码的前提下，可以扩展模块的功能，使其满足新的需求。
 * 对扩展开放，对修改封闭
 * 抽象约束，封装变化，派生类
 * @author ZerlindaLi create at 2019/5/28 17:09
 * @version 1.0.0
 * @description OcpTest
 */
public class OcpTest {
    public static void main(String[] args) {
        Hospital h = new Hospital();
        Medicine m = new Medicine("阿司匹林",new BigDecimal(12.34));
        OneLevelSocialSecurityPatient chf = new OneLevelSocialSecurityPatient("程海锋");
        h.sellMedicine(chf, m);

        TwoLevelSocialSecurityPatient zl  = new TwoLevelSocialSecurityPatient("郑龙");
        h.sellMedicine(zl, m);

        ThreeLevelSocialSecurityPatient zc  = new ThreeLevelSocialSecurityPatient("张超");
        h.sellMedicine(zc, m);
    }

}

class Medicine {
    private String name;
    private BigDecimal price;

    public Medicine(String name, BigDecimal price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

class Hospital {
    public void sellMedicine(IPatient patient, Medicine medicine){
        BigDecimal money = patient.pay(medicine);
        System.out.println(patient.getName() + "花了" + money.setScale(2, BigDecimal.ROUND_UP) + "块钱买了药：" + medicine.getName());
    }
}

interface IPatient {
    String getName();
    BigDecimal pay(Medicine medicine);
}

/**
 * 一档社保
 */
class OneLevelSocialSecurityPatient implements IPatient {
    private String name;

    public OneLevelSocialSecurityPatient(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public BigDecimal pay(Medicine medicine) {
        return medicine.getPrice().multiply(new BigDecimal(0.7));
    }
}

/**
 * 二挡社保
 */
class TwoLevelSocialSecurityPatient implements IPatient {
    private String name;

    public TwoLevelSocialSecurityPatient(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public BigDecimal pay(Medicine medicine) {
        return medicine.getPrice().multiply(new BigDecimal(0.8));
    }
}

/**
 * 三挡社保
 */
class ThreeLevelSocialSecurityPatient implements IPatient {
    private String name;

    public ThreeLevelSocialSecurityPatient(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public BigDecimal pay(Medicine medicine) {
        return medicine.getPrice().multiply(new BigDecimal(0.9));
    }
}