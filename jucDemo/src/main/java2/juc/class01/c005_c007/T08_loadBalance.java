package juc.class01.c005_c007;

/*
    银行账户信息修改，只给写加锁，不给读加锁会产生问题
 */
public class T08_loadBalance {
    static class Account{

        private String name = "zhangyang";
        private Double money = 12233.00;

        public Account(String zhangyang, Double money) {

            this.name = name;
            this.money = money;
        }

        public String getName() {
            return name;
        }

        public Double getMoney() {
            return money;
        }

        public synchronized void write(String name, Double money){
            this.name = name;
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

           this.money = money;
        }

        public Account read(){
            return this;
        }

    }


    public static void main(String[] args) {

        Account a = new Account("zhangyang",1110.0);
        new Thread(new Runnable() {
            @Override
            public void run() {
                a.write("zhangsan",1.00);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Account read = a.read();
                System.out.println("read:" + read.getName()+","+read.getMoney());
            }
        }).start();


    }
}

