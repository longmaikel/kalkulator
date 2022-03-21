import java.util.Scanner;

public class ActionManager {

    private static final int ACTION_MAKE_TRIANGLE = 1;
    private static final int ACTION_MAKE_SQUARE = 2;
    private static final int ACTION_MAKE_CIRCLE = 3;
    private static final int ACTION_MAKE_PRISM = 4;
    private static final int ACTION_KILL_APPLICATION = 5;

    private Scanner input;

    public ActionManager(Scanner input) {
        this.input = input;
    }

    public void doAction(int actionId) throws IllegalActionException, IllegalArgumentException, KillApplicationException {
        switch (actionId) {
            case ActionManager.ACTION_MAKE_TRIANGLE:
                this.makeTriangle();
                break;
            case ActionManager.ACTION_MAKE_SQUARE:
                this.makeSquare();
                break;
            case ActionManager.ACTION_MAKE_CIRCLE:
                this.makeCircle();
                break;
            case ActionManager.ACTION_MAKE_PRISM:
                this.makePrism();
                break;
            case ActionManager.ACTION_KILL_APPLICATION:
                this.killApplication();
                break;
            default:
                throw new IllegalActionException();
        }
    }

    private Prism makePrism() throws IllegalActionException, IllegalArgumentException {
        System.out.print("wybierz podstawę (1 - trojkat, 2 - kwadrat, 3 - kolo): ");
        int figureId = this.input.nextInt();
        Figure figure;

        if (ActionManager.ACTION_MAKE_TRIANGLE == figureId){
            figure = this.makeTriangle();
        } else if (ActionManager.ACTION_MAKE_SQUARE == figureId) {
            figure = this.makeSquare();
        } else if (ActionManager.ACTION_MAKE_CIRCLE == figureId) {
            figure = this.makeCircle();
        } else {
            throw new IllegalActionException();
        }

        System.out.print("wprowadz wysokosc: ");
        double h = this.input.nextDouble();

        Prism p = new Prism(figure, h);
        p.print();
        return p;

    }

    private Circle makeCircle() throws IllegalArgumentException {

        System.out.print("wprowadź promień: ");
        double r = this.input.nextDouble();
        Circle c = new Circle(r);
        c.print();
        return c;
    }

    private Square makeSquare() throws IllegalArgumentException {
        System.out.print("wprowadź długośc boku: ");
        double a = this.input.nextDouble();
        Square s = new Square(a);
        s.print();
        return s;
    }

    private void killApplication() throws KillApplicationException {
        throw new KillApplicationException();
    }

    private Triangle makeTriangle() throws IllegalArgumentException {
        System.out.print("wprowadź dlugość boku a: ");
        double a = this.input.nextDouble();

        System.out.print("wprowadź dlugość boku b: ");
        double b = this.input.nextDouble();

        System.out.print("wprowadź dlugość boku c: ");
        double c = this.input.nextDouble();

        Triangle t = new Triangle(a,b,c);
        t.print();

        return t;
    }
}
