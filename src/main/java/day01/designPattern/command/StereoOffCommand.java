package day01.designPattern.command;

/**
 * @author ZerlindaLi create at 2019/9/2 18:24
 * @version 1.0.0
 * @description StereoOffCommand
 */
public class StereoOffCommand implements Command{
    Stereo stereo;

    public StereoOffCommand(Stereo stereo){
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.off();
    }

    @Override
    public void undo() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);
    }
}
