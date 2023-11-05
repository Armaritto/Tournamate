package com.generator.tournamate.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @PostMapping("/backend")
    public HashMap<String,String> post(@RequestBody Map<String, Object> payload) {
        HashMap<String, String> response = new HashMap<>();
        String helloMessage = payload.get("msg").toString();
        helloMessage += " Software Developer";
        response.put("msg",String.valueOf(helloMessage));
        return response;
    }

}
