package com.generator.tournamate.controllers;

import com.generator.tournamate.services.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin

@RestController
@RequestMapping
public class MessageController {
    @PostMapping("/backend")
    public HashMap<String,String> post(@RequestBody Map<String, Object> payload) {
        HashMap<String, String> response = new HashMap<>();
        String helloMessage = payload.get("msg").toString();
        helloMessage += " Software Developer";
        response.put("msg",String.valueOf(helloMessage));
        return response;
    }
    @PostMapping(path = "/shuffle")
    public List shuffle(@RequestParam("list") List list) {
        System.out.println(list);
       return  Service.shuffle(list);

    }
}
