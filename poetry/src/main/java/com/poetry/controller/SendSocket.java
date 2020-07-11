package com.poetry.controller;
import java.io.IOException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class SendSocket {
 
    @RequestMapping("/test/{str}")
    public String back(@PathVariable("str") String str) throws IOException {
        new WebSocket().onMessage(str,null);
        return null;
    }
}