package day01.happensbefore;

/**
 * @author ZerlindaLi create at 2019/5/27 10:18
 * @version 1.0.0
 * @description BinarySearch 二分法查找
 */
public class BinarySearch {

    /**
     * 循环实现二分查找
     * @param a 有序集合
     * @param n 集合个数
     * @param value 要查找的值
     * @return -1 表示不存在
     */
    public static int bSearch(int [] a, int n, int value){
        // 初始化how, high, mid下标值
        int low = 0;
        int high = n-1;

       while(a[low] <= a[high]){
           int mid = (low + high)/2;
           if(value == a[mid]){
               return mid;
           }else if(value > a[mid]){
               low = mid + 1;
           }else {
               high = mid - 1;
           }
       }
        return -1;
    }

    public static int bSearch2(int [] a, int n, int value){
        return bSearchInternally(a, 0, n-1, value);
    }

    /**
     * 递归实现二分查找
     * @param
     */
    public static int bSearchInternally(int [] a, int low, int high, int value){

        if(low > high) {
            return -1;
        }

        int mid = ((high - low) >> 1) + low;

        if (value == a[mid]){
            return mid;
        } else if(value > a[mid]){
            return bSearchInternally(a, mid + 1, high, value);
        } else {
            return bSearchInternally(a, low, mid - 1, value);
        }
    }



    public static void main(String[] args) {
        int [] a = {1,2,5,7,8,12,124,357,845,3235,43254,5654563,53454554};
        int index = bSearch(a,a.length,9);
        System.out.println("bSearch:"+index);

        index = bSearch2(a, a.length, 9);
        System.out.println("bSearch2:"+index);
    }
}
/**
 * 注意点3个：
 * 1. 循环退出的条件为a[low] <= a[high]，当查找的值落在查找的最后一个数值上时，low,high,mid三者相等
 * 2. 问题mid = (low + high) / 2，这种写法，当low和high非常大时，两者之和有可能会出现溢出。
 *    可以改成 mid = (high - low) / 2 + low
 *    进一步优化，将除以2换成位移运算 (high - low) >> 1 + low
 * 3. low = mid + 1; high = mid - 1; 注意不要写成low = mid; high = mid;否则会出现死循环。
 *    当三者相等时，而查找的值仍然不等于最后一个值，如果low = mid;则永远跳不出循环。
 *
 * 二分法应用场景分析：
 * 1. 二分法所依赖的数据结构是有序集合，即数组。
 * 2. 数据量太小不适合二分查找
 * 3. 数据量太大爷不适合二分查找，因为数组为了支持随机访问的特性，要求内存空间连续。
 */
