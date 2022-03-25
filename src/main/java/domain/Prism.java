package domain;


public class Prism implements Printable {
    private final Figure figure;
    private final double h;

    public Prism(Figure figure, double h) {
        this.figure = figure;
        this.h = h;
        this.validateInput();
    }

    protected void validateInput() throws IllegalArgumentException {
        if (this.h <= 0) {
            throw new IllegalArgumentException("Wysokość musi być większa od zera.");
        }

        if (!this.figure.isRegular()) {
            throw new IllegalArgumentException("Podstawa musi być wielokątem prawidłowym.");
        }

    }

    public double calculateArea() {
        return this.figure.calculatePerimeter() * this.h + 2 * this.figure.calculateArea();
    }

    public double calculateVolume() {
        return this.figure.calculateArea() * this.h;
    }

    @Override
    public void print() {
        System.out.println("graniastosłup o powierzchni: " + this.calculateArea() + " i objętości: " + this.calculateVolume());
    }
}
