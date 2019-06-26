package lecture.fifteen;

import lecture.fifteen.controller.BetConsoleHandler;
import lecture.fifteen.controller.CarConsoleHandler;
import lecture.fifteen.lib.Injector;

import java.util.Scanner;

public class Main {

    static {
        try {
            Injector.injectDependency();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Если хотите сделать ставку, введите 1.\n"
                + "Если хотите внести автомобиль, введите 2.");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1:
                System.out.println("Введите сумму ставки и риск.");
                BetConsoleHandler.handle();
                break;
            case 2:
                System.out.println("Введите марку автомобиля и год выпуска");
                CarConsoleHandler.handle();
                break;
            default:
                throw new IllegalArgumentException("Неверный аргумент");
        }
    }
}
