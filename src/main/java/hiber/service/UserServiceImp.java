package hiber.service;

import hiber.dao.UserDaoImpl;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserDaoImpl userDao;

    @Transactional
    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional()
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    @Transactional
    public void update(Long id, User user) {
        User userForUpdate = getUser(id);
        userForUpdate.setName(user.getName());
        userForUpdate.setLastName(user.getLastName());
        userForUpdate.setAge(user.getAge());
        save(userForUpdate);
    }

    @Override
    @Transactional()
    public List<User> listUsers() {
        return userDao.listUser();
    }
}
