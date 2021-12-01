import java.util.Scanner;

class Test {
    public static void main(String[] args) throws RuntimeException {
        MyCatCafe harryCafe = new MyCatCafe();
        System.out.println("请给定店内余额");
        Scanner in = new Scanner(System.in);
        harryCafe.balance = in.nextDouble();
        harryCafe.buyCat();
        harryCafe.receiveCustomer();
        harryCafe.close();
    }
}