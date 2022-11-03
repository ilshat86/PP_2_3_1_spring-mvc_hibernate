package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManagerFactory entityManagerFactory;

    @Override
    public void save(User user) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(user);
            entityTransaction.commit();
        }catch(Exception e){
            entityTransaction.rollback();
        }finally{
        entityManager.close();
    }
    }

    @Override
    public User getUser(Long id) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return (User) entityManager.createQuery("from User where id = :id")
                    .setParameter("id", id)
                    .getSingleResult();
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
