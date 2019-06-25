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
        System.out.println("Если хотите сделать ставку, введите " +
                "1.\n" +
                "Если хотите внести автомобиль, введите " +
                "2.");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int command = scanner.nextInt();
            if (command == 1) {
                System.out.println("Введите сумму ставки и риск.");
                try {
                    break;
                } finally {
                    BetConsoleHandler.handle();
                }
            } else if (command == 2) {
                System.out.println("Введите марку автомобиля и год выпуска");
                try {
                    break;
                } finally {
                    CarConsoleHandler.handle();
                }
            } else throw new IllegalArgumentException("Неверный аргумент");
        }

    }
}
