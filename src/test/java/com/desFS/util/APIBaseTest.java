package com.desFS.util;

import org.example.APIServer;
import org.example.api.services.ApiTest;
import org.example.configs.MorphiaConfig;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.rules.ExternalResource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mongodb.morphia.Datastore;

public class APIBaseTest {
    @Mock
    private static Datastore mockDatastore;

    @InjectMocks
    public ApiTest apiTest;

    @ClassRule
    public static ExternalResource externalResource = new ExternalResource() {
        @Override
        protected void after() { mockDatastore.getDB().dropDatabase(); }
    };

    @Before
    public void setUp() {
        MockitoAnnotations.
                openMocks(this);
        mockDatastore = new MorphiaConfig("MockDataBase").getDatastore();
        APIServer.setDatastore(mockDatastore);
    }
}
