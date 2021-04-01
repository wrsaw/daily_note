package aop;

/**
 * @author WangRui
 * create at 2021/03/30 下午 3:51
 **/
public class FundsService {
    private double balance = 1000;

    public double recharge(String userName, double price) {
        System.out.println(String.format("%s提现%s", userName, price));
        balance += price;
        return balance;
    }

    public double cashOut(String userName, double price) {
        if (balance < price) {
            throw new RuntimeException("余额不足!");
        }
        System.out.println(String.format("%s提现%s", userName, price));
        balance -= price;
        return balance;
    }

    public double getBalance(String userName) {
        return balance;
    }

}
