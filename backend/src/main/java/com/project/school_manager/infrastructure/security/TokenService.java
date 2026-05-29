package com.project.school_manager.infrastructure.security;

import com.auth0.jwt.algorithms.Algorithm;
import com.project.school_manager.modules.user.User;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    public String generateToken(User user){
        try {
            Algorithm algorithm = Algorithm.HMAC256();
        } catch (){

        }
    }
}
