package webproject.dao;


import org.springframework.stereotype.Repository;
import webproject.model.User;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private final EntityManager entityManager;

    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

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
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(show(id));
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Long id, User userUpdate) {
        entityManager.getTransaction().begin();
        User userToBeUpdated = show(id);
        userToBeUpdated.setName(userUpdate.getName());
        userToBeUpdated.setLastName(userUpdate.getLastName());
        userToBeUpdated.setAge(userUpdate.getAge());
        userToBeUpdated.setEmail(userUpdate.getEmail());
        entityManager.getTransaction().commit();
    }

}
