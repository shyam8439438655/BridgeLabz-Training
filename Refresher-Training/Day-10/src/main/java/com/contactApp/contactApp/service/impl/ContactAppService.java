package com.contactApp.contactApp.service.impl;
import com.contactApp.contactApp.DTO.RequestDTO;
import com.contactApp.contactApp.DTO.ResponseDTO;
import com.contactApp.contactApp.entity.ContactApp;
import com.contactApp.contactApp.exception.ContactNotFoundException;
import com.contactApp.contactApp.repository.ContactAppRepository;
import com.contactApp.contactApp.service.ContactAppInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.contactApp.contactApp.mapper.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.contactApp.contactApp.mapper.ContactMapper.mapToEntity;
import static com.contactApp.contactApp.mapper.ContactMapper.mapToResponse;

@Service
public class  ContactAppService implements ContactAppInterface {

    @Autowired
    private final ContactAppRepository contactAppRepository;

    public ContactAppService(ContactAppRepository contactAppRepository){
        this.contactAppRepository=contactAppRepository;
    }

    @Override
    public ResponseDTO addData(RequestDTO requestDTO){

        ContactApp app=mapToEntity(requestDTO);
        ContactApp saved=contactAppRepository.save(app);
        return mapToResponse(saved);
    }
    @Override


    public List<ResponseDTO> getAll(){

        List<ContactApp> list= contactAppRepository.findAll();
        return list.stream()
                .map(ContactMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseDTO getDataById(int id){

        ContactApp ans= contactAppRepository
                .findById(id)
                .orElseThrow(()-> new ContactNotFoundException("Contact with this " + id + " does not exist"));

         return mapToResponse(ans);
//        Optional<ContactApp>app=contactAppRepository.findById(id);
//        return mapToResponse(app.get());
    }
   @Override
    public ResponseDTO findContact(String mobNo){
        Optional<ContactApp> res=contactAppRepository.findByMobNo(mobNo);
        return mapToResponse(res.get());
    }
    @Override
    public List<ResponseDTO> searchByName(String name){
        List<ContactApp> ll= contactAppRepository.findByNameContaining(name);

        return ll.stream()
                .map(ContactMapper::mapToResponse)
                .collect(Collectors.toList());
    }
     @Override
    public ResponseDTO updateData(RequestDTO requestDTO, int id){

         ContactApp sav=contactAppRepository.findById(id)
                 .orElseThrow(()-> new ContactNotFoundException("Contact with this " + id + "does not exist"));

         sav.setName(requestDTO.getName());
         sav.setMobNo(requestDTO.getMobNo());
         sav.setEmail(requestDTO.getEmail());

         ContactApp saved=contactAppRepository.save(sav);

       return mapToResponse(saved);

    }

    @Override
    public void deleteById(int id){
        ContactApp toBeDeleted=contactAppRepository.findById(id)
                        .orElseThrow(()->new ContactNotFoundException("Contact with this " + id + "does not exist"));
         contactAppRepository.delete(toBeDeleted);
    }

}