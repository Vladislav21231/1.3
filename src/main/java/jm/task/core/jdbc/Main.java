package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    private final static UserService userService = new UserServiceImpl();
    public static void main(String[] args) {
        userService.createUsersTable();

        userService.saveUser("Alex", "Prime", (byte) 65);
        userService.saveUser("Luk", "Maser", (byte) 23);
        userService.saveUser("Fick", "Mara", (byte) 34);
        userService.saveUser("Max", "Loom", (byte) 67);

        userService.removeUserById(2);

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}
