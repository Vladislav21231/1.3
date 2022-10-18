package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();

    public void createUsersTable() {
        this.userDaoHibernate.createUsersTable();
    }

    public void dropUsersTable() {
        this.userDaoHibernate.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        this.userDaoHibernate.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        this.userDaoHibernate.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return this.userDaoHibernate.getAllUsers();
    }

    public void cleanUsersTable() {
        this.userDaoHibernate.cleanUsersTable();
    }
}
