package newjuc.juc08;

/**
 * 面试题：模拟银行业务，对写方法加锁，对读方法不加锁，这样行不行？
 * 容易产生脏读
 */
public class Account {
    String name;
    Double money;

    public Double read(String name) {
        return money;
    }

    public synchronized void write(String name, Double money) {
        this.name = name;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.money = money;
    }

    public static void main(String[] args) {

        Account account = new Account();
        new Thread(new Runnable() {
            @Override
            public void run() {
                account.write("zhangyang", 500.00);
            }
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("first try : " + account.name + "," + account.money);
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("again : " + account.name + "," + account.money);

    }
}
