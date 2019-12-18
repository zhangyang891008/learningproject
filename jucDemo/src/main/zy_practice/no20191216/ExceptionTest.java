package no20191216;

/*
    受查异常和非受查异常的区别
 */
public class ExceptionTest {

    public void m1(int i){
        if(1==1){;
            throw new RuntimeException("equals 1");
        }
    }

    public static void main(String[] args) {
        int i = 1;
        //new ExceptionTest().m1(i);
        try {
            new ExceptionTest().m1(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
