public class Circle extends Figure implements Printable {

    private double r;

    public Circle(double r) {
        this.r = r;
        this.validateInput();
    }


    @Override
    public double calculateArea() {
        return this.r * this.r * Math.PI;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * this.r;
    }

    @Override
    protected void printName() {
        System.out.println("koło");
    }

    @Override
    protected boolean isRegular() {
        return false;
    }

    @Override
    protected void validateInput() throws IllegalArgumentException {
        if (this.r <= 0) {
            throw new IllegalArgumentException("Promień koła musi być większy od zera.");
        }
    }

    @Override
    public void print() {
        this.printLine();
        this.printName();
        System.out.println("promien: " + this.r);
        this.printArea();
        this.printPerimeter();
        this.printLine();
    }
}
