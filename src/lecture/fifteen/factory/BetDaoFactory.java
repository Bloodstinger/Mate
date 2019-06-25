package lecture.fifteen.factory;

import lecture.fifteen.dao.DaoPattern;
import lecture.fifteen.dao.BetDaoImpl;

public class BetDaoFactory extends AbstractDaoFactory {

    private static DaoPattern instance;

    public BetDaoFactory() {
        getInstance();
    }

    public static DaoPattern getInstance() {
        if (instance == null) {
            instance = new BetDaoImpl();
        }
        return instance;
    }
}
