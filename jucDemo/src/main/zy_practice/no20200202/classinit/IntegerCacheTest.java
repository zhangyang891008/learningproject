package no20200202.classinit;

/**
 * 基本类型和包装类型：
 *      Integer.valueOf方法的缓存机制。
 *      new Integer（）不具有缓存机制。
 */
public class IntegerCacheTest {
    public static void main(String[] args) {
        Integer integer1 = Integer.valueOf(1);
        Integer integer2 = Integer.valueOf(1);
        Integer integer3 = Integer.valueOf(234);
        Integer integer4 = Integer.valueOf(234);
        Integer integer5 = new Integer(5);
        Integer integer6 = new Integer(6);

        System.out.println(integer1 == integer2);
        System.out.println(integer3 == integer4);
        System.out.println(integer5 == integer6);

        Integer integer11 = Integer.valueOf(-1);
        Integer integer12 = Integer.valueOf(-1);
        System.out.println(integer11 == integer12);
    }
}
