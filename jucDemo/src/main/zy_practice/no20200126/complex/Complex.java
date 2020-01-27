package no20200126.complex;

/**
 *
 * 不可变类：实现复数的运算
 *
 * effective java 17
 */
public class Complex {

    private final double re;
    private final double im;

    public Complex(double re, double im){
        this.re =  re;
        this.im = im;

    }

    public double realPart(){
        return re;
    }

    public double imaginaryPart(){
        return im;
    }

    public Complex plus(Complex c){
        return new Complex(re + c.realPart(), im + c.imaginaryPart());
    }

    public Complex minus(Complex c){
        return new Complex(re - c.realPart(),im - c.imaginaryPart());
    }

    public Complex times(Complex c){
        return new Complex(re * c.re - im * c.imaginaryPart(),
                re  * c.imaginaryPart() + im*c.realPart());
    }

    public Complex dividedBy(Complex c){
        double temp = c.realPart() * c.realPart() + c.imaginaryPart() * c.imaginaryPart();
        return new Complex((re* c.realPart() + im * c.imaginaryPart())/temp,
                (im*c.realPart() - re*c.imaginaryPart())/temp);
    }

    public boolean equals(Object o){
        if(o == this)
            return true;
        if( !(o instanceof Complex))
            return false;
        Complex c= (Complex)o;
        return Double.compare(this.re, c.realPart()) == 0
                && Double.compare(this.im, c.imaginaryPart()) == 0;
    }

    @Override
    public int hashCode() {
        return 31 * Double.hashCode(re) + Double.hashCode(im);
    }

    @Override
    public String toString() {
        return "("+re+"+"+im+"i)";
    }
}
