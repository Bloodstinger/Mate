package lecture.fifteen.lib;

import lecture.fifteen.controller.BetConsoleHandler;
import lecture.fifteen.controller.CarConsoleHandler;
import lecture.fifteen.dao.BetDaoImpl;
import lecture.fifteen.dao.CarDaoImpl;
import lecture.fifteen.factory.BetDaoFactory;
import lecture.fifteen.factory.CarDaoFactory;

import java.lang.reflect.Field;

public class Injector {

    public static void injectDependency() throws IllegalAccessException {
        Class<BetDaoImpl> betDaoClass = BetDaoImpl.class;
        Class<CarDaoImpl> carDaoClass = CarDaoImpl.class;
        Class<CarConsoleHandler> carConsoleHandlerClass = CarConsoleHandler.class;
        Class<BetConsoleHandler> betConsoleHandlerClass = BetConsoleHandler.class;
        Field[] betContollerFields = betConsoleHandlerClass.getDeclaredFields();
        for (Field field : betContollerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getName().equals("betDao") && betDaoClass.getAnnotation(Dao.class) != null) {
                    field.set(null, BetDaoFactory.getInstance());
                }
            }
        }
        Field[] carControllerFields = carConsoleHandlerClass.getDeclaredFields();
        for (Field field : carControllerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getName().equals("carDao") && carDaoClass.getAnnotation(Dao.class) != null) {
                    field.set(null, CarDaoFactory.getInstance());
                }
            }
        }

    }
}
