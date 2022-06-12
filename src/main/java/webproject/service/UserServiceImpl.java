package webproject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webproject.dao.UserDAO;
import webproject.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    @Override
    public List<User> index() {
        return userDAO.index();
    }
    @Override
    public User show(Long id) {
        return userDAO.show(id);
    }
    @Transactional
    @Override
    public void save(User user) {
        userDAO.save(user);
    }
    @Transactional
    @Override
    public void delete(Long id) {
        userDAO.delete(id);
    }
    @Transactional
    @Override
    public void update(Long id, User user) {
         userDAO.update(id, user);
    }
}
