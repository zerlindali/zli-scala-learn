package day01.designPattern.command;

/**
 * @author ZerlindaLi create at 2019/9/3 11:30
 * @version 1.0.0
 * @description CeilingFanLowCommand
 */
public class CeilingFanLowCommand implements Command {
    CeilingFan ceilingFan;
    int prevSpeed;

    public CeilingFanLowCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    public void execute(){
        // 在execute()中，在我们改变吊扇的速度之前，需要先将它之前的状态记录起来，一遍需要撤销时使用
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.low();
    }

    // 将吊扇的速度设置回之前的值，达到撤销的目的
    public void undo() {
        if(prevSpeed == CeilingFan.HIGH) {
            ceilingFan.high();
        } else if(prevSpeed == CeilingFan.MEDIUM) {
            ceilingFan.medium();
        } else if(prevSpeed == CeilingFan.LOW) {
            ceilingFan.low();
        } else if(prevSpeed == CeilingFan.OFF) {
            ceilingFan.off();
        }
    }
}
