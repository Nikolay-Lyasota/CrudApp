package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    public EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Transactional
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void removeUser(Long id) {
        entityManager.createQuery("DELETE FROM User u WHERE u.id = :id").setParameter("id", id).executeUpdate();
    }

    @Transactional
    @Override
    public void editUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }
}
