package com.dmdev;

import com.dmdev.entity.User;
import com.dmdev.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;

public class HibernateRunner {

    public static void main(String[] args) throws SQLException {
        User user = User.builder()
                .username("ivan@gmail.com")
                .lastname("Ivanov")
                .firstname("Ivan")
                .build();

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            try (Session session1 = sessionFactory.openSession()) {
                session1.beginTransaction();

                session1.saveOrUpdate(user);

                session1.getTransaction().commit();
            }
            try (Session session2 = sessionFactory.openSession()) {
                session2.beginTransaction();

                user.setFirstname("Sveta");
//                session2.delete(user);
//                refresh/merge
//                User freshUser = session2.get(User.class, user.getUsername());
//                freshUser.setLastname(user.getLastname());
//                freshUser.setFirstname(user.getFirstname());

                Object mergedUser = session2.merge(user);
//                session2.refresh(user);

                session2.getTransaction().commit();
            }
        }
    }












}
