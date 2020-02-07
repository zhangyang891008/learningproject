package juc.class02.u1.singletontest;

/*
    4枚举单例
 */
public class EnumSingleton {

    private EnumSingleton(){}

    public static EnumSingleton getInstance(){
        return EnumBuilder.SINGLETON.getInstance();
    }

    static enum EnumBuilder{
        SINGLETON;
        private EnumSingleton singleton;
        private EnumBuilder(){
            singleton = new EnumSingleton();
        }

        public EnumSingleton getInstance(){
            return singleton;

        }
    }

}
