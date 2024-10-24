package com.mybank.daprtestservice;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.security.test.context.support.WithMockUser;

@SpringBootTest
@ActiveProfiles("test")
@WithMockUser
class DaprTestServiceApplicationTests {

    //@Test
    void contextLoads() {
    }

}
