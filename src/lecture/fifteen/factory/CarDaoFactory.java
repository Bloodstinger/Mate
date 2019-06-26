package lecture.fifteen.factory;

import lecture.fifteen.dao.CarDaoImpl;
import lecture.fifteen.dao.DaoPattern;

public class CarDaoFactory {

    private static DaoPattern instance;

    public CarDaoFactory() {
        getInstance();
    }

    public static DaoPattern getInstance() {
        if (instance == null) {
            instance = new CarDaoImpl();
        }
        return instance;
    }

}
