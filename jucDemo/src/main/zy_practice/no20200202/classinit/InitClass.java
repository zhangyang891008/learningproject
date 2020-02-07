package no20200202.classinit;

public class InitClass {

    private static int a = 5;

    public InitClass(){
        System.out.println(a);
        a = 6;
        System.out.println(a);
    }

    public static void main(String[] args) {
        InitClass initClass = new InitClass();

    }
}
