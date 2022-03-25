package domain;

import domain.Figure;
import domain.Printable;

public class Square extends Figure implements Printable {

    private final double a;

    public Square(double a) {
        this.a = a;
        this.validateInput();
    }

    @Override
    public double calculateArea() {
        return this.a * this.a;
    }

    @Override
    public double calculatePerimeter() {
        return this.a * 4;
    }

    @Override
    protected void printName() {
        System.out.println("Kwadrat");
    }

    @Override
    protected boolean isRegular() {
        return true;
    }

    @Override
    protected void validateInput() throws IllegalArgumentException {
        if (this.a <= 0) {
            throw new IllegalArgumentException("Długość boku kwadratu musi być większa od zera.");
        }
    }

    @Override
    public void print() {
        this.printLine();
        this.printName();
        System.out.println("bok: " + this.a);
        this.printArea();
        this.printPerimeter();
        this.printLine();
    }
}
