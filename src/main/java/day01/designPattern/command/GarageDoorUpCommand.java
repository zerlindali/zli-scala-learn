package day01.designPattern.command;

/**
 * @author ZerlindaLi create at 2019/9/2 18:10
 * @version 1.0.0
 * @description GarageDoorUpCommand
 */
public class GarageDoorUpCommand {
    GarageDoor garageDoor;

    public GarageDoorUpCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }
}
