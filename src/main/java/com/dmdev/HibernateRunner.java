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
             Session session = sessionFactory.openSession()) {
            TestDataImporter.importData(sessionFactory);

//            session.setDefaultReadOnly(true);
//            session.setReadOnly();
            session.beginTransaction();

            session.createNativeQuery("SET TRANSACTION READ ONLY;").executeUpdate();

//            var payments = session.createQuery("select p from Payment p", Payment.class)
//                    .setLockMode(LockModeType.PESSIMISTIC_FORCE_INCREMENT)
//                    .setHint("javax.persistence.lock.timeout", 5000)
//                    .setReadOnly(true)
//                    .setHint(QueryHints.READ_ONLY, true)
//                    .list();

            var payment = session.find(Payment.class, 1L);
            payment.setAmount(payment.getAmount() + 10);

            session.getTransaction().commit();
        }
    }












}
