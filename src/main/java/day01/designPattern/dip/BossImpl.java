package day01.designPattern.dip;

/**
 * @author ZerlindaLi create at 2019/5/29 15:49
 * @version 1.0.0
 * @description BossImpl
 */
public class BossImpl extends Boss{
    public BossImpl(Staff staff) {
        super(staff);
    }

    @Override
    void support() {
        this.getStaff().service();
    }

    @Override
    void askHelp(Boss boss) {
        boss.support();
    }
}
