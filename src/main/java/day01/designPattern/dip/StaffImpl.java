package day01.designPattern.dip;

/**
 * @author ZerlindaLi create at 2019/5/29 15:51
 * @version 1.0.0
 * @description StaffImpl
 */
public class StaffImpl extends Staff {
    public StaffImpl(String name) {
        this.setName(name);
    }

    @Override
    void service() {
        System.out.println(this.getName() + "提供服务");
    }

    @Override
    void askHelp(Boss boss) {
        boss.support();
    }
}
