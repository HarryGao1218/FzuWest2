import java.util.*;

import static java.lang.System.in;

//MyCatCafe实现CatCafe
class MyCatCafe implements CatCafe {
    int dayRuaTimes = 0;
    double balance;//店的余额
    ArrayList<Cat> catInShop = new ArrayList<>();//店内猫猫列表
    ArrayList<Customer> customerInShop = new ArrayList<>();//顾客列表

    //重写买入新猫猫
    public void buyCat() throws InsufficientBalanceException {
        Scanner catin = new Scanner(in);
        System.out.println("是否买猫猫，y-买,n-不买");
        while (!catin.next().equals("n")) {
            Cat caat = new RealCat(); // 创建猫猫类的对象
            System.out.println("请输入猫猫的姓名:");
            caat.name = catin.next();
            System.out.println("请输入猫猫的年龄:");
            caat.age = catin.nextInt();
            System.out.println("请输入猫猫性别:");
            caat.gender = catin.next();
            System.out.println("请输入猫猫的单价:");
            caat.pricePerCat = catin.nextDouble();
            catInShop.add(caat);
            //判断余额是否够买猫猫
            if (caat.pricePerCat <= balance) {
                balance = balance - caat.pricePerCat;
                System.out.println("购买成功");
            } else {
                throw new InsufficientBalanceException("余额不足");//抛出余额不足异常
            }
            System.out.println("是否继续y买猫猫，y-买,n-不买");
        }
    }

    //重写招待顾客
    public void receiveCustomer() throws CatNotFoundException {//招待顾客
        Scanner customerIn = new Scanner(in);
        Random randomNumber = new Random();
        //开始接待顾客
        System.out.println("招待顾客，y-有新的顾客,n-没有顾客了");
        //循环
        while (!customerIn.next().equals("n")) {
            Customer custtomer = new Customer(); //创建顾客类对象
            //输入顾客信息
            System.out.println("请输入顾客的姓名:");
            custtomer.name = customerIn.next();
            System.out.println("请输入顾客想rua几次猫猫:");
            custtomer.ruaTimes = customerIn.nextInt();
            customerInShop.add(custtomer);
//            if (catInShop.equals(null)) {
            if (catInShop.size() == 0) {
                throw new CatNotFoundException("店内没有猫猫可以rua了");
            } else {
                balance = balance + 15 * custtomer.ruaTimes;
                dayRuaTimes += custtomer.ruaTimes;
                //随机抓一只猫猫给顾客rua,并用toString输出猫猫信息
                for (int i = 0; i < custtomer.ruaTimes; i++) {
                    System.out.println(catInShop.get(randomNumber.nextInt(catInShop.size())).toString());
                }
            }
            System.out.println("是否继续招待顾客，y-还有新的顾客,n-没有顾客了");//招待下一个顾客
        }
    }

    public void close() {//歇业
        System.out.println("顾客的信息如下：");
        System.out.println("姓名\trua猫次数\t到店时间");
        Iterator<Customer> iterator = customerInShop.iterator();
        while (iterator.hasNext()) {
            Customer a = iterator.next();
            System.out.println(a.name + "\t" + a.ruaTimes + "\t" + a.arriveTime);
        }
        System.out.println("今日利润为：" + 15 * dayRuaTimes);
    }
}