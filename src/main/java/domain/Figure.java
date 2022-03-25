package domain;

public abstract class Figure {

    abstract public double calculateArea();

    abstract public double calculatePerimeter();

    abstract protected void printName();

    abstract protected void validateInput() throws IllegalArgumentException;

    abstract protected boolean isRegular();

    protected void printArea() {
        System.out.println("pole:" + this.calculateArea());
    }

    protected void printLine() {
        System.out.println("----------");
    }

    protected void printPerimeter() {
        System.out.println("obwod:" + this.calculatePerimeter());
    }


}
