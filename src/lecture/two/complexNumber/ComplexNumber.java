package lecture.two.complexNumber;

public class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        ComplexNumber complexNumber = (ComplexNumber) o;
        return Double.compare(complexNumber.re, re) == 0 &&
                Double.compare(complexNumber.im, im) == 0;
    }

    @Override
    public int hashCode() {
        int hash;
        hash = 31 * Integer.parseInt(String.valueOf(re)) - Integer.parseInt(String.valueOf(im)) / 36 + 15;
        return hash;
    }
}
