package com.tsune.vhr02.controller;

import com.tsune.vhr02.entity.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @GetMapping("/login")
    public RespBean login(){
        return RespBean.error("尚未登陆请登录！");
    }
}
