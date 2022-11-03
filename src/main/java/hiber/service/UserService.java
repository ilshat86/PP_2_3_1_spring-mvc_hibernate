package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User getUser(Long id);

    void delete(Long id);

    void update(Long id, User user);

    List<User> listUsers();
}
