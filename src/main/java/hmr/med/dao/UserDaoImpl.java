package hmr.med.dao;

import hmr.med.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public User get(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public User get(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("FROM User WHERE username=:name", User.class);
        query.setParameter("name", username);

        try {
            return query.getResultList().get(0);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("FROM User", User.class);
        return query.getResultList();
    }

    @Override
    public boolean remove(User user) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.remove(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean update(User user) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.update(user);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean create(String username, String password, String type) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.saveOrUpdate(new User(username, password, type));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
