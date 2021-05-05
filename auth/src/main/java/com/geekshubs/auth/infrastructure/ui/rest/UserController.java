package com.geekshubs.auth.infrastructure.ui.rest;

import com.geekshubs.auth.app.services.UserService;
import com.geekshubs.auth.domain.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {


    private final UserService userService;
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService)
    {
        this.userService= userService;
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) throws Exception {

        User result = null ;
        try {
            result = userService.save(user);


        }catch(Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(result,HttpStatus.OK);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user, HttpServletRequest request){
        logger.info("Solicitud de Login");
        return userService.login(user.getUsername(),user.getPassword(),request);
    }



}
