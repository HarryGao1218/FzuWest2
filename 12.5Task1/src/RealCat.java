//继承abstract Cat类，实例化
class RealCat extends Cat {
    @Override
    public String toString() {
        return "RealCat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", pricePerCat=" + pricePerCat +
                '}';
    }
}
