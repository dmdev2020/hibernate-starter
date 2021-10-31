package com.dmdev;

import com.dmdev.dao.PaymentRepository;
import com.dmdev.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.sql.SQLException;

@Slf4j
public class HibernateRunner {

    @Transactional
    public static void main(String[] args) throws SQLException {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            try (var session = sessionFactory.openSession()) {
                session.beginTransaction();

                var paymentRepository = new PaymentRepository(sessionFactory);

                paymentRepository.findById(1L).ifPresent(System.out::println);

                session.getTransaction().commit();
            }
        }
    }












}
