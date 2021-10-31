package com.dmdev.dao;

import com.dmdev.entity.Company;
import org.hibernate.SessionFactory;

public class CompanyRepository extends RepositoryBase<Integer, Company> {

    public CompanyRepository(SessionFactory sessionFactory) {
        super(Company.class, sessionFactory);
    }
}











