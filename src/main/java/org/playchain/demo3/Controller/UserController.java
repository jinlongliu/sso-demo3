package org.playchain.demo3.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Liu on 2017/8/23.
 */
@RestController
//@EnableWebSecurity
//@EnableResourceServer
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/user")
    public Principal user(Principal user) {
        logger.info(user.toString());
        return user;
    }
}
