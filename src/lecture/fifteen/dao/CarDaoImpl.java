package lecture.fifteen.dao;

import lecture.fifteen.db.Storage;
import lecture.fifteen.lib.Dao;
import lecture.fifteen.model.Car;

import java.util.List;

@Dao
public class CarDaoImpl implements CarDao<Car> {
    @Override
    public void add(Car car) {
        Storage.cars.add(car);
    }

    @Override
    public List<Car> getAll() {
        return Storage.cars;
    }
}
