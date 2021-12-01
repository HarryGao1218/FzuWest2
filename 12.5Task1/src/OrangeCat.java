//橘猫类OrangeCat(继承extends Cat类 )
class OrangeCat extends Cat {
    final double pricePerCat = 200;
    protected boolean isFat;

    public String toString() {
        return "OrangeCat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", pricePerCat=" + pricePerCat +
                '}';
    }
}