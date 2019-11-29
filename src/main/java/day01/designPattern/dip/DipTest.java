package day01.designPattern.dip;

/**
 * 依赖倒置原则：
 * 高层模块不应该依赖低层模块，两者都应该依赖其抽象（模块间的依赖通过抽象发生，实现类之间不发生直接的依赖关系，其依赖关系是通过接口或抽象类产生的）
 * 抽象不应该依赖细节（接口或抽象类不依赖于实现类）
 * 细节应该依赖抽象（实现类依赖接口或抽象类）
 *
 * 需求：
 * 一个小村里，有两家饭馆，虽然挂着不同的牌子，挨在一起，但是老板确是表兄弟。这两兄弟抠得很，为了节省成本，密谋了一个想法：在两家饭馆谁家忙的时候，可以让不忙的那家的员工过去支援一下。这样子，本来每家饭馆都需要 2 个洗碗工，总共需要 4 个，他们就只招了 3 个，省了 1 个洗碗工的成本，当然不止洗碗工，还有服务员等等。两兄弟约定了规则：
 *
 * 1. A 饭馆需要支援的时候，B 饭馆老板，让 B 饭馆老板选哪个员工去支援，不能直接让 A 饭馆的员工直接找 B 饭馆的员工去帮忙，但可以让 A 饭馆员工找 B饭馆老板告知需要支援。
 *
 * 2. 虽然老板权利大，但是也不能说 A 饭馆老板直接叫 B 饭馆的员工去帮忙。
 *
 * 3. 员工没有真实的老板，今天为 A 饭馆工作就是 A 饭馆的员工，没有跟定哪个老板。
 *
 * @author ZerlindaLi create at 2019/5/29 11:00
 * @version 1.0.0
 * @description DipTest
 */
public class DipTest {
    public static void main(String[] args) {
        Staff staffA = new StaffImpl("A 员工");
        Staff staffB = new StaffImpl("B 员工");

        Boss bossA = new BossImpl(staffA);
        Boss bossB = new BossImpl(staffB);

        /**
         * A老板向B老板求支援
         */
        bossA.askHelp(bossB);

        /**
         * B员工向A老板求支援
         */
        staffB.askHelp(bossB);

        /**
         * A老板辞退了A员工，换成了C员工
         */
        Staff staffC = new StaffImpl("C 员工");
        bossA.setStaff(staffC);

        /**
         * B员工向A老板求支援
         */
        staffB.askHelp(bossA);
    }
}
