package no20200126.constantDefine;

/**
 * 接口常量定义问题解决方案：改为如下方式可以避免接口常量污染，泄露实现细节、不再使用常量接口不能删除的问题
 */
public class PhysicalConstants {
    private PhysicalConstants(){}

    public static final double PAI = 3.1415926;

}
