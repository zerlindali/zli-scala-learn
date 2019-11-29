package day03.nowcoder;

/**
 * @author ZerlindaLi create at 2019/9/4 9:59
 * @version 1.0.0
 * @description StringReplace 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class StringReplace {

    public static void main(String[] args) {
        String result = replaceSpace(new StringBuffer("We Are Happy"));
        System.out.println(result);
    }


    public static String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }
}
