package hiber.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import hiber.model.Car;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public List<Car> listCar(int count) {
        TypedQuery<Car> query=sessionFactory.getCurrentSession().createQuery("from Car");
        query.setMaxResults(count);
        return query.getResultList();
    }

    @Override
    public List<Car> listCar() {
        TypedQuery<Car> query=sessionFactory.getCurrentSession().createQuery("from Car");
        return query.getResultList();
    }
}
