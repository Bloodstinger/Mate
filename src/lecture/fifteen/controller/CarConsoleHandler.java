package lecture.fifteen.controller;

import lecture.fifteen.dao.DaoPattern;
import lecture.fifteen.lib.Inject;
import lecture.fifteen.model.Car;

import java.util.Scanner;

public class CarConsoleHandler {
    @Inject
    private static DaoPattern carDao;

    public static void handle() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String command = scanner.nextLine();
                if (command.equals("0")) {
                    System.out.println(carDao.getAll());
                    return;
                }
                String[] data = command.split(" ");
                String model = data[0];
                int yearOfProduction = Integer.parseInt(data[1]);
                Car car = new Car(model, yearOfProduction);
                carDao.add(car);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Данные введены некорректно");
        }
    }
}
