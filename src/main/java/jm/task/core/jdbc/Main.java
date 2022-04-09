package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        Util.getConnection();
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();

        User user1 = new User("Name1", "LastName1", (byte) 20);
        User user2 = new User("Name2", "LastName2", (byte) 24);
        User user3 = new User("Name3", "LastName3", (byte) 10);
        User user4 = new User("Name4", "LastName4", (byte) 44);

        userDaoJDBC.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        userDaoJDBC.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        userDaoJDBC.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        userDaoJDBC.saveUser(user4.getName(), user4.getLastName(), user4.getAge());



        userDaoJDBC.removeUserById(2);

        List<User> list = userDaoJDBC.getAllUsers();
        for (User u:list){
            System.out.println(u);
        }

        userDaoJDBC.dropUsersTable();
    }
}
