package com.geekshubs.auth.app.services;

import com.geekshubs.auth.domain.entities.User;
import com.geekshubs.auth.domain.repositories.UserRepository;
import com.geekshubs.auth.infrastructure.services.jwt.JwtService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.Base64;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private JwtService jwtService;


    public UserServiceImpl(UserRepository userRepository, JwtService jwtService)
    {
        this.userRepository = userRepository;
        this.jwtService = jwtService;

    }


    @Override
    public User save(User user) {
        String password = Base64.getEncoder().encodeToString(user.getPassword().getBytes());
        user.setPassword(password);
        return userRepository.save(user);
    }



    @Override
    public String login(String userName, String password, HttpServletRequest request){
        Optional<User> user = userRepository.findByUsername(userName);
        if(!user.isPresent()) return "El usuario no existe";
         return (user.get().getPassword().equals(Base64.getEncoder().encodeToString(password.getBytes()))) ?  jwtService.getJwt(userName, request) : "Error no existe usuario o password" ;
    }
}
