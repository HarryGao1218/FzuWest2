//黑猫类BlackCat(继承extends Cat类 )
class BlackCat extends Cat {
    final double pricePerCat = 350;

    public String toString() {
        return "OrangeCat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", pricePerCat=" + pricePerCat +
                '}';
    }
}
