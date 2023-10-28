package com.company.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public boolean isRoleValid(String role) {
        return role.equals("EMPLOYEE") || role.equals("CLIENT");
    }
}
