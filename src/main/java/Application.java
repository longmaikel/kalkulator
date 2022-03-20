import java.util.Scanner;

public class Application {

    private boolean alive = false;
    private Scanner input;
    private ActionManager actionManager;

    public Application() {
        this.input = new Scanner(System.in);
        this.actionManager = new ActionManager(this.input);
    }

    public void run() {
        this.keepAlive();
        this.welcome();
        while (this.alive) {
            this.menu();
            try {
                int action = this.input.nextInt();
                this.actionManager.doAction(action);
                continue;
            } catch (IllegalActionException e) {
                System.out.println("UPSSSS, wybrana akcja nie istnieje! Wybierz poprawną akcję.");
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            } catch (KillApplicationException e) {
                this.kill();
                continue;
            } catch (Throwable e) {
                System.out.println("Fatal Error.");
                this.kill();
            }
        }
        this.bye();
    }

    private void bye() {
        System.out.println("Bye!");
    }

    private void keepAlive() {
        this.alive = true;
    }

    private void kill() {
        this.alive = false;
    }

    private void welcome() {
        System.out.println("Witaj w aplikacji.");
    }

    private void menu() {
        this.printSeparator();
        System.out.println("Wybierz co chcesz zrobić.");
        this.printSeparator();
        System.out.println("1. Stworzyć trójkąt");
        System.out.println("2. Stworzyć kwadrat");
        System.out.println("3. Stworzyć koło");
        System.out.println("4. Stworzyć graniastosłup prawidłowy.");
        System.out.println("5. Zakończ.");
        this.printSeparator();
        System.out.println();
    }

    private void printSeparator() {
        System.out.println("----------");
    }
}
