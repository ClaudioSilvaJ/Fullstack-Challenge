package com.desFS.services;

import com.desFS.util.APIBaseTest;
import static org.junit.Assert.assertEquals;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.ws.rs.core.Response;

@FixMethodOrder(MethodSorters.JVM)
public class ApiTest extends APIBaseTest {

    public String dummyEmail = "test@example.com";
    public String dummyPassword = "password123";

    @Test
    public void testAPI(){
        assertEqualsOK(apiTest.test());
    }

    public void assertEqualsOK(Response function){
        assertEquals(Response.Status.OK.getStatusCode(), function.getStatus());
    }

}
