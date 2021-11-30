package com.test.day8;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Package: com.test.day8
 * @ClassName: TransferMoneySafely
 * @Author: 86150
 * @Description: 可以利用类似userId这种唯一且可以比较大小的字段来给多线程设置一个固定的加锁顺序，所有的线程都按这个顺序获取锁，就不会出现死锁的问题。
 * @Date: 2021/11/12 12:44
 */
public class TransferMoneySafely {

    private final Object lock = new Object();

    public void transferMoney(Account fromAccount, Account toAccount, BigDecimal amount) throws InterruptedException {

        if(fromAccount.getUserId() > toAccount.getUserId()) {
            synchronized (fromAccount) {
                Thread.sleep(2000);
                synchronized (toAccount) {
                    doTransfer(fromAccount,toAccount, amount);
                }
            }
        } else if(fromAccount.getUserId() < toAccount.getUserId()) {
            synchronized (toAccount) {
                Thread.sleep(2000);
                synchronized (fromAccount) {
                    doTransfer(fromAccount,toAccount, amount);
                }
            }
        } else {
            synchronized (lock) {
                synchronized (fromAccount){
                    Thread.sleep(2000);
                    synchronized (toAccount) {
                        doTransfer(fromAccount,toAccount, amount);
                    }
                }
            }
        }
    }

    public void doTransfer(Account fromAccount, Account toAccount, BigDecimal amount) {
        if(fromAccount.getAmount().compareTo(amount) < 0) {
            throw new RuntimeException("转账金额错误");
        } else {
            fromAccount.debit(amount);
            toAccount.credit(amount);
            System.out.println("fromAccount amount is " + fromAccount.getAmount() + ", toAccount amount is " + toAccount.getAmount());
        }
    }

    public static void main(String[] agrs) {
        TransferMoneySafely transferMoneySafely = new TransferMoneySafely();
        Account fromAccount = new Account(1231231233, new BigDecimal("10000"));
        Account toAccount = new Account(1231231231, new BigDecimal("10000"));
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            transferMoneySafely.transferMoney(fromAccount, toAccount, new BigDecimal("2000"));
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
                            transferMoneySafely.transferMoney(toAccount ,fromAccount, new BigDecimal("2000"));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
    }
}