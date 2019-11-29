package day01.designPattern.lod;

/**
 * @author ZerlindaLi create at 2019/7/2 17:12
 * @version 1.0.0
 * @description 迪米特法则
 * Each unit should have only limited knowledge about other units: only units "closely" related to the current unit. (每个单元对于其他的单元只能拥有有限的知识：只是与当前单元紧密联系的单元)
 * Each unit should only talk to its friends; don't talk to strangers. (每个单元只能和它的朋友交谈：不能和陌生单元交谈)
 * Only talk to your immediate friends. (只和自己直接的朋友交谈)
 * (来自维基百科)
 *
 * 平常在零碎的时间里，喜欢看一些书籍，一般都是电子书，现在我们看书的操作是这样的：唤醒手机，打开阅读软件，选择书籍，然后阅读。总共 3 个步骤，涉及了 3 样东西：手机、软件、书籍。同学们用代码实现这个过程。
 */
public class LODRightTest {

    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.readBook();
    }
}

class Book {

    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

class App {
    private Book book = new Book("设计模式");

    public void read(){
        System.out.println(book.getTitle());
    }
}

class Phone {
    private App app = new App();

    public void readBook() {
        app.read();
    }
}
