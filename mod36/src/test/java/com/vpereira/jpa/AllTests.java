package com.vpereira.jpa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ClienteJpaDao2BancosTest.class, ClienteJpaDao3BancosTest.class,
        ClienteJpaDaoTest.class, ProdutoJpaDAOTest.class,
        VendaJpaDAOTest.class})
public class AllTests {

}
