package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
    void save(User user);

    User getUser(Long id);

    void delete(Long id);

    List<User> listUser();

}
