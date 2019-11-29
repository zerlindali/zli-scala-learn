package day02;

/**
 * @author ZerlindaLi create at 2019/8/23 17:19
 * @version 1.0.0
 * @description StringTest
 */
public class StringTest {
    public static void main(String[] args) {
        String requestUrl = "/api/finance/financeTemplate";
        int fromIndex = requestUrl.contains("/") ? requestUrl.lastIndexOf("/") + 1 : 0;
        int toIndex = requestUrl.contains(".") ? requestUrl.lastIndexOf(".") : requestUrl.length();
        String methodName = requestUrl.substring(fromIndex, toIndex);
        System.out.println(methodName);
    }
}
