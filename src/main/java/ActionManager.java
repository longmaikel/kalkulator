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

    public boolean doAction(int actionId) throws IllegalActionException, IllegalArgumentException, KillApplicationException {
        switch (actionId) {
            case ActionManager.ACTION_MAKE_TRIANGLE:
                return this.makeTriangle();
            case ActionManager.ACTION_MAKE_SQUARE:
                return this.makeSquare();
            case ActionManager.ACTION_MAKE_CIRCLE:
                return this.makeCircle();
            case ActionManager.ACTION_MAKE_PRISM:
                return this.makePrism();
            case ActionManager.ACTION_KILL_APPLICATION:
                return this.killApplication();
            default:
                throw new IllegalActionException();
        }
    }

    private boolean makePrism() {
        return true;
    }

    private boolean makeCircle() {
        return true;
    }

    private boolean makeSquare() {
        return true;
    }

    private boolean killApplication() throws KillApplicationException {
        throw new KillApplicationException();
    }

    private boolean makeTriangle() {
        return true;
    }
}
