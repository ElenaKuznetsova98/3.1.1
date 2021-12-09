package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    void removeUserById(int id);

    User getUserById(int id);

    List<User> getAllUsers();

    void update(User user);

    User findByUsername(String username);
}
