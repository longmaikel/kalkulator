package application;

import domain.*;

import java.io.PrintStream;
import java.util.Scanner;

public class ActionManager {

    private static final int ACTION_MAKE_TRIANGLE = 1;
    private static final int ACTION_MAKE_SQUARE = 2;
    private static final int ACTION_MAKE_CIRCLE = 3;
    private static final int ACTION_MAKE_PRISM = 4;
    private static final int ACTION_KILL_APPLICATION = 5;

    private final Scanner input;
    private final PrintStream output;

    public ActionManager(Scanner input, PrintStream output) {
        this.input = input;
        this.output = output;
    }

    public void doAction(int actionId) throws IllegalActionException, IllegalArgumentException, KillApplicationException {
        switch (actionId) {
            case ActionManager.ACTION_MAKE_TRIANGLE -> this.makeTriangle();
            case ActionManager.ACTION_MAKE_SQUARE -> this.makeSquare();
            case ActionManager.ACTION_MAKE_CIRCLE -> this.makeCircle();
            case ActionManager.ACTION_MAKE_PRISM -> this.makePrism();
            case ActionManager.ACTION_KILL_APPLICATION -> this.killApplication();
            default -> throw new IllegalActionException();
        }
    }

    private Prism makePrism() throws IllegalActionException, IllegalArgumentException {
        this.output.print("wybierz podstawę (1 - trojkat, 2 - kwadrat, 3 - kolo): ");
        int figureId = this.input.nextInt();
        Figure figure;

        if (ActionManager.ACTION_MAKE_TRIANGLE == figureId) {
            figure = this.makeTriangle();
        } else if (ActionManager.ACTION_MAKE_SQUARE == figureId) {
            figure = this.makeSquare();
        } else if (ActionManager.ACTION_MAKE_CIRCLE == figureId) {
            figure = this.makeCircle();
        } else {
            throw new IllegalActionException();
        }

        this.output.print("wprowadz wysokosc: ");
        double h = this.input.nextDouble();

        Prism p = new Prism(figure, h);
        p.print();
        return p;

    }

    private Circle makeCircle() throws IllegalArgumentException {

        this.output.print("wprowadź promień: ");
        double r = this.input.nextDouble();
        Circle c = new Circle(r);
        c.print();
        return c;
    }

    private Square makeSquare() throws IllegalArgumentException {
        this.output.print("wprowadź długośc boku: ");
        double a = this.input.nextDouble();
        Square s = new Square(a);
        s.print();
        return s;
    }

    private void killApplication() throws KillApplicationException {
        throw new KillApplicationException();
    }

    private Triangle makeTriangle() throws IllegalArgumentException {
        this.output.print("wprowadź dlugość boku a: ");
        double a = this.input.nextDouble();

        this.output.print("wprowadź dlugość boku b: ");
        double b = this.input.nextDouble();

        this.output.print("wprowadź dlugość boku c: ");
        double c = this.input.nextDouble();

        Triangle t = new Triangle(a, b, c);
        t.print();

        return t;
    }
}
