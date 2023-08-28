package valerko.lgs.service.impl;

import valerko.lgs.dao.impl.UserDaoImpl;
import valerko.lgs.domain.User;
import valerko.lgs.dao.UserDao;
import valerko.lgs.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    @Override
    public void create(User user) {
        userDao.create(user);
    }

    @Override
    public User read(int id) {
        return userDao.read(id);
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
