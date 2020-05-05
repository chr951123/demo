package com.tsune.vhr02.controller;

import com.tsune.vhr02.entity.ChatMsg;
import com.tsune.vhr02.entity.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.Date;

@Controller
public class WsController {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/ws/chat")
    public void handleMsg(Authentication authentication, ChatMsg chatMsg){
        Hr hr = (Hr) authentication.getPrincipal();
        chatMsg.setFrom(hr.getUsername());
        chatMsg.setFromNickname(hr.getName());
        chatMsg.setDate(new Date());
        simpMessagingTemplate.convertAndSendToUser(chatMsg.getTo(),"/queue/chat",chatMsg);
    }
//    @MessageMapping("/ws/chat")
//    public void handleMsg(Principal principal, ChatMsg chatMsg){
//        chatMsg.setFrom(principal.getName());
//        chatMsg.setDate(new Date());
//        simpMessagingTemplate.convertAndSendToUser(chatMsg.getTo(),"/queue/chat",chatMsg);
//    }
}
