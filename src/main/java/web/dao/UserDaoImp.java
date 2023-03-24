package web.dao;


import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public void add(User user) {
      entityManager.persist(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query = entityManager.createQuery("from User", User.class);
      return query.getResultList();
   }

   @Override
   public User getUser(int id) {
      return entityManager.find(User.class, id);
   }

   @Override
   public void deleteUser(int id) {
      User user = entityManager.find(User.class, id);
      entityManager.remove(user);
   }

   @Override
   public void updateUser(User user) {
      entityManager.merge(user);
   }

}
