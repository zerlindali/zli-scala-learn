package day01.designPattern.dip;

/**
 * @author ZerlindaLi create at 2019/5/29 15:42
 * @version 1.0.0
 * @description 依赖倒置原则
 *
 * High level modules should not depend upon low level modules.Both should depend upon abstractions. 高层模块不应该依赖低层模块，两者都应该依赖其抽象（模块间的依赖通过抽象发生，实现类之间不发生直接的依赖关系，其依赖关系是通过接口或抽象类产生的）
 * Abstractions should not depend upon details. 抽象不应该依赖细节（接口或抽象类不依赖于实现类）
 * Details should depend upon abstractions. 细节应该依赖抽象（实现类依赖接口或抽象类）
 */
abstract class Boss {
    private Staff staff;

    public Boss(Staff staff) {
        this.staff = staff;
    }

    /**
     * 提供支持
     */
    abstract void support();

    /**
     * 需求帮助
     * @param boss
     */
    abstract void askHelp(Boss boss);

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    /**
     * 招募员工
     * @return
     */
    public Staff getStaff() {
        return staff;
    }
}
