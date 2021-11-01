package com.dmdev.mapper;

import com.dmdev.dto.CompanyReadDto;
import com.dmdev.entity.Company;
import org.hibernate.Hibernate;

public class CompanyReadMapper implements Mapper<Company, CompanyReadDto> {

    @Override
    public CompanyReadDto mapFrom(Company object) {
        Hibernate.initialize(object.getLocales());
        return new CompanyReadDto(
                object.getId(),
                object.getName(),
                object.getLocales()
        );
    }
}
