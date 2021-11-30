package com.test.day8;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Package: com.test.day8
 * @ClassName: TransferMoneyDeadLock
 * @Author: 86150
 * @Description:
 * @Date: 2021/11/12 12:39
 */
public class TransferMoneyDeadLock {

    public void transferMoney(Account fromAccount, Account toAccount, BigDecimal amount) throws InterruptedException {
        synchronized (fromAccount){
            Thread.sleep(2000);
            synchronized (toAccount) {
                if(fromAccount.getAmount().compareTo(amount) < 0) {
                    throw new RuntimeException("转账金额错误");
                } else {
                    fromAccount.debit(amount);
                    toAccount.credit(amount);
                    System.out.println("fromAccount amount is " + fromAccount.getAmount() + ", toAccount amount is " + toAccount.getAmount());
                }
            }
        }
    }

    public static void main(String[] agrs) {
        TransferMoneyDeadLock transferMoneyDeadLock = new TransferMoneyDeadLock();
        Account fromAccount = new Account(1231231233, new BigDecimal("10000"));
        Account toAccount = new Account(1231231231, new BigDecimal("10000"));
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            transferMoneyDeadLock.transferMoney(fromAccount, toAccount, new BigDecimal("2000"));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        executorService.submit(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            transferMoneyDeadLock.transferMoney(toAccount ,fromAccount, new BigDecimal("2000"));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
    }
}