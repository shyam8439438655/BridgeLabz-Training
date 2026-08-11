package com.contactApp.contactApp.service;

import com.contactApp.contactApp.DTO.RequestDTO;
import com.contactApp.contactApp.DTO.ResponseDTO;
import com.contactApp.contactApp.entity.ContactApp;
import com.contactApp.contactApp.exception.ContactNotFoundException;
import com.contactApp.contactApp.repository.ContactAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactAppService implements ContactAppInterface {

    @Autowired
    private final ContactAppRepository contactAppRepository;

    public ContactAppService(ContactAppRepository contactAppRepository) {
        this.contactAppRepository = contactAppRepository;
    }

    @Override
    public ResponseDTO add(ContactApp contactAppReq) {
        ContactApp cont = contactAppRepository.save(contactAppReq);
        return mapToResponse(cont);
    }

    @Override
    public List<ResponseDTO> getAll() {
        return contactAppRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseDTO getById(int id) {
        ContactApp contact = contactAppRepository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException("Contact not found with id: " + id));
        return mapToResponse(contact);
    }

    @Override
    public ResponseDTO update(int id, RequestDTO req) {
        ContactApp contact = contactAppRepository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException("Contact not found with id: " + id));

        contact.setName(req.getName());
        contact.setEmail(req.getEmail());
        contact.setMobNo(req.getMobNo());

        ContactApp updated = contactAppRepository.save(contact);
        return mapToResponse(updated);
    }

    @Override
    public void delete(int id) {
        if (!contactAppRepository.existsById(id)) {
            throw new ContactNotFoundException("Contact not found with id: " + id);
        }
        contactAppRepository.deleteById(id);
    }

    private ResponseDTO mapToResponse(ContactApp cont) {
        return ResponseDTO.builder()
                .id(cont.getId())
                .name(cont.getName())
                .mail(cont.getEmail())
                .mobNo(cont.getMobNo())
                .build();
    }
}