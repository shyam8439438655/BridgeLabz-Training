package com.contactApp.contactApp.service;//package com.contactApp.contactApp.service;
//
//import com.contactApp.contactApp.DTO.RequestDTO;
//import com.contactApp.contactApp.DTO.ResponseDTO;
//import com.contactApp.contactApp.entity.ContactApp;
//
//import java.util.List;
//
//public interface ContactAppInterface {
//    ResponseDTO add(ContactApp contactAppReq);
//    List<ResponseDTO> getAll();
//    ResponseDTO getById(int id);
//    ResponseDTO update(int id, RequestDTO req);
//    void delete(int id);
//}

import com.contactApp.contactApp.DTO.RequestDTO;
import com.contactApp.contactApp.DTO.ResponseDTO;

import java.util.List;

public interface ContactAppInterface {
    ResponseDTO addData(RequestDTO requestDTO);
    List<ResponseDTO> getAll();
    ResponseDTO getDataById(int id);
    List<ResponseDTO> searchByName(String name);
    ResponseDTO updateData(RequestDTO requestDTO, int id);
    void deleteById(int id);
}