package day01.designPattern.command;

/**
 * @author ZerlindaLi create at 2019/8/29 17:41
 * @version 1.0.0
 * @description LightOnCommad 实现一个打开电灯的命令
 */
public class LightOnCommand implements Command{
    Light light;

    // 构造器被传入了某个电灯（比方说：客厅的电灯），以便让这个命令控制，然后记录在实例变量中。
    // 一旦调用execute(),就由这个电灯对象成为接收者，负责接受请求。
    public LightOnCommand(Light light) {
        this.light = light;
    }

    // 这个execute()方法用接收对象（我们正在控制的电灯）的on()方法
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
