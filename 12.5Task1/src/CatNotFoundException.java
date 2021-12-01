//没找到猫异常：店内无猫可rua(即猫咪总数小于0)时候抛出
class CatNotFoundException extends RuntimeException {
    public CatNotFoundException(String msg) {
        super(msg);
    }
}