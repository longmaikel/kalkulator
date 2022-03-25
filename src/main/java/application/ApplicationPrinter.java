package application;

import java.io.PrintStream;

public class ApplicationPrinter {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    private final PrintStream output;

    public ApplicationPrinter(PrintStream output) {
        this.output = output;
    }

    public void menu() {
        this.printSeparator();
        this.output.println("Wybierz co chcesz zrobić.");
        this.printSeparator();
        this.output.println("1. Stworzyć trójkąt");
        this.output.println("2. Stworzyć kwadrat");
        this.output.println("3. Stworzyć koło");
        this.output.println("4. Stworzyć graniastosłup prawidłowy.");
        this.output.println("5. Zakończ.");
        this.printSeparator();
        this.output.println();
        this.output.print("-> ");
    }

    public void welcome() {
        this.output.println("Witaj w aplikacji.");
    }

    public void printSeparator() {
        this.output.println("----------");
    }

    public void printWarning(String msg) {
        this.printWithColor(msg, ANSI_YELLOW);
    }

    public void printError(String msg) {
        this.printWithColor(msg, ANSI_RED);
    }

    public void printWithColor(String msg, String color) {
        this.output.println(color + msg + ANSI_RESET);
    }

    public void bye() {
        this.output.println("Bye!");
    }
}
