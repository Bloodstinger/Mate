package lecture.fifteen.factory;

import lecture.fifteen.dao.CarDaoImpl;
import lecture.fifteen.dao.DaoPattern;

public abstract class AbstractDaoFactory {

    private static DaoPattern instance;

    public AbstractDaoFactory() {
        getInstance();
    }

    public static DaoPattern getInstance() {
        if (instance == null) {
            instance = new CarDaoImpl() {
            };
        }
        return instance;
    }
}
