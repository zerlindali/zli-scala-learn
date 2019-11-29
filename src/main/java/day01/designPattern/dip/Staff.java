package day01.designPattern.dip;

/**
 * @author ZerlindaLi create at 2019/5/29 15:44
 * @version 1.0.0
 * @description Staff
 */
abstract class Staff {
    private String name;

    abstract void service();

    abstract void askHelp(Boss boss);

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


