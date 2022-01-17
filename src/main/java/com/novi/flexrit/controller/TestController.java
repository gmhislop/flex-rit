package com.novi.flexrit.controller;

import com.novi.flexrit.model.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class TestController {

    @PostMapping("/request")
    public LoginForm test(@RequestBody LoginForm form) {
        System.out.println(form);
        return form;
    }
}
