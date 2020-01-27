package no20200127.enumTest;

public class MainTest {

    public static void main(String[] args) {
        int pay = PayrollDay.FRIDAY.pay(8);
        System.out.println(pay);
        int pay1 = PayrollDay.SUNDAY.pay(8);
        System.out.println(pay1);

    }
}
