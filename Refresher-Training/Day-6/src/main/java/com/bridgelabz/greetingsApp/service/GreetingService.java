package com.bridgelabz.greetingsApp.service;

import com.bridgelabz.greetingsApp.entity.GreetingApp;
import com.bridgelabz.greetingsApp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    public GreetingApp create(GreetingApp greetingReq){
        return greetingRepository.save(greetingReq);
    }

    public GreetingApp getGreeting(Long id){
        Optional<GreetingApp> app= greetingRepository.findById(id);
        if(app.isEmpty()) return null;

        return app.get();
    }

    public List<GreetingApp> getAll(){

        List<GreetingApp> ll= greetingRepository.findAll();
        if(ll.isEmpty()) return null;

        return ll;
    }

    public GreetingApp updateApp(Long id, GreetingApp greetingReq){
          Optional<GreetingApp> exist=greetingRepository.findById(id);
          if(exist.isEmpty()) return null;

          GreetingApp toUpdate=exist.get();

//          toUpdate.setId(greetingReq.getId()); auto update
          toUpdate.setMessage(greetingReq.getMessage());

          return greetingRepository.save(toUpdate);
    }

    public void delete(Long id){
          greetingRepository.deleteById(id);

    }

}
