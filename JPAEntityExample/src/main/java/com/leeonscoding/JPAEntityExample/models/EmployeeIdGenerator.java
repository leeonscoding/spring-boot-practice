package com.leeonscoding.JPAEntityExample.models;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.util.Properties;

public class EmployeeIdGenerator implements IdentifierGenerator, Configurable {

    String prefix = "emp";

    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) throws HibernateException {


        int max = session.createQuery("SELECT id FROM employee", Employee.class)
                .stream()
                .mapToInt(Employee::getId)
                .max()
                .orElse(0);

        return prefix.concat("-"+max);
    }

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        prefix = params.getProperty("prefix");
    }
}
