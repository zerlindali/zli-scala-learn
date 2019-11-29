package day01.designPattern.isp;

/**
 * @description 接口隔离原则
 * 1. Clients should not be forced to depend upon interfaces that they don't use.（客户端不应该依赖它不需要的接口。）
 * 2. The dependency of one class to another one should depend on the smallest possible interface.（类间的依赖关系应该建立在最小的接口上。）
 * @author ZerlindaLi create at 2019/6/11 16:44
 * @version 1.0.0
 * @description IspTest
 */
public class IspTest {
    public static void main(String[] args) {
        // 测试代码
        LiAunt liAunt = new LiAunt();
        WangMather wangMather = new WangMather();
        ChenUncle chenUncle = new ChenUncle();
        HuangSister huangSister = new HuangSister();
        liAunt.hairBraiding();
        wangMather.getDressed();
        chenUncle.packingIntoTheBox();
        huangSister.makeTag();
    }
}

interface Hair {
    void hairBraiding();
}

interface Dress {
    void getDressed();
}

interface Box {
    void packingIntoTheBox();
}

interface Tag {
    void makeTag();
}

class LiAunt implements Hair {

    @Override
    public void hairBraiding() {
        System.out.println("李大姨给布娃娃扎辫子");
    }
}

class WangMather implements Dress {

    @Override
    public void getDressed() {
        System.out.println("王大妈给布娃娃穿衣服");
    }
}

class ChenUncle implements Box {

    @Override
    public void packingIntoTheBox() {
        System.out.println("陈大叔给布娃娃装箱");
    }
}

class HuangSister implements Tag {

    @Override
    public void makeTag() {
        System.out.println("黄大姐给箱子打标签");
    }
}
