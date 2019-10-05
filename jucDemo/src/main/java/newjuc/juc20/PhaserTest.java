package newjuc.juc20;

import java.util.concurrent.Phaser;

/**
 * phaser，多个阶段的栅栏
 */
public class PhaserTest {

    static MarriagePhaser phaser = new MarriagePhaser();

    static class MarriagePhaser extends Phaser {

        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase) {
                case 0:
                    System.out.println("到场。。。");
                    return false;
                case 1:
                    System.out.println("离开。。。");
                    return false;
                case 2:
                    System.out.println("旅行。。。");
                    return true;
                    default:
                        return true;
            }
        }
    }

    static class Person implements  Runnable{
        private String name;

        public Person(String name){
            this.name = name;
        }

        public void arrive(){
            System.out.println(this.name+" arrived"+", arrived: "+phaser.getArrivedParties());
            phaser.arriveAndAwaitAdvance();
        }

        public void left(){
            System.out.println(this.name + " left."+", arrived: "+phaser.getArrivedParties() );
            phaser.arriveAndAwaitAdvance();
        }

        public void travel(){
            if(this.name.equals("bride") || this.name.equals("bridegroom")){
                System.out.println(this.name + " travelling..." +", arrived: "+phaser.getArrivedParties());
                phaser.arriveAndAwaitAdvance(); //继续
            }else{
                phaser.arriveAndDeregister(); //放弃注册
            }

        }

        @Override
        public void run() {
            arrive();
            left();
            travel();
        }
    }

    public static void main(String[] args) {
        phaser.bulkRegister(7);
        for (int i = 0; i < 5; i++) {
            new Thread(new Person("person--"+i)).start();
        }
        new Thread(new Person("bride")).start();
        new Thread(new Person("bridegroom")).start();
    }

}
