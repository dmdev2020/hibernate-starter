package com.dmdev;

import com.dmdev.entity.Payment;
import com.dmdev.util.HibernateUtil;
import com.dmdev.util.TestDataImporter;
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
             Session session = sessionFactory.openSession();
             Session session1 = sessionFactory.openSession()) {
            TestDataImporter.importData(sessionFactory);

            session.beginTransaction();
            session1.beginTransaction();

            var payment = session.find(Payment.class, 1L);
            payment.setAmount(payment.getAmount() + 10);

            var theSamePayment = session1.find(Payment.class, 1L);
            theSamePayment.setAmount(theSamePayment.getAmount() + 20);

            session.getTransaction().commit();
            session1.getTransaction().commit();
        }
    }












}
