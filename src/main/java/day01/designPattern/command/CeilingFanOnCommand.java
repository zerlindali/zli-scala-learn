package day01.designPattern.command;

/**
 * @author ZerlindaLi create at 2019/9/2 17:49
 * @version 1.0.0
 * @description CeilingFanOnCommand
 */
public class CeilingFanOnCommand implements Command{
    CeilingFan ceilingFan;

    public CeilingFanOnCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        ceilingFan.on();
    }

    @Override
    public void undo() {
        ceilingFan.off();
    }
}
