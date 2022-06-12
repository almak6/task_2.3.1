package webproject.dao;

import webproject.model.User;
import java.util.List;

public interface UserDAO {

    List<User> index();

    User show(Long id);

    void save(User user);

    void delete(Long id);

    void update(Long id, User user);
}
