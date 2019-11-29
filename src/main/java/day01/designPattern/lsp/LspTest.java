package day01.designPattern.lsp;

/**
 * 里氏替换原则：
 * 如果对每一个类型为S的对象o1，都有类型为T的对象o2，使得以T定义的所有程序P在所有的对象o1都代换成o2时，程序P的行为没有发生变化，
 * 那么类型S是类型T的子类型。
 * 所有引用基类的地方必须能透明地使用其子类的对象。
 *
 * 子类继承父类，且不重写父类的方法。
 * @author ZerlindaLi create at 2019/5/28 11:41
 * @version 1.0.0
 * @description LSPTest
 */
public class LspTest {
    public static void main(String[] args) {
        Father f = new Father();
        Son1 s1 = new Son1();
        Son2 s2 = new Son2();

        f.makeMechine();
        s1.makeMechine();
        s2.makeMechine();
        s2.makeWeapon();
    }
}

class Father{
    public void makeMechine(){
        System.out.println("制造冷兵器");
    }
}

class Son1 extends Father {
    @Override
    public void makeMechine(){
        System.out.println("制造核武器");
    }
}

class Son2 extends Father {
    public void makeWeapon(){
        System.out.println("制造核武器");
    }
}
