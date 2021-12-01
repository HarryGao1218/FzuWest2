//异常类InsufficientBalanceException，余额不足异常：余额小于0时抛出
class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}