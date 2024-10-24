package com.hdfc.accounts;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.security.test.context.support.WithMockUser;

@SpringBootTest
@ActiveProfiles("test")
@WithMockUser
class AccountServiceApplicationTests {

    @Test
    void contextLoads() {
    }

}
