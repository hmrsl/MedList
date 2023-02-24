package hmr.med.service;

import hmr.med.dao.MedicineDao;
import hmr.med.dao.UserDao;
import hmr.med.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;


    @Override
    @Transactional
    public User get(int id) {
        return userDao.get(id);
    }

    @Override
    @Transactional
    public User get(String username) {
        return userDao.get(username);
    }

    @Override
    @Transactional
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    @Transactional
    public boolean remove(User user) {
        return userDao.remove(user);
    }

    @Override
    @Transactional
    public boolean update(User user) {
        return userDao.update(user);
    }

    @Override
    @Transactional
    public boolean create(String username, String password, String type) {
        return userDao.create(username, password, type);
    }
}
