package day03.nowcoder;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ZerlindaLi create at 2019/9/25 10:36
 * @version 1.0.0
 * @description ArrayRotate
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class ArrayRotate {
    public int minNumberInRotateArray(int [] array) {
        int n = array.length;
        if(n==0){
            return 0;
        }

/*        for(int i = 0; i < n - 1; i++){
            if(array[i+1]<array[i]) {
                return array[i+1];
            }
        }*/

//        Arrays.sort(array);


        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i = 0; i<n; i++){
            priorityQueue.add(array[i]);
        }
        return priorityQueue.poll();
    }

    public static void main(String[] args) {
        int[] array = {3,4,5,2,4,5,6,1,2};

        System.out.println(new ArrayRotate().minNumberInRotateArray(array));

    }
}
