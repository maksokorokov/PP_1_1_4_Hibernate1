package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();

        userDaoHibernate.createUsersTable();

        User user1 = new User("Name1", "LastName1", (byte) 20);
        User user2 = new User("Name2", "LastName2", (byte) 24);
        User user3 = new User("Name3", "LastName3", (byte) 10);
        User user4 = new User("Name4", "LastName4", (byte) 44);

        userDaoHibernate.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        System.out.println("User с именем – " + user1.getName() + " добавлен в базу данных");
        userDaoHibernate.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        System.out.println("User с именем – " + user2.getName() + " добавлен в базу данных");
        userDaoHibernate.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        System.out.println("User с именем – " + user3.getName() + " добавлен в базу данных");
        userDaoHibernate.saveUser(user4.getName(), user4.getLastName(), user4.getAge());
        System.out.println("User с именем – " + user4.getName() + " добавлен в базу данных");

        userDaoHibernate.removeUserById(1);

        List<User> allUsers = userDaoHibernate.getAllUsers();
        allUsers.forEach(System.out::println);

        userDaoHibernate.dropUsersTable();


    }
}
