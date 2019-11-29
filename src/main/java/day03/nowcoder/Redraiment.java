package day03.nowcoder;

import java.util.Scanner;

/**
 * @author ZerlindaLi create at 2019/7/23 16:45
 * @version 1.0.0
 * @description Redraiment 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Redraiment {
    public static void main(String[] args) {
        // 输入数字个数
        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int target = 7;
        find(target,array);

        fint2(target,array);
    }

    /**
     * 暴力遍历
     * @param target
     * @param array
     * @return
     */
    public static boolean find(int target, int[][] array) {
        // 遍历数组
        for(int i = 0;i < array.length;  i++) {
            for(int j = 0; j < array[i].length; j++){
                if(target == array[i][j]){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 从左下角开始比较，target大与当前值则右移，小于当前值则上移
     */
    public static boolean fint2(int target, int[][] array) {
        if(array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }

        // 行数
        int rowIndex = array.length - 1;
        // 列数
        int i = 0;

        while(i<=array[0].length - 1 && rowIndex >= 0){
            if(target == array[rowIndex][i]) {
                return true;
            } else if(target > array[rowIndex][i]) {
                ++i;
            } else {
                --rowIndex;
            }
        }
        return false;
    }
}
