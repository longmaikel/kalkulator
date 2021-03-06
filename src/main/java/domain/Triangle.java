package domain;


public class Triangle extends Figure implements Printable {

    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.validateInput();
    }


    @Override
    public double calculateArea() {
        double p = this.calculatePerimeter() / 2;
        return Math.sqrt(p * (p - this.a) * (p - this.b) * (p - this.c));
    }

    @Override
    public double calculatePerimeter() {
        return this.a + this.b + this.c;
    }

    @Override
    protected void printName() {
        System.out.println("Trojkat");
    }

    @Override
    protected boolean isRegular() {
        return 0 == Double.compare(this.a, this.b) && 0 == Double.compare(this.a, this.c);
    }

    @Override
    protected void validateInput() throws IllegalArgumentException {
        if (
                this.a < this.b + this.c
                        && this.b < this.a + this.c
                        && this.c < this.a + this.b
        ) {
            return;
        }

        throw new IllegalArgumentException("Boki o podanych długościach nie utworzą trójkąta.");
    }

    @Override
    public void print() {
        this.printLine();
        this.printName();
        System.out.println("bok a:" + this.a + ", bok b:" + this.b + ",bok c:" + this.c);
        this.printArea();
        this.printPerimeter();
        this.printLine();
    }
}
