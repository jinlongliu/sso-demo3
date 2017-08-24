package org.playchain.demo3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Liu on 2017/8/24.
 */
@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

    @RequestMapping("/user1")
    public String user1() {
        return "user1";
    }

    @RequestMapping("/user2")
    public String user2() {
        return "user2";
    }

    @RequestMapping("/user3")
    public String user3() {
        return "user3";
    }

    @RequestMapping("/user4")
    public String user4() {
        return "user4";
    }

    @RequestMapping("/dev")
    public String dev() {
        return "dev";
    }

}
