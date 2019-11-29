package day01.designPattern.command;

/**
 * @author ZerlindaLi create at 2019/9/3 10:34
 * @version 1.0.0
 * @description RemoteLoaderWithUndo 测试带有撤销功能的遥控器
 */
public class RemoteLoaderWithUndo {
    public static void main(String[] args) {
        RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

        // 创建一个电灯对象和新支持undo()功能命令
        Light livingRoomLight = new Light("Living Room");

        // undo()功能的命令
        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);

        // 将电灯命令设置到遥控器的0号插槽
        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);

        // 打开电灯，关闭电灯，然后撤销
        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();
        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(0);
        System.out.println();
        remoteControl.undoButtonWasPushed();

        // 创建一个天花板吊扇
        CeilingFan ceilingFan = new CeilingFan("Living Room");
        // 创建天花板吊扇的转速命令
        CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
        CeilingFanMediumCommand ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
        CeilingFanLowCommand ceilingFanLow = new CeilingFanLowCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

        // 将风扇命令分别设置到1,2,3号
        remoteControl.setCommand(1, ceilingFanHigh, ceilingFanOff);
        remoteControl.setCommand(2, ceilingFanMedium, ceilingFanOff);
        remoteControl.setCommand(3, ceilingFanLow, ceilingFanOff);

        remoteControl.onButtonWasPushed(4);
        remoteControl.offButtonWasPushed(4);
        System.out.println(remoteControl);

    }

}
