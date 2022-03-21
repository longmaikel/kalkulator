import java.util.Scanner;

public class Application {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";

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
                System.out.print("-> ");
                int actionId = this.input.nextInt();
                this.actionManager.doAction(actionId);
                continue;
            } catch (IllegalActionException e) {
                System.out.println(Application.ANSI_YELLOW + "UPSSSS, wybrana akcja nie istnieje! Wybierz poprawną akcję." + Application.ANSI_RESET);
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println(Application.ANSI_RED + e.getMessage() + Application.ANSI_RESET);
                continue;
            } catch (KillApplicationException e) {
                this.kill();
                continue;
            } catch (Throwable e) {
                System.out.println(Application.ANSI_RED + "Fatal Error." + Application.ANSI_RESET);
                this.kill();
                return;
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
