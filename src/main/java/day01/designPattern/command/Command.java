package day01.designPattern.command;

/**
 * @author ZerlindaLi create at 2019/8/29 17:38
 * @version 1.0.0
 * @description Command 命令接口
 */
public interface Command {
    public void execute();

    public void undo();
}
