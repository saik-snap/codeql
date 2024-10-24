package com.hdfc.login.domain.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginEntityResponse {

    private String id;

    private String title;

    private boolean isActive;
}
