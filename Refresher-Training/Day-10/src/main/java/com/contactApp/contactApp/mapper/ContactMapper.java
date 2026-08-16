package com.contactApp.contactApp.mapper;

import com.contactApp.contactApp.DTO.RequestDTO;
import com.contactApp.contactApp.DTO.ResponseDTO;
import com.contactApp.contactApp.entity.ContactApp;

public class ContactMapper {

    public static ResponseDTO mapToResponse(ContactApp cont){
        return ResponseDTO.builder()
                .name((cont.getName()))
                .mobNo(cont.getMobNo())
                .email(cont.getEmail())
                .build();

    }

    public static ContactApp mapToEntity(RequestDTO requestDTO){
        return ContactApp.builder()
                .name(requestDTO.getName())
                .mobNo(requestDTO.getMobNo())
                .email(requestDTO.getEmail())
                .build();
    }
}
