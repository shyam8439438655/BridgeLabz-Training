package com.contactApp.contactApp.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDTO {

    private int id;
    private String name;
    private String mail;
    private String mobNo;

}
