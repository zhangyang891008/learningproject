package no20200127.enumTest;

/**
 * 枚举类的应用：effectivejava
 */
public enum PayrollDay {
    MONDAY,
    TUESDAY,
    WENDESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY(PayType.WEEKEND),
    SUNDAY(PayType.WEEKEND);

    private final PayType payType;
    PayrollDay(PayType payType) {
        this.payType = payType;
    }

    PayrollDay() {
        this.payType = PayType.WEEKDAY;
    }

    int pay(int hour){
        return payType.pay(hour);
    }

    private enum PayType{
        WEEKDAY{
            @Override
            int overtimePay(int hour) {
                return hour*1;
            }
        },
        WEEKEND{
            @Override
            int overtimePay(int hour) {
                return hour*2;
            }
        };

        abstract int overtimePay(int hour);

        int pay(int hour){
            int base = hour * 10;
            return base + overtimePay(hour);
        }
    }
}
