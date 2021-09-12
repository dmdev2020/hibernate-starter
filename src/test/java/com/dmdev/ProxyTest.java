package com.dmdev;

import com.dmdev.entity.Company;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

public class ProxyTest {

    @Test
    void testDynamic() {
        Company company = new Company();
        Proxy.newProxyInstance(company.getClass().getClassLoader(), company.getClass().getInterfaces(),
                (proxy, method, args) -> method.invoke(company, args));
    }
}
