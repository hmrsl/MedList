package hmr.med.service;

import hmr.med.entity.User;

import java.util.List;

public interface UserService {

    User get(int id);
    User get(String username);
    List<User> getAll();
    boolean remove(User user);
    boolean update(User user);
    boolean create(String username, String password, String type);

}
