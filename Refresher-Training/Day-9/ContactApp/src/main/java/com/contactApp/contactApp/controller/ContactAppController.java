package com.contactApp.contactApp.controller;

import com.contactApp.contactApp.DTO.RequestDTO;
import com.contactApp.contactApp.DTO.ResponseDTO;
import com.contactApp.contactApp.service.impl.ContactAppService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/contactApp")
public class ContactAppController {

    @Autowired
    private ContactAppService contactAppService;

    public  ContactAppController(ContactAppService contactAppService){
        this.contactAppService=contactAppService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> create(@Valid @RequestBody RequestDTO requestDTO){
        ResponseDTO res=contactAppService.addData(requestDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(res);

        //return ResponseEntity.ok(res);
    }

    @GetMapping("/get")
    public ResponseEntity<List<ResponseDTO>> getFullData(){
        List<ResponseDTO> ll=contactAppService.getAll();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ll);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getById(@PathVariable int id){
        ResponseDTO res=contactAppService.getDataById(id);

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(res);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ResponseDTO>> searchbyName(@RequestParam String name){

        List<ResponseDTO> res=contactAppService.searchByName(name);

        return ResponseEntity
                .ok(res);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> update(@Valid @RequestBody RequestDTO requestDTO , @PathVariable int id){
        ResponseDTO updated=contactAppService.updateData(requestDTO,id);

        return  ResponseEntity
                .status(HttpStatus.OK)
                .body(updated);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        contactAppService.deleteById(id);

        return ResponseEntity.noContent().build();
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .body("Data deleted Successfully");
    }

}