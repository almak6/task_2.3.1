package webproject.dao;

import org.springframework.stereotype.Repository;
import webproject.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> index() {
        return entityManager.createQuery("FROM User").getResultList();
    }

    public User show(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }
    @Override
    public void delete(Long id) {
        entityManager.remove(show(id));
    }
    @Override
    public void update(Long id, User userUpdate) {
        User userToBeUpdated = show(id);
        userToBeUpdated.setName(userUpdate.getName());
        userToBeUpdated.setLastName(userUpdate.getLastName());
        userToBeUpdated.setAge(userUpdate.getAge());
        userToBeUpdated.setEmail(userUpdate.getEmail());
    }

}
