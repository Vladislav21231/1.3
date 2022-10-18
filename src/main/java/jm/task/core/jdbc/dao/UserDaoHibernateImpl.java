package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private final SessionFactory sessionFactory =  Util.getConnection();
    public UserDaoHibernateImpl() {

    }


    public void createUsersTable() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS test.MyTable (id mediumint not null auto_increment, name VARCHAR(50), lastname VARCHAR(50), age tinyint, PRIMARY KEY (id))").executeUpdate();
            transaction.commit();
            System.out.println("The table has been created");
        } catch (Exception var7) {
            var7.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }

        }

    }

    public void dropUsersTable() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.createSQLQuery("Drop table if exists test.MyTable").executeUpdate();
            transaction.commit();
            System.out.println("Table deleted");
        } catch (Exception var7) {
            var7.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }

        }

    }

    public void saveUser(String name, String lastName, byte age) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(new User(name, lastName, age));
            transaction.commit();
            System.out.println("User with the name – " + name + " added to the database");
        } catch (Exception var10) {
            var10.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }

        }

    }

    public void removeUserById(long id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.delete(session.get(User.class, id));
            transaction.commit();
            System.out.println("User deleted");
        } catch (Exception var9) {
            var9.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }

        }

    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList();
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            list = session.createCriteria(User.class).list();
            transaction.commit();
        } catch (Exception var8) {
            var8.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return (List)list;
    }

    public void cleanUsersTable() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            List<User> instances = session.createCriteria(User.class).list();
            Iterator var4 = instances.iterator();

            while(var4.hasNext()) {
                Object o = var4.next();
                session.delete(o);
            }

            session.getTransaction().commit();
            System.out.println("The table is cleared");
        } catch (Exception var9) {
            var9.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }

        }

    }
}
