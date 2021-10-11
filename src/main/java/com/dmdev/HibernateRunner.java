package com.dmdev;

import com.dmdev.entity.Payment;
import com.dmdev.util.HibernateUtil;
import com.dmdev.util.TestDataImporter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.LockModeType;
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

//            session.createQuery("select p from Payment p", Payment.class)
//                    .setLockMode(LockModeType.PESSIMISTIC_FORCE_INCREMENT)
//                    .setHint("javax.persistence.lock.timeout", 5000)
//                    .list();

            var payment = session.find(Payment.class, 1L, LockModeType.PESSIMISTIC_FORCE_INCREMENT);
            payment.setAmount(payment.getAmount() + 10);

            var theSamePayment = session1.find(Payment.class, 1L);
            theSamePayment.setAmount(theSamePayment.getAmount() + 20);

            session1.getTransaction().commit();
            session.getTransaction().commit();
        }
    }












}
