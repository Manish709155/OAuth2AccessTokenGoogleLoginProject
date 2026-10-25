package com.oauth2.accesstoken.googlelogin.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/test")
@RestController
public class TestRestController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello World!";
    }


    @GetMapping("/me")
    public Map<String,Object> getProfileInfo(@AuthenticationPrincipal OAuth2User user){

        Map<String,Object> response = new HashMap<>();

        response.put("name",user.getAttribute("name"));
        response.put("email",user.getAttribute("email"));
        response.put("picture",user.getAttribute("picture"));

        return  response;

    }
}
