package hiber.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import hiber.dao.CarDao;
import hiber.model.Car;

import java.util.List;

@Service
public class CarServiceImp implements CarService{
    @Autowired
    private CarDao carDao;

    @Transactional
    @Override
    public void add(Car car) {
        carDao.add(car);
    }

    @Override
    @Transactional
    public List<Car> listUsers(int count) {
        if(count>=5){
            return carDao.listCar();
        }
        else return carDao.listCar(count);
    }
}
