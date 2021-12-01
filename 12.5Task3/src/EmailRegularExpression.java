import java.util.Scanner;

public class EmailRegularExpression {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入邮箱");//用户输入邮箱
        String inEmail = in.next();
        /*
        邮箱格式：用户名@域名
        数字、字母、_ @数字、字母.com/.com.cn
        example:
        1、harry12138@sina.com.cn
        2、Harry_12138@163.com
         */
        boolean rule = inEmail.matches("[a-zA-Z0-9_]+@[a-zA-Z]+(\\.[a-z]+)+");
        System.out.println(rule);
    }
}
