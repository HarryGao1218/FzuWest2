import java.util.Date;

//顾客类Customer
class Customer {
    String name;//顾客名字
    int ruaTimes;//想要rua猫的次数
    Date arriveTime = new Date();//到店时间

    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", ruaCat=" + ruaTimes +
                ", arriveTime=" + arriveTime +
                '}';
    }

}