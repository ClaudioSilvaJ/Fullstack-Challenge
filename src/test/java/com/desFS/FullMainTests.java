package com.desFS;

import com.desFS.services.ApiTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ApiTest.class,
})
public class FullMainTests {
}
