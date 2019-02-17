package dao;

import entity.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

//realization of user will be declared in Bean,
// here we just need to create UserDao on start of our webapp
public interface UserDao {

    void save(User user);

    User getById(Integer id);

    List<User> findAll();

    void update(User user);

    void delete(Integer id);
}
