package day01.designPattern.command;

/**
 * @author ZerlindaLi create at 2019/8/29 17:46
 * @version 1.0.0
 * @description SimpleRemoteControl 使用命令对象：假设我们有一个遥控器，
 * 它只有一个按钮和对应的插槽，可以控制一个装置
 */
public class SimpleRemoteControl {
    /**
     * 有一个插槽持有命令，而这个命令控制着一个装置
     */
    Command slot;

    public SimpleRemoteControl(){}

    /**
     * 这个方法用来设置插槽控制的命令。
     * 如果这段代码的客户想要改变遥控器按钮的行为，
     * 可以多次调用这个方法
     * @param command
     */
    public void setCommand(Command command) {
        slot = command;
    }

    /**
     * 当按下按钮时，这个方法就会被调用，使得当前命令衔接插槽，
     * 并调用它的execute()方法
     */
    public void buttonWasPressed(){
        slot.execute();
    }
}
