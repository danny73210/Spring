package service;

import entity.User;

import java.util.List;

public interface UserService {

    void save(User user);

    User getById(Integer id);

    List<User> findAll();

    void update(User user);

    void delete(Integer id);

}
