package org.playchain.demo3.controller;

import org.playchain.demo3.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Liu on 2017/8/22.
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login() {

        return "login";
    }
}
