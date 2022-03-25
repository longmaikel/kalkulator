package application;

import java.util.Scanner;

public class Application {

    private final ApplicationPrinter printer;
    private final Scanner input;
    private final ActionManager actionManager;
    private boolean alive = false;

    public Application() {
        this.input = new Scanner(System.in);
        this.printer = new ApplicationPrinter(System.out);
        this.actionManager = new ActionManager(this.input, System.out);
    }

    public void run() {
        this.keepAlive();
        this.printer.welcome();
        while (this.alive) {
            this.printer.menu();
            try {
                int actionId = this.input.nextInt();
                this.actionManager.doAction(actionId);
            } catch (IllegalActionException e) {
                this.printer.printWarning("UPSSSS, wybrana akcja nie istnieje! Wybierz poprawną akcję.");
            } catch (IllegalArgumentException e) {
                this.printer.printError(e.getMessage());
            } catch (KillApplicationException e) {
                this.kill();
            } catch (Throwable e) {
                this.printer.printError("Fatal Error.");
                this.kill();
                return;
            }
        }
        this.printer.bye();
    }

    private void keepAlive() {
        this.alive = true;
    }

    private void kill() {
        this.alive = false;
    }


}
