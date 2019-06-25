package lecture.fifteen.controller;

import lecture.fifteen.dao.DaoPattern;
import lecture.fifteen.lib.Inject;
import lecture.fifteen.model.Bet;

import java.util.Scanner;

public class BetConsoleHandler {

    @Inject
    private static DaoPattern betDao;

    static public void handle() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String command = scanner.nextLine();
                if (command.equals("0")) {
                    System.out.println(betDao.getAll());
                    return;
                }
                String[] data = command.split(" ");
                int value = Integer.parseInt(data[0]);
                double risk = Double.parseDouble(data[1]);
                Bet bet = new Bet(value, risk);
                betDao.add(bet);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Данные введены некорректно");
        }
    }
}

