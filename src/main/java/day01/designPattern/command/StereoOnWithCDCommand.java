package day01.designPattern.command;

/**
 * @author ZerlindaLi create at 2019/9/2 15:25
 * @version 1.0.0
 * @description StereoOnWithCDCommand
 */
public class StereoOnWithCDCommand implements Command{
    Stereo stereo;

    // 就如同lightOnCommand的做法一样，传入音响的实例，
    // 然后将其储存在局部实例变量中
    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        // 要实现这个请求，需要调用音响的三个方法：
        // 首先打开它，然后把它设置成播放CD,最后把音量设置为11.
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);
    }

    @Override
    public void undo() {
        stereo.off();
    }
}
