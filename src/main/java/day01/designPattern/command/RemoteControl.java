package day01.designPattern.command;

/**
 * @author ZerlindaLi create at 2019/9/2 13:54
 * @version 1.0.0
 * @description RemoteControl 实现遥控器
 */
public class RemoteControl {
    // 这个时候，遥控器要处理7个开与关的命令，使用相应数组记录这些命令。
    Command[] onCommands;
    Command[] offCommands;


    public RemoteControl() {
        // 在构造器中，只需实例化并初始化这两个开与关的数组
        onCommands = new Command[7];
        offCommands = new Command[7];

        Command noCommand = new NoCommand();
        for(int i = 0; i < 7; i++){
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    /**
     * setCommand()方法须有3个参数，分别是插槽的位置，开的命令，关的命令。
     * 这些命令将记录在开关数组中对应的插槽位置，以供稍后使用
     * @param slot 插槽的位置
     * @param onCommand 开的命令
     * @param offCommand 关的命令
     */
    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
    }

    /**
     * 当按下开或关的按钮，硬件就会负责调用对应的方法，
     * 也就是onButtonWasPushed()或offButtonWasPushed()
     * @param slot
     */
    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
    }

    // 覆盖toString(), 打印出每个插槽和它对应的命令。稍后在测试遥控器的时候，会用到这个方法。
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n----- Remote Control -----\n");
        for(int i = 0; i < onCommands.length; i++) {
            stringBuffer.append("[slot " + i + "] " + onCommands[i].getClass().getName()
            + " " + offCommands[i].getClass().getName() + "\n");
        }
        return stringBuffer.toString();
    }
}
