package com.bridgelabz.greetingsApp.controller;

import com.bridgelabz.greetingsApp.entity.GreetingApp;
import com.bridgelabz.greetingsApp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @PostMapping("/create")
    public GreetingApp create(@RequestBody GreetingApp greeting){
        return greetingService.create(greeting);
    }

    @GetMapping("/{id}")
    public GreetingApp getGreeting(@PathVariable Long id){
        return greetingService.getGreeting(id);
    }

    @GetMapping()
    public List<GreetingApp> getAll(){
        return greetingService.getAll();
    }

    @PutMapping("/{id}")
    public GreetingApp updateApp(@PathVariable Long id,@RequestBody GreetingApp greetingReq){

        GreetingApp updated=greetingService.updateApp(id,greetingReq);

        return updated;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        greetingService.delete(id);
        return "deleted";
    }
}
