package com.dmdev;

import com.dmdev.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.sql.SQLException;

@Slf4j
public class HibernateRunner {

    @Transactional
    public static void main(String[] args) throws SQLException {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.doWork(connection -> System.out.println(connection.getTransactionIsolation()));

//            try {
//                var transaction = session.beginTransaction();
//
//                var payment1 = session.find(Payment.class, 1L);
//                var payment2 = session.find(Payment.class, 2L);
//
//                session.getTransaction().commit();
//            } catch (Exception exception) {
//                session.getTransaction().rollback();
//                throw exception;
//            }
//            session.save()
        }
    }












}
