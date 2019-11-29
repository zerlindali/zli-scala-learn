package day01.designPattern.command;

/**
 * @author ZerlindaLi create at 2019/9/2 9:37
 * @version 1.0.0
 * @description LightOffCommand
 */
public class LightOffCommand implements Command{

    Light light;
    public LightOffCommand(Light light){
        this.light = light;
    }


    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
