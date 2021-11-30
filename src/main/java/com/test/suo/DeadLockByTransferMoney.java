package com.test.suo;

/**
 * @Package: com.test.suo
 * @ClassName: DeadLockByTransferMoney
 * @Author: 86150
 * @Description:
 * @Date: 2021/6/27 22:40
 */
public class DeadLockByTransferMoney implements Runnable{

    private static class User {
        String username;
        Integer money;

        public User(String username, Integer money) {
            this.username = username;
            this.money = money;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Integer getMoney() {
            return money;
        }

        public void setMoney(Integer money) {
            this.money = money;
        }

        public void transfer(User user, Integer money) {
            try{
                this.money = this.money - money;
                user.money = user.money + money;
            } catch (Exception e) {
                System.out.println("回滚----");
                // 回滚逻辑
            }
            System.out.println("转账发生");
        }
    }

    // 转账发起者
    private final User fromLock;
    // 转账接收者
    private final User toLock;

    public DeadLockByTransferMoney(User fromLock, User toLock) {
        this.fromLock = fromLock;
        this.toLock = toLock;
    }

    /**
     * 保证原子性的锁操作
     * 也证明了锁的可重入性质
     */
    @Override
    public void run() {
        synchronized (fromLock) {
            // 模拟网络开销 , 一旦有网络开销, 发生死锁的概率极高
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (toLock) {
                toLock.transfer(toLock, 20);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        User jay = new User("jay", 500);
        User james = new User("james", 500);
        DeadLockByTransferMoney r1 = new DeadLockByTransferMoney(jay, james);
        DeadLockByTransferMoney r2 = new DeadLockByTransferMoney(james, jay);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(jay.getMoney() + ":::::" + james.getMoney());
    }
}
