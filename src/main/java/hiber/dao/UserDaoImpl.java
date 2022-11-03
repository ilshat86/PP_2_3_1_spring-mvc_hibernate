package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User getUser(Long id) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User where id=:id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void delete(Long id) {
        sessionFactory.getCurrentSession().delete(getUser(id));
    }

    @Override
    public List<User> listUser() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }
}
