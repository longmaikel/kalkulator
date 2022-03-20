public class Prism {
    private Figure figure;
    private double h;

    protected Prism(Figure figure, double h) {
        this.figure = figure;
        this.h = h;
        this.validateInput();
    }

    protected void validateInput() throws IllegalArgumentException {
        if (this.h <= 0 || !this.figure.isRegular()) {
            throw new IllegalArgumentException();
        }
    }

    public double calculateArea() {
        return this.figure.calculatePerimeter() * this.h + 2 * this.figure.calculateArea();
    }

    public double calculateVolume() {
        return this.figure.calculateArea() * this.h;
    }
}
