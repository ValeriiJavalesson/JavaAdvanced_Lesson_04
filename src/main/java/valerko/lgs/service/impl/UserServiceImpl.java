package valerko.lgs.service.impl;

import valerko.lgs.dao.impl.UserDaoImpl;
import valerko.lgs.domain.User;
import valerko.lgs.dao.UserDao;
import valerko.lgs.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl userServiceImpl;
    private UserDao userDao;

    private UserServiceImpl() {
        userDao = new UserDaoImpl();
    }
    public static UserService getUserService(){
        if(userServiceImpl == null){
            userServiceImpl = new UserServiceImpl();
        }
        return userServiceImpl;
    }

    @Override
    public void create(User user) {
        userDao.create(user);
    }

    @Override
    public User read(int id) {
        return userDao.read(id);
    }
    public User read(String email) {
        return userDao.read(email);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public List<User> readAll() {
        return userDao.readAll();
    }
}
