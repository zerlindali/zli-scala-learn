package day01.designPattern.command;

/**
 * @author ZerlindaLi create at 2019/9/2 15:26
 * @version 1.0.0
 * @description Stereo
 */
public class Stereo {

    String name;

    public Stereo(){}

    public Stereo(String name){

    }

    public void off() {
        System.out.println("关闭音响...");
    }

    public void on(){
        System.out.println("打开音响...");
    }

    public void setCD(){
        System.out.println("进入CD播放模式...");
    }

    public void setVolume(int volume){
        System.out.println("当前音量为"+volume+"...");
    }

}
