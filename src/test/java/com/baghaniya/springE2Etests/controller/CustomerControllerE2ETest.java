package com.baghaniya.springE2Etests.controller;

import com.baghaniya.springE2Etests.SpringE2ETestsApplication;
import com.baghaniya.springE2Etests.model.Customer;
import com.baghaniya.springE2Etests.service.CustomerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringE2ETestsApplication.class)
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:beforeTestRun.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:afterTestRun.sql")
})
public class CustomerControllerE2ETest {
    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerService customerService;


    @Test
    public void testGetCustomer(){
        Customer result1 = customerController.getCustomer(11L);
        Customer result2 = customerController.getCustomer(22L);

        Assert.assertEquals("rahul",result1.getName());
        Assert.assertEquals("anjali",result2.getName());
    }



}
