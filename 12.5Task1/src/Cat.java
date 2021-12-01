//一个Cat猫类(抽象类abstract)
public abstract class Cat {
    protected String name;//猫名字
    protected int age;//年龄
    protected String gender;//性别
    protected double pricePerCat;//买一只的价格

    //一个全参构造方法
    public void Cat(String name, int age, String gender, double pricePerCat) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.pricePerCat = pricePerCat;
    }

    //一个抽象的 toString 方法
    public abstract String toString();
}











