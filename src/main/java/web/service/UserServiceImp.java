package web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
   @Autowired
   private UserDao userDao;

   @Override
   @Transactional
   public void add(User user) {
      userDao.add(user);
   }


   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Override
   public User getUser(int id) {
      return userDao.getUser(id);
   }

   @Override
   public void deleteUser(int id) {
      userDao.deleteUser(id);
   }

   @Override
   @Transactional
   public void updateUser(User user) {
      userDao.updateUser(user);
   }

}
