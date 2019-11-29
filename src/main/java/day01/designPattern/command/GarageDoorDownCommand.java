package day01.designPattern.command;

/**
 * @author ZerlindaLi create at 2019/9/2 18:15
 * @version 1.0.0
 * @description GarageDoorDownCommand
 */
public class GarageDoorDownCommand {
    GarageDoor garageDoor;

    public GarageDoorDownCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }
}
